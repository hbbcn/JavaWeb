<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: 30988
  Date: 2021/8/10
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <base href="http://localhost:8080/webexer/">
    <link type="text/css" rel="stylesheet" href="pages/style/style.css">

    <script type="text/javascript" src="pages/script/jquery-1.7.2.js"></script>



    <script type="text/javascript">

        $(function () {
            $(".deleteStu").click(function () {
                //confirm是确认提示框函数，它有两个按钮 一个是确认按钮一个是取消按钮
             return confirm("你确认要删除【" + $(this).parent().find("td:first").text() +"】" )

            });
        });



    </script>
</head>
<body>

<div style="text-align: center" >

    <span><a href="index.jsp">返回到首页</a></span>
    <span><a href="studentServlet?action=list">查询全部学生信息</a></span>
    <span><a href="pages/student/student_edit.jsp">添加学生信息</a></span>
    <table>
        <tr>
            <td>姓名</td>
            <td>生日</td>
            <td>身高</td>
            <td>班级</td>
            <td colspan="2" width="90px">操作</td>
        </tr>


        <c:forEach items="${requestScope.students}" var="stu">
            <tr>
                <td>${stu.name}</td>
                <td>${stu.birth}</td>
                <td>${stu.height}</td>
                <td>${stu.grade}</td>
                <td><a href="studentServlet?action=getStudent&id=${stu.id}">修改</a></td>
                <td class="deleteStu"><a href="studentServlet?action=delete&id=${stu.id}">删除</a></td>
            </tr>
        </c:forEach>
    </table>




</div>


</body>
</html>
