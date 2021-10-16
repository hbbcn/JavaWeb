package com.atguigu.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.sun.tools.javac.Main;

import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 *@ClassName JdbcUtils
 *@Description  TODO
 *@Author HuangQingbin
 *@Date 2021/7/22 17:26
 *@Version 1.0
 */
public class JdbcUtils {

    /**
     * 获取数据库连接
     */

    private static DruidDataSource dataSource;
    private static ThreadLocal<Connection> conns = new ThreadLocal<Connection>();

    static {
        try {
            Properties properties = new Properties();
            //读取jdbc.properties属性配置文件
            InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            //  从流中加载数据
            properties.load(inputStream);
            //  创建数据库连接池
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接池的连接
     *
     * @return 如果返回null 说明获取连接失败
     */
    public static Connection getConnection() {

        Connection conn = conns.get();
        //考虑事务
        if (conn == null) {
            try {
                conn = dataSource.getConnection(); //从数据库连接池中获取连接

                conns.set(conn); //保存到ThreadLocal对象中，供后面的jdbc操作使用
                conn.setAutoCommit(false); // 设置为手动管理事务
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        //不考虑事务
    /*    Connection conn = null;
        try {
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;*/

        return conn;
    }

    /*
        提交事务，并关闭释放连接
     */

    public static void commitAndClose(){
        Connection connection = conns.get();
        if (connection != null){ //如果不等于null，说明之前使用过连接，操作过数据库
            try {
                connection.commit();//提交 事务
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    connection.close(); //关闭连接资源
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        // 一定要执行remove操作，否则就会报错。（因为tomcat服务器底层使用了线程池技术）
        conns.remove();
    }


    public static void rollbackAndClose(){
        Connection connection = conns.get();
        if (connection != null){ //如果不等于null，说明之前使用过连接，操作过数据库
            try {
                connection.rollback();//回滚事务
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    connection.close(); //关闭连接资源
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        // 一定要执行remove操作，否则就会报错。（因为tomcat服务器底层使用了线程池技术）
        conns.remove();
    }

    /**
     * 关闭连接，放回数据库连接池
     * @param conn
     */
/*    public static void close(Connection conn ){
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }*/

}
