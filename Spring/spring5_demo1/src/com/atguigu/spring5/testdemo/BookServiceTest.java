package com.atguigu.spring5.testdemo;

import com.atguigu.spring5.service.BookService;
import com.atguigu.spring5.service.BookServiceImpl;
import org.junit.Test;

public class BookServiceTest {
    @Test
    public void test01(){
        BookService bookService = new BookServiceImpl();
        bookService.add2();
    }
}
