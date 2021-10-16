package com.atguigu.mybatis;

import org.apache.ibatis.type.Alias;

/**
 *@ClassName Employee
 *@Description  TODO
 *@Author HuangQingbin
 *@Date 2021/8/15 12:36
 *@Version 1.0
 */
//注解方式起别名
@Alias("emp")
public class Employee{

    private Integer id;
    private String name;
    private String gender;
    private String email;
    private Department dept;

    public Employee() {
    }

    public Employee(Integer id, String name, String gender, String email) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.email = email;
    }

    public Employee(Integer id, String name, String gender, String email, Department dept) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.dept = dept;
    }

    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

