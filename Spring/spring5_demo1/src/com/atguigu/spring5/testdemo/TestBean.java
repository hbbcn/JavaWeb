package com.atguigu.spring5.testdemo;

import com.atguigu.spring5.bean.Dept;
import com.atguigu.spring5.bean.Emp;
import com.atguigu.spring5.dao.UserDaoImpl;
import com.atguigu.spring5.service.BookService;
import com.atguigu.spring5.service.BookServiceImpl;
import com.atguigu.spring5.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *@ClassName TestBean
 *@Description  TODO
 *@Author HuangQingbin
 *@Date 2021/8/7 16:03
 *@Version 1.0
 */
public class TestBean{


    @Test
    public void testAdd(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");

//        UserDaoImpl userDaoImpl = context.getBean("userDaoImpl", UserDaoImpl.class);


        UserService userService = context.getBean("userService", UserService.class);

        boolean userService1 = context.containsBean("userService");
        System.out.println(userService1);
        userService.add();

    }


//    内部bean测试
    @Test
    public void testEmp(){
        //1、加载spring配置文件
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");
        //2、获取配置创建的对象
        Emp emp = context.getBean("emp", Emp.class);

        emp.testEmp();
    }

//    级联赋值
    @Test
    public void testEmp1(){
        //1、加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean4.xml");
        //2、获取配置创建的对象
        Emp emp = context.getBean("emp", Emp.class);
        emp.testEmp();
    }

    @Test
    public void testBookService(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean5.xml");
        BookService bookServiceImpl = (BookServiceImpl) context.getBean("bookServiceImpl",BookService.class);
        bookServiceImpl.add2();
    }
}

