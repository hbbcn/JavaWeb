package com.atguigu.autowire;
/**
 *@ClassName Emp
 *@Description  TODO
 *@Author HuangQingbin
 *@Date 2021/8/12 17:59
 *@Version 1.0
 */
public class Emp{

    private Dept dept1;

    public void setDept1(Dept dept1) {
        this.dept1 = dept1;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "dept1=" + dept1 +
                '}';
    }

}

