package com.atguigu.Dao;


import com.atguigu.Bean.Book;

/**
 *@ClassName UserDao
 *@Description  TODO
 *@Author HuangQingbin
 *@Date 2021/8/16 15:34
 *@Version 1.0
 */
public interface UserDao{

    void addMoney(Integer money,String name);

    void reduceMoney(Integer money,String name);

    Book queryById(Integer id);
    void test();
}

