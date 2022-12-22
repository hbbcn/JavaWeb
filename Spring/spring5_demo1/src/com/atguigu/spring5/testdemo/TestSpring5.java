package com.atguigu.spring5.testdemo;

import com.atguigu.spring5.Book;
import com.atguigu.spring5.Orders;
import com.atguigu.spring5.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *@ClassName TestSpring5
 *@Description  TODO
 *@Author HuangQingbin
 *@Date 2021/8/6 21:03
 *@Version 1.0
 */
public class TestSpring5{

    @Test
    public void testAdd(){

        //1、spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        ApplicationContext context1 = new ClassPathXmlApplicationContext("bean1.xml");

        //2、获取配置创建的对象
        User user = context.getBean("user", User.class);

        User user1 = context1.getBean("user", User.class);//false
        System.out.println(user);
        System.out.println(user==user1);
        user.add();

    }

    @Test
    public void testBook1(){

        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        Book book = context.getBean("book", Book.class);
        System.out.println(book);
        book.testBook();
    }


    @Test
    public void testOrders(){
        //1、加载spring配置文件
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");

        //2、获取配置文件的对象
        Orders orders = context.getBean("orders", Orders.class);

        System.out.println(orders);
        orders.ordersTest();
    }



}

