package com.nic.dal.mapper;

import com.nic.dal.entity.RebateRecord;
import com.nic.dal.entity.RebateRecordExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RebateRecordMapper {
    /**
     *
     * @mbggenerated 2019-10-19
     */
    int countByExample(RebateRecordExample example);

    /**
     *
     * @mbggenerated 2019-10-19
     */
    int deleteByExample(RebateRecordExample example);

    /**
     *
     * @mbggenerated 2019-10-19
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbggenerated 2019-10-19
     */
    int insert(RebateRecord record);

    /**
     *
     * @mbggenerated 2019-10-19
     */
    int insertSelective(RebateRecord record);

    /**
     *
     * @mbggenerated 2019-10-19
     */
    List<RebateRecord> selectByExample(RebateRecordExample example);

    /**
     *
     * @mbggenerated 2019-10-19
     */
    RebateRecord selectByPrimaryKey(Long id);

    /**
     *
     * @mbggenerated 2019-10-19
     */
    int updateByExampleSelective(@Param("record") RebateRecord record, @Param("example") RebateRecordExample example);

    /**
     *
     * @mbggenerated 2019-10-19
     */
    int updateByExample(@Param("record") RebateRecord record, @Param("example") RebateRecordExample example);

    /**
     *
     * @mbggenerated 2019-10-19
     */
    int updateByPrimaryKeySelective(RebateRecord record);

    /**
     *
     * @mbggenerated 2019-10-19
     */
    int updateByPrimaryKey(RebateRecord record);
}