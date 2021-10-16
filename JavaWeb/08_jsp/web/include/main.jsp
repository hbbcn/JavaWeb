<%--
  Created by IntelliJ IDEA.
  User: 30988
  Date: 2021/7/24
  Time: 18:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    头部信息<br>
    主题内容<br>

    <%--
        <%@ include file=""%> 就是静态包含
                file 属性指定你要包含的jsp页面的路径
                地址中的第一个斜杠"/"表示为http://ip:port工程路径/

          静态包含的特点:
                1.静态包含不会被翻译成jsp页面
                2.静态包含其实是把被包含的jsp页面的代码拷贝到包含的位置执行输出
                 <%@include file="/include/footer.jsp"%>
    --%>
            <%--
            <jsp:include page=""></jsp:include>这是动态包含
            page 属性指定你要包含的jsp页面的路径
            动态包含也可以像静态包含一样,把被包含的内容执行输出到包含的位置

           动态包含的特点:
                 1.动态包含会把包含的jsp页面页翻译成为java代码
                 2.动态包含底层代码使用如下代码去调用被包含的jsp页面执行输出
                 3.动态包含,还可以传递参数


         --%>

        <jsp:include page="footer.jsp">
            <jsp:param name="username" value="bbj"/>
            <jsp:param name="password" value="root"/>


        </jsp:include>


</body>
</html>
