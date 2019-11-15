package com.nic.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.nic.auth.AuthConstants;
import com.nic.common.model.PageResult;
import com.nic.common.model.dto.RebateRecordListDto;
import com.nic.common.model.dto.RebateRuleSaveDto;
import com.nic.common.model.vo.PackageListVo;
import com.nic.common.model.vo.RebateRecordListVo;
import com.nic.config.AppException;
import com.nic.config.ErrorCode;
import com.nic.dal.entity.*;
import com.nic.dal.entity.Package;
import com.nic.dal.mapper.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @auther: wl
 * @date: 2019/10/19
 * @description:
 * @since : 1.0
 */
@Service
public class RebateService {

    @Resource
    private CustomerMapper customerMapper;

    @Resource
    private RebateRuleMapper rebateRuleMapper;

    @Resource
    private CardMapper cardMapper;

    @Resource
    private PackageMapper packageMapper;

    @Resource
    private RebateRecordMapper rebateRecordMapper;

    @Resource
    private OrderRecordMapper orderRecordMapper;

    @Resource
    private CustomerService customerService;

    public Boolean ruleSave(RebateRuleSaveDto dto) {
        List<Long> customerIds = dto.getCustomerIds();
        Date date = new Date();
        customerIds.forEach(customerId -> {
            RebateRuleExample example = new RebateRuleExample();
            example.createCriteria().andPackageIdEqualTo(dto.getPackageId()).andCustomerIdEqualTo(customerId);
            List<RebateRule> rebateRules = rebateRuleMapper.selectByExample(example);
            if (!CollectionUtils.isEmpty(rebateRules)){
                throw new AppException(ErrorCode.ERR_EXISTED, "该套餐已为该代理商设置返利金额");
            }
            RebateRule rule = new RebateRule();
            rule.setCustomerId(customerId);
            rule.setMoney(dto.getMoney());
            rule.setPackageId(dto.getPackageId());
            rule.setGmtCreate(date);
            rule.setGmtModified(date);
            rebateRuleMapper.insertSelective(rule);
        });
        return true;
    }

    public PageResult<RebateRecordListVo> recordList(RebateRecordListDto dto, String token) {
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
        if (!StringUtils.equals(loginer.getAccount(), AuthConstants.superAdminAccount) && CollectionUtils.isEmpty(cardIdList)){
            return null;
        }
        RebateRecordExample rebateRecordExample = new RebateRecordExample();
        RebateRecordExample.Criteria criteria = rebateRecordExample.createCriteria();
        if (!StringUtils.equals(loginer.getAccount(),AuthConstants.superAdminAccount) && !CollectionUtils.isEmpty(cardIdList)){
            criteria.andCardIdIn(cardIdList);
        }
        if (StringUtils.isNotBlank(dto.getName())){
            CustomerExample customerExample = new CustomerExample();
            customerExample.createCriteria().andNameLike("%" + dto.getName() + "%");
            List<Customer> customerList = customerMapper.selectByExample(customerExample);
            if (!CollectionUtils.isEmpty(customerList)){
                List<Long> ids = customerList.stream().map(Customer::getId).collect(Collectors.toList());
                criteria.andCustomerIdIn(ids);
            }
        }
        if (StringUtils.isNotBlank(dto.getNumber())){
            CardExample cardExample = new CardExample();
            cardExample.createCriteria().andNumberLike("%" + dto.getNumber() + "%");
            List<Card> cards = cardMapper.selectByExample(cardExample);
            if (!CollectionUtils.isEmpty(cards)){
                List<Long> ids = cards.stream().map(Card::getId).collect(Collectors.toList());
                criteria.andCardIdIn(ids);
            }
        }
        if (Objects.nonNull(dto.getStartTime())){
            criteria.andGmtCreateGreaterThanOrEqualTo(dto.getStartTime());
        }
        if (Objects.nonNull(dto.getEndTime())){
            criteria.andGmtCreateLessThan(dto.getEndTime());
        }
        Page<RebateRecordListVo> page = PageHelper.startPage(dto.getPageNo(), dto.getPageSize());
        List<RebateRecord> rebateRecords = rebateRecordMapper.selectByExample(rebateRecordExample);
        List<RebateRecordListVo> vos = new ArrayList<>();
        rebateRecords.forEach(rebateRecord -> {
            RebateRecordListVo vo = new RebateRecordListVo();
            vo.setId(rebateRecord.getId());
            Customer customer = customerMapper.selectByPrimaryKey(rebateRecord.getCustomerId());
            if (Objects.nonNull(customer)){
                vo.setCustomerName(customer.getName());
            }
            Card card = cardMapper.selectByPrimaryKey(rebateRecord.getCardId());
            if (Objects.nonNull(card)){
                vo.setNumber(card.getNumber());
            }
            Package aPackage = packageMapper.selectByPrimaryKey(rebateRecord.getPackageId());
            if (Objects.nonNull(aPackage)){
                vo.setPackageName(aPackage.getName());
            }
            Customer rebateCustomer = customerMapper.selectByPrimaryKey(rebateRecord.getRebateCustomerId());
            if (Objects.nonNull(rebateCustomer)){
                vo.setRebateCustomerName(rebateCustomer.getName());
            }
            vo.setStartMoney(rebateRecord.getMoney());
            vo.setMoney(rebateRecord.getRebateMoney());
            vo.setEndMoney(rebateRecord.getMoney().add(rebateRecord.getRebateMoney()));
            OrderRecord orderRecord = orderRecordMapper.selectByPrimaryKey(rebateRecord.getOrderId());
            if (Objects.nonNull(orderRecord)){
                vo.setOrderNumber(orderRecord.getOrderNumber());
            }
            vo.setTime(rebateRecord.getGmtCreate());
            vos.add(vo);
        });
        return new PageResult<>(page.getPageNum(), page.getPageSize(), page.getTotal(), vos);
    }
}
