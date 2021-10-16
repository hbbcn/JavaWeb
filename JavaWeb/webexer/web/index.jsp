<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 30988
  Date: 2021/8/11
  Time: 12:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="http://localhost:8080/webexer/">
    <title>Title</title>

</head>
<body>
我是首页
<jsp:forward page="studentServlet?action=list1"></jsp:forward>


我是首页
</body>
</html>
