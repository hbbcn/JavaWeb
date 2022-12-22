package com.atguigu.service;
import com.atguigu.Bean.Book;
import com.atguigu.Dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 *@ClassName UserService
 *@Description  TODO
 *@Author HuangQingbin
 *@Date 2021/8/16 15:49
 *@Version 1.0
 */
@Service
@Transactional()
public class UserService{

    @Autowired
    private UserDao userDao;

    public void test(){
        userDao.test();
    }

    public Book queryById(Integer id){
        Book book = userDao.queryById(id);
        return book;
    }
}

