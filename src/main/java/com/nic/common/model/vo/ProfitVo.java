package com.nic.common.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @auther: wl
 * @date: 2019/10/18
 * @description:
 * @since : 1.0
 */
@Data
public class ProfitVo {

    @ApiModelProperty("一级代理总数")
    private Integer oneCustomerNum;

    @ApiModelProperty("代理总数")
    private Integer customerNum;

    @ApiModelProperty("订单总数")
    private Integer orderNum;

    @ApiModelProperty("返利总数")
    private BigDecimal rebateCount;

    @ApiModelProperty("当日订单数")
    private Integer todayOrderNum;

    @ApiModelProperty("当日返利")
    private BigDecimal todayRebateCount;

    @ApiModelProperty("当月订单数")
    private Integer monthOrderNum;

    @ApiModelProperty("当月返利")
    private BigDecimal monthRebateCount;

    @ApiModelProperty("昨日订单数")
    private Integer yesterdayOrderNum;

    @ApiModelProperty("昨日返利")
    private BigDecimal yesterdayRebateCount;

    @ApiModelProperty("上月订单数")
    private Integer lastMonthOrderNum;

    @ApiModelProperty("上月返利")
    private BigDecimal lastMonthRebateCount;

}
