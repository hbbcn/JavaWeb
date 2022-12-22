package com.atguigu.testdemo;

import com.atguigu.autowire.Emp;
import com.atguigu.beanlife.Orders;
import com.atguigu.collectiontype.Book;
import com.atguigu.collectiontype.Course;
import com.atguigu.collectiontype.Stu;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *@ClassName TestSpring5Demo1
 *@Description  TODO
 *@Author HuangQingbin
 *@Date 2021/8/7 17:53
 *@Version 1.0
 */
public class TestSpring5Demo1{

    @Test
    public void testCollection(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        Stu stu = context.getBean("stu", Stu.class);
        stu.test();


    }

  @Test
    public void testBook(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        Book book = context.getBean("book", Book.class);
        Book book1 = context.getBean("book", Book.class);
//        book.test();
      System.out.println(book);
      System.out.println(book1);
    }

    @Test
    public void testMyBean(){

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("factorybean.xml");
        Course course = context.getBean("myBean", Course.class);
        System.out.println(course);
    }

    @Test
    public void testOrderBean(){

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ordersbean.xml");
        Orders orders = context.getBean("orders", Orders.class);
        System.out.println("第四步 获取创建bean实例对象");
        System.out.println(orders);

        //手动让bean实例销毁
        context.close();
    }

    @Test
    public void testEmpBean(){

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("empBean.xml");
        Emp emp = context.getBean("emp", Emp.class);
        System.out.println(emp);
    }
}

