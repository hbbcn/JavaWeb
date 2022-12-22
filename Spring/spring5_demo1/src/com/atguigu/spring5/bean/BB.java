package com.atguigu.spring5.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.sql.SQLOutput;

/**
 *@ClassName BB
 *@Description  TODO
 *@Author hqb
 *@Date 2021/11/10 12:25
 *@Version 1.0
 */
@Component
public class BB{

    @Resource
    private static AA aa;

    public static void main(String[] args) {
        System.out.println(">>>>>>>>>>>");
        int age = aa.getAge();
        System.out.println(aa.getAge());
    }
}

