package com.atguigu.web;

import com.atguigu.dao.BookDao;
import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.pojo.User;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import com.atguigu.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 *@ClassName BookServlet
 *@Description  TODO
 *@Author HuangQingbin
 *@Date 2021/7/28 18:24
 *@Version 1.0
 */
public class BookServlet extends BaseServlet{
    private BookDao bookDao = new BookDaoImpl();
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
        page.setUrl("manager/bookServlet?action=page");
        //3、保存Page对象到Request域中
        req.setAttribute("page",page);
        //4、请求转发到pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);
    }

    //1.添加图书
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 0);
        pageNo+=1;
        //1、获取请求的参数--》封装成为Book对象
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
        //2、调用BookService.addBook保存图书
        bookService.addBook(book);
        //3、跳到图书列表页面
        // req.getRequestDispatcher("/manager/bookServlet?action=list").forward(req,resp);
         resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + pageNo);
    }

    //2. 删除图书
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、获取请求参数id,图书编号
        //2、调用bookService.deleteBookById();删除图书
        int id  = WebUtils.parseInt(req.getParameter("id"),0);
        bookService.deleteBookById(id);
        //3、重定向回图书列表管理页面
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + req.getParameter("pageNo"));
    }


    //3. 修改图书
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
        bookService.updateBook(book);
        //请求重定向服务器解析"/"只解析到端口号
        //3、重定向回到图书列表管理页面
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + req.getParameter("pageNo"));
    }
    /*
        遇到问题：book.edit.jsp页面，即要做添加操作，又要做修改操作，而到底是添加还是修改操作是由隐藏域来决定的
        如何动态的修改隐藏域的值。
            方案一： 可以发送请求时，附带上当前要操作的值，并注入到隐藏域中
            	<td><a href="manager/bookServlet?action=getBook&id=${book.id}&method=update">修改</a></td>
		<td><a class="deleteClass" href="manager/bookServlet?action=delete&id=${book.id}&method=add">删除</a></td>
		<input type="hidden" name="action" value="${param.method}"/>
            方案二： 可以通过判断当前请求中是否包含有id参数，如果有说明是修改操作，如果没有说明的添加操作
                    value="${empty param.id ? "add" : "update"}
            方案三： 可以通过判断，Request域中是否有修改的图书信息对象，如果有说明是添加操作，如果没有说明是修改操作
                    value="${empty requestScope.book ? "add" : "update"}

     */

    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1、获取图书编号
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
          //2、调用bookService.queryBookById(id):Book:得到修改的图书信息
        Book book = bookService.queryBookById(id);
        //3、把图书保存到Request域中
        req.setAttribute("book",book);
        //4、请求转发到/pag
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req,resp);

    }


    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1、通过BookService查询全部图书
        List<Book> books = bookService.queryBooks();
        // 2、把全部图书保存到request域中
        req.setAttribute("books",books);
        // 3、请求转发到/pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);
    }

  /*  protected void queryBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bookName = req.getParameter("book");
        Book book = bookDao.queryBookByName(bookName);
        System.out.println(book);
        req.setAttribute("book",book);
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);
    }*/
}

