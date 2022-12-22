package com.atguigu.test;

import com.atguigu.bean.Book;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *@ClassName testBook
 *@Description  TODO
 *@Author hqb
 *@Date 2021/8/30 13:18
 *@Version 1.0
 */
public class testBook {

    @Test
    public void testBook(){

          ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanbook.xml");
        Book book = context.getBean("book", Book.class);
//        book.test1();
        Book book1 = context.getBean("book", Book.class);
        System.out.println(book1);
        System.out.println(book);

    }

}

