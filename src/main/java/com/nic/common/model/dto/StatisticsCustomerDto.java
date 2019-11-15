package com.nic.common.model.dto;

import com.nic.common.model.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @auther: wl
 * @date: 2019/11/15
 * @description:
 * @since : 1.0
 */
@ApiModel("代理统计对象")
@Data
public class StatisticsCustomerDto extends PageQuery {

    @ApiModelProperty("类型")
    private String grade;
}
