<%--
  Created by IntelliJ IDEA.
  User: 30988
  Date: 2021/7/26
  Time: 11:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%--
    param           Map<String,String>          它可以获取请求参数的值
    paramValues     Map<String,String[]>        它可以获取请求参数的值，获取多个值的时候使用
    header          Map<String,String>          它可以获取请求头的信息
    headerValues    Map<String,String[]>        它可以获取请求头的信息，它可以获取多个值的情况
    cookie的名称    Map<String,Cookie>          它可以获取当前请求的Cookie信息
    initParam       Map<String,String>          它可以获取在web.xml中配置的<context-param>上下文参数

--%>
<body>
    输出请求参数username的值: ${param.username}<br/>
    输出请求参数password的值：${param.password}<br/>
    输出请求参数username的值：${paramValues.username[0]}<br/>

<hr>
    输出请求头User-Agent的值： ${header['User-Agent']} <br/><%--含有特殊符号，使用中括号--%>
    输出请求头:Connection的值： ${header.Connection}<br/>
    输出请求头User-Agent的值：${headerValues['User-Agent'][0]}
<hr>
    获取Cookie的名称：${cookie.JSESSIONID.name}<br/>
    获取Cookie的值： ${cookie.JSESSIONID.value}<br/>

<hr/>
    ${initParam}<br/>
    输出&lt;Context-param&gt;username的值：${initParam.username}

</body>
</html>

