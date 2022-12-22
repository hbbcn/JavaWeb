package com.atguigu.aopannotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 *@ClassName ConfigAop
 *@Description  TODO
 *@Author HuangQingbin
 *@Date 2021/8/13 20:04
 *@Version 1.0
 */

//完全注解 增强方法
@Configuration
@ComponentScan(basePackages = {"com.atguigu"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ConfigAop{

}

