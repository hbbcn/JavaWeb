package com.atguigu.service;

import com.atguigu.dao.BookDao;
import com.atguigu.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *@ClassName BookService
 *@Description  TODO
 *@Author HuangQingbin
 *@Date 2021/8/13 20:48
 *@Version 1.0
 */
@Service
public class BookService{

    //注入BookDao
    @Autowired
    private BookDao bookDao;

    //添加方法
    public void addBook(Book book){
        bookDao.add(book);
    }


    //修改方法
    public void updateBook(Book book){
        bookDao.updateBook(book);
    }

    //删除方法
    public void delete(Integer id){

        bookDao.deleteBook(id);
    }

    //查询表记录数
    public int selectCount(){
        return  bookDao.selectCount();
    }

    //查询返回对象
    public Book findOne(Integer userId){
       return bookDao.findOne(userId);
    }

    //查询返回集合
    public List<Book> findList(){
       return bookDao.findList();
    }

    //批量添加
    public void batchAdd(List<Object[]> batchArgs){
         bookDao.batchAdd(batchArgs);
    }

    //批量修改
    public void batchUpdate(List<Object[]> batchArgs){
        bookDao.batchUpdate(batchArgs);
    }

    //批量删除操作
    public void batchDelete(List<Object[]> batchArgs){
        bookDao.batchDelete(batchArgs);
    }

}



