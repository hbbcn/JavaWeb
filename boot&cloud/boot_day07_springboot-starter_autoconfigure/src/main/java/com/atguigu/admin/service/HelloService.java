package com.atguigu.admin.service;

import com.atguigu.admin.bean.HelloProperties;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *@ClassName HelloService
 *@Description  TODO
 *@Author hqb
 *@Date 2021/11/13 14:06
 *@Version 1.0
 */

/**
 * 默认不要放容器中
 */
public class HelloService{

    @Autowired
    HelloProperties helloProperties;

    public String sayHello(String userName){
        return helloProperties.getPrefix() + ":" + "username" + "<<" + helloProperties.getSuffix();
    }
}

