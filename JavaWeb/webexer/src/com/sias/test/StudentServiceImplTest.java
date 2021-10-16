package com.sias.test;

import com.sias.javabean.Student;
import com.sias.service.Impl.StudentServiceImpl;
import com.sias.service.StudentService;
import org.junit.Test;

import javax.swing.text.Style;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.Assert.*;

public class StudentServiceImplTest {

    private StudentService studentService = new StudentServiceImpl();
    @Test
    public void addStudent() throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-DD");
        studentService.addStudent(new Student(null,"胡歌",null,new BigDecimal(183),"表演系一班"));

    }

    @Test
    public void deleteStudentById() {
        studentService.deleteStudentById(3);
    }

    @Test
    public void updateStudent() throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        studentService.updateStudent(new Student(5,"利智",null,new BigDecimal(180),"表演系一班"));
    }

    @Test
    public void queryStudentById() {
        Student student = studentService.queryStudentById(3);
        System.out.println(student);
    }

    @Test
    public void queryStudentAll() {
        List<Student> students = studentService.queryStudentAll();
        for (Student student : students){
            System.out.println(student);
        }
    }
}