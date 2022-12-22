package com.atguigu.test;

import com.atguigu.aopannotation.User;
import com.atguigu.aopxml.Book;
import com.atguigu.proxy.UserDao;
import com.atguigu.proxy.UserDaoImpl;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *@ClassName TestAop
 *@Description  TODO
 *@Author HuangQingbin
 *@Date 2021/8/13 15:52
 *@Version 1.0
 */
public class TestAop{

    @Test
    public void testAopAnno(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        User user = context.getBean("user", User.class);
        user.add();
    }

    @Test
    public void testAopXml(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("proxyBean.xml");
        Book book = context.getBean("book", Book.class);
        book.buy();
    }

    @Test
    public void test(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        UserDao user= context.getBean(UserDao.class);
        int add = user.add(1, 2);


    }
}

