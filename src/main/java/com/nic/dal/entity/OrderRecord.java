package com.nic.dal.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class OrderRecord implements Serializable {
    /**
     * 
     */
    private Long id;

    /**
     * 
     */
    private Date gmtCreate;

    /**
     * 
     */
    private Date gmtModified;

    /**
     * 
     */
    private Long customerId;

    /**
     * 
     */
    private Long cardId;

    /**
     * 
     */
    private String channel;

    /**
     * 
     */
    private Date handingTime;

    /**
     * 
     */
    private BigDecimal money;

    /**
     * 
     */
    private String status;

    /**
     * 
     */
    private String remark;

    /**
     * 
     */
    private String orderNumber;

    /**
     * 
     */
    private BigDecimal rebate;

    /**
     * order_record
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
     * 
     * @return customer_id 
     */
    public Long getCustomerId() {
        return customerId;
    }

    /**
     * 
     * @param customerId 
     */
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    /**
     * 
     * @return card_id 
     */
    public Long getCardId() {
        return cardId;
    }

    /**
     * 
     * @param cardId 
     */
    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    /**
     * 
     * @return channel 
     */
    public String getChannel() {
        return channel;
    }

    /**
     * 
     * @param channel 
     */
    public void setChannel(String channel) {
        this.channel = channel == null ? null : channel.trim();
    }

    /**
     * 
     * @return handing_time 
     */
    public Date getHandingTime() {
        return handingTime;
    }

    /**
     * 
     * @param handingTime 
     */
    public void setHandingTime(Date handingTime) {
        this.handingTime = handingTime;
    }

    /**
     * 
     * @return money 
     */
    public BigDecimal getMoney() {
        return money;
    }

    /**
     * 
     * @param money 
     */
    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    /**
     * 
     * @return status 
     */
    public String getStatus() {
        return status;
    }

    /**
     * 
     * @param status 
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 
     * @return remark 
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 
     * @param remark 
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 
     * @return order_number 
     */
    public String getOrderNumber() {
        return orderNumber;
    }

    /**
     * 
     * @param orderNumber 
     */
    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber == null ? null : orderNumber.trim();
    }

    /**
     * 
     * @return rebate 
     */
    public BigDecimal getRebate() {
        return rebate;
    }

    /**
     * 
     * @param rebate 
     */
    public void setRebate(BigDecimal rebate) {
        this.rebate = rebate;
    }

    /**
     *
     * @mbggenerated 2019-10-31
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", customerId=").append(customerId);
        sb.append(", cardId=").append(cardId);
        sb.append(", channel=").append(channel);
        sb.append(", handingTime=").append(handingTime);
        sb.append(", money=").append(money);
        sb.append(", status=").append(status);
        sb.append(", remark=").append(remark);
        sb.append(", orderNumber=").append(orderNumber);
        sb.append(", rebate=").append(rebate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}