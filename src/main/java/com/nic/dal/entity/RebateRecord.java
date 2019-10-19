package com.nic.dal.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class RebateRecord implements Serializable {
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
     * 网卡主键
     */
    private Long cardId;

    /**
     * 套餐主键
     */
    private Long packageId;

    /**
     * 返利客户主键
     */
    private Long rebateCustomerId;

    /**
     * 返利前金额
     */
    private BigDecimal money;

    /**
     * 返利金额
     */
    private BigDecimal rebateMoney;

    /**
     * 订单主键
     */
    private Long orderId;

    /**
     * rebate_record
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
     * 网卡主键
     * @return card_id 网卡主键
     */
    public Long getCardId() {
        return cardId;
    }

    /**
     * 网卡主键
     * @param cardId 网卡主键
     */
    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    /**
     * 套餐主键
     * @return package_id 套餐主键
     */
    public Long getPackageId() {
        return packageId;
    }

    /**
     * 套餐主键
     * @param packageId 套餐主键
     */
    public void setPackageId(Long packageId) {
        this.packageId = packageId;
    }

    /**
     * 返利客户主键
     * @return rebate_customer_id 返利客户主键
     */
    public Long getRebateCustomerId() {
        return rebateCustomerId;
    }

    /**
     * 返利客户主键
     * @param rebateCustomerId 返利客户主键
     */
    public void setRebateCustomerId(Long rebateCustomerId) {
        this.rebateCustomerId = rebateCustomerId;
    }

    /**
     * 返利前金额
     * @return money 返利前金额
     */
    public BigDecimal getMoney() {
        return money;
    }

    /**
     * 返利前金额
     * @param money 返利前金额
     */
    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    /**
     * 返利金额
     * @return rebate_money 返利金额
     */
    public BigDecimal getRebateMoney() {
        return rebateMoney;
    }

    /**
     * 返利金额
     * @param rebateMoney 返利金额
     */
    public void setRebateMoney(BigDecimal rebateMoney) {
        this.rebateMoney = rebateMoney;
    }

    /**
     * 订单主键
     * @return order_id 订单主键
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * 订单主键
     * @param orderId 订单主键
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
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
        sb.append(", packageId=").append(packageId);
        sb.append(", rebateCustomerId=").append(rebateCustomerId);
        sb.append(", money=").append(money);
        sb.append(", rebateMoney=").append(rebateMoney);
        sb.append(", orderId=").append(orderId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}