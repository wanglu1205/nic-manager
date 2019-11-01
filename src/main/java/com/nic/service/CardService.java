package com.nic.service;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hmf.common.http.LoadBalanceAsyncHttpClient;
import com.nic.auth.AuthConstants;
import com.nic.common.model.PageResult;
import com.nic.common.model.dto.CardListDto;
import com.nic.common.model.vo.CardListVo;
import com.nic.common.model.vo.CardStatusVo;
import com.nic.common.model.vo.CustomerListVo;
import com.nic.config.AppException;
import com.nic.config.ErrorCode;
import com.nic.dal.entity.Card;
import com.nic.dal.entity.CardExample;
import com.nic.dal.entity.Customer;
import com.nic.dal.entity.CustomerExample;
import com.nic.dal.mapper.CardMapper;
import com.nic.dal.mapper.CustomerMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.asynchttpclient.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @auther: wl
 * @date: 2019/10/18
 * @description:
 * @since : 1.0
 */
@Service
public class CardService {

    private static final Logger logger = LoggerFactory.getLogger(CardService.class);

    @Resource
    private CardMapper cardMapper;

    @Resource
    private CustomerMapper customerMapper;

    @Resource
    private CustomerService customerService;

    @Resource
    private LoadBalanceAsyncHttpClient loadBalanceAsyncHttpClient;

    @Value("${nic.card.host}")
    private String HOST;

    @Value("${nic.card.statusUrl}")
    private String CARD_STATUS_URL;

    public PageResult<CardListVo> list(CardListDto dto, String token) {
        Customer loginer = customerService.getInfoByToken(token);
        if (Objects.isNull(loginer)){
            throw new AppException(ErrorCode.NOT_EXIST);
        }
        List<Long> cardIdList = new ArrayList<>();
        String cardIds = loginer.getCardIds();
        if (StringUtils.isNotBlank(cardIds)){
            String[] ids = cardIds.split(",");
            for (String id: ids){
                cardIdList.add(Long.valueOf(id));
            }
        }
        if (CollectionUtils.isEmpty(cardIdList)){
            return null;
        }
        Page<CustomerListVo> page = PageHelper.startPage(dto.getPageNo(), dto.getPageSize());
        CardExample cardExample = new CardExample();
        CardExample.Criteria criteria = cardExample.createCriteria();
        if (!StringUtils.equals(loginer.getAccount(), AuthConstants.superAdminAccount)){
            criteria.andIdIn(cardIdList);
        }
        List<Card> cards = cardMapper.selectByExample(cardExample);
        List<CardListVo> vos = new ArrayList<>();
        for (Card card : cards) {
            CardListVo vo = new CardListVo();
            vo.setId(card.getId());
            vo.setName(loginer.getName());
            vo.setNumber(card.getNumber());
            /*vo.setResidualFlowValue(card.getResidualFlowValue());
            vo.setMonthUsedValue(card.getMonthUsedValue());
            vo.setTotalUsedValue(card.getTotalUsedValue());
            vo.setStatus(card.getStatus());*/
            vos.add(vo);
        }
        return new PageResult<>(page.getPageNum(), page.getPageSize(), page.getTotal(), vos);
    }

    public Boolean delete(List<Long> ids) {
        CardExample cardExample = new CardExample();
        cardExample.createCriteria().andIdIn(ids);
        cardMapper.deleteByExample(cardExample);
        return true;
    }

    public CardStatusVo status(Long id) {
        Card card = cardMapper.selectByPrimaryKey(id);
        if (Objects.isNull(card)){
            throw new AppException(ErrorCode.NOT_EXIST, "该互联网卡不存在");
        }
        CardStatusVo cardStatusVo = getCardStatus(card.getNumber());
        Card c = new Card();
        c.setId(card.getId());
        c.setMsisdn(cardStatusVo.getMSISDN());
        cardMapper.insertSelective(c);
        return cardStatusVo;
    }

