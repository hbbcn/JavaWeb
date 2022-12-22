package com.atguigu.test;

import com.atguigu.bean.Book;
import com.atguigu.factoryBean.MyBean;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *@ClassName TestMyBean
 *@Description  TODO
 *@Author hqb
 *@Date 2021/8/30 15:49
 *@Version 1.0
 */
public class TestMyBean{

    @Test
    public void test01(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("FactoryBean.xml");
        Book book = context.getBean("mybean", Book.class);
        System.out.println(book);

    }
}

