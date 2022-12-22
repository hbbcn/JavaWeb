package com.atguigu.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *@ClassName SpringConfig
 *@Description  TODO
 *@Author HuangQingbin
 *@Date 2021/8/13 10:34
 *@Version 1.0
 */

//完全注解开发
@Configuration //作为配置类，替代xml配置文件
@ComponentScan(basePackages = {"com.atguigu"})
public class SpringConfig{

}

