package com.atguigu.web;

import com.atguigu.pojo.Cart;
import com.atguigu.pojo.CartItem;
import com.atguigu.pojo.User;
import com.atguigu.service.OrderService;
import com.atguigu.service.impl.OrderServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.Map;

/**
 * @ClassName OrderServlet
 * @Description TODO
 * @Author HuangQingbin
 * @Date 2021/8/4 15:28
 * @Version 1.0
 */
public class OrderServlet extends BaseServlet {


    OrderService orderService = new OrderServiceImpl();

    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart)req.getSession().getAttribute("cart");
        System.out.println("cart:"+cart);
        BigDecimal totalPrice = cart.getTotalPrice();
        req.getSession().setAttribute("totalPrice",totalPrice);
        System.out.println(totalPrice);
        String name = " ";
        StringBuffer stringBuffer = new StringBuffer();

        Map<Integer, CartItem> items = cart.getItems();
        Iterator<Map.Entry<Integer, CartItem>> iterator = items.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, CartItem> next = iterator.next();
            String value = next.getValue().getName();
            StringBuffer append = stringBuffer.append(value).append(", ");
        }
        req.getSession().setAttribute("name",stringBuffer.toString());
        System.out.println(items);
       /* req.getSession().setAttribute("items",items);*/
        User loginUser = (User)req.getSession().getAttribute("user");
        if (loginUser == null){
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
            return;
        }

        Integer id = loginUser.getId();

        System.out.println(id);
        String orderId = orderService.createOrder(cart, id);
        System.out.println(orderId);

        //请求转发到/pages/cart/checkout/.jsp
//        req.setAttribute("orderId",orderId);
        req.getSession().setAttribute("orderId",orderId);


        System.out.println(orderId);
        //修改前
//        req.getRequestDispatcher("/pages/cart/checkout.jsp").forward(req,resp);
        //修改后
        req.getRequestDispatcher("/pay/index.jsp").forward(req,resp);

//        resp.sendRedirect(req.getContextPath() + "/pages/cart/checkout.jsp");

    }
}

