package com.sias.dao.Impl;

import com.sias.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import javax.management.Query;
import javax.print.attribute.standard.ReferenceUriSchemesSupported;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *@ClassName BaseDao
 *@Description  TODO
 *@Author HuangQingbin
 *@Date 2021/8/8 18:02
 *@Version 1.0
 */
public abstract class BaseDao{


    //首先使用DbUtils操作数据库，导入jar包 commons-dbutils-1.3.jar
    private QueryRunner queryRunner = new QueryRunner();
    //update方法 对表进行增删改操作
    public int update (String sql,Object ...args){

        Connection conn = JdbcUtils.getConnection();
        try {
            return queryRunner.update(conn, sql, args);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }finally {
            JdbcUtils.close(conn);
        }
    }

    //查询返回一条javaBean的sql语句

    public  <T> T queryBookById(Class<T> Type,String sql,Object  ...args){

        Connection conn = JdbcUtils.getConnection();

        try {
            BeanHandler<T> handler = new BeanHandler<>(Type);
            return queryRunner.query(conn,sql,handler,args);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }finally {
           JdbcUtils.close(conn);
        }
    }

    //查询返回多条javaBean的sql语句

    public <T> List<T> queryStudentAll(Class<T> Type, String sql, Object ...args){
        Connection conn = JdbcUtils.getConnection();
        try {
            BeanListHandler<T> listHandler = new BeanListHandler<>(Type);
            return queryRunner.query(conn,sql,listHandler,args);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }finally {
            JdbcUtils.close(conn);
        }
    }

    //查询特殊值
    public Object queryForSingerValue(String sql,Object ...args){
        Object query = null;
        Connection conn = JdbcUtils.getConnection();
        try {
            query = queryRunner.query(conn, sql, new ScalarHandler(), args);
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            JdbcUtils.close(conn);
        }

    }
}

