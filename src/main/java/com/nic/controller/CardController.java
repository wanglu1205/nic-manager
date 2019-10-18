package com.nic.controller;

import com.nic.auth.AuthConstants;
import com.nic.auth.LoginToken;
import com.nic.common.model.PageResult;
import com.nic.common.model.dto.CardListDto;
import com.nic.common.model.dto.CustomerListDto;
import com.nic.common.model.dto.RechargeDto;
import com.nic.common.model.vo.CardListVo;
import com.nic.common.model.vo.CustomerListVo;
import com.nic.config.RestResponse;
import com.nic.service.CardService;
import com.nic.service.CustomerService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @auther: wl
 * @date: 2019/10/18
 * @description:
 * @since : 1.0
 */
@RestController
@RequestMapping("/card")
public class CardController {

    @Resource
    private CardService cardService;

    @PostMapping("/list")
    @ApiOperation(httpMethod = "POST", value = "列表")
    @ApiImplicitParam(paramType = "header", name = "token", value = "令牌", dataType = "String", required = true, defaultValue = AuthConstants.testToken)
    public RestResponse<PageResult<CardListVo>> list(@RequestBody CardListDto dto, @ApiParam(hidden = true) @LoginToken String token) {
        return RestResponse.success(cardService.list(dto, token));
    }

    @PostMapping("/delete")
    @ApiOperation(httpMethod = "POST", value = "删除")
    @ApiImplicitParam(paramType = "header", name = "token", value = "令牌", dataType = "String", required = true, defaultValue = AuthConstants.testToken)
    public RestResponse<Boolean> delete(@RequestBody List<Long> ids, @ApiParam(hidden = true) @LoginToken String token) {
        return RestResponse.success(cardService.delete(ids));
    }

}
