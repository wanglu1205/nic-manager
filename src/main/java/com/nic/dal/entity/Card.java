package com.nic.dal.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Card implements Serializable {
    /**
     * 
     */
    private Long id;

    /**
     * 卡号
     */
    private String number;

    /**
     * 
     */
    private Date gmtCreate;

    /**
     * 
     */
    private Date gmtModified;

    /**
     * 剩余流量
     */
    private BigDecimal residualFlowValue;

    /**
     * 本月已用
     */
    private String monthUsedValue;

    /**
     * 累计已用
     */
    private String totalUsedValue;

    /**
     * 状态
     */
    private String status;

    /**
     * 运营商
     */
    private String operator;

    /**
     * 
     */
    private String msisdn;

    /**
     * card
     */
    private static final long serialVersionUID = 1L;

    /**
     * 
     * @return id 
     */
    public Long getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 卡号
     * @return number 卡号
     */
    public String getNumber() {
        return number;
    }

    /**
     * 卡号
     * @param number 卡号
     */
    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    /**
     * 
     * @return gmt_create 
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * 
     * @param gmtCreate 
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * 
     * @return gmt_modified 
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * 
     * @param gmtModified 
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * 剩余流量
     * @return residual_flow_value 剩余流量
     */
    public BigDecimal getResidualFlowValue() {
        return residualFlowValue;
    }

    /**
     * 剩余流量
     * @param residualFlowValue 剩余流量
     */
    public void setResidualFlowValue(BigDecimal residualFlowValue) {
        this.residualFlowValue = residualFlowValue;
    }

    /**
     * 本月已用
     * @return month_used_value 本月已用
     */
    public String getMonthUsedValue() {
        return monthUsedValue;
    }

    /**
     * 本月已用
     * @param monthUsedValue 本月已用
     */
    public void setMonthUsedValue(String monthUsedValue) {
        this.monthUsedValue = monthUsedValue == null ? null : monthUsedValue.trim();
    }

    /**
     * 累计已用
     * @return total_used_value 累计已用
     */
    public String getTotalUsedValue() {
        return totalUsedValue;
    }

    /**
     * 累计已用
     * @param totalUsedValue 累计已用
     */
    public void setTotalUsedValue(String totalUsedValue) {
        this.totalUsedValue = totalUsedValue == null ? null : totalUsedValue.trim();
    }

    /**
     * 状态
     * @return status 状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 状态
     * @param status 状态
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 运营商
     * @return operator 运营商
     */
    public String getOperator() {
        return operator;
    }

    /**
     * 运营商
     * @param operator 运营商
     */
    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    /**
     * 
     * @return msisdn 
     */
    public String getMsisdn() {
        return msisdn;
    }

    /**
     * 
     * @param msisdn 
     */
    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn == null ? null : msisdn.trim();
    }

    /**
     *
     * @mbggenerated 2019-10-23
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", number=").append(number);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", residualFlowValue=").append(residualFlowValue);
        sb.append(", monthUsedValue=").append(monthUsedValue);
        sb.append(", totalUsedValue=").append(totalUsedValue);
        sb.append(", status=").append(status);
        sb.append(", operator=").append(operator);
        sb.append(", msisdn=").append(msisdn);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}