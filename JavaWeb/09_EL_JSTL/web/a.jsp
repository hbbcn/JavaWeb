<%--
  Created by IntelliJ IDEA.
  User: 30988
  Date: 2021/7/25
  Time: 19:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%--
    EL表达式的格式是:${表达式}
    EL表达式在输出null值的时候，输出的是空串.jsp表达式输出的是null字符串
    --%>
</head>
<body>
    <%
        request.setAttribute("key","值");
    %>
    表达式脚本输出的值是：<%=request.getAttribute("key")%><br/>
    EL表达式输出key的值是：${key}


</body>
</html>
