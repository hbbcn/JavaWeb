package com.sias.dao;

import com.sias.javabean.Student;

import java.util.List;

public interface StudentDao {

    public void addStudent(Student stu);

    public void deleteStudent(Integer id);

    public void updateStudent(Student stu);

    public Student queryStudentById(Integer id);

    public List<Student> queryStudentAll();

}
