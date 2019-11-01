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
@ApiModel("订单列表查询对象")
@Data
public class OrderListDto extends PageQuery {

}
