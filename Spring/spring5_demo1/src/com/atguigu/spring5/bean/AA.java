package com.atguigu.spring5.bean;

import org.springframework.stereotype.Component;

/**
 *@ClassName AA
 *@Description  TODO
 *@Author hqb
 *@Date 2021/11/10 12:25
 *@Version 1.0
 */
@Component
public class AA{

    private String name;
    private int age =1;

    public AA() {
    }

    public AA(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

