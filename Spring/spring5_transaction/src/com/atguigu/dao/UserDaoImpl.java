package com.atguigu.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @ClassName UserDaoImpl
 * @Description TODO
 * @Author HuangQingbin
 * @Date 2021/8/14 15:50
 * @Version 1.0
 */
@Repository

public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public void addMoney(Integer money,String name) {

        String sql = "update t_account set money = money+? where name = ?";

        jdbcTemplate.update(sql,money,name);
    }

    @Override
    public void reduceMoney(Integer money,String name) {

        String sql = "update t_account set money = money-? where  name = ?";
        jdbcTemplate.update(sql, money,name);
    }
}

