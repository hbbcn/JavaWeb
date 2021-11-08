<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: 30988
  Date: 2021/7/25
  Time: 20:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%--
    .点运算，可以输出Bean对象中某个属性的值
    []中括号运算，可以输出有序集合中某个元素的值
    并且中括号运算，还可以输出map集合中key里含有特殊字符key的值
    --%>
</head>
<body>
<%
    Map<String,Object> map = new HashMap<>();
    map.put("a.a.a","aaaValue");
    map.put("b+b+b","bbbValue");
    request.setAttribute("map",map);
%>
值为： ${map["a.a.a"]}<br>
${map['b+b+b']}
</body>
</html>
