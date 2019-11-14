package com.nic.common.enums;

import org.apache.commons.lang3.StringUtils;

public enum CustomerTypeEnum {

    one("one", "一级客户"),
    two("two", "二级客户"),
    three("three", "三级客户");

    private String code;
    private String msg;

    CustomerTypeEnum(String code, String msg) {
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

    public static CustomerTypeEnum getEnumByCode(String code) {
        for (CustomerTypeEnum customerTypeEnum : CustomerTypeEnum.values()) {
            if (StringUtils.equals(code, customerTypeEnum.getCode())) {
                return customerTypeEnum;
            }
        }
        return null;
    }
}
