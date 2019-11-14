package com.nic.service;

import com.nic.auth.AuthConstants;
import com.nic.common.enums.CustomerStatisticsEnum;
import com.nic.common.model.vo.CustomerVo;
import com.nic.common.model.vo.ProfitVo;
import com.nic.config.AppException;
import com.nic.config.ErrorCode;
import com.nic.dal.entity.*;
import com.nic.dal.mapper.CustomerMapper;
import com.nic.dal.mapper.OrderRecordMapext;
import com.nic.dal.mapper.OrderRecordMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @auther: wl
 * @date: 2019/10/18
 * @description:
 * @since : 1.0
 */
@Service
public class StatisticsService {

    @Resource
    private OrderRecordMapper orderRecordMapper;

    @Resource
    private CustomerMapper customerMapper;

    @Resource
    private CustomerService customerService;

    @Resource
    private OrderRecordMapext orderRecordMapext;

    public ProfitVo profit(String token) {
        Customer customer = customerService.getInfoByToken(token);
        if (Objects.isNull(customer)){
            throw new AppException(ErrorCode.NOT_EXIST);
        }

        if (StringUtils.equals(customer.getAccount(), AuthConstants.superAdminAccount)){
            CustomerExample customerExample = new CustomerExample();
            customerExample.createCriteria().andParentIdIsNotNull();
            int customerNum = customerMapper.countByExample(customerExample);

            OrderRecordExample orderRecordExample = new OrderRecordExample();
            List<OrderRecord> orderRecords = orderRecordMapper.selectByExample(orderRecordExample);

            BigDecimal rebateCount = orderRecords.stream().map(OrderRecord::getRebate).reduce(BigDecimal.ZERO, BigDecimal::add);

            int todayOrderCount = orderRecordMapext.selectTodayOrderCount(null);
            int monthOrderCount = orderRecordMapext.selectMonthOrderCount(null);
            int lastTodayOrderCount = orderRecordMapext.selectLastTodayOrderCount(null);
            int lastMonthOrderCount = orderRecordMapext.selectLastMonthOrderCount(null);
            double todayRebateCount = orderRecordMapext.selectTodayRebateCount(null);
            double monthRebateCount = orderRecordMapext.selectMonthRebateCount(null);
            double lastTodayRebateCount = orderRecordMapext.selectLastTodayRebateCount(null);
            double lastMonthRebateCount = orderRecordMapext.selectLastMonthRebateCount(null);
            ProfitVo vo = new ProfitVo();
            vo.setOneCustomerNum(customerNum);
            vo.setCustomerNum(customerNum);
            vo.setRebateCount(rebateCount);
            vo.setOrderNum(orderRecords.size());
            vo.setTodayOrderNum(todayOrderCount);
            vo.setYesterdayOrderNum(lastTodayOrderCount);
            vo.setMonthOrderNum(monthOrderCount);
            vo.setLastMonthOrderNum(lastMonthOrderCount);
            vo.setTodayRebateCount(new BigDecimal(todayRebateCount));
            vo.setMonthRebateCount(new BigDecimal(monthRebateCount));
            vo.setYesterdayRebateCount(new BigDecimal(lastTodayRebateCount));
            vo.setLastMonthRebateCount(new BigDecimal(lastMonthRebateCount));
            return vo;
        }else {
            CustomerExample customerExample = new CustomerExample();
            customerExample.createCriteria().andParentIdEqualTo(customer.getId());
            int oneCustomerNum = customerMapper.countByExample(customerExample);

            List<Long> cardIdList = new ArrayList<>();
            String cardIds = customer.getCardIds();
            if (StringUtils.isNotBlank(cardIds)){
                String[] ids = cardIds.split(",");
                for (String id: ids){
                    cardIdList.add(Long.valueOf(id));
                }
            }

            if (CollectionUtils.isEmpty(cardIdList)){
                ProfitVo vo = new ProfitVo();
                vo.setOneCustomerNum(oneCustomerNum);
                vo.setCustomerNum(oneCustomerNum);
                vo.setRebateCount(new BigDecimal(0));
                vo.setOrderNum(0);
                vo.setTodayOrderNum(0);
                vo.setYesterdayOrderNum(0);
                vo.setMonthOrderNum(0);
                vo.setLastMonthOrderNum(0);
                vo.setTodayRebateCount(new BigDecimal(0));
                vo.setMonthRebateCount(new BigDecimal(0));
                vo.setYesterdayRebateCount(new BigDecimal(0));
                vo.setLastMonthRebateCount(new BigDecimal(0));
                return vo;
            }

            OrderRecordExample orderRecordExample = new OrderRecordExample();
            orderRecordExample.createCriteria().andCardIdIn(cardIdList);
            List<OrderRecord> orderRecords = orderRecordMapper.selectByExample(orderRecordExample);

            BigDecimal rebateCount = orderRecords.stream().map(OrderRecord::getRebate).reduce(BigDecimal.ZERO, BigDecimal::add);

            int todayOrderCount = orderRecordMapext.selectTodayOrderCount(cardIdList);
            int monthOrderCount = orderRecordMapext.selectMonthOrderCount(cardIdList);
            int lastTodayOrderCount = orderRecordMapext.selectLastTodayOrderCount(cardIdList);
            int lastMonthOrderCount = orderRecordMapext.selectLastMonthOrderCount(cardIdList);
            double todayRebateCount = orderRecordMapext.selectTodayRebateCount(cardIdList);
            double monthRebateCount = orderRecordMapext.selectMonthRebateCount(cardIdList);
            double lastTodayRebateCount = orderRecordMapext.selectLastTodayRebateCount(cardIdList);
            double lastMonthRebateCount = orderRecordMapext.selectLastMonthRebateCount(cardIdList);
            ProfitVo vo = new ProfitVo();
            vo.setOneCustomerNum(oneCustomerNum);
            vo.setCustomerNum(oneCustomerNum);
            vo.setRebateCount(rebateCount);
            vo.setOrderNum(orderRecords.size());
            vo.setTodayOrderNum(todayOrderCount);
            vo.setYesterdayOrderNum(lastTodayOrderCount);
            vo.setMonthOrderNum(monthOrderCount);
            vo.setLastMonthOrderNum(lastMonthOrderCount);
            vo.setTodayRebateCount(new BigDecimal(todayRebateCount));
            vo.setMonthRebateCount(new BigDecimal(monthRebateCount));
            vo.setYesterdayRebateCount(new BigDecimal(lastTodayRebateCount));
            vo.setLastMonthRebateCount(new BigDecimal(lastMonthRebateCount));
            return vo;
        }
    }

