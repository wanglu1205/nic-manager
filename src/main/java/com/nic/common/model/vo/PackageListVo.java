package com.nic.common.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @auther: wl
 * @date: 2019/10/17
 * @description:
 * @since : 1.0
 */
@Data
public class PackageListVo {

    @ApiModelProperty("主键")
    private Long id;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("价格")
    private BigDecimal price;

    @ApiModelProperty("规格")
    private String standard;

}
