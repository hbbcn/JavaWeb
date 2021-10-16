package com.sias.service.Impl;

import com.sias.dao.Impl.StudentDaoImpl;
import com.sias.dao.StudentDao;
import com.sias.javabean.Student;
import com.sias.service.StudentService;

import java.util.List;

/**
 *@ClassName StudentServiceImpl
 *@Description  TODO
 *@Author HuangQingbin
 *@Date 2021/8/9 16:01
 *@Version 1.0
 */
public class StudentServiceImpl implements StudentService {

   private StudentDao studentDao =  new StudentDaoImpl();
    @Override
    public void addStudent(Student stu) {
        studentDao.addStudent(stu);
    }

    @Override
    public void deleteStudentById(Integer id) {

        studentDao.deleteStudent(id);
    }

    @Override
    public void updateStudent(Student stu) {

        studentDao.updateStudent(stu);
    }

    @Override
    public Student queryStudentById(Integer id) {

       return studentDao.queryStudentById(id);
    }

    @Override
    public List<Student> queryStudentAll() {

      return  studentDao.queryStudentAll();
    }
}

