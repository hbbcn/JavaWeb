<%--
  Created by IntelliJ IDEA.
  User: 30988
  Date: 2021/7/26
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--
        变量              类型                      作用
    pageContext         PageContextImpl         它可以获取jsp中的九大内置对象

    request.getScheme()         它可以获取请求的协议
    request.getServerName()     获取请求的服务器ip或域名
    request.getMethod()         获取请求的方式
    request.getRemoteHost()     获取客户端的ip地址
    session.getId()             获取会话的唯一标识
--%>

<%=request.getServerPort()%><br>
<%
    pageContext.setAttribute("req",request);
%>
    1.协议： ${req.scheme}<br>
    2.服务器ip: ${pageContext.request.serverName}<br/>
    3.服务器端口：${pageContext.request.serverPort}<br/>
    4.获取工程路径: ${pageContext.request.contextPath}<br/>
    5.获取请求的方式：${pageContext.request.method}<br/>
    6.获取客户端ip地址 :${pageContext.request.remoteHost}<br/>
    7.获取会话的id编号：${pageContext.session.id}
</body>
</html>
