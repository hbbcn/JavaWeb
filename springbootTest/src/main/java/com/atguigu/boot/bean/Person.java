package com.atguigu.boot.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 *@ClassName Person
 *@Description  TODO
 *@Author hqb
 *@Date 2021/11/9 14:53
 *@Version 1.0
 */


public interface Person{

    String getName();
    String getAge();

}

