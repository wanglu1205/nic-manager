package com.nic.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.nic.common.enums.CustomerTypeEnum;
import com.nic.common.model.PageResult;
import com.nic.common.model.dto.CustomerListDto;
import com.nic.common.model.dto.CustomerSaveDto;
import com.nic.common.model.dto.LoginDto;
import com.nic.common.model.dto.WxBindingDto;
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
import java.util.stream.Collectors;

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
        Customer customer = getInfoByToken(token);
        if (Objects.isNull(customer)){
            throw new AppException(ErrorCode.NOT_EXIST);
        }

        switch (CustomerTypeEnum.getEnumByCode(dto.getType())){
            case one:
                Page<CustomerListVo> page1 = PageHelper.startPage(dto.getPageNo(), dto.getPageSize());
                CustomerExample ce1 = new CustomerExample();
                CustomerExample.Criteria criteria = ce1.createCriteria();
                criteria.andParentIdEqualTo(customer.getId());
                if (StringUtils.isNotBlank(dto.getAccount())) {
                    criteria.andAccountLike("%" + dto.getAccount() + "%");
                }
                List<Customer> cs1 = customerMapper.selectByExample(ce1);
                if (CollectionUtils.isEmpty(cs1)){
                    return null;
                }
                return new PageResult<>(page1.getPageNum(), page1.getPageSize(), page1.getTotal(), getCustomerListVos(cs1));
            case two:
                CustomerExample ce2 = new CustomerExample();
                ce2.createCriteria().andParentIdEqualTo(customer.getId());
                List<Customer> cs2 = customerMapper.selectByExample(ce2);
                if (CollectionUtils.isEmpty(cs2)){
                    return null;
                }
                List<Long> ids1 = cs2.stream().map(Customer::getId).collect(Collectors.toList());

                ce2.clear();
                CustomerExample.Criteria criteria1 = ce2.createCriteria();
                criteria1.andParentIdIn(ids1);
                if (StringUtils.isNotBlank(dto.getAccount())) {
                    criteria1.andAccountLike("%" + dto.getAccount() + "%");
                }
                Page<CustomerListVo> page2 = PageHelper.startPage(dto.getPageNo(), dto.getPageSize());
                List<Customer> cs3 = customerMapper.selectByExample(ce2);
                if (CollectionUtils.isEmpty(cs3)){
                    return null;
                }
                return new PageResult<>(page2.getPageNum(), page2.getPageSize(), page2.getTotal(), getCustomerListVos(cs3));
            case three:
                CustomerExample ce3 = new CustomerExample();
                ce3.createCriteria().andParentIdEqualTo(customer.getId());
                List<Customer> cs4 = customerMapper.selectByExample(ce3);
                if (CollectionUtils.isEmpty(cs4)){
                    return null;
                }
                List<Long> ids2 = cs4.stream().map(Customer::getId).collect(Collectors.toList());

                ce3.clear();
                ce3.createCriteria().andParentIdIn(ids2);
                List<Customer> cs5 = customerMapper.selectByExample(ce3);
                if (CollectionUtils.isEmpty(cs5)){
                    return null;
                }
                List<Long> ids3 = cs5.stream().map(Customer::getId).collect(Collectors.toList());

                ce3.clear();
                CustomerExample.Criteria criteria2 = ce3.createCriteria();
                criteria2.andParentIdIn(ids3);
                if (StringUtils.isNotBlank(dto.getAccount())) {
                    criteria2.andAccountLike("%" + dto.getAccount() + "%");
                }
                Page<CustomerListVo> page3 = PageHelper.startPage(dto.getPageNo(), dto.getPageSize());
                List<Customer> cs6 = customerMapper.selectByExample(ce3);
                if (CollectionUtils.isEmpty(cs6)){
                    return null;
                }
                return new PageResult<>(page3.getPageNum(), page3.getPageSize(), page3.getTotal(), getCustomerListVos(cs6));
            default:

        }
        return null;
    }

    private List<CustomerListVo> getCustomerListVos(List<Customer> cs1) {
        List<CustomerListVo> vos = new ArrayList<>();
        cs1.forEach(c -> {
            CustomerListVo vo = new CustomerListVo();
            vo.setId(c.getId());
            vo.setAccount(c.getAccount());
            vo.setName(c.getName());
            Customer parent = customerMapper.selectByPrimaryKey(c.getParentId());
            if (Objects.nonNull(parent)){
                vo.setParentName(parent.getName());
            }
            vo.setTel(c.getTel());
            vo.setGmtCreate(c.getGmtCreate());
            vo.setAlipayName(c.getAlipayName());
            vo.setAlipayAccount(c.getAlipayAccount());
            vo.setCredit(c.getCredit());
            vo.setGroupNumber(c.getGroupNumber());
            vo.setEmail(c.getEmail());
            vo.setCommission(c.getCommission());
            vo.setIsEnabled(c.getIsEnabled());
            vos.add(vo);
        });
        return vos;
    }

    public Customer getInfoByToken(String token) {
        CustomerExample customerExample = new CustomerExample();
        customerExample.createCriteria().andTokenEqualTo(token);
        List<Customer> customers = customerMapper.selectByExample(customerExample);
        if (CollectionUtils.isEmpty(customers)){
            throw new AppException(ErrorCode.NOT_EXIST, "该用户不存在");
        }
        return customers.get(0);
    }

    public Boolean save(CustomerSaveDto dto, String token) {
        if (Objects.isNull(dto.getId())){
            CustomerExample customerExample = new CustomerExample();
            customerExample.createCriteria().andAccountEqualTo(dto.getAccount());
            List<Customer> customers = customerMapper.selectByExample(customerExample);
            if (!CollectionUtils.isEmpty(customers)){
                throw new AppException(ErrorCode.ERR_EXISTED, "该用户已存在");
            }
        }
        Customer customer = new Customer();
        customer.setPassword(BCrypt.hashpw(dto.getPassword(), BCrypt.gensalt()));
        customer.setName(dto.getName());
        customer.setTel(dto.getTel());
        customer.setEmail(dto.getEmail());
        customer.setAlipayName(dto.getAlipayName());
        customer.setGroupNumber(dto.getGroupNumber());
        customer.setAlipayAccount(dto.getAlipayAccount());
        Date date = new Date();
        customer.setGmtModified(date);
        if (Objects.isNull(dto.getId())){
            Customer loginer = getInfoByToken(token);
            customer.setAccount(dto.getAccount());
            customer.setIsEnabled(true);
            customer.setParentId(loginer.getId());
            customer.setCredit(0);
            customer.setCommission(new BigDecimal(0));
            customer.setGmtCreate(date);
            customerMapper.insertSelective(customer);
        }else {
            customer.setId(dto.getId());
            customer.setIsEnabled(dto.getIsEnabled());
            customerMapper.updateByPrimaryKeySelective(customer);
        }
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
        c.setToken(token);
        customerMapper.updateByPrimaryKeySelective(c);
        //token放入缓存
        tokenCacheService.addToken(token);
        customer.setToken(token);
        customer.setPassword(null);
        return customer;
    }

    public Boolean logout(String token) {
        tokenCacheService.deleteToken(token);
        return true;
    }

    public Customer info(Long id) {
        Customer customer = customerMapper.selectByPrimaryKey(id);
        customer.setPassword(null);
        return customer;
    }

    public Boolean wxBinding(WxBindingDto dto) {
        Customer customer = new Customer();
        customer.setId(dto.getCustomerId());
        customer.setOpenId(dto.getOpenid());
        customerMapper.updateByPrimaryKeySelective(customer);
        return true;
    }
}
