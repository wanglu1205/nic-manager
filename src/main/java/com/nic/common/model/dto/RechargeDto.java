package com.nic.common.model.dto;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @auther: wl
 * @date: 2019/10/18
 * @description:
 * @since : 1.0
 */
public class RechargeDto {

    @ApiModelProperty("卡号集合")
    private List<String> numbers;

    @ApiModelProperty("套餐主键")
    private Long packageId;

    public List<String> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<String> numbers) {
        this.numbers = numbers;
    }

    public Long getPackageId() {
        return packageId;
    }

    public void setPackageId(Long packageId) {
        this.packageId = packageId;
    }
}