    public List<CustomerVo> customer(String token, String type) {
        Customer customer = customerService.getInfoByToken(token);
        if (Objects.isNull(customer)){
            throw new AppException(ErrorCode.NOT_EXIST);
        }
        if (!StringUtils.equals(customer.getAccount(), AuthConstants.superAdminAccount)){
            return null;
        }
        CustomerExample customerExample = new CustomerExample();
        customerExample.createCriteria().andParentIdIsNotNull();
        List<Customer> customerList = customerMapper.selectByExample(customerExample);
        if (CollectionUtils.isEmpty(customerList)){
            return null;
        }
        List<CustomerVo> vos = new ArrayList<>();
        customerList.forEach(c -> {
            List<Long> cardIdList = new ArrayList<>();
            String cardIds = c.getCardIds();
            if (StringUtils.isNotBlank(cardIds)){
                String[] ids = cardIds.split(",");
                for (String id: ids){
                    cardIdList.add(Long.valueOf(id));
                }
            }

            if (CollectionUtils.isEmpty(cardIdList)){
                return;
            }
            List<OrderRecord> orderRecords = new ArrayList<>();
            switch (CustomerStatisticsEnum.getEnumByCode(type)){
                case today:
                    orderRecords = orderRecordMapext.selectTodayListByCardIds(cardIdList);
                    break;
                case month:
                    orderRecords = orderRecordMapext.selectMonthListByCardIds(cardIdList);
                    break;
                case yesterday:
                    orderRecords = orderRecordMapext.selectYesterdayListByCardIds(cardIdList);
                    break;
                case last_month:
                    orderRecords = orderRecordMapext.selectLastMonthListByCardIds(cardIdList);
                    break;
                    default:
            }

            BigDecimal rebateCount = orderRecords.stream().map(OrderRecord::getRebate).reduce(BigDecimal.ZERO, BigDecimal::add);

            CustomerVo vo = new CustomerVo();
            vo.setName(c.getName());
            vo.setOrderCount(orderRecords.size());
            vo.setRebateCount(rebateCount);

            vos.add(vo);
        });

        return vos;
    }
}
