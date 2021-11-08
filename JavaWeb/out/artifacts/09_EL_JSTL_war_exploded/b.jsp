<%@ page import="java.awt.print.PageFormat" %><%--
  Created by IntelliJ IDEA.
  User: 30988
  Date: 2021/7/25
  Time: 19:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--
      EL表达式主要在jsp页面中输出数据
      主要输出域对象中的数据
      当四个域中都有相同的key的数据的时候，EL表达式会按照从小到大的顺序进行搜索，找到就输出


--%>
        <%
            //往四个域中都保存了相同的key数据
            request.setAttribute("key","request");
            session.setAttribute("key","session");
            application.setAttribute("key","application");
//          pageContext.setAttribute("key","pageContext");
        %>
        ${key}

</body>
</html>
