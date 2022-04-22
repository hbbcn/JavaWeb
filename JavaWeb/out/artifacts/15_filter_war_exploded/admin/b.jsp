<%--
  Created by IntelliJ IDEA.
  User: 30988
  Date: 2021/8/4
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


    <%
//        System.out.println("b.jsp页面执行了");
        Object user = session.getAttribute("user");
        //如果等于null,说明还没有登录
        if (user == null){
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return;
        }
    %>

    我是b.jsp文件
</body>
</html>
