package com.laki.gymdemo.common.exception;

import com.laki.gymdemo.common.ResultCom;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.ShiroException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 */

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = RuntimeException.class)
    public ResultCom handler(RuntimeException e) {
        log.error("运行时异常：--------------------", e);
        return ResultCom.fail(e.getMessage());
    }

    /**
     * shiro异常，如果未认证则会显示401的报错
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(value = ShiroException.class)
    public ResultCom handler(ShiroException e) {
        log.error("运行时异常：--------------------", e);
        return ResultCom.fail(401,e.getMessage(),null);
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = IllegalAccessException.class)
    public ResultCom handler(IllegalAccessException e) {
        log.error("Assert异常：--------------------", e);
        return ResultCom.fail(e.getMessage());
    }


}
