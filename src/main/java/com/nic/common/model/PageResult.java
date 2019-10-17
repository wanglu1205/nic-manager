package com.nic.common.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 分页查询结果
 *
 * @author yongli.chen
 * @since 1.0
 */
@ApiModel("分页结果")
@Data
public class PageResult<T> {
    @ApiModelProperty("总条数")
    private Long total;
    @ApiModelProperty("总页数")
    private Integer totalPage;
    @ApiModelProperty("每页包含数量")
    private Integer pageSize;
    @ApiModelProperty("当前页数")
    private Integer pageNo;
    @ApiModelProperty("记录")
    private List<T> rows;

    public PageResult() {
    }

    public PageResult(PageResult pageResult, List<T> rows) {
        this.total = pageResult.getTotal();
        this.totalPage = pageResult.getTotalPage();
        this.pageSize = pageResult.getPageSize();
        this.pageNo = pageResult.getPageNo();
        this.rows = rows;
    }

    public PageResult(Integer pageNo, Integer pageSize, Long total, List<T> rows) {
        this.total = total;
        this.totalPage = total.intValue() % pageSize == 0 ? total.intValue() / pageSize : total.intValue() / pageSize + 1;
        this.pageSize = pageSize;
        this.pageNo = pageNo;
        this.rows = rows;
    }
}
