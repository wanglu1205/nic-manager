package com.nic.common.enums;

public enum RechargeStatusEnum {

    SUCCESS_SUCCESS("SUCCESS_SUCCESS", "充值成功返利成功订单"),
    FAIL_FAIL("FAIL_FAIL", "充值失败返利失败订单"),
    SUCCESS_FAIL("SUCCESS_FAIL", "充值成功返利失败订单");

    private String code;
    private String msg;

    RechargeStatusEnum(String code, String msg) {
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
}
