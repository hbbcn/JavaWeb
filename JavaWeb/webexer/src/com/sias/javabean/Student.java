package com.sias.javabean;

import java.math.BigDecimal;
import java.sql.Date;


/**
 *@ClassName Student
 *@Description  TODO
 *@Author HuangQingbin
 *@Date 2021/8/9 10:21
 *@Version 1.0
 */
public class Student{

    private Integer id;
    private String name;
    private Date birth;
    private BigDecimal height;
    private String grade;

    public Student() {
    }

    public Student(Integer id, String name, Date birth, BigDecimal height, String grade) {
        this.id = id;
        this.name = name;
        this.birth = birth;
        this.height = height;
        this.grade = grade;
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

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public BigDecimal getHeight() {
        return height;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grader) {
        this.grade = grader;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birth=" + birth +
                ", height=" + height +
                ", grade='" + grade + '\'' +
                '}';
    }
}

