<%@ page import="com.atguigu.pojo.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 30988
  Date: 2021/7/25
  Time: 11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">

        table{
            border: 1px solid black;
            border-collapse: collapse;
            width: 600px;
        }

        th,td{
            border: 1px solid black;
            border-collapse: collapse;
        }

    </style>
</head>
<body>
<%-- 练习二：jsp输出一个表格，里面有10个学生信息。--%>
<%
   ArrayList<Student> stuList = (ArrayList<Student>) request.getAttribute("stuList");

%>

<table>
    <tr>
        <th>学号</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>电话</th>
        <th>操作</th>
    </tr>

<%

    for(Student list1: stuList){
 %>

    <tr>
        <td> <%=list1.getId()%></td>
        <td> <%=list1.getName()%></td>
        <td> <%=list1.getAge()%></td>
        <td> <%=list1.getPhone()%></td>
        <td>删除、修改</td>
    </tr>
<%
    }
%>
</table>
</body>
</html>
