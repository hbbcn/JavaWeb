package com.atguigu.test;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class BookServiceImplTest {

    private BookService bookService = new BookServiceImpl();
    @Test
    public void addBook() {
        bookService.addBook(new Book(null,"西亚斯","hbb1",new BigDecimal(10000),99999,999,null));
    }

    @Test
    public void deleteBookById() {

        bookService.deleteBookById(23);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(23,"毛泽东","hbb1",new BigDecimal(99999),999999,999,null));
    }

    @Test
    public void queryBookById() {

        System.out.println(bookService.queryBookById(23));
    }

    @Test
    public void queryBooks() {
       for (Book queryBook : bookService.queryBooks()){
           System.out.println(queryBook);
       }
    }

    @Test
    public void page(){
        System.out.println(bookService.page(1,4));
    }

    @Test
    public void pageByPrice(){

//        Page<Book> bookPage = bookService.pageByPrice(1, 2, 10, 50);
        System.out.println(bookService.pageByPrice(10,50 , 1, 4));

    }



}