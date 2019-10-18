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
     * 用户账户
     */
    private String account;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 真实姓名
     */
    private String name;

    /**
     * 联系电话
     */
    private String tel;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 父级主键
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
     * 支付宝账号
     */
    private String alipayAccount;

    /**
     * 支付宝户名
     */
    private String alipayName;

    /**
     * 佣金
     */
    private BigDecimal commission;

    /**
     * 信用
     */
    private Integer credit;

    /**
     * 
     */
    private String token;

    /**
     * 是否启用
     */
    private Boolean isEnabled;

    /**
     * 微信支付appid
     */
    private String appId;

    /**
     * 所属互联网卡id集合，英文逗号分隔
     */
    private String cardIds;

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
     * 用户账户
     * @return account 用户账户
     */
    public String getAccount() {
        return account;
    }

    /**
     * 用户账户
     * @param account 用户账户
     */
    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    /**
     * 用户密码
     * @return password 用户密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 用户密码
     * @param password 用户密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 真实姓名
     * @return name 真实姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 真实姓名
     * @param name 真实姓名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 联系电话
     * @return tel 联系电话
     */
    public String getTel() {
        return tel;
    }

    /**
     * 联系电话
     * @param tel 联系电话
     */
    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    /**
     * 电子邮箱
     * @return email 电子邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 电子邮箱
     * @param email 电子邮箱
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 父级主键
     * @return parent_id 父级主键
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 父级主键
     * @param parentId 父级主键
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
     * 支付宝账号
     * @return alipay_account 支付宝账号
     */
    public String getAlipayAccount() {
        return alipayAccount;
    }

    /**
     * 支付宝账号
     * @param alipayAccount 支付宝账号
     */
    public void setAlipayAccount(String alipayAccount) {
        this.alipayAccount = alipayAccount == null ? null : alipayAccount.trim();
    }

    /**
     * 支付宝户名
     * @return alipay_name 支付宝户名
     */
    public String getAlipayName() {
        return alipayName;
    }

    /**
     * 支付宝户名
     * @param alipayName 支付宝户名
     */
    public void setAlipayName(String alipayName) {
        this.alipayName = alipayName == null ? null : alipayName.trim();
    }

    /**
     * 佣金
     * @return commission 佣金
     */
    public BigDecimal getCommission() {
        return commission;
    }

    /**
     * 佣金
     * @param commission 佣金
     */
    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }

    /**
     * 信用
     * @return credit 信用
     */
    public Integer getCredit() {
        return credit;
    }

    /**
     * 信用
     * @param credit 信用
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
     * 是否启用
     * @return is_enabled 是否启用
     */
    public Boolean getIsEnabled() {
        return isEnabled;
    }

    /**
     * 是否启用
     * @param isEnabled 是否启用
     */
    public void setIsEnabled(Boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    /**
     * 微信支付appid
     * @return app_id 微信支付appid
     */
    public String getAppId() {
        return appId;
    }

    /**
     * 微信支付appid
     * @param appId 微信支付appid
     */
    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    /**
     * 所属互联网卡id集合，英文逗号分隔
     * @return card_ids 所属互联网卡id集合，英文逗号分隔
     */
    public String getCardIds() {
        return cardIds;
    }

    /**
     * 所属互联网卡id集合，英文逗号分隔
     * @param cardIds 所属互联网卡id集合，英文逗号分隔
     */
    public void setCardIds(String cardIds) {
        this.cardIds = cardIds == null ? null : cardIds.trim();
    }

    /**
     *
     * @mbggenerated 2019-10-18
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
        sb.append(", isEnabled=").append(isEnabled);
        sb.append(", appId=").append(appId);
        sb.append(", cardIds=").append(cardIds);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}