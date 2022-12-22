package com.atguigu.collectiontype;
/**
 *@ClassName Course
 *@Description  TODO
 *@Author HuangQingbin
 *@Date 2021/8/7 18:04
 *@Version 1.0
 */
public class Course{

    private String cname;

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Override
    public String toString() {
        return "Course{" +
                "cname='" + cname + '\'' +
                '}';
    }
}

