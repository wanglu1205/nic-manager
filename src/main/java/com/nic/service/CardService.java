package com.nic.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hmf.common.http.LoadBalanceAsyncHttpClient;
import com.nic.common.model.PageResult;
import com.nic.common.model.dto.CardListDto;
import com.nic.common.model.vo.CardListVo;
import com.nic.common.model.vo.CardStatusVo;
import com.nic.common.model.vo.CustomerListVo;
import com.nic.dal.entity.Card;
import com.nic.dal.entity.CardExample;
import com.nic.dal.entity.Customer;
import com.nic.dal.mapper.CardMapper;
import com.nic.dal.mapper.CustomerMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
        Customer customer = null;
        if (Objects.isNull(dto.getCustomerId())){
            customer = customerService.getInfoByToken(token);
        }else {
            customer = customerMapper.selectByPrimaryKey(dto.getCustomerId());
        }
        String cardIds = customer.getCardIds();
        if (Objects.isNull(cardIds)){
            return null;
        }
        List<Long> ids = new ArrayList<>();
        for (String cardId : cardIds.split(",")){
            ids.add(Long.valueOf(cardId));
        }
        Page<CustomerListVo> page = PageHelper.startPage(dto.getPageNo(), dto.getPageSize());
        CardExample cardExample = new CardExample();
        cardExample.createCriteria().andIdIn(ids);
        List<Card> cards = cardMapper.selectByExample(cardExample);
        List<CardListVo> vos = new ArrayList<>();
        for (Card card : cards) {
            CardListVo vo = new CardListVo();
            vo.setId(card.getId());
            vo.setName(customer.getName());
            vo.setNumber(card.getNumber());
            vo.setResidualFlowValue(card.getResidualFlowValue());
            vo.setMonthUsedValue(card.getMonthUsedValue());
            vo.setTotalUsedValue(card.getTotalUsedValue());
            vo.setStatus(card.getStatus());
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

    public CardStatusVo status(String number) {
        String result = null;
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("ICCID", number);
        try {
            result = loadBalanceAsyncHttpClient.postBody(HOST + CARD_STATUS_URL, buildHeader(), jsonObject.toJSONString(), 5000L, TimeUnit.MILLISECONDS);
            logger.info("状态查询返回结果：{}", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JSON.parseObject(result, CardStatusVo.class);
    }

    /**
     * 构造header(必填参数字段)
     */
    public Map<String, Object> buildHeader() {
        Map<String, Object> map = new HashMap<>();
        map.put("Content-Type", "application/json");
        return map;
    }
}
