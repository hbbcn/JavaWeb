package com.atguigu.proxy;
/**
 *@ClassName UserDaoImpl
 *@Description  TODO
 *@Author hqb
 *@Date 2021/8/30 18:55
 *@Version 1.0
 */
public class UserDaoImpl implements UserDao{

    @Override
    public int add(int i, int j) {

        return i + j;
    }

    @Override
    public String update(String id) {
        return null;
    }
}

