package com.atguigu.test;

import com.atguigu.service.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.IdentityHashMap;

/**
 *@ClassName testUservice
 *@Description  TODO
 *@Author hqb
 *@Date 2021/8/30 14:15
 *@Version 1.0
 */
public class TestUserService {

    @Test
    public void testUserService(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanUserService.xml");
        UserService userService = context.getBean(UserService.class);
        userService.testUserDao();
    }
}

