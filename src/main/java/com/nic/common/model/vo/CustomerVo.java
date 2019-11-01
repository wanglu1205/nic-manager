package com.nic.common.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @auther: wl
 * @date: 2019/11/1
 * @description:
 * @since : 1.0
 */
@Data
public class CustomerVo {

    @ApiModelProperty("客户名称")
    private String name;

    @ApiModelProperty("总订单")
    private Integer orderCount;

    @ApiModelProperty("总返利")
    private BigDecimal rebateCount;
}
