package com.nic.service;

import com.nic.common.model.vo.ProfitVo;
import com.nic.dal.entity.Customer;
import com.nic.dal.entity.CustomerExample;
import com.nic.dal.entity.OrderRecordExample;
import com.nic.dal.mapper.CustomerMapper;
import com.nic.dal.mapper.OrderRecordMapext;
import com.nic.dal.mapper.OrderRecordMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
        List<Customer> c1 = null;
        Customer customer = customerService.getInfoByToken(token);
        CustomerExample customerExample = new CustomerExample();
        customerExample.createCriteria().andParentIdEqualTo(customer.getId());
        List<Customer> customers = customerMapper.selectByExample(customerExample);
        c1.addAll(customers);
        int oneCustomerNum = customers.size();
        int customerNum = 0;
        while (true){
            List<Customer> cs = new ArrayList<>();
            for (Customer c : customers) {
                customerExample.clear();
                customerExample.createCriteria().andParentIdEqualTo(c.getId());
                List<Customer> customerList = customerMapper.selectByExample(customerExample);
                if (CollectionUtils.isEmpty(customerList)){
                    continue;
                }
                c1.addAll(customerList);
                customerNum += customerList.size();
                cs.addAll(customerList);
            }
            if (!CollectionUtils.isEmpty(cs)){
                customers = cs;
            }else {
                break;
            }
        }
        BigDecimal rebateCount = new BigDecimal(0);
        int orderNum = 0;
        for (Customer c : c1) {
            rebateCount.add(c.getCommission());
            OrderRecordExample example = new OrderRecordExample();
            example.createCriteria().andCustomerIdEqualTo(c.getId());
            int count = orderRecordMapper.countByExample(example);
            orderNum += count;
        }

        int todayOrderCount = orderRecordMapext.selectTodayOrderCount();
        int monthOrderCount = orderRecordMapext.selectMonthOrderCount();
        int lastTodayOrderCount = orderRecordMapext.selectLastTodayOrderCount();
        int lastMonthOrderCount = orderRecordMapext.selectLastMonthOrderCount();
        ProfitVo vo = new ProfitVo();
        vo.setOneCustomerNum(oneCustomerNum);
        vo.setCustomerNum(customerNum);
        vo.setRebateCount(rebateCount);
        vo.setOrderNum(orderNum);
        vo.setTodayOrderNum(todayOrderCount);
        vo.setYesterdayOrderNum(lastTodayOrderCount);
        vo.setMonthOrderNum(monthOrderCount);
        vo.setLastMonthOrderNum(lastMonthOrderCount);
        return vo;
    }
}
