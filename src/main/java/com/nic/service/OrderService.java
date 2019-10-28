package com.nic.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hmf.common.http.LoadBalanceAsyncHttpClient;
import com.nic.common.enums.RechargeStatusEnum;
import com.nic.common.model.dto.RechargeDto;
import com.nic.common.model.vo.CardRechargeVo;
import com.nic.common.model.vo.CardStatusVo;
import com.nic.config.AppException;
import com.nic.config.ErrorCode;
import com.nic.dal.entity.*;
import com.nic.dal.entity.Package;
import com.nic.dal.mapper.*;
import org.apache.commons.lang3.StringUtils;
import org.asynchttpclient.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @auther: wl
 * @date: 2019/10/18
 * @description:
 * @since : 1.0
 */
@Service
public class OrderService {

    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

    @Resource
    private CardMapper cardMapper;

    @Resource
    private OrderRecordMapper orderRecordMapper;

    @Resource
    private CustomerService customerService;

    @Resource
    private PackageMapper packageMapper;

    @Resource
    private CustomerMapper customerMapper;

    @Resource
    private RebateRuleMapper rebateRuleMapper;

    @Resource
    private RebateRecordMapper rebateRecordMapper;

    @Resource
    private CardService cardService;

    @Resource
    private LoadBalanceAsyncHttpClient loadBalanceAsyncHttpClient;

    @Value("${nic.card.host}")
    private String HOST;

    @Value("${nic.card.rechargeUrl}")
    private String CARD_RECHARGE_URL;

    public Boolean recharge(RechargeDto dto, String token) {
        Card card = cardMapper.selectByPrimaryKey(dto.getCardId());
        if (Objects.isNull(card)){
            throw new AppException(ErrorCode.NOT_EXIST, "该互联网卡不存在");
        }

        Package p = packageMapper.selectByPrimaryKey(dto.getPackageId());
        if (Objects.isNull(p)){
            throw new AppException(ErrorCode.NOT_EXIST, "该套餐不存在");
        }

        Customer customer = customerService.getInfoByToken(token);

        CustomerExample customerExample = new CustomerExample();
        List<Customer> customerList = customerMapper.selectByExample(customerExample);

        //生成订单
        OrderRecord order = new OrderRecord();

        //调用充值接口
        String result = recharge(p.getPrice(), customer, card.getMsisdn());

        boolean isRechargeSuccess = true;
        boolean isRebateSuccess = true;
        if (StringUtils.isBlank(result)){
            isRechargeSuccess = false;
        }else {
            CardRechargeVo cardRechargeVo = JSON.parseObject(result, CardRechargeVo.class);
            if (cardRechargeVo.getSuccess_fee() == 0){
                isRechargeSuccess = false;
            }else {
                order.setOrderNumber(cardRechargeVo.getBatch_no());
            }
        }

        Date date = new Date();
        if (isRechargeSuccess){
            //返利
            isRebateSuccess = rebate(card, p, customer, customerList, order, date);
        }
        if (isRechargeSuccess && isRebateSuccess){
            order.setStatus(RechargeStatusEnum.SUCCESS_SUCCESS.getCode());
        }else if (isRechargeSuccess && !isRebateSuccess){
            order.setStatus(RechargeStatusEnum.SUCCESS_FAIL.getCode());
        }else if (!isRechargeSuccess && !isRebateSuccess){
            order.setStatus(RechargeStatusEnum.FAIL_FAIL.getCode());
        }
        order.setCardId(card.getId());
        order.setCustomerId(customer.getId());
        order.setMoney(p.getPrice());
        order.setGmtCreate(date);
        order.setGmtModified(date);
        orderRecordMapper.insertSelective(order);

        return true;
    }

    private Boolean rebate(Card card, Package p, Customer customer, List<Customer> customerList, OrderRecord order, Date date) {
        //获取该卡绑定的代理商
        List<Customer> customers = getCustomers(customerList, card);
        if (CollectionUtils.isEmpty(customers)){
            logger.error("互联网卡主键={},未绑定代理商", card.getId());
            return false;
        }
        boolean isAllSuccess = true;
        while (true){
            List<Customer> customers1 = new ArrayList<>();
            for (Customer c : customers) {
                RebateRuleExample example = new RebateRuleExample();
                example.createCriteria().andCustomerIdEqualTo(c.getId()).andPackageIdEqualTo(p.getId());
                List<RebateRule> rebateRules = rebateRuleMapper.selectByExample(example);
                if (CollectionUtils.isEmpty(rebateRules)) {
                    logger.error("代理商主键={}, 套餐主键={},未设置返利规则", c.getId(), p.getId());
                    isAllSuccess = false;
                    continue;
                }
                BigDecimal money = rebateRules.get(0).getMoney();
                //生成返利记录
                RebateRecord record = new RebateRecord();
                record.setCardId(card.getId());
                record.setCustomerId(customer.getId());
                record.setMoney(c.getCommission());
                record.setRebateMoney(money);
                record.setOrderId(order.getId());
                record.setPackageId(p.getId());
                record.setRebateCustomerId(c.getId());
                record.setGmtCreate(date);
                record.setGmtModified(date);
                rebateRecordMapper.insertSelective(record);
                //更新账户余额
                Customer customer1 = new Customer();
                customer1.setId(c.getId());
                customer1.setCommission(c.getCommission().add(money));
                customerMapper.updateByPrimaryKeySelective(customer1);
                if (Objects.nonNull(c.getParentId())) {
                    Customer customer2 = customerMapper.selectByPrimaryKey(c.getParentId());
                    customers1.add(customer2);
                }
            }
            if (!CollectionUtils.isEmpty(customers1)){
                customers = customers1;
            }else {
                break;
            }
        }
        return isAllSuccess;
    }

    private String recharge(BigDecimal price, Customer customer, String msisdn) {
        String result = null;
        List<Param> params = new ArrayList<>();
        params.add(new Param("msisdn", msisdn));
        params.add(new Param("amount", String.valueOf(price)));
        params.add(new Param("groupid", customer.getGroupNumber()));
        try {
            result = loadBalanceAsyncHttpClient.simplePostParams(HOST + CARD_RECHARGE_URL, params, 5000L, TimeUnit.MILLISECONDS);
            logger.info("状态查询返回结果：{}", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private List<Customer> getCustomers(List<Customer> customerList, Card card) {
        return customerList.stream().filter(c -> {
                    String cardIds = c.getCardIds();
                    if (StringUtils.isNotBlank(cardIds)) {
                        for (String cardId : cardIds.split(",")) {
                            if (Objects.equals(Long.valueOf(cardId), card.getId())) {
                                return true;
                            }
                        }
                    }
                    return false;
                }).collect(Collectors.toList());
    }
}
