package com.nic.dal.mapper;

import com.nic.dal.entity.RebateRule;
import com.nic.dal.entity.RebateRuleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RebateRuleMapper {
    /**
     *
     * @mbggenerated 2019-10-19
     */
    int countByExample(RebateRuleExample example);

    /**
     *
     * @mbggenerated 2019-10-19
     */
    int deleteByExample(RebateRuleExample example);

    /**
     *
     * @mbggenerated 2019-10-19
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbggenerated 2019-10-19
     */
    int insert(RebateRule record);

    /**
     *
     * @mbggenerated 2019-10-19
     */
    int insertSelective(RebateRule record);

    /**
     *
     * @mbggenerated 2019-10-19
     */
    List<RebateRule> selectByExample(RebateRuleExample example);

    /**
     *
     * @mbggenerated 2019-10-19
     */
    RebateRule selectByPrimaryKey(Long id);

    /**
     *
     * @mbggenerated 2019-10-19
     */
    int updateByExampleSelective(@Param("record") RebateRule record, @Param("example") RebateRuleExample example);

    /**
     *
     * @mbggenerated 2019-10-19
     */
    int updateByExample(@Param("record") RebateRule record, @Param("example") RebateRuleExample example);

    /**
     *
     * @mbggenerated 2019-10-19
     */
    int updateByPrimaryKeySelective(RebateRule record);

    /**
     *
     * @mbggenerated 2019-10-19
     */
    int updateByPrimaryKey(RebateRule record);
}