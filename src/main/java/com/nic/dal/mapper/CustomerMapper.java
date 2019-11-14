package com.nic.dal.mapper;

import com.nic.dal.entity.Customer;
import com.nic.dal.entity.CustomerExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerMapper {
    /**
     *
     * @mbggenerated 2019-11-14
     */
    int countByExample(CustomerExample example);

    /**
     *
     * @mbggenerated 2019-11-14
     */
    int deleteByExample(CustomerExample example);

    /**
     *
     * @mbggenerated 2019-11-14
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbggenerated 2019-11-14
     */
    int insert(Customer record);

    /**
     *
     * @mbggenerated 2019-11-14
     */
    int insertSelective(Customer record);

    /**
     *
     * @mbggenerated 2019-11-14
     */
    List<Customer> selectByExample(CustomerExample example);

    /**
     *
     * @mbggenerated 2019-11-14
     */
    Customer selectByPrimaryKey(Long id);

    /**
     *
     * @mbggenerated 2019-11-14
     */
    int updateByExampleSelective(@Param("record") Customer record, @Param("example") CustomerExample example);

    /**
     *
     * @mbggenerated 2019-11-14
     */
    int updateByExample(@Param("record") Customer record, @Param("example") CustomerExample example);

    /**
     *
     * @mbggenerated 2019-11-14
     */
    int updateByPrimaryKeySelective(Customer record);

    /**
     *
     * @mbggenerated 2019-11-14
     */
    int updateByPrimaryKey(Customer record);
}