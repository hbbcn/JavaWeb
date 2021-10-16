package com.sias.test;

import com.alibaba.druid.sql.visitor.functions.Now;
import com.sias.dao.Impl.BaseDao;
import com.sias.dao.Impl.StudentDaoImpl;
import com.sias.dao.StudentDao;
import com.sias.javabean.Student;
import org.junit.Test;

import javax.swing.plaf.synth.SynthRadioButtonUI;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.Assert.*;

public class BaseDaoImplTest {

  private StudentDao baseDao = new StudentDaoImpl();
    @Test
    public void addStudent() throws ParseException {
      SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
      baseDao.addStudent(new Student(null,"刘德华",new Date(sdf1.parse("1975-10-1").getTime()),new BigDecimal(175),"音乐1班"));

    }

    @Test
    public void deleteStudent() {

      baseDao.deleteStudent(13);

    }

    @Test
    public void updateStudent() throws ParseException {

      SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
      baseDao.updateStudent(new Student(5,"张丰三",new Date(sdf1.parse("1975-10-1").getTime()),new BigDecimal(180),"表演系一班"));
    }

    @Test
  public void queryTest(){
      System.out.println(baseDao.queryStudentById(12));
    }

    @Test
  public void queryStudentAllTest(){
      List<Student> students = baseDao.queryStudentAll();
      for (Student student : students){
        System.out.println(student);
      }
    }
}