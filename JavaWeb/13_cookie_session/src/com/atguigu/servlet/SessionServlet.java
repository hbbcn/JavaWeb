package com.atguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.channels.ReadPendingException;

/**
 *@ClassName SessionServlet
 *@Description  TODO
 *@Author HuangQingbin
 *@Date 2021/8/1 15:56
 *@Version 1.0
 */
public class SessionServlet extends BaseServlet{


    protected void createOrGetSession(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 创建和获取Session会话对象
        HttpSession session = req.getSession();
        // 判断当前Session会话，是否是新创建出来的
        boolean isNew = session.isNew();
        //获取Session会话的唯一标识id
        String id = session.getId();

        resp.getWriter().write("得到的Session，它的id是" + id + "<br>");
        resp.getWriter().write("这个Session是否是新创建的：" + isNew + "<br>");
    }

    /**
     * 向session域中保存数据
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void setAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("key1" ,"value1");
        req.getSession().setAttribute("key2" ,"value2");
        resp.getWriter().write("已经往Session中保存了数据");

    }

    /**
     * 获取session域中的数据
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void getAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object key1= req.getSession().getAttribute("key1");
        Object key2= req.getSession().getAttribute("key2");
        resp.getWriter().write("session域在的key1的值是：" + key1);
        resp.getWriter().write("session域在的key1的值是：" + key2);

    }

    protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取了Session的默认超时时长
        int maxInactiveInterval = req.getSession().getMaxInactiveInterval();
        resp.getWriter().write("Session的默认超时时长" + maxInactiveInterval +"秒");
    }

    protected void life3(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 先获取Session对象
        HttpSession session = req.getSession();

        // 设置当前session3秒后超时
        // 值为正数的时候，设定Session的超时时长。
        //  负数表示永不超时（极少使用）
        session.setMaxInactiveInterval(3);
        resp.getWriter().write("当前Session已经设置为3秒后超时");
    }

    protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 先获取Session对象
        HttpSession session = req.getSession();
        // 让Session会话马上超时
        session.invalidate();
        resp.getWriter().write("Session已经设置为超时（无效）");

    }

}

