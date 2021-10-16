<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 30988
  Date: 2021/7/26
  Time: 13:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--
    JSTL标签库的使用步骤
        1.先导入jstl标签库的jar包。
            taglibs-standard-impl-1.2.1.jar
            taglibs-standard-spec-1.2.1.jar
        2.使用taglib指令引入标签库。
            <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <c:set/>
        作用：set标签可以往域中保存数据
        域对象.setAttributr(key,value);
        scope 属性设置保存到哪个域
            page表示PageContext域
            request表示Request域
            session表示Session域
            application表示ServletContext域
        var属性设置key是多少
        value属性值设置值

--%>
  保存之前：  ${requestScope.abc}<br/>
    <c:set scope="request" var ="abc" value="abcValue"/>
  保存之后：${requestScope.abc}

<%--
    <c:if >
        if标签用来做if判断
        test属性表示判断的条件(使用EL表达式输出)

--%>
    <c:if test="${12 == 12}">
        <h1>12等于12</h1>
    </c:if>

<%--
    <c:chooose> <c:when> <c:otherwise>标签
    作用：多路判断

    choose标签开始选择判断
    when标签表示每一种
    otherwise标签表示剩下的情况

    注意：
        1、标签不能使用html标签，需使用jsp标签
        2、when标签的父标签一定要是choose标签

--%>

<%
    request.setAttribute("height",178);
%>
<c:choose>
    <c:when test="${requestScope.height > 180}">
        <h2>小巨人</h2>
    </c:when>
    <c:when test="${requestScope.height > 170}">
        <h2>还可以</h2>
    </c:when>
    <c:otherwise>
        <h2>其他情况</h2>
    </c:otherwise>
</c:choose>
</body>
</html>
