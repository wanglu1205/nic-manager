package com.nic.dal.mapper;

import com.nic.dal.entity.OrderRecord;
import com.nic.dal.entity.OrderRecordExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderRecordMapper {
    /**
     *
     * @mbggenerated 2019-10-19
     */
    int countByExample(OrderRecordExample example);

    /**
     *
     * @mbggenerated 2019-10-19
     */
    int deleteByExample(OrderRecordExample example);

    /**
     *
     * @mbggenerated 2019-10-19
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbggenerated 2019-10-19
     */
    int insert(OrderRecord record);

    /**
     *
     * @mbggenerated 2019-10-19
     */
    int insertSelective(OrderRecord record);

    /**
     *
     * @mbggenerated 2019-10-19
     */
    List<OrderRecord> selectByExample(OrderRecordExample example);

    /**
     *
     * @mbggenerated 2019-10-19
     */
    OrderRecord selectByPrimaryKey(Long id);

    /**
     *
     * @mbggenerated 2019-10-19
     */
    int updateByExampleSelective(@Param("record") OrderRecord record, @Param("example") OrderRecordExample example);

    /**
     *
     * @mbggenerated 2019-10-19
     */
    int updateByExample(@Param("record") OrderRecord record, @Param("example") OrderRecordExample example);

    /**
     *
     * @mbggenerated 2019-10-19
     */
    int updateByPrimaryKeySelective(OrderRecord record);

    /**
     *
     * @mbggenerated 2019-10-19
     */
    int updateByPrimaryKey(OrderRecord record);
}