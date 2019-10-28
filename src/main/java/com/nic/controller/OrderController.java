package com.nic.controller;

import com.nic.auth.AuthConstants;
import com.nic.auth.LoginToken;
import com.nic.common.model.dto.RechargeDto;
import com.nic.config.AppException;
import com.nic.config.ErrorCode;
import com.nic.config.RestResponse;
import com.nic.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @auther: wl
 * @date: 2019/10/18
 * @description: 订单控制器
 * @since : 1.0
 */
@RestController
@RequestMapping("/order")
@Api(value = "card", tags = "订单控制器")
public class OrderController {

    @Resource
    private OrderService orderService;

    @PostMapping("/recharge")
    @ApiOperation(httpMethod = "POST", value = "充值")
    @ApiImplicitParam(paramType = "header", name = "token", value = "令牌", dataType = "String", required = true, defaultValue = AuthConstants.testToken)
    public RestResponse<Boolean> recharge(@RequestBody RechargeDto dto, @ApiParam(hidden = true) @LoginToken String token) {
        if (Objects.isNull(dto) || Objects.isNull(dto.getCardId()) || Objects.isNull(dto.getPackageId())){
            throw new AppException(ErrorCode.ERR_PARAM);
        }
        return RestResponse.success(orderService.recharge(dto, token));
    }
}
