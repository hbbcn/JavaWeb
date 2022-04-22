<%--
  Created by IntelliJ IDEA.
  User: 30988
  Date: 2021/8/9
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<script type="text/javascript" src="../script/jquery-1.7.2.js"></script>--%>
<html>
<head>
    <title>Title</title>
    <base href="http://localhost:8080/webexer/">
    <script type="text/javascript">

    </script>
</head>
<body>
    <form action="studentServlet" method='get'>
        <input type="hidden" name="action" value="${empty param.id ? "addBook" : "update"}">
        <input type="hidden" name="id" value="${param.id}">

        <table border="1px" cellspacing="0" width="500">
            <tr>
                <td>姓名</td>
                <td>出生时间</td>
                <td>身高</td>
                <td>班级</td>
                <td colspan="2">操作</td>
            </tr>
            <td><input type="text" name="name" value="${requestScope.student.name}"></td>
            <td><input type="text" name="birth" value="${requestScope.student.birth}"></td>
            <td><input type="text" name="height" value="${requestScope.student.height}"></td>
            <td><input type="text" name="grade" value="${requestScope.student.grade}"></td>
            <td><input type="submit" value="提交"></td>
            </tr>
            <tr><a href="pages/student/student_manager.jsp">返回</a></tr>
        </table>
    </form>


</body>
</html>
