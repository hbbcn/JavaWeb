package com.atguigu.aopannotation;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 *@ClassName PersonProcy
 *@Description  TODO
 *@Author HuangQingbin
 *@Date 2021/8/13 19:29
 *@Version 1.0
 */

@Component
@Aspect
@Order(1)
public class PersonProxy {
    //前置通知(返回通知)
    @Before(value = "execution(* com.atguigu.aopannotation.User.add(..))")
    public void before(){
        System.out.println("Person Before......");
    }
}

