<%--
  Created by IntelliJ IDEA.
  User: 30988
  Date: 2021/8/2
  Time: 11:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="registServlet?s=b" method="get">
        用户名：<input type="text" name="username"> <br/>
        密码：<input type="text" name="password" ><br/>
        验证码：<input style="width: 60px" type="text" name="code">
        <img src="http://localhost:8080/temp/kaptcha.jpg" style="width: 100px;height: 25px"><br/>
        <input type="submit" value="登录">
    </form>
</body>
</html>
