package com.nic.common.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @auther: wl
 * @date: 2019/10/19
 * @description:
 * @since : 1.0
 */
@Data
public class RebateRecordListVo {

    @ApiModelProperty("主键")
    private Long id;

    @ApiModelProperty("客户名称")
    private String customerName;

    @ApiModelProperty("客户账号")
    private String account;

    @ApiModelProperty("卡号")
    private String number;

    @ApiModelProperty("套餐名称")
    private String packageName;

    @ApiModelProperty("返佣对象")
    private String rebateCustomerName;

    @ApiModelProperty("返佣前金额")
    private BigDecimal startMoney;

    @ApiModelProperty("返佣金额")
    private BigDecimal money;

    @ApiModelProperty("返佣后金额")
    private BigDecimal endMoney;

    @ApiModelProperty("订单号")
    private String orderNumber;

    @ApiModelProperty("返佣时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date time;
}
