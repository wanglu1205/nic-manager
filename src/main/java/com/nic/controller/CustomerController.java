package com.nic.controller;

import com.nic.auth.AuthConstants;
import com.nic.auth.LoginToken;
import com.nic.common.model.PageResult;
import com.nic.common.model.dto.CustomerListDto;
import com.nic.common.model.dto.CustomerSaveDto;
import com.nic.common.model.dto.LoginDto;
import com.nic.common.model.vo.CustomerListVo;
import com.nic.config.AppException;
import com.nic.config.ErrorCode;
import com.nic.config.RestResponse;
import com.nic.dal.entity.Customer;
import com.nic.service.CustomerService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @auther: wl
 * @date: 2019/10/17
 * @description: 客户控制器
 * @since : 1.0
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Resource
    private CustomerService customerService;

    @PostMapping("/list")
    @ApiOperation(httpMethod = "POST", value = "列表")
    @ApiImplicitParam(paramType = "header", name = "token", value = "令牌", dataType = "String", required = true, defaultValue = AuthConstants.testToken)
    public RestResponse<PageResult<CustomerListVo>> list(@RequestBody CustomerListDto dto, @ApiParam(hidden = true) @LoginToken String token) {
        return RestResponse.success(customerService.list(dto, token));
    }

    @GetMapping("/info")
    @ApiOperation(httpMethod = "GET", value = "详情")
    @ApiImplicitParam(paramType = "header", name = "token", value = "令牌", dataType = "String", required = true, defaultValue = AuthConstants.testToken)
    public RestResponse<Customer> info(Long id) {
        if (Objects.isNull(id)){
            throw new AppException(ErrorCode.ERR_PARAM);
        }
        return RestResponse.success(customerService.info(id));
    }

    @PostMapping("/save")
    @ApiOperation(httpMethod = "POST", value = "保存")
    @ApiImplicitParam(paramType = "header", name = "token", value = "令牌", dataType = "String", required = true, defaultValue = AuthConstants.testToken)
    public RestResponse<Boolean> save(@RequestBody CustomerSaveDto dto, @ApiParam(hidden = true) @LoginToken String token) {
        return RestResponse.success(customerService.save(dto, token));
    }

    @PostMapping("/login")
    @ApiOperation(httpMethod = "POST", value = "登录")
    public RestResponse<Customer> login(@RequestBody LoginDto dto) {
        if (Objects.isNull(dto) || Objects.isNull(dto.getAccount()) || Objects.isNull(dto.getPassword())){
            throw new AppException(ErrorCode.ERR_PARAM);
        }
        return RestResponse.success(customerService.login(dto));
    }

    @GetMapping("/logout")
    @ApiOperation(httpMethod = "GET", value = "登出")
    @ApiImplicitParam(paramType = "header", name = "token", value = "令牌", dataType = "String", required = true, defaultValue = AuthConstants.testToken)
    public RestResponse<Boolean> login(@ApiParam(hidden = true) @LoginToken String token) {
        return RestResponse.success(customerService.logout(token));
    }
}
