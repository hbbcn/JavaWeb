package com.atguigu.test;

import com.atguigu.Bean.Book;
import com.atguigu.Bean.User;
import com.atguigu.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 *@ClassName ServiceTest
 *@Description  TODO
 *@Author HuangQingbin
 *@Date 2021/8/16 16:04
 *@Version 1.0
 */
public class ServiceTest{

    @Test
    public void test01(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("conf/bean1.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.test();
        Book book = userService.queryById(1);
        System.out.println(book.toString());

    }


//   基于xml的方式创建对象
    @Test
    public void test02(){

        ApplicationContext context = new ClassPathXmlApplicationContext("conf/userbean.xml");
        User user = context.getBean("user", User.class);
        user.add();
    }

    @Test
    public void test03(){
        ApplicationContext context = new ClassPathXmlApplicationContext("conf/userbean.xml");
        User user = context.getBean("user", User.class);
        user.add();
    }

    @Test
    public void testBook1(){


    }
}

