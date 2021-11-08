<%--
  Created by IntelliJ IDEA.
  User: 30988
  Date: 2021/7/26
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <%--
        pageScope           pageContext域
        requestScope        Request域
        sessionScope        Session域
        applicationScope    ServletContext域

    --%>
</head>

<body>
    <%
        pageContext.setAttribute("key1","pageContext1");
        pageContext.setAttribute("key2","pageContext2");
        request.setAttribute("key2","request");
        session.setAttribute("key2","session");
        application.setAttribute("key2","application");

    %>
    ${key1==pageContext1}<br>
    ${requestScope.key2}
</body>
</html>
