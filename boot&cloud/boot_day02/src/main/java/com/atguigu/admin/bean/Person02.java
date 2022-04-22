package com.atguigu.admin.bean;

import lombok.Data;

import java.util.Date;

/**
 *@ClassName Person02
 *@Description  TODO
 *@Author hqb
 *@Date 2021/11/1 11:30
 *@Version 1.0
 */
@Data
public class Person02{

    private String userName;
    private Integer age;
    private Date birth;
    private Pet pet;
}

