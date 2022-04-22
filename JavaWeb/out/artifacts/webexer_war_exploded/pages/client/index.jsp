<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 30988
  Date: 2021/8/11
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="http://localhost:8080/webexer/">
    <link type="text/css" rel="stylesheet" href="pages/style/style.css">

    <script type="text/javascript" src="pages/script/jquery-1.7.2.js"></script>



</head>
<body>

<div>
    <span><a href="pages/student/student_manager.jsp">学生管理系统</a></span>
    <table>
        <c:forEach items="${requestScope.students}" var="stu">
            <tr>
                <td>${stu.name}</td>
                <td>${stu.birth}</td>
                <td>${stu.height}</td>
                <td>${stu.grade}</td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
