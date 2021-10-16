package com.atguigu.test;

import com.atguigu.utils.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;

/**
 *@ClassName JdbcUtilsTest
 *@Description  TODO
 *@Author HuangQingbin
 *@Date 2021/7/22 18:51
 *@Version 1.0
 */
public class JdbcUtilsTest{

    @Test
    public void testJdbcUtils(){
        Connection connection = JdbcUtils.getConnection();
        System.out.println(connection);
//        JdbcUtils.close(connection);
    }
}

