<%--
  Created by IntelliJ IDEA.
  User: 30988
  Date: 2021/7/23
  Time: 18:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         errorPage="/error500.jsp"
         language="java" %>
<%-- errorPage表示错误后自动跳转去的路径
    这个路径一般都是以斜杠打头，它表示请求地址为http://ip:port/工程路径/
    映射到代码的web目录
--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    b.jsp页面
    <%
        int i = 12 / 0;
    %>

</body>
</html>
