package com.atguigu.servlet;

import com.atguigu.pojo.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 *@ClassName SearchStudentServlet
 *@Description  TODO
 *@Author HuangQingbin
 *@Date 2021/7/25 14:58
 *@Version 1.0
 */
public class SearchStudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数
        //发sql语句查询学生信息
        //使用for循环生成查询的数据做模拟
        ArrayList<Student> studentList= new ArrayList<>();
        for (int i = 1; i <= 10 ; i++) {
            Student student = new Student(i, "学生" + i, 15+i, "phone"+ i);
            studentList.add(student);
        }
        //保存查询结果（学生信息）到request域中
        req.setAttribute("stuList",studentList);
        //请求转发到showStudent.jsp页面
        req.getRequestDispatcher("test/showStudent.jsp").forward(req,resp);
    }
}

