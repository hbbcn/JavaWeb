package com.atguigu.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *@ClassName ExceptionController
 *@Description  TODO
 *@Author hqb
 *@Date 2021/8/29 15:59
 *@Version 1.0
 */
@ControllerAdvice
public class ExceptionController{

    @ExceptionHandler(value = {ArithmeticException.class,NullPointerException.class})
    public String testException(Exception ex, Model model){

        model.addAttribute("ex",ex);
        return "error";
    }


}

