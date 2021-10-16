package com.sias.test;

import com.sias.utils.JdbcUtils;
import org.junit.Test;

import java.net.SocketTimeoutException;
import java.sql.Connection;

/**
 *@ClassName JdbcUtilsTest
 *@Description  TODO
 *@Author HuangQingbin
 *@Date 2021/8/8 20:45
 *@Version 1.0
 */
public class JdbcUtilsTest{

    @Test
    public void test(){
        Connection conn = JdbcUtils.getConnection();
        System.out.println(conn);
    }
}

