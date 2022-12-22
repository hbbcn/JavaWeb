package com.atguigu.test;

import com.atguigu.entity.Book;
import com.atguigu.service.BookService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.xml.transform.Source;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

/**
 * @ClassName TestBook
 * @Description TODO
 * @Author HuangQingbin
 * @Date 2021/8/13 21:19
 * @Version 1.0
 */
public class TestBook {

    @Test
    public void testJdbcTemplate() {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);

        //添加操作
//        bookService.addBook(new Book(3,"java","j"));

        //修改操作
        bookService.updateBook(new Book(1,"数学","m"));
        //删除操作
//        bookService.delete(1);

        //查询表中记录数
//        int i = bookService.selectCount();
//        System.out.println(i);

        //查询返回对象
/*        Book one = bookService.findOne(1);
        System.out.println(one);*/

        //查询返回集合
//        List<Book> list = bookService.findList();
//        System.out.println(list);

        //批量添加

//        List<Object[]> batchArgs = new ArrayList<>();
//
//        Object[] o1 = {2,"spring","s"};
//        Object[] o2 = {4,"js","j"};
//        Object[] o3 = {5,"jQuery","a"};
//        batchArgs.add(o1);
//        batchArgs.add(o2);
//        batchArgs.add(o3);
//        bookService.batchAdd(batchArgs);
        //批量修改操作
//        List<Object[]> batchArgs = new ArrayList<>();
//        Object[] o1 = {"数学", "s3", 2};
//        Object[] o2 = {"高数", "j4", 4};
//        Object[] o3 = {"计算机", "a5", 5};
//
//        batchArgs.add(o1);
//        batchArgs.add(o2);
//        batchArgs.add(o3);
//
//        bookService.batchUpdate(batchArgs);

        //批量删除操作
        //批量修改操作
/*        List<Object[]> batchArgs = new ArrayList<>();
        Object[] o1 = {2};
        Object[] o2 = {4};
        Object[] o3 = {};

        batchArgs.add(o1);
        batchArgs.add(o2);
        batchArgs.add(o3);
        bookService.batchDelete(batchArgs);*/
    }

}

