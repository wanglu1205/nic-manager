package com.nic.dal.mapper;

public interface OrderRecordMapext {

    int selectTodayOrderCount();

    int selectMonthOrderCount();

    int selectLastTodayOrderCount();

    int selectLastMonthOrderCount();

    double selectTodayRebateCount();

    double selectMonthRebateCount();

    double selectLastTodayRebateCount();

    double selectLastMonthRebateCount();
}