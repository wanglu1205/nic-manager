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
@ApiModel("互联网卡列表查询对象")
@Data
public class CardListDto extends PageQuery {

    @ApiModelProperty("开始ID")
    private Long startId;

    @ApiModelProperty("结束ID")
    private Long endId;

    @ApiModelProperty("卡号")
    private String number;

    @ApiModelProperty("客户主键")
    private Long customerId;

    @ApiModelProperty("运营商")
    private String operator;

    @ApiModelProperty("状态")
    private String status;
}
