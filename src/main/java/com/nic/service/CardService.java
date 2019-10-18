package com.nic.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.nic.common.model.PageResult;
import com.nic.common.model.dto.CardListDto;
import com.nic.common.model.dto.RechargeDto;
import com.nic.common.model.vo.CardListVo;
import com.nic.common.model.vo.CustomerListVo;
import com.nic.dal.entity.Card;
import com.nic.dal.entity.CardExample;
import com.nic.dal.entity.Customer;
import com.nic.dal.mapper.CardMapper;
import com.nic.dal.mapper.CustomerMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @auther: wl
 * @date: 2019/10/18
 * @description:
 * @since : 1.0
 */
@Service
public class CardService {

    @Resource
    private CardMapper cardMapper;

    @Resource
    private CustomerMapper customerMapper;

    @Resource
    private CustomerService customerService;

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
}
