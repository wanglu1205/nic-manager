package com.nic.controller;

import com.nic.auth.AuthConstants;
import com.nic.auth.LoginToken;
import com.nic.common.model.PageResult;
import com.nic.common.model.dto.PackageListDto;
import com.nic.common.model.dto.PackageSaveDto;
import com.nic.common.model.vo.PackageListVo;
import com.nic.config.AppException;
import com.nic.config.ErrorCode;
import com.nic.config.RestResponse;
import com.nic.dal.entity.Package;
import com.nic.service.PackageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @auther: wl
 * @date: 2019/10/17
 * @description: 套餐控制器
 * @since : 1.0
 */
@RestController
@RequestMapping("/package")
@Api(value = "card", tags = "套餐控制器")
public class PackageController {

    @Resource
    private PackageService packageService;

    @PostMapping("/list")
    @ApiOperation(httpMethod = "POST", value = "列表")
    @ApiImplicitParam(paramType = "header", name = "token", value = "令牌", dataType = "String", required = true, defaultValue = AuthConstants.testToken)
    public RestResponse<PageResult<PackageListVo>> list(@RequestBody PackageListDto dto, @ApiParam(hidden = true) @LoginToken String token) {
        return RestResponse.success(packageService.list(dto));
    }

    @GetMapping("/info")
    @ApiOperation(httpMethod = "GET", value = "详情")
    @ApiImplicitParam(paramType = "header", name = "token", value = "令牌", dataType = "String", required = true, defaultValue = AuthConstants.testToken)
    public RestResponse<Package> info(Long id, @ApiParam(hidden = true) @LoginToken String token) {
        if (Objects.isNull(id)){
            throw new AppException(ErrorCode.ERR_PARAM);
        }
        return RestResponse.success(packageService.info(id));
    }

    @PostMapping("/save")
    @ApiOperation(httpMethod = "POST", value = "保存")
    @ApiImplicitParam(paramType = "header", name = "token", value = "令牌", dataType = "String", required = true, defaultValue = AuthConstants.testToken)
    public RestResponse<Boolean> save(@RequestBody PackageSaveDto dto, @ApiParam(hidden = true) @LoginToken String token) {
        return RestResponse.success(packageService.save(dto));
    }
}
