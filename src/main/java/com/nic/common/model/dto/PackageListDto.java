package com.nic.common.model.dto;

import com.nic.common.model.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @auther: wl
 * @date: 2019/10/18
 * @description:
 * @since : 1.0
 */
@ApiModel("套餐列表查询对象")
@Data
public class PackageListDto extends PageQuery {

    @ApiModelProperty("套餐名称")
    private String name;
}
