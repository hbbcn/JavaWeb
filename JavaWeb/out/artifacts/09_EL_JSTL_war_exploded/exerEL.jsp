<%--
  Created by IntelliJ IDEA.
  User: 30988
  Date: 2021/7/31
  Time: 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">

    </script>
</head>
<%--

EL 个达式中 11 个隐含对象，是 EL 表达式中自己定义的，可以直接使用。

变量                   类型                      作用
pageContext         PageContextImpl             它可以获取 jsp 中的九大内置对象
pageScope           Map<String,Object>          它可以获取 pageContext 域中的数据
requestScope        Map<String,Object>          它可以获取 Request 域中的数据
sessionScope        Map<String,Object>          它可以获取 Session 域中的数据
applicationScope    Map<String,Object>          它可以获取 ServletContext 域中的数据
param               Map<String,String>          它可以获取请求参数的值
paramValues         Map<String,String[]>        它也可以获取请求参数的值，获取多个值的时候使用。
header              Map<String,String>          它可以获取请求头的信息
headerValues        Map<String,String[]>        它可以获取请求头的信息，它可以获取多个值的情况
cookie              Map<String,Cookie>          它可以获取当前请求的 Cookie 信息
initParam           Map<String,String>          它可以获取在 web.xml 中配置的<context-param>上下文参数
--%>
<body>
alert(${3 > 5 && 5 < 6});

</body>
</html>
