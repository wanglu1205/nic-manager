package com.nic.dal.mapper;

import com.nic.dal.entity.Card;
import com.nic.dal.entity.CardExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CardMapper {
    /**
     *
     * @mbggenerated 2019-10-18
     */
    int countByExample(CardExample example);

    /**
     *
     * @mbggenerated 2019-10-18
     */
    int deleteByExample(CardExample example);

    /**
     *
     * @mbggenerated 2019-10-18
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbggenerated 2019-10-18
     */
    int insert(Card record);

    /**
     *
     * @mbggenerated 2019-10-18
     */
    int insertSelective(Card record);

    /**
     *
     * @mbggenerated 2019-10-18
     */
    List<Card> selectByExample(CardExample example);

    /**
     *
     * @mbggenerated 2019-10-18
     */
    Card selectByPrimaryKey(Long id);

    /**
     *
     * @mbggenerated 2019-10-18
     */
    int updateByExampleSelective(@Param("record") Card record, @Param("example") CardExample example);

    /**
     *
     * @mbggenerated 2019-10-18
     */
    int updateByExample(@Param("record") Card record, @Param("example") CardExample example);

    /**
     *
     * @mbggenerated 2019-10-18
     */
    int updateByPrimaryKeySelective(Card record);

    /**
     *
     * @mbggenerated 2019-10-18
     */
    int updateByPrimaryKey(Card record);
}