package com.nic.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.nic.common.model.PageResult;
import com.nic.common.model.dto.CustomerListDto;
import com.nic.common.model.dto.CustomerSaveDto;
import com.nic.common.model.dto.LoginDto;
import com.nic.common.model.vo.CustomerListVo;
import com.nic.common.util.RandomCodeUtil;
import com.nic.config.AppException;
import com.nic.config.ErrorCode;
import com.nic.dal.entity.Customer;
import com.nic.dal.entity.CustomerExample;
import com.nic.dal.mapper.CustomerMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @auther: wl
 * @date: 2019/10/17
 * @description:
 * @since : 1.0
 */
@Service
public class CustomerService {

    @Resource
    private CustomerMapper customerMapper;

    @Resource
    private TokenCacheService tokenCacheService;


    public PageResult<CustomerListVo> list(CustomerListDto dto, String token) {
        Customer customer = null;
        if (Objects.isNull(dto.getId())){
            customer = getInfoByToken(token);
        }else {
            customer = customerMapper.selectByPrimaryKey(dto.getId());
        }
        Page<CustomerListVo> page = PageHelper.startPage(dto.getPageNo(), dto.getPageSize());
        CustomerExample customerExample = new CustomerExample();
        CustomerExample.Criteria criteria = customerExample.createCriteria();
        criteria.andParentIdEqualTo(customer.getId());
        if (StringUtils.isNotBlank(dto.getAccount())) {
            criteria.andAccountLike("%" + dto.getAccount() + "%");
        }
        List<Customer> customers = customerMapper.selectByExample(customerExample);

        List<CustomerListVo> vos = new ArrayList<>();
        customers.forEach(c -> {
            CustomerListVo vo = new CustomerListVo();
            vo.setId(c.getId());
            vo.setAccount(c.getAccount());
            vo.setName(c.getName());
            vo.setParentName(c.getName());
            vo.setTel(c.getTel());
            vo.setGmtCreate(c.getGmtCreate());
            vo.setAlipayName(c.getAlipayName());
            vo.setAlipayAccount(c.getAlipayAccount());
            vo.setCredit(c.getCredit());
            vo.setCommission(c.getCommission());
            vos.add(vo);
        });
        return new PageResult<>(page.getPageNum(), page.getPageSize(), page.getTotal(), vos);
    }

    private Customer getInfoByToken(String token) {
        CustomerExample customerExample = new CustomerExample();
        customerExample.createCriteria().andTokenEqualTo(token);
        List<Customer> customers = customerMapper.selectByExample(customerExample);
        if (CollectionUtils.isEmpty(customers)){
            throw new AppException(ErrorCode.NOT_EXIST, "该用户不存在");
        }
        return customers.get(0);
    }

    public Boolean save(CustomerSaveDto dto, String token) {
        Customer loginer = getInfoByToken(token);
        Customer customer = new Customer();
        customer.setAccount(dto.getAccount());
        customer.setPassword(dto.getPassword());
        customer.setName(dto.getName());
        customer.setTel(dto.getTel());
        customer.setEmail(dto.getEmail());
        customer.setAlipayName(dto.getAlipayName());
        customer.setAlipayAccount(dto.getAlipayAccount());
        customer.setParentId(loginer.getId());
        customer.setCredit(0);
        customer.setCommission(new BigDecimal(0));
        Date date = new Date();
        customer.setGmtCreate(date);
        customer.setGmtModified(date);
        customerMapper.insertSelective(customer);
        return true;
    }

    public Customer login(LoginDto dto) {
        CustomerExample customerExample = new CustomerExample();
        CustomerExample.Criteria criteria = customerExample.createCriteria();
        criteria.andAccountEqualTo(dto.getAccount());
        List<Customer> customers = customerMapper.selectByExample(customerExample);
        if (CollectionUtils.isEmpty(customers)){
            throw new AppException(ErrorCode.NOT_EXIST, "该用户不存在");
        }
        Customer customer = customers.get(0);
        if (!BCrypt.checkpw(dto.getPassword(), customer.getPassword())) {
            throw new AppException(ErrorCode.ERR_PWD, "账号或密码错误");
        }
        //清除之前token
        tokenCacheService.deleteToken(customer.getToken());
        //更新token
        String token = RandomCodeUtil.getUuid();
        Customer c = new Customer();
        c.setId(customer.getId());
        c.setToken(customer.getToken());
        customerMapper.updateByPrimaryKeySelective(c);
        //token放入缓存
        tokenCacheService.addToken(token);
        customer.setToken(token);
        return customer;
    }

    public Boolean logout(String token) {
        tokenCacheService.deleteToken(token);
        return true;
    }
}
