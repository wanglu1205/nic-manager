package com.nic.common.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @auther: wl
 * @date: 2019/10/19
 * @description:
 * @since : 1.0
 */
@Data
public class RebateRuleSaveDto {

    @ApiModelProperty("套餐主键")
    private Long packageId;

    @ApiModelProperty("客户主键集合")
    private List<Long> customerIds;

    @ApiModelProperty("金额")
    private BigDecimal money;

}
