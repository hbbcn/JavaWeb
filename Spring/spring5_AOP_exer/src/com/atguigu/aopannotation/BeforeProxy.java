package com.atguigu.aopannotation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 *@ClassName BeforeProxy
 *@Description  TODO
 *@Author hqb
 *@Date 2021/8/30 20:03
 *@Version 1.0
 */
@Component
@Aspect
public class BeforeProxy{

    @Before("execution(* com.atguigu.aopannotation.User.add(..))")
    public void before(){
        System.out.println("方法之前执行");
    }
}

