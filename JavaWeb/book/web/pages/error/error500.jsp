<%--
  Created by IntelliJ IDEA.
  User: 30988
  Date: 2021/8/5
  Time: 18:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        a{
            text-decoration:none;
            font-size: 20px;
        }
        a:link {color:red;}      /* 未访问链接*/
        a:visited {color:gray;}  /* 已访问链接 */
        a:hover {color:blue;}  /* 鼠标移动到链接上 */
        a:active {color:black;}  /* 鼠标点击时 */

    </style>
    <title>错误页面</title>
    <%@include file="/pages/common/head.jsp" %>
</head>
<body>
    <span style="color: #1D222D">
        很抱歉，你访问的后台程序出现了错误，请不要着急，
        程序猿小哥正在为你抢修，点击下面按钮即可返回首页
    </span><br/>
    <button><a href="index.jsp">返回首页</a></button>
</body>
</html>
