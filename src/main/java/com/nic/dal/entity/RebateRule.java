package com.nic.dal.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class RebateRule implements Serializable {
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
     * 套餐主键
     */
    private Long packageId;

    /**
     * 返利金额
     */
    private BigDecimal money;

    /**
     * 客户主键
     */
    private Long customerId;

    /**
     * rebate_rule
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
     * 返利金额
     * @return money 返利金额
     */
    public BigDecimal getMoney() {
        return money;
    }

    /**
     * 返利金额
     * @param money 返利金额
     */
    public void setMoney(BigDecimal money) {
        this.money = money;
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
        sb.append(", packageId=").append(packageId);
        sb.append(", money=").append(money);
        sb.append(", customerId=").append(customerId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}