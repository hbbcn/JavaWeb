package com.atguigu.web;

import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.pojo.Book;
import com.atguigu.pojo.Cart;
import com.atguigu.pojo.CartItem;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import com.atguigu.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *@ClassName CartServlet
 *@Description  TODO
 *@Author HuangQingbin
 *@Date 2021/8/2 20:27
 *@Version 1.0
 */
public class CartServlet extends BaseServlet{
    BookService bookService = new BookServiceImpl();
    /**
     * 加入购物车
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("加入购物车");
        System.out.println("商品编号"+ req.getParameter("id"));

        // 获取请求参数 商品编号
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        // 调用bookService.queryBookId(id) 得到图书信息
        Book book = bookService.queryBookById(id);
        // 把图书信息转换为CartItem商品项
        CartItem cartItem = new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());
        // 调用cart.addItem(cartItem)添加商品项

        Cart cart = (Cart)req.getSession().getAttribute("cart");
        if (cart == null){
           cart = new Cart();
           req.getSession().setAttribute("cart",cart);
       }
        cart.addItem(cartItem);
        System.out.println(cart);

        System.out.println("请求头Referer的值：" + req.getHeader("Referer"));

        //最后一个添加的商品名称
        req.getSession().setAttribute("lastName",cartItem.getName());
        resp.sendRedirect(req.getHeader("Referer"));
    }

    /**
     * 删除商品项
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取商品编号
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        Cart cart = (Cart)req.getSession().getAttribute("cart");
        if(cart != null){
            //删除购物车商品项
            cart.deleteItem(id);
            //重定向原来购物车展示的页面
            resp.sendRedirect(req.getHeader("Referer"));
        }

    }

    /**
     * 清空购物车
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        Cart cart = (Cart)req.getSession().getAttribute("cart");
        if(cart != null){
            cart.clear();
            //重定向原来购物车展示的页面
            resp.sendRedirect(req.getHeader("Referer"));
        }

    }

    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数，商品编号、商品数量
        int id = WebUtils.parseInt(req.getParameter("id"),0);
        int count = WebUtils.parseInt(req.getParameter("count"), 1);

        Cart cart = (Cart)req.getSession().getAttribute("cart");

        if (cart != null){
            //修改商品数量
            cart.updateCount(id,count);
            resp.sendRedirect(req.getHeader("Referer"));
        }

    }
}

