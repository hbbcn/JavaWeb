package com.atguigu.dao;

import com.atguigu.entity.Book;

import java.util.List;

public interface BookDao {

    //添加方法
    void add(Book book);

    void deleteBook(Integer id);

    void updateBook(Book book);

    int selectCount();

    Book findOne(Integer userId);

    List<Book> findList();

    void  batchAdd(List<Object[]> batchArgs);

    void batchUpdate(List<Object[]> batchArgs);

    void batchDelete(List<Object[]> batchArgs);
}

