<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.List" %>
<%@ page import="com.atguigu.pojo.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 30988
  Date: 2021/7/26
  Time: 14:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--
            1.遍历1到10
            begin属性设置开始的索引
            end属性设置结束的索引
            var属性循环的变量
    --%>
    <%--<table border="1">--%>


    <%--<c:forEach begin="1" end="10" var="i">--%>
        <%--<tr>--%>
            <%--<td>第${i}行</td>--%>
        <%--</tr>--%>
    <%--</c:forEach>--%>
    <%--</table>--%>


<hr>
    <%--
        遍历数组
    --%>

    <%
        request.setAttribute("arr",new String[]{"1232432","12343244","1234245"});

    %>
    <c:forEach items="${requestScope.arr}" var="item">
        ${item}

    </c:forEach>
<hr/>
    <%
        Map<String,Object> map = new HashMap<>();
        map.put("key1","value1");
        map.put("key2","value2");
        map.put("key3","value3");

//        for(Map.Entry<String,Object> entry : map.entrySet()){
//
//        }

        request.setAttribute("map",map);
    %>

    <c:forEach items="${requestScope.map}" var = "entry">
       <h1> ${entry.key}</h1>
    </c:forEach>

    <%-- 遍历List集合---list中存放Student类，有属性：编号，用户名，密码，年龄，电话--%>
    <%
        List<Student> studentList = new ArrayList<>();
        for (int i = 1; i < 10 ; i++) {
            Student student = new Student(i, "学生" + i, "1234" + i,10+i, "1234");
            studentList.add(student);
        }
        request.setAttribute("studentList",studentList);
    %>
    <table border="1" cellspacing="0" width="500px">
        <tr>
            <td>编号</td>
            <td>用户名</td>
            <td>密码</td>
            <td>年龄</td>
            <td>手机号</td>
            <td>操作</td>

        </tr>
        <%--
                items       表示遍历的集合
                var         表示遍历到的数据变量
                begin       表示遍历开始的索引值
                end         表示结束的索引值
                step        表示遍历的步长值
                varStatus
        --%>

      <%--
          public interface LoopTagStatus{
              Object getCurrent(); ——表示获取当前遍历的数据
              int getIndex(); ——表示获取遍历的索引
              int getCount(); ——表示遍历的个数
              boolean isFirst(); ——表示当前遍历是数据是否是第一条
              boolean isLast(); ——表示当前遍历是数据是否是第一条
              Integer getBegin(); ——获取begin属性值
              Integer getEnd(); ——获取end属性值
              Integer getStep(); ——获取step属性值

          }
        --%>





        <c:forEach begin="2" end="7" varStatus="status" step="2" items="${requestScope.studentList}" var="stu">
        <tr>
            <td>${stu.id}</td>
            <td>${stu.username}</td>
            <td>${stu.password}</td>
            <td>${stu.age}</td>
            <td>${stu.phone}</td>
            <td>${status.current}</td>
        </tr>
        </c:forEach>
    </table>





</body>
</html>
