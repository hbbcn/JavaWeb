<%@ page import="java.util.concurrent.ForkJoinPool" %><%--
  Created by IntelliJ IDEA.
  User: 30988
  Date: 2021/7/24
  Time: 18:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        table{
            width: 600px;
        }
    </style>
</head>
<body>
    <%-- 练习一:在jsp页面中输出九九乘法口诀--%>
    <table >
        <%
            for (int i = 1; i <=9 ; i++) {
        %>
        <tr>
          <%
              for(int j = 1;j <= i ; j++){
          %>
            <td><%=j + "x" + i + "=" + (i*j)%></td>
    <%}
    %>
        </tr>
    <%}
    %>
    </table>
</body>
</html>
