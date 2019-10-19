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
     * 客户主键
     */
    private Long customerId;

    /**
     * 卡号主键
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
     * 金额
     */
    private BigDecimal money;

    /**
     * 状态
     */
    private String status;

    /**
     * 备注
     */
    private String remark;

    /**
     * 订单编号
     */
    private String orderNumber;

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
     * 客户主键
     * @return customer_id 客户主键
     */
    public Long getCustomerId() {
        return customerId;
    }

    /**
     * 客户主键
     * @param customerId 客户主键
     */
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    /**
     * 卡号主键
     * @return card_id 卡号主键
     */
    public Long getCardId() {
        return cardId;
    }

    /**
     * 卡号主键
     * @param cardId 卡号主键
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
     * 金额
     * @return money 金额
     */
    public BigDecimal getMoney() {
        return money;
    }

    /**
     * 金额
     * @param money 金额
     */
    public void setMoney(BigDecimal money) {
        this.money = money;
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
     * 备注
     * @return remark 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 订单编号
     * @return order_number 订单编号
     */
    public String getOrderNumber() {
        return orderNumber;
    }

    /**
     * 订单编号
     * @param orderNumber 订单编号
     */
    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber == null ? null : orderNumber.trim();
    }

    /**
     *
     * @mbggenerated 2019-10-19
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
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}