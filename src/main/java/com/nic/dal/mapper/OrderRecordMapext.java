package com.nic.dal.mapper;

import com.nic.dal.entity.OrderRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderRecordMapext {

    int selectTodayOrderCount(@Param("cardIdList") List<Long> cardIdList);

    int selectMonthOrderCount(@Param("cardIdList") List<Long> cardIdList);

    int selectLastTodayOrderCount(@Param("cardIdList") List<Long> cardIdList);

    int selectLastMonthOrderCount(@Param("cardIdList") List<Long> cardIdList);

    double selectTodayRebateCount(@Param("cardIdList") List<Long> cardIdList);

    double selectMonthRebateCount(@Param("cardIdList") List<Long> cardIdList);

    double selectLastTodayRebateCount(@Param("cardIdList") List<Long> cardIdList);

    double selectLastMonthRebateCount(@Param("cardIdList") List<Long> cardIdList);

    List<OrderRecord> selectTodayListByCardIds(@Param("cardIdList") List<Long> cardIdList);

    List<OrderRecord> selectMonthListByCardIds(@Param("cardIdList") List<Long> cardIdList);

    List<OrderRecord> selectYesterdayListByCardIds(@Param("cardIdList") List<Long> cardIdList);

    List<OrderRecord> selectLastMonthListByCardIds(@Param("cardIdList") List<Long> cardIdList);
}