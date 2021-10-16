<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: 30988
  Date: 2021/7/23
  Time: 18:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%--
jsp的全称是java server pages。java的服务器页面。
jsp的主要作用是代替Servlet程序回传html页面的数据
因为Servlet程序回传html页面数据是一件非常繁琐的事情。开发成本和维护成本都极高
--%>
<body>

<%--练习：

--%>
<%--1、声明类属性--%>
<%!
        private Integer id;
        private String name;
        private static Map<String, Object> map;

%>

<%-- 2、声明static静态代码块--%>
<%!
     {
        map = new HashMap<String, Object>();
        map.put("key1", "'value1");
        map.put("key2", "'value2");
        map.put("key3", "'value3");
    }
%>

<%-- 3、声明类的方法 --%>
<%!
    public int abc() {
        return 12;
    }
%>
<%-- 4、声明内部类 --%>
<%!
    public static class A {
        private Integer id = 12;
        private String abc = "abc";
    }

%>
<%--
表达式脚本的作用是：
在jsp页面上输出数据 表达式脚本的特点：
1、所有的表达式脚本都会被翻译到_jspService方法中
2、表达式脚本都会被翻译成为out.print()输出到页面上
3、由于表达式脚本翻译的内容都在_jspService()方法中的对象都可以直接使用。
4、表达式脚本不能以分号结束
--%>

<%--
练习
1、输出整型
2、输出浮点型
3、输出字符型
4、输出对象
--%>

<%=12 %><br/>
<%=12.12%><br/>
<%="我是字符串"%><br/>
<%=map%><br/>
<%=request.getParameter("username")%>

<%--练习--%>
<%-- 1、代码脚本----if --%>

<%--
代码脚本的特点：
    1、代码脚本翻译之后都在_jspService方法中
    2、代码脚本由翻译到_jspService方法中，所以在_jspService方法中现有对象都可以直接使用。
    3、还可以由多个代码脚本块组合完成的java语句

--%>
<%
    int i = 12;
    if (i == 12) {
        System.out.println("我爱中国共产党");
    } else {
        System.out.println("我爱祖国");
    }
%>

<%-- 2.代码脚本---for循环语句--%>

<table border="1" cellspacing="0">
    <%
        for (int j = 0; j < 10; j++) {
    %>
    <tr>
        <td>第<%=j%>行</td>
    </tr>
    <%
        }
    %>
</table>

<% request.setAttribute("username","hbb");

    System.out.println(request.getAttribute("username"));
%>

<%
    System.out.println("********************");
    String username = request.getParameter("username");
    System.out.println(username);
%>
</body>
</html>
