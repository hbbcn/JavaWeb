package com.atguigu.admin.service;

import com.atguigu.admin.bean.User01;
import com.atguigu.admin.mapper.User01Mapper;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *@ClassName AccountService
 *@Description  TODO
 *@Author hqb
 *@Date 2021/11/5 17:01
 *@Version 1.0
 */

/**
 * 配置mybatis步骤
 * 导入mybatis官方starter
 * 编写mapper接口。标注@Mapper注解
 * 编写sql映射文件并绑定mapper接口
 * 在application.yaml中指定Mapper配置文件的位置，以及指定全局配置文件的信息
 */
@Service
public class User01Service {

    @Autowired
    User01Mapper userMapper;

    public User01 getUserById(Long id){
        return userMapper.getUser(id);
   }


}

