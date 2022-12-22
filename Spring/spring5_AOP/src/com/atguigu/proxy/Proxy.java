package com.atguigu.proxy;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;

/**
 *@ClassName Proxy
 *@Description  TODO
 *@Author hqb
 *@Date 2021/8/30 20:24
 *@Version 1.0
 */
@Component
@Aspect//生成代理对象
public class Proxy{

    @Before("execution(* com.atguigu.proxy.UserDaoImpl.add(..))")
    public void before(){
        System.out.println("方法之前执行");
    }
}

