package com.atguigu.admin.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import sun.rmi.runtime.Log;

/**
 *@ClassName GlobalExceptionHandler
 *@Description  TODO
 *@Author hqb
 *@Date 2021/11/7 16:49
 *@Version 1.0
 */

/*
    处理整个web controller的异常
 */

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler{

    @ExceptionHandler({ArithmeticException.class,NullPointerException.class})   //处理异常
    public String handleArithException(Exception e){

        log.error("异常是：{}",e);
        return "login"; //视图地址
    }

}

