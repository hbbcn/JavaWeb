package com.atguigu.aopannotation;
import org.springframework.stereotype.Component;

/**
 *@ClassName User
 *@Description  TODO
 *@Author HuangQingbin
 *@Date 2021/8/13 14:54
 *@Version 1.0
 */

//AOP操作(AspectJ注解)
// 被增强类
// 1、创建类，在类中定义方法

@Component
public class User{

    public void add(){
        System.out.println("add.....");
    }
}

