<%--
  Created by IntelliJ IDEA.
  User: 30988
  Date: 2021/7/24
  Time: 9:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%--
    四个域对象分别是
        ①pageContext     PageContext类       当前jsp页面有效
        ②request         HttpServletRequest类    一次请求内有效
        ③session         HttpSession类           一个会话范围内有效(打开浏览器访问服务器，直到关闭浏览器)
        ④application     ServletContext类        整个web工程范围内都有效(只要web工程步停止)


    域对象是可用像Map一样存储数据的对象。四个域对象功能一样，不同的是它们对数据的取值范围
    四个域在使用的时候，优先顺序分别是，它们从小到大的范围的顺序

    --%>
</head>
<body>

<h1>scope.jsp页面</h1>

<%
    // 往四个域对象分别保存了数据
    pageContext.setAttribute("key", "pageContext");
    request.setAttribute("key", "request");
    session.setAttribute("key", "session");
    application.setAttribute("key", "application");

%>

pageContext域是否有值： <%=pageContext.getAttribute("key")%><br/>
request域是否有值： <%=request.getAttribute("key")%><br/>
session域是否有值： <%=session.getAttribute("key")%><br/>
application域是否有值： <%=application.getAttribute("key")%>

<%
//    request.getRequestDispatcher("/scope2.jsp").forward(request,response);
%>

<%--
        <jsp:forward page=""></jsp:forward> 是请求转发标签,它的功能就是请求转发
--%>
    <jsp:forward page="/scope2.jsp"></jsp:forward>
</body>
</html>
