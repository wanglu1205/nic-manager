package com.nic.controller;

import com.nic.auth.AuthConstants;
import com.nic.auth.LoginToken;
import com.nic.common.model.PageResult;
import com.nic.common.model.dto.RebateRecordListDto;
import com.nic.common.model.dto.RebateRuleSaveDto;
import com.nic.common.model.vo.PackageListVo;
import com.nic.common.model.vo.RebateRecordListVo;
import com.nic.config.AppException;
import com.nic.config.ErrorCode;
import com.nic.config.RestResponse;
import com.nic.service.RebateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @auther: wl
 * @date: 2019/10/19
 * @description: 返利控制器
 * @since : 1.0
 */
@RestController
@RequestMapping("/rebate")
@Api(value = "card", tags = "返利控制器")
public class RebateController {

    @Resource
    private RebateService rebateService;

    @PostMapping("/rule/save")
    @ApiOperation(httpMethod = "POST", value = "返利规则设置")
    @ApiImplicitParam(paramType = "header", name = "token", value = "令牌", dataType = "String", required = true, defaultValue = AuthConstants.testToken)
    public RestResponse<Boolean> ruleSave(@RequestBody RebateRuleSaveDto dto, @ApiParam(hidden = true) @LoginToken String token) {
        if (Objects.isNull(dto) || Objects.isNull(dto.getPackageId()) || Objects.isNull(dto.getMoney()) || CollectionUtils.isEmpty(dto.getCustomerIds())){
            throw new AppException(ErrorCode.ERR_PARAM);
        }
        return RestResponse.success(rebateService.ruleSave(dto));
    }

    @PostMapping("/record/list")
    @ApiOperation(httpMethod = "POST", value = "返利记录列表")
    @ApiImplicitParam(paramType = "header", name = "token", value = "令牌", dataType = "String", required = true, defaultValue = AuthConstants.testToken)
    public RestResponse<PageResult<RebateRecordListVo>> recordList(@RequestBody RebateRecordListDto dto, @ApiParam(hidden = true) @LoginToken String token) {
        return RestResponse.success(rebateService.recordList(dto));
    }
}
