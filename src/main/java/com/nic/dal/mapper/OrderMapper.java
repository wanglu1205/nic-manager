package com.nic.dal.mapper;

import com.nic.dal.entity.Order;
import com.nic.dal.entity.OrderExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {
    /**
     *
     * @mbggenerated 2019-10-18
     */
    int countByExample(OrderExample example);

    /**
     *
     * @mbggenerated 2019-10-18
     */
    int deleteByExample(OrderExample example);

    /**
     *
     * @mbggenerated 2019-10-18
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbggenerated 2019-10-18
     */
    int insert(Order record);

    /**
     *
     * @mbggenerated 2019-10-18
     */
    int insertSelective(Order record);

    /**
     *
     * @mbggenerated 2019-10-18
     */
    List<Order> selectByExample(OrderExample example);

    /**
     *
     * @mbggenerated 2019-10-18
     */
    Order selectByPrimaryKey(Long id);

    /**
     *
     * @mbggenerated 2019-10-18
     */
    int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderExample example);

    /**
     *
     * @mbggenerated 2019-10-18
     */
    int updateByExample(@Param("record") Order record, @Param("example") OrderExample example);

    /**
     *
     * @mbggenerated 2019-10-18
     */
    int updateByPrimaryKeySelective(Order record);

    /**
     *
     * @mbggenerated 2019-10-18
     */
    int updateByPrimaryKey(Order record);
}