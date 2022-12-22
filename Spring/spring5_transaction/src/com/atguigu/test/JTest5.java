package com.atguigu.test;

import com.atguigu.service.UserService;

import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 *@ClassName JTest5
 *@Description  TODO
 *@Author HuangQingbin
 *@Date 2021/8/15 11:28
 *@Version 1.0
 */

//@ExtendWith(SpringExtension.class)
//@ContextConfiguration("classpath:bean1.xml")
@SpringJUnitConfig(locations = "classpath:bean1.xml")
public class JTest5{

    @Autowired
    private UserService userService;


    @Test
    public void test1(){
        userService.transfer();
    }
}

