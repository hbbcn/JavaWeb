package com.atguigu.spring5.bean;

import org.springframework.beans.factory.annotation.Autowired;

/**
 *@ClassName Emp
 *@Description  TODO
 *@Author HuangQingbin
 *@Date 2021/8/7 16:13
 *@Version 1.0
 */
public class Emp{


    private String ename;
    private String gender;

    private Dept dept;

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }
    public void setEname(String ename) {
        this.ename = ename;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    public void testEmp(){
        System.out.println(ename + "::" + gender + "::" + dept);
    }
}

