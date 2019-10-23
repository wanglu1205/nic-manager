package com.nic.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hmf.common.http.LoadBalanceAsyncHttpClient;
import com.nic.common.model.dto.RechargeDto;
import com.nic.common.model.vo.CardRechargeVo;
import com.nic.common.model.vo.CardStatusVo;
import com.nic.config.AppException;
import com.nic.config.ErrorCode;
import com.nic.dal.entity.*;
import com.nic.dal.entity.Package;
import com.nic.dal.mapper.*;
import org.apache.commons.lang3.StringUtils;
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
        Package p = packageMapper.selectByPrimaryKey(dto.getPackageId());
        if (Objects.isNull(p)){
            throw new AppException(ErrorCode.NOT_EXIST, "该套餐不存在");
        }
        CustomerExample customerExample = new CustomerExample();
        List<Customer> customerList = customerMapper.selectByExample(customerExample);
        BigDecimal price = p.getPrice();

        Customer customer = customerService.getInfoByToken(token);
        List<String> numbers = dto.getNumbers();
        CardExample cardExample = new CardExample();
        Date date = new Date();
        numbers.forEach(number -> {
            cardExample.createCriteria().andNumberEqualTo(number);
            List<Card> cards = cardMapper.selectByExample(cardExample);
            if (CollectionUtils.isEmpty(cards)){
                return;
            }
            Card card = cards.get(0);
            //生成订单
            OrderRecord order = new OrderRecord();

            //卡状态查询接口
            CardStatusVo cardStatusVo = cardService.status(number);
            String msisdn = cardStatusVo.getMSISDN();
            //调用充值接口
            String result = recharge(price, customer, msisdn);

            if (Objects.isNull(result)){
                order.setStatus("FAIL");
            }else {
                CardRechargeVo cardRechargeVo = JSON.parseObject(result, CardRechargeVo.class);
                if (cardRechargeVo.getSuccess_fee() == 0){
                    order.setStatus("FAIL");
                }else {
                    order.setStatus("SUCCESS");
                    order.setOrderNumber(cardRechargeVo.getBatch_no());
                }
            }

            order.setCardId(card.getId());
            //order.setChannel("WXPAY");
            order.setCustomerId(customer.getId());
            order.setMoney(price);
            order.setGmtCreate(date);
            order.setGmtModified(date);
            orderRecordMapper.insertSelective(order);
            //获取该卡绑定的代理商
            List<Customer> customers = getCustomers(customerList, card);
            while (true){
                List<Customer> customers1 = new ArrayList<>();
                customers.forEach(c -> {
                    RebateRuleExample example = new RebateRuleExample();
                    example.createCriteria().andCustomerIdEqualTo(c.getId()).andPackageIdEqualTo(p.getId());
                    List<RebateRule> rebateRules = rebateRuleMapper.selectByExample(example);
                    if (CollectionUtils.isEmpty(rebateRules)){
                        return;
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
                    if (Objects.nonNull(c.getParentId())){
                        Customer customer2 = customerMapper.selectByPrimaryKey(c.getParentId());
                        customers1.add(customer2);
                    }
                });
                if (!CollectionUtils.isEmpty(customers1)){
                    customers = customers1;
                }else {
                    break;
                }
            }
        });
        return true;
    }

    private String recharge(BigDecimal price, Customer customer, String msisdn) {
        String result = null;
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msisdn", msisdn);
        jsonObject.put("amount", price);
        jsonObject.put("groupid", customer.getGroupNumber());
        try {
            result = loadBalanceAsyncHttpClient.postBody(HOST + CARD_RECHARGE_URL, cardService.buildHeader(), jsonObject.toJSONString(), 5000L, TimeUnit.MILLISECONDS);
            logger.info("状态查询返回结果：{}", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String getOrderIdByTime() {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
        String newDate=sdf.format(new Date());
        String result="";
        Random random=new Random();
        for(int i=0;i<3;i++){
            result+=random.nextInt(10);
        }
        return newDate+result;
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
