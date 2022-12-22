package com.atguigu.aopannotation;

import org.springframework.stereotype.Component;

/**
 *@ClassName User
 *@Description  TODO
 *@Author hqb
 *@Date 2021/8/30 18:24
 *@Version 1.0
 */


//被增强的方法
@Component
public class User{

    public void add(){
        System.out.println("add>>>>>>>>>>>>>>>");
    }
}

