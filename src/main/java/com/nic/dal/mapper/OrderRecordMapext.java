package com.nic.dal.mapper;

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
}