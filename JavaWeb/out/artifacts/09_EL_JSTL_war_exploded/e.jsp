<%--
  Created by IntelliJ IDEA.
  User: 30988
  Date: 2021/7/25
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    // 1.值为null值的时候，为空
    request.setAttribute("emptyNull",null);
    // 2.值为空串的时候，为空
    request.setAttribute("emptyStr","");
    // 3.值是Object类型数组，长度为零时
    request.setAttribute("emptyArr",new Object[]{});
    // 4.list集合,元素个数为零
    // 5.map集合中，元素个数为零


%>
    ${empty emptyNull}<br>
    ${empty emptyStr}<br>
    ${empty emptyArr}
<hr>
${12 == 12 ? "我真帅":"你又骗人了"}
</body>
</html>
