package com.nic.aspect;

import com.alibaba.fastjson.JSON;
import com.nic.config.AppException;
import com.nic.config.ErrorCode;
import com.nic.config.RestResponse;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLException;
import java.util.Objects;

/**
 * ControllerAspect class
 *
 * @author : cyl
 * @date : 2018/7/2 下午6:18
 * @description : 日志切面
 * @since : 1.0
 */
@Aspect
@Component
public class ControllerAspect {
    private static final Logger logger = LoggerFactory.getLogger(ControllerAspect.class);

    /**
     * 将异常日志和参数日志一起打印
     *
     * @param jp
     * @return
     * @throws Throwable
     */
    @ExceptionHandler
    @Around("execution(* com.nic.controller..*.*(..))")
    public Object process(ProceedingJoinPoint jp) throws Throwable {
        Object rvt = null;
        long startTime = System.currentTimeMillis();
        String fullMethodInfo = jp.getTarget().getClass().getSimpleName() + "."
            + jp.getSignature().getName();

        String paramInfo = null;
        try {
            if (!fullMethodInfo.endsWith("Batch") &&
                !fullMethodInfo.endsWith("export") &&
                !fullMethodInfo.endsWith("login") &&
                !fullMethodInfo.endsWith("getVerify") &&
                !fullMethodInfo.endsWith("download") &&
                !fullMethodInfo.endsWith("Upload") &&
                !fullMethodInfo.endsWith("getSmokeDetectorPushData")) {
                paramInfo = JSON.toJSONString(jp.getArgs());
                //入参
                logger.info("{\"Controller_method_start\":{},\"params:\"{}}",
                    fullMethodInfo, paramInfo);
            }
        } catch (Throwable ex) {
            logger.error("请求方法 = {},参数序列化异常", fullMethodInfo, ex);
        }


        try {
            rvt = jp.proceed();
            if (fullMethodInfo.endsWith("insertEventLog") || fullMethodInfo.endsWith("queryIfsListByAppNo") ||
                fullMethodInfo.endsWith("Export") || fullMethodInfo.endsWith("export")) {
                return rvt;
            }
            long endTime = System.currentTimeMillis();
            String returnInfo = JSON.toJSONString(rvt);
            long time = endTime - startTime;
            //出参
            logger.info("{\"Controller_method_end\":{},\"returnData:\"{},\"duration\":{}}",
                fullMethodInfo, returnInfo, time);
            return rvt;
        } catch (AppException e) {
            if (Objects.equals(e.getCode(), ErrorCode.NOT_EXIST.getCode())) {
                logger.info("请求方法 = {},参数 = {}，{}", fullMethodInfo, paramInfo, e.getMessage());
            } else {
                logger.error("请求方法 = {},参数 = {}发生系统业务异常:{}", fullMethodInfo, paramInfo, e.getMessage(), e);
            }
            return new RestResponse(e.getCode(), e.getMessage());
        } catch (DataAccessException | SQLException e) {
            logger.error("请求方法={},参数={}发生了数据库访问异常:{}", fullMethodInfo, paramInfo, e.getMessage(), e);
            return new RestResponse(ErrorCode.ERR_SYSTEM.getCode(), "数据库访问异常:" + e.getMessage());
        } catch (Throwable e) {
            logger.error("请求方法={},参数={}发生了系统未知异常:{}", fullMethodInfo, paramInfo, e.getMessage(), e);
            return new RestResponse(ErrorCode.ERR_SYSTEM.getCode(), e.getMessage());
        }

    }
}