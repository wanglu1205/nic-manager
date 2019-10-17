package com.nic.auth;

import com.alibaba.fastjson.JSONObject;
import com.nic.config.ErrorCode;
import com.nic.service.TokenCacheService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Objects;

/**
 * 增加方法注入，将含有LoginUser注解的方法参数注入当前登录用户
 */
@Component
public class TokenArgumentResolver implements HandlerMethodArgumentResolver {


    @Resource
    private HttpServletResponse response;

    @Resource
    private TokenCacheService tokenCacheService;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        //如果参数类型是String并且有LoginUuid注解则支持
        if (parameter.getParameterType().isAssignableFrom(String.class) &&
            parameter.hasParameterAnnotation(LoginToken.class)) {
            return true;
        }
        return false;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        // 取出鉴权时存入的登录用户token
//        String token = (String) nativeWebRequest.getAttribute(AuthConstants.TOKEN, RequestAttributes.SCOPE_REQUEST);
        String token = nativeWebRequest.getHeader(AuthConstants.TOKEN);
        if (Objects.equals(token, AuthConstants.testToken)) {
            return token;
        }
        if (StringUtils.isBlank(token)) {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            JSONObject json = new JSONObject();
            json.put("code", ErrorCode.ERR_AUTH.getCode());
            json.put("message", "缺少token");
            PrintWriter writer = response.getWriter();
            writer.write(json.toJSONString());
            writer.flush();
            writer.close();
            return false;
        }
        String value = tokenCacheService.getToken(token);
        if (StringUtils.isBlank(value)) {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            JSONObject json = new JSONObject();
            json.put("code", ErrorCode.ERR_AUTH.getCode());
            json.put("message", "token过期，请重新登录");
            PrintWriter writer = response.getWriter();
            writer.write(json.toJSONString());
            writer.flush();
            writer.close();
            return false;
        } else {
            return token;
        }
//        return token;
    }
}
