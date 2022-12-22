package com.atguigu.test;

import com.atguigu.dao.UserDao;
import com.atguigu.dao.UserDaoImpl;
import com.atguigu.service.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *@ClassName TestUser
 *@Description  TODO
 *@Author hqb
 *@Date 2021/8/30 16:46
 *@Version 1.0
 */
public class Test01 {

    @Test
    public void testUser(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        UserDaoImpl userDao = context.getBean("userDaoImpl", UserDaoImpl.class);
        userDao.add();

    }

    @Test
    public void testService(){

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.testAdd();
    }




}