    public CardStatusVo getCardStatus(String number) {
        String result = null;
        List<Param> params = new ArrayList<>();
        params.add(new Param("iccid", number));
        try {
            result = loadBalanceAsyncHttpClient.simplePostParams(HOST + CARD_STATUS_URL, params, 60000L, TimeUnit.MILLISECONDS);
            logger.info("状态查询返回结果：{}", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JSON.parseObject(result, CardStatusVo.class);
    }

    public List<String> importData(MultipartFile file, String token) {
        //获取登录用户和一级代理商
        List<Customer> customers = getCustomer(token);

        List<String> errorList = new ArrayList<>();
        Workbook workbook = null;
        try {
            workbook = new XSSFWorkbook(file.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 获取第一个张表
        Sheet sheet = workbook.getSheetAt(0);
        // 获取每行中的字段
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);  // 获取行
            // 获取单元格中的值
            Cell cell0 = row.getCell(0);
            Cell cell1 = row.getCell(1);
            if (Objects.isNull(cell0)){
                errorList.add("第" + (i + 1) + "行, 代理商账号为空");
                continue;
            }
            if (Objects.isNull(cell0)){
                errorList.add("第" + (i + 1) + "行, 卡号为空");
                continue;
            }
            cell0.setCellType(CellType.STRING);
            cell1.setCellType(CellType.STRING);
            String account = cell0.getStringCellValue();
            String number = cell1.getStringCellValue();

            if (StringUtils.isBlank(account)){
                errorList.add("第" + (i + 1) + "行, 代理商账号为空");
                continue;
            }
            if (StringUtils.isBlank(number)){
                errorList.add("第" + (i + 1) + "行, 卡号为空");
                continue;
            }
            if (number.length() != 20){
                errorList.add("第" + (i + 1) + "行, 卡号长度不为20");
                continue;
            }
            Customer customer = customers.stream().filter(c -> Objects.equals(c.getAccount(), account)).findFirst().orElse(null);
            if (Objects.isNull(customer)){
                errorList.add("第" + (i + 1) + "行, 代理商账号不正确，必须为自己的账号或自己的一级代理商账号");
                continue;
            }
            Long cardId = null;
            CardExample cardExample = new CardExample();
            cardExample.createCriteria().andNumberEqualTo(number);
            List<Card> cards = cardMapper.selectByExample(cardExample);
            if (!CollectionUtils.isEmpty(cards)){
                Card card = cards.get(0);
                cardId = card.getId();
                String cardIds = customer.getCardIds();
                if (StringUtils.isNotBlank(cardIds)){
                    List<String> list = Arrays.asList(cardIds.split(","));
                    if (list.contains(String.valueOf(card.getId()))){
                        errorList.add("第" + (i + 1) + "行, 该代理商账号已分配该卡号");
                        continue;
                    }
                }
            }else {
                Card card = new Card();
                card.setNumber(number);
                Date date = new Date();
                card.setGmtCreate(date);
                card.setGmtModified(date);
                cardMapper.insertSelective(card);
                cardId = card.getId();
            }

            Customer c = new Customer();
            String cardIds = customer.getCardIds();
            if (StringUtils.isBlank(cardIds)){
                cardIds = String.valueOf(cardId);
            }else {
                cardIds = cardIds + "," + cardId;
            }
            c.setCardIds(cardIds);
            c.setGmtModified(new Date());
            c.setId(customer.getId());
            customerMapper.updateByPrimaryKeySelective(c);
        }
        return errorList;
    }

    private List<Customer> getCustomer(String token) {
        Customer loginer = customerService.getInfoByToken(token);
        CustomerExample customerExample = new CustomerExample();
        customerExample.createCriteria().andParentIdEqualTo(loginer.getId());
        List<Customer> customerList = customerMapper.selectByExample(customerExample);
        customerList.add(loginer);
        return customerList;
    }
}
