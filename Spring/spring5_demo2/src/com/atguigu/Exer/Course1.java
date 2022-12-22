package com.atguigu.Exer;
/**
 *@ClassName Course1
 *@Description  TODO
 *@Author HuangQingbin
 *@Date 2021/8/11 20:01
 *@Version 1.0
 */
public class Course1{


    private String id;
    private String name;


    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Course1{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

