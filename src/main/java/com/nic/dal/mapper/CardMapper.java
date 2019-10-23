package com.nic.dal.mapper;

import com.nic.dal.entity.Card;
import com.nic.dal.entity.CardExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CardMapper {
    /**
     *
     * @mbggenerated 2019-10-23
     */
    int countByExample(CardExample example);

    /**
     *
     * @mbggenerated 2019-10-23
     */
    int deleteByExample(CardExample example);

    /**
     *
     * @mbggenerated 2019-10-23
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbggenerated 2019-10-23
     */
    int insert(Card record);

    /**
     *
     * @mbggenerated 2019-10-23
     */
    int insertSelective(Card record);

    /**
     *
     * @mbggenerated 2019-10-23
     */
    List<Card> selectByExample(CardExample example);

    /**
     *
     * @mbggenerated 2019-10-23
     */
    Card selectByPrimaryKey(Long id);

    /**
     *
     * @mbggenerated 2019-10-23
     */
    int updateByExampleSelective(@Param("record") Card record, @Param("example") CardExample example);

    /**
     *
     * @mbggenerated 2019-10-23
     */
    int updateByExample(@Param("record") Card record, @Param("example") CardExample example);

    /**
     *
     * @mbggenerated 2019-10-23
     */
    int updateByPrimaryKeySelective(Card record);

    /**
     *
     * @mbggenerated 2019-10-23
     */
    int updateByPrimaryKey(Card record);
}