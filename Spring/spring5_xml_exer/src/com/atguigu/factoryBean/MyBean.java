package com.atguigu.factoryBean;

import com.atguigu.bean.Book;
import org.springframework.beans.factory.FactoryBean;

import java.util.PrimitiveIterator;

/**
 *@ClassName MyBean
 *@Description  TODO
 *@Author hqb
 *@Date 2021/8/30 15:32
 *@Version 1.0
 */
public class MyBean implements FactoryBean<Book> {

    private Book book;

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public Book getObject() throws Exception {

        return book;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}

