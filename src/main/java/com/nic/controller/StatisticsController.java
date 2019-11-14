package com.nic.controller;

import com.nic.auth.AuthConstants;
import com.nic.auth.LoginToken;
import com.nic.common.model.vo.CustomerVo;
import com.nic.common.model.vo.ProfitVo;
import com.nic.config.RestResponse;
import com.nic.service.StatisticsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @auther: wl
 * @date: 2019/10/18
 * @description: 统计控制器
 * @since : 1.0
 */
@RestController
@RequestMapping("/statistics")
@Api(value = "card", tags = "统计控制器")
public class StatisticsController {

    @Resource
    private StatisticsService statisticsService;

    @PostMapping("/profit")
    @ApiOperation(httpMethod = "POST", value = "利润统计")
    @ApiImplicitParam(paramType = "header", name = "token", value = "令牌", dataType = "String", required = true, defaultValue = AuthConstants.testToken)
    public RestResponse<ProfitVo> profit(@ApiParam(hidden = true) @LoginToken String token) {
        return RestResponse.success(statisticsService.profit(token));
    }

    @PostMapping("/customer")
    @ApiOperation(httpMethod = "POST", value = "代理统计")
    @ApiImplicitParam(paramType = "header", name = "token", value = "令牌", dataType = "String", required = true, defaultValue = AuthConstants.testToken)
    public RestResponse<List<CustomerVo>> customer(@ApiParam(hidden = true) @LoginToken String token, String type) {
        return RestResponse.success(statisticsService.customer(token, type));
    }
}
