package com.nic.common.model.dto;

import com.nic.common.model.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @auther: wl
 * @date: 2019/10/19
 * @description:
 * @since : 1.0
 */
@ApiModel("返利列表查询对象")
@Data
public class RebateRecordListDto extends PageQuery {

    @ApiModelProperty("客户名称")
    private String name;

    @ApiModelProperty("卡号")
    private String number;

    @ApiModelProperty("开始时间")
    private Date startTime;

    @ApiModelProperty("结束时间")
    private Date endTime;

}
