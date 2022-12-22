package com.atguigu.spring5.service;
import com.atguigu.spring5.dao.BookMapper;
import com.atguigu.spring5.dao.BookMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
public  class BookServiceImpl implements BookService{

    //需要我们new一个对象，类与类之间的耦合度高
//    BookMapper mapper = new BookMapperImpl();


    BookMapper mapper;

    //通过setter方法注入属性
    public void setMapper(BookMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public void add2() {
        mapper.add();
    }
}
