package com.nic.common.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @auther: wl
 * @date: 2019/10/18
 * @description:
 * @since : 1.0
 */
@Data
public class RechargeDto {

    @ApiModelProperty("卡主键")
    private Long cardId;

    @ApiModelProperty("套餐主键")
    private Long packageId;

}
