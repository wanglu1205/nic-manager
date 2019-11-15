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
public class CardListVo {

    @ApiModelProperty("主键")
    private Long id;

    @ApiModelProperty("客户名称")
    private String name;

    @ApiModelProperty("客户账号")
    private String account;

    @ApiModelProperty("卡号")
    private String number;

    /*@ApiModelProperty("剩余流量")
    private BigDecimal residualFlowValue;

    @ApiModelProperty("本月已用")
    private String monthUsedValue;

    @ApiModelProperty("累计已用")
    private String totalUsedValue;

    @ApiModelProperty("状态")
    private String status;*/

}
