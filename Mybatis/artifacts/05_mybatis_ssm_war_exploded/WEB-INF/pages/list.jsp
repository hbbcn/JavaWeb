<%--
  Created by IntelliJ IDEA.
  User: 30988
  Date: 2021/8/20
  Time: 17:57
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>员工列表</title>
</head>
<body>
<table>
    <c:forEach items="${allEmps}" var="emp">
        <tr>
            <td>${emp.id}</td>
            <td>${emp.name}</td>
            <td>${emp.gender}</td>
            <td>${emp.email}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
