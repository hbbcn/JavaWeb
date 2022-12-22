package com.atguigu.dao;

import com.atguigu.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

/**
 *@ClassName BookDaoImpl
 *@Description  TODO
 *@Author HuangQingbin
 *@Date 2021/8/13 20:48
 *@Version 1.0
 */
@Repository
public class BookDaoImpl implements BookDao{

    //注入JdbcTemplate
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void add(Book book) {

        //创建sql语句
        String sql = "insert into t_book values(?,?,?)";
        Object[] args = { book.getUserId(), book.getUsername(), book.getUstatus()};

        //调用方法实现
        int update = jdbcTemplate.update(sql,args);
        System.out.println(update);
    }

    @Override
    public void deleteBook(Integer id) {

        String sql = "delete from t_book where userId = ?";
        jdbcTemplate.update(sql,id);

    }

    @Override
    public void updateBook(Book book) {

        String sql = "update t_book set username=?,ustatus=? where userId = ?";
        Object[] args = {book.getUsername(), book.getUstatus(),book.getUserId()};
        jdbcTemplate.update(sql,args);
    }

    @Override
    public int selectCount() {
        String sql = "select count(*) from t_book";

        //查询表中记录数
         return jdbcTemplate.queryForObject(sql, Integer.class);

    }

    @Override
    public Book findOne(Integer userId) {
        String sql = "select * from t_book where userId = ?";
        return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<Book>(Book.class),userId);
    }

    @Override
    public List<Book> findList() {
        String sql = "select * from t_book";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Book.class));
    }

    //批量添加操作
    @Override
    public void batchAdd(List<Object[]> batchArgs) {

        String sql = "insert into t_book values(?,?,?)";
        int[] ints = jdbcTemplate.batchUpdate(sql, batchArgs);

    }

    //批量修改操作
    @Override
    public void batchUpdate(List<Object[]> batchArgs){

        System.out.println(">>>>>>");
//        String sql = "update t_book set username = ?, ustatus = ? where userId = ?";
        String sql =  "update t_book set username=?,ustatus=? where userId = ?";
        for (Object[] obj : batchArgs){
            System.out.println(Arrays.toString(obj));
        }
        jdbcTemplate.batchUpdate(sql,batchArgs);
    }

    @Override
    public void batchDelete(List<Object[]> batchArgs) {
        String sql = "delete from t_book where userId = ?";
        jdbcTemplate.batchUpdate(sql,batchArgs);
    }


}

