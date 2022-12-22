package com.atguigu.spring5.bean;
/**
 *@ClassName Dept
 *@Description  TODO
 *@Author HuangQingbin
 *@Date 2021/8/7 16:12
 *@Version 1.0
 */
public class Dept{

    private String dname;

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDname() {
        return dname;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "dname='" + dname + '\'' +
                '}';
    }


}

