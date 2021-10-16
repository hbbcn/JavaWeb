package com.atguigu.web;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import com.atguigu.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *@ClassName ClientBookServlet
 *@Description  TODO
 *@Author HuangQingbin
 *@Date 2021/7/31 16:12
 *@Version 1.0
 */
public class ClientBookServlet extends BaseServlet{
    BookService bookService = new BookServiceImpl();


    /**
     * 处理分页功能
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1、获取请求的参数 pageNo 和 pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);

        //2、调用BookService.page(pageNo,pageSize):Page对象
        Page<Book> page = bookService.page(pageNo, pageSize);

        page.setUrl("client/bookServlet?action=page");
        //3、保存Page对象到Request域中
        req.setAttribute("page",page);
        //4、请求转发到pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);
    }

    protected void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 1、获取请求参数
        int min = WebUtils.parseInt(req.getParameter("min"), 0);
        int max = WebUtils.parseInt(req.getParameter("max"), Integer.MAX_VALUE);
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);

        //2、调用bookService.pag
        Page<Book> page = bookService.pageByPrice(min,max,pageNo,pageSize);

        StringBuilder sb = new StringBuilder("client/bookServlet?action=pageByPrice");

        if(req.getParameter("min") != null){
            sb.append("&min=").append(req.getParameter("min"));
        }

        if(req.getParameter("max") != null){
            sb.append("&max=").append(req.getParameter("max"));
        }

        page.setUrl(sb.toString());
        //3、保存page到Request域中
        req.setAttribute("page",page);
        //4、请求转发到pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);

    }
}

