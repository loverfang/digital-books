package com.echuang.common.exception;

import com.echuang.common.utils.ResultResponse;
import org.apache.shiro.authz.AuthorizationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * 自定义异常处理器
 * @Author Luo.z.x
 * @Date 2020/8/26 12:34
 * @Version 1.0
 */
@RestControllerAdvice
public class RRExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 处理自定义异常
     */
    @ExceptionHandler(RRException.class)
    public ResultResponse handleRRException(RRException e) {
        ResultResponse r = new ResultResponse();
        r.put("code", e.getCode());
        r.put("msg", e.getMessage());
        return r;
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResultResponse handlerNoFoundException(Exception e) {
        logger.error(e.getMessage(), e);
        return ResultResponse.error(404, "路径不存在，请检查路径是否正确");
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public ResultResponse handleDuplicateKeyException(DuplicateKeyException e) {
        logger.error(e.getMessage(), e);
        return ResultResponse.error("数据库中已存在该记录");
    }

    @ExceptionHandler(AuthorizationException.class)
    public ResultResponse handleAuthorizationException(AuthorizationException e) {
        logger.error(e.getMessage(), e);
        return ResultResponse.error("没有权限，请联系管理员授权");
    }

    @ExceptionHandler(Exception.class)
    public ResultResponse handleException(Exception e) {
        logger.error(e.getMessage(), e);
        return ResultResponse.error();
    }
}
