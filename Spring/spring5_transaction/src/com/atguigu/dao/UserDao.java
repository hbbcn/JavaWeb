package com.atguigu.dao;

public interface UserDao {

    void addMoney(Integer money,String name);

    void reduceMoney(Integer money,String name);

}
