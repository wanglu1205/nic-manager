package com.nic.controller;

import com.nic.auth.AuthConstants;
import com.nic.auth.LoginToken;
import com.nic.common.model.PageResult;
import com.nic.common.model.dto.CardListDto;
import com.nic.common.model.vo.CardListVo;
import com.nic.common.model.vo.CardStatusVo;
import com.nic.config.RestResponse;
import com.nic.service.CardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

/**
 * @auther: wl
 * @date: 2019/10/18
 * @description: 物联网卡控制器
 * @since : 1.0
 */
@RestController
@RequestMapping("/card")
@Api(value = "card", tags = "物联网卡控制器")
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

    @GetMapping("/status")
    @ApiOperation(httpMethod = "GET", value = "状态查询")
    @ApiImplicitParam(paramType = "header", name = "token", value = "令牌", dataType = "String", required = true, defaultValue = AuthConstants.testToken)
    public RestResponse<CardStatusVo> status(Long id, @ApiParam(hidden = true) @LoginToken String token) {
        return RestResponse.success(cardService.status(id));
    }

    @PostMapping("/import")
    @ApiOperation(httpMethod = "POST", value = "导入")
    @ApiImplicitParam(paramType = "header", name = "token", value = "令牌", dataType = "String", required = true, defaultValue = AuthConstants.testToken)
    public RestResponse<List<String>> importData(MultipartFile file, @ApiParam(hidden = true) @LoginToken String token) {
        return RestResponse.success(cardService.importData(file, token));
    }
}
