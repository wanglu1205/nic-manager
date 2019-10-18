package com.nic.service;

import com.nic.common.model.dto.RechargeDto;
import com.nic.config.AppException;
import com.nic.config.ErrorCode;
import com.nic.dal.entity.*;
import com.nic.dal.entity.Package;
import com.nic.dal.mapper.CardMapper;
import com.nic.dal.mapper.OrderMapper;
import com.nic.dal.mapper.PackageMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @auther: wl
 * @date: 2019/10/18
 * @description:
 * @since : 1.0
 */
@Service
public class OrderService {

    @Resource
    private CardMapper cardMapper;

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private CustomerService customerService;

    public Boolean recharge(RechargeDto dto, String token) {
        Customer customer = customerService.getInfoByToken(token);
        List<String> numbers = dto.getNumbers();
        CardExample cardExample = new CardExample();
        numbers.forEach(number -> {
            cardExample.createCriteria().andNumberEqualTo(number);
            List<Card> cards = cardMapper.selectByExample(cardExample);
            if (CollectionUtils.isEmpty(cards)){
                return;
            }
            Card card = cards.get(0);
            Order order = new Order();
            order.setCardId(card.getId());
            order.setChannel("WXPAY");
            order.setCustomerId(customer.getId());
            order.setPackageId(dto.getPackageId());
            order.setStatus("SUCCESS");
            Date date = new Date();
            order.setGmtCreate(date);
            order.setGmtModified(date);
            orderMapper.insertSelective(order);
        });
        return true;
    }
}
