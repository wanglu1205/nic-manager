package com.nic.common.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @auther: wl
 * @date: 2019/10/17
 * @description:
 * @since : 1.0
 */
@Data
public class CustomerSaveDto {

    @ApiModelProperty("账号")
    private String account;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("所属客户")
    private String parentName;

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("手机号")
    private String tel;

    @ApiModelProperty("支付宝户名")
    private String alipayName;

    @ApiModelProperty("支付宝账号")
    private String alipayAccount;

    @ApiModelProperty("邮箱")
    private String email;

}
