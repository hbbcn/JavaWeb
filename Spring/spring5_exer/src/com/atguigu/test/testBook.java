package com.atguigu.test;

import com.atguigu.Bean.Book;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *@ClassName testBook
 *@Description  TODO
 *@Author hqb
 *@Date 2021/8/30 13:18
 *@Version 1.0
 */
public class testBook{

    @Test
    public void testBook(){

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("conf/beanbook.xml");
        Book book = context.getBean("book", Book.class);
        System.out.println(book);

    }

}

