package com.atguigu.pojo;
/**
 *@ClassName pojo
 *@Description  TODO
 *@Author HuangQingbin
 *@Date 2021/8/5 20:20
 *@Version 1.0
 */

import javax.print.DocFlavor;

/**
 *JavaBean是一个遵循特定写法的Java类，它通常具有如下特点：
 *    这个Java类必须具有一个无参的构造函数
 *    属性必须私有化。
 *    私有化的属性必须通过public类型的方法暴露给其它程序，并且方法的命名也必须遵守一定的命名规范。
 */
public class Person {

    private Integer id;
    private String name;

    public Person() {
    }

    public Person(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

