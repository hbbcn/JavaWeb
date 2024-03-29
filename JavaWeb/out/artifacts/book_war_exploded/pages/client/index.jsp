<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.atguigu.pojo.Picture" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>书城首页</title>
    <%-- 静态包含base标签，css样式，jQuery文件--%>
    <%@ include file="/pages/common/head.jsp" %>

    <script type="text/javascript">
        $(function () {

            // 给购物车按钮绑定单击事件
            $(".addToCart").click(function () {
                var bookId = $(this).attr("bookId");
                location.href = "http://localhost:8080/book/cartServlet?action=addItem&id=" + bookId;

            })
        })


    </script>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">网上书城</span>
    <div>
        <%-- 如果用户还没有登录，显示 【登录和注册的菜单】--%>
        <c:if test="${empty sessionScope.user}">
            <a href="pages/user/login.jsp">登录</a> |
            <a href="pages/user/regist.jsp">注册</a> &nbsp;&nbsp;
        </c:if>
        <c:if test="${not empty sessionScope.user}">
            <span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临西亚斯网上书城</span>
            <a href="pages/order/order.jsp">我的订单</a>
            <a href="userServlet?action=logout">注销</a>
        </c:if>

            <a href="http://localhost:8080/book/cartServlet?action=addItemToDb">购物车</a>

            <c:if test="${sessionScope.user.username == 'admin'}">
                <a href="pages/manager/manager.jsp">后台管理</a>
            </c:if>

    </div>
</div>
<div id="main">

    <div id="book">
     <%--   <div>
            <form style="padding-left: 500px;" action="manager/bookServlet" method="get">
                <input type="hidden" name="action" value="queryBook">
                图书名:<input type="text" name="book" value="${param.book}">
                <input type="submit" value="搜索">
            </form>
        </div>--%>

        <div class="book_cond">
            <form action="client/bookServlet" method="get">
                <input type="hidden" name="action" value="pageByPrice">
                价格：<input id="min" type="text" name="min" value="${param.min}"> 元 -
                <input id="max" type="text" name="max" value="${param.max}"> 元
                <input type="submit" value="查询"/>
            </form>
        </div>
        <div style="text-align: center">
            <c:if test="${not empty sessionScope.cart.items}">
                <span>您的购物车中有${sessionScope.cart.totalCount}件商品</span>
                <div>
                    您刚刚将<span style="color: red">${sessionScope.lastName}</span>加入到了购物车中
                </div>
            </c:if>
            <c:if test="${empty sessionScope.cart.items}">
                <span style="color: red">您的购物车为空</span>
            </c:if>
        </div>
        <%-- <div class="img_div">
           <img class="book_img" alt="" src="${book.imgPath}"/>
       </div>--%>
        <%--Integer id =  ${book.id};--%>
        <%--  id值在put的时候不存在       String id = ${book.id};
                pageContext.setAttribute("id",id);
                <%
                    Picture p = new Picture();
                    HashMap<String, String> map = new HashMap<>();
                    map.put(id ,id+".jpg");
                    p.setMap(map);
                    session.setAttribute("p",p);
                %>--%>

        <c:forEach items="${requestScope.page.items}" var="book">
            <div class="b_list">
                <div class="img_div">
                    <img class="book_img" alt="" src="static/img/${book.id}.jpg"/>
                </div>
                <div class="book_info">
                    <div class="book_name">
                        <span class="sp1">书名:</span>
                        <span class="sp2">${book.name}</span>
                    </div>
                    <div class="book_author">
                        <span class="sp1">作者:</span>
                        <span class="sp2">${book.author}</span>
                    </div>
                    <div class="book_price">
                        <span class="sp1">价格:</span>
                        <span class="sp2">${book.price}</span>
                    </div>
                    <div class="book_sales">
                        <span class="sp1">销量:</span>
                        <span class="sp2">${book.sales}</span>
                    </div>
                    <div class="book_amount">
                        <span class="sp1">库存:</span>
                        <span class="sp2">${book.stock}</span>
                    </div>
                    <div class="book_add">
                        <c:if test="${not empty sessionScope.user}">
                            <button bookId="${book.id}" class="addToCart">加入购物车</button>
                        </c:if>
                        <c:if test="${empty sessionScope.user}">
                            <button><a href="pages/user/login.jsp">加入购物车</a> </button>
                        </c:if>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>

    <%--静态包含分页体条--%>
    <%@include file="/pages/common/page_nav.jsp" %>
</div>

<%-- 静态包含页脚内容--%>
<%@include file="/pages/common/footer.jsp" %>
</body>
</html>