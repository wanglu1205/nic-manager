package com.nic.dal.mapper;

import com.nic.dal.entity.OrderRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderRecordMapext {

    int selectTodayOrderCount(List<Long> cardIdList);

    int selectMonthOrderCount(List<Long> cardIdList);

    int selectLastTodayOrderCount(List<Long> cardIdList);

    int selectLastMonthOrderCount(List<Long> cardIdList);

    double selectTodayRebateCount(List<Long> cardIdList);

    double selectMonthRebateCount(List<Long> cardIdList);

    double selectLastTodayRebateCount(List<Long> cardIdList);

    double selectLastMonthRebateCount(List<Long> cardIdList);

    List<OrderRecord> selectTodayListByCardIds(@Param("cardIdList") List<Long> cardIdList);

    List<OrderRecord> selectMonthListByCardIds(@Param("cardIdList") List<Long> cardIdList);

    List<OrderRecord> selectYesterdayListByCardIds(@Param("cardIdList") List<Long> cardIdList);

    List<OrderRecord> selectLastMonthListByCardIds(@Param("cardIdList") List<Long> cardIdList);
}