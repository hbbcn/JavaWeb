package com.atguigu.test;

import com.atguigu.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *@ClassName JTest4
 *@Description  TODO
 *@Author HuangQingbin
 *@Date 2021/8/15 10:44
 *@Version 1.0
 */
//第一步引入依赖 spring-test-5.2.6.RELEASE.jar

@RunWith(SpringJUnit4ClassRunner.class)//单元测试版本
@ContextConfiguration("classpath:bean1.xml")//加载配置文件

//Spring5整合Junit4
public class JTest4{

    @Autowired
    private UserService userService;

    @Test
    public void test1(){
        System.out.println(userService);
    }
}

