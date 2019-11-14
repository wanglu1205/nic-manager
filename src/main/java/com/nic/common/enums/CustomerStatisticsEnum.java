package com.nic.common.enums;

import org.apache.commons.lang3.StringUtils;

/**
 * @auther: wl
 * @date: 2019/11/14
 * @description:
 * @since : 1.0
 */
public enum  CustomerStatisticsEnum {

    today("today", "今日"),
    yesterday("yesterday", "昨日"),
    month("month", "本月"),
    last_month("last_month", "上月");

    private String code;
    private String msg;

    CustomerStatisticsEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static CustomerStatisticsEnum getEnumByCode(String code) {
        for (CustomerStatisticsEnum statisticsEnum : CustomerStatisticsEnum.values()) {
            if (StringUtils.equals(code, statisticsEnum.getCode())) {
                return statisticsEnum;
            }
        }
        return null;
    }
}
