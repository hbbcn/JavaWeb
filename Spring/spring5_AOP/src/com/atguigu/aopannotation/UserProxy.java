package com.atguigu.aopannotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 *@ClassName UserProxy
 *@Description  TODO
 *@Author HuangQingbin
 *@Date 2021/8/13 14:57
 *@Version 1.0
 */

//增强类
@Component
@Aspect //生成代理对象
@Order(3) // 有多个增强类对同一个方法进行增强，设置增强类优先级 数字类型值越小优先级就越高
public class UserProxy{

    //相同切入点抽取
    @Pointcut(value = "execution(* com.atguigu.aopannotation.User.add(..))")
    public void pointDemo(){
    }
    //前置通知
    //@Before注解表示作为前置通知
    @Before(value = "pointDemo()")
    public void before(){
        System.out.println("before....");
    }

      //最终通知 无论有没有异常都执行
    @After(value = "pointDemo()")
    public void after(){
        System.out.println("after.....");
    }

    //后置通知(返回通知) 有异常就不执行
    @AfterReturning(value = "pointDemo()")//返回值之后执行
    public void afterReturning(){
        System.out.println("afterReturning.....");
    }

    // 异常通知
    @AfterThrowing(value = "pointDemo()")
    public void afterThrowing(){
        System.out.println("afterThrowing.....");
    }

    //环绕通知
    @Around(value = "execution(* com.atguigu.aopannotation.User.add(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕之前.....");

        //被增强的方法执行
        proceedingJoinPoint.proceed();
        System.out.println("环绕之后.....");
    }
}

