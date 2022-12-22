package com.atguigu.Dao;

import com.atguigu.Bean.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


/**
 *@ClassName UserDaoImpl
 *@Description  TODO
 *@Author HuangQingbin
 *@Date 2021/8/16 15:35
 *@Version 1.0
 */


@Repository
public class UserDaoImpl implements UserDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addMoney(Integer money, String name) {

    }

    @Override
    public void reduceMoney(Integer money, String name) {

    }

    @Override
    public Book queryById(Integer id) {
        System.out.println("你好");

        String sql = "select * from t_book where userId = ?";
        Book book = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Book.class), id);
        return book;
    }


    @Override
    public void test() {
        System.out.println("你好");
    }


}

