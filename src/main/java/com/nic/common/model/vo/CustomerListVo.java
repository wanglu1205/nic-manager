package com.nic.common.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @auther: wl
 * @date: 2019/10/17
 * @description:
 * @since : 1.0
 */
@Data
public class CustomerListVo {

    @ApiModelProperty("主键")
    private Long id;

    @ApiModelProperty("客户账号")
    private String account;

    @ApiModelProperty("所属客户")
    private String parentName;

    @ApiModelProperty("联系电话")
    private String name;

    @ApiModelProperty("手机号")
    private String tel;

    @ApiModelProperty("支付宝户名")
    private String alipayName;

    @ApiModelProperty("支付宝账号")
    private String alipayAccount;

    @ApiModelProperty("信用")
    private Integer credit;

    @ApiModelProperty("佣金")
    private BigDecimal commission;

    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date gmtCreate;

}
