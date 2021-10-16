package com.sias.service;

import com.sias.javabean.Student;

import java.util.List;

public interface StudentService {

    //添加学生信息
    public void addStudent(Student stu);
    //删除学生信息
    public void deleteStudentById(Integer id);
    //更改学生信息
    public void updateStudent(Student stu);
    //通过ID学生信息
    public Student queryStudentById(Integer id);
    //查询所有的学生信息
    public List<Student> queryStudentAll();

}
