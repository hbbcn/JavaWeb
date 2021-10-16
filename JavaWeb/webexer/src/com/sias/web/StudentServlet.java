package com.sias.web;

import com.sias.dao.Impl.BaseDao;
import com.sias.javabean.Student;
import com.sias.service.Impl.StudentServiceImpl;
import com.sias.service.StudentService;
import com.sias.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.print.Book;
import java.io.IOException;
import java.util.List;

/**
 *@ClassName StudentServlet
 *@Description  TODO
 *@Author HuangQingbin
 *@Date 2021/8/9 17:06
 *@Version 1.0
 */
public class StudentServlet extends BaseServlet {

    private StudentService studentService = new StudentServiceImpl();

    /**
     * 添加学生信息
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void addBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Student student = WebUtils.copyParamToBean(req.getParameterMap(), new Student());
        System.out.println(student);
        studentService.addStudent(student);

        resp.sendRedirect(req.getContextPath() + "/pages/student/student_edit.jsp");

    }


    /**
     * 查询所有信息并显示到页面上
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //通过studentService查询所有图书
        List<Student> students = studentService.queryStudentAll();
        //把全部图书保存到request域中
        req.setAttribute("students",students);
        //请求转发到/pages/student/student_manager.jsp 因为是一起请求所以共享一个request域
        req.getRequestDispatcher("/pages/student/student_manager.jsp").forward(req,resp);

    }

    /**
     * 更改学生信息
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void getStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取学生信息id参数
        String id1 = req.getParameter("id");
        int  id = Integer.parseInt(id1);


        //查询需要修改的学生信息
        Student student = studentService.queryStudentById(id);
        //保存学生信息到request域中
        req.setAttribute("student",student);
        //请求转发到
        req.getRequestDispatcher("/pages/student/student_edit.jsp").forward(req,resp);

    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Student student = WebUtils.copyParamToBean(req.getParameterMap(), new Student());

        //通过studentService 调用 updateStudent
        studentService.updateStudent(student);

        req.getRequestDispatcher("/pages/student/student_manager.jsp").forward(req,resp);

    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        studentService.deleteStudentById(id);
        req.getRequestDispatcher("pages/student/student_manager.jsp").forward(req,resp);


    }


    protected void list1(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //通过studentService查询所有图书
        List<Student> students = studentService.queryStudentAll();
        //把全部图书保存到request域中
        req.setAttribute("students",students);
        //请求转发到/pages/student/student_manager.jsp 因为是一起请求所以共享一个request域
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);

    }

}

