package com.nic.dal.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Customer implements Serializable {
    /**
     * 
     */
    private Long id;

    /**
     * 
     */
    private String account;

    /**
     * 
     */
    private String password;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private String tel;

    /**
     * 
     */
    private String email;

    /**
     * 
     */
    private Long parentId;

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
    private String alipayAccount;

    /**
     * 
     */
    private String alipayName;

    /**
     * 
     */
    private BigDecimal commission;

    /**
     * 
     */
    private Integer credit;

    /**
     * 
     */
    private String token;

    /**
     * 
     */
    private String openId;

    /**
     * 
     */
    private String cardIds;

    /**
     * 
     */
    private String groupNumber;

    /**
     * 
     */
    private Boolean isEnabled;

    /**
     * customer
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
     * @return account 
     */
    public String getAccount() {
        return account;
    }

    /**
     * 
     * @param account 
     */
    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    /**
     * 
     * @return password 
     */
    public String getPassword() {
        return password;
    }

    /**
     * 
     * @param password 
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 
     * @return name 
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name 
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 
     * @return tel 
     */
    public String getTel() {
        return tel;
    }

    /**
     * 
     * @param tel 
     */
    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    /**
     * 
     * @return email 
     */
    public String getEmail() {
        return email;
    }

    /**
     * 
     * @param email 
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 
     * @return parent_id 
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 
     * @param parentId 
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
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
     * @return alipay_account 
     */
    public String getAlipayAccount() {
        return alipayAccount;
    }

    /**
     * 
     * @param alipayAccount 
     */
    public void setAlipayAccount(String alipayAccount) {
        this.alipayAccount = alipayAccount == null ? null : alipayAccount.trim();
    }

    /**
     * 
     * @return alipay_name 
     */
    public String getAlipayName() {
        return alipayName;
    }

    /**
     * 
     * @param alipayName 
     */
    public void setAlipayName(String alipayName) {
        this.alipayName = alipayName == null ? null : alipayName.trim();
    }

    /**
     * 
     * @return commission 
     */
    public BigDecimal getCommission() {
        return commission;
    }

    /**
     * 
     * @param commission 
     */
    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }

    /**
     * 
     * @return credit 
     */
    public Integer getCredit() {
        return credit;
    }

    /**
     * 
     * @param credit 
     */
    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    /**
     * 
     * @return token 
     */
    public String getToken() {
        return token;
    }

    /**
     * 
     * @param token 
     */
    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    /**
     * 
     * @return open_id 
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * 
     * @param openId 
     */
    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    /**
     * 
     * @return card_ids 
     */
    public String getCardIds() {
        return cardIds;
    }

    /**
     * 
     * @param cardIds 
     */
    public void setCardIds(String cardIds) {
        this.cardIds = cardIds == null ? null : cardIds.trim();
    }

    /**
     * 
     * @return group_number 
     */
    public String getGroupNumber() {
        return groupNumber;
    }

    /**
     * 
     * @param groupNumber 
     */
    public void setGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber == null ? null : groupNumber.trim();
    }

    /**
     * 
     * @return is_enabled 
     */
    public Boolean getIsEnabled() {
        return isEnabled;
    }

    /**
     * 
     * @param isEnabled 
     */
    public void setIsEnabled(Boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    /**
     *
     * @mbggenerated 2019-11-14
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", account=").append(account);
        sb.append(", password=").append(password);
        sb.append(", name=").append(name);
        sb.append(", tel=").append(tel);
        sb.append(", email=").append(email);
        sb.append(", parentId=").append(parentId);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", alipayAccount=").append(alipayAccount);
        sb.append(", alipayName=").append(alipayName);
        sb.append(", commission=").append(commission);
        sb.append(", credit=").append(credit);
        sb.append(", token=").append(token);
        sb.append(", openId=").append(openId);
        sb.append(", cardIds=").append(cardIds);
        sb.append(", groupNumber=").append(groupNumber);
        sb.append(", isEnabled=").append(isEnabled);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}