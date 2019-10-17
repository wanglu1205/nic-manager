package com.nic.common.model;


import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * PageQuery class
 *
 * @author : cyl
 * @date : 2018/7/2 下午12:46
 * @description : 分页查询
 */
@ApiModel("分页对象")
@Data
public class PageQuery {

    // 页码（从1开始）
    protected int pageNo = 1;

    // 每页数量
    protected int pageSize = 10;

}
