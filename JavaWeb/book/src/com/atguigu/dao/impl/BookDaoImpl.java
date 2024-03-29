package com.atguigu.dao.impl;

import com.atguigu.dao.BookDao;
import com.atguigu.pojo.Book;

import java.util.List;

/**
 *@ClassName BookDaoImpl
 *@Description  TODO
 *@Author HuangQingbin
 *@Date 2021/7/28 16:26
 *@Version 1.0
 */
public class BookDaoImpl extends BaseDao implements BookDao {


    @Override
    public int addBook(Book book) {

        String sql = "insert into t_book (name,price,author,sales,stock,img_path) values(?,?,?,?,?,?)";
        return update(sql,book.getName(),book.getPrice(),book.getAuthor(),book.getSales(),book.getStock(),book.getImgPath());

    }

    @Override
    public int deleteBookById(Integer id) {

        String sql = "delete from t_book where id = ?";
        return  update(sql,id);

    }

    @Override
    public int updateBook(Book book) {

        String sql = "update t_book set name=?,price=?,author=?,sales=?,stock=?,img_path=? where id = ?";

       return update(sql,book.getName(),book.getPrice(),book.getAuthor(),book.getSales(),book.getStock(),book.getImgPath(),book.getId());


    }

    @Override
    public Book queryBookById(Integer id) {

        String sql = "select * from t_book where id = ?";
        return queryForOne(Book.class, sql, id);
    }

    /*public Book queryBookByName(String bookName){
        String sql = "select * from t_book where name like %?% ";
        return queryForOne(Book.class,sql,bookName);
    }*/

   @Override
    public List<Book> queryBooks() {
        String sql = "select * from t_book";

        return queryForOne2(Book.class,sql);
    }

    @Override
    public Integer queryForPageTotalCount() {

        String sql = "select count(*) from t_book";
        Number count = (Number) queryForSingleValue(sql);
        return count.intValue();
    }

    @Override
    public List<Book> queryForPageItems(int begin, int pageSize) {
        String sql = "select * from t_book limit ?, ?";
        return queryForOne2(Book.class,sql,begin,pageSize);
    }

    @Override
    public List<Book> queryForPagePrice(int min, int max,int begin,int pageSize) {

        String sql = "select * from (select * from t_book where price between ? and ?) as t order by price limit ?,?";
        return queryForOne2(Book.class,sql,min,max,begin,pageSize);
    }

    public Integer queryPriceTotalCount(int min,int max){

        String sql = "select count(*) from t_book where price between ? and ?";

        Number priceCount = (Number) queryForSingleValue(sql, min, max);
        return priceCount.intValue();
    }


}

