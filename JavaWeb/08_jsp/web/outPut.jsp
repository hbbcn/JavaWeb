<%--
  Created by IntelliJ IDEA.
  User: 30988
  Date: 2021/7/24
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--
    jsp的九大内置对象
    ① request       请求对象
    ② reponse       响应对象
    ③ pageContext   jsp的上下文对象
    ④ session       会话对象
    ⑤ application   ServletContext对象
    ⑥ config        ServletConfig对象
    ⑦ out           jsp输出流对象
    ⑧ page          指向当前jsp的对象
    ⑨ exception     异常对象--%>
<%--
    当jsp页面中所有代码执行完成后会做以下两个操作
    1.执行out.flush()操作,会把out缓冲区中的数据
            追加写入到response缓冲区末尾

    2.会执行repsponse的刷新操作.把全部数据写给客户端
--%>
    <%

        out.write("1out输出1<br/>");
        out.flush();
        out.write("2out输出2<br/>");
//
        response.getWriter().write("response输出1 <br/>");
        response.getWriter().write("response输出2 <br/>");
        out.write("12");
        out.print("12");
        out.print(12);//将int类型转换为String型后输出

    %>

</body>
</html>
