package com.sias.dao.Impl;

import com.sias.dao.StudentDao;
import com.sias.javabean.Student;
import org.apache.commons.dbutils.QueryRunner;

import javax.swing.text.Style;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 *@ClassName BaseDaoImpl
 *@Description  TODO
 *@Author HuangQingbin
 *@Date 2021/8/9 10:05
 *@Version 1.0
 */
public class StudentDaoImpl extends BaseDao implements StudentDao {

    //添加学生的操作
    public void addStudent(Student stu){

        String sql = "insert into t_student values(?,?,?,?,?)";
        update(sql,stu.getId(),stu.getName(),stu.getBirth(),stu.getHeight(),stu.getGrade());
    }

    //删除学生的操作
    public void deleteStudent(Integer id){
        String sql = "delete from t_student where id = ?";
        update(sql,id);
    }

    //更改学生信息的操作

    public void updateStudent(Student stu){
        String sql = "update t_student set id = ?,name = ?,birth = ?, height = ?,grade = ? where id = ?";
        update(sql,stu.getId(),stu.getName(),stu.getBirth(),stu.getHeight(),stu.getGrade(),stu.getId());
    }

    //查询一条学生记录并返回
    public Student queryStudentById(Integer id){
        String sql = "select * from t_student where id = ?";
        return  queryBookById(Student.class,sql,id);
    }

    //查询全部表中所有内容并返回

    public List<Student> queryStudentAll(){
        String sql  = "select * from t_student";

        return   queryStudentAll(Student.class,sql);

    }

}


