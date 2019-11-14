package com.nic.common.model.dto;

import com.nic.common.model.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @auther: wl
 * @date: 2019/10/17
 * @description:
 * @since : 1.0
 */
@ApiModel("客户列表查询对象")
@Data
public class CustomerListDto extends PageQuery {

    @ApiModelProperty("账户")
    private String account;

    @ApiModelProperty("类型")
    private String type;
}
