package com.atguigu.service;

import com.atguigu.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *@ClassName UserService
 *@Description  TODO
 *@Author HuangQingbin
 *@Date 2021/8/14 15:47
 *@Version 1.0
 */
@Service
@Transactional(transactionManager = "transactionManager",readOnly = false,propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ,timeout = -1) //事务注解
public class UserService{

    //注入UserDao
    @Autowired
    private UserDao userDao;


    public void transfer(){
//        try {
            //第一步 开启事务
            //第二步 进行业务操作
            userDao.addMoney(100, "lucy");

            //模拟异常
//            int i = 100/0;
            //第三步 没有发生异常，提交事务
            userDao.reduceMoney(100, "mary");
        }
//        catch(Exception e){
            //第四步 出现异常，事务回滚
//        }
//    }


}

