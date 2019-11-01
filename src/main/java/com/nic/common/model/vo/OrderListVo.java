package com.nic.common.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @auther: wl
 * @date: 2019/11/1
 * @description:
 * @since : 1.0
 */
@Data
public class OrderListVo {

    @ApiModelProperty("订单号")
    private String orderNumber;

    @ApiModelProperty("卡号")
    private String number;

    @ApiModelProperty("提交时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @ApiModelProperty("状态")
    private String status;

    @ApiModelProperty("金额")
    private BigDecimal money;

    @ApiModelProperty("备注")
    private String remark;

}
