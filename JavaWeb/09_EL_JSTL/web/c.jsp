<%@ page import="com.atguigu.pojo.Person" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: 30988
  Date: 2021/7/25
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Person person = new Person();
    person.setName("中国");
    person.setPhones(new String[]{"18888666","138848384","1666669999"});

    List<String> cities = new ArrayList<>();
    cities.add("北京");
    cities.add("上海");
    cities.add("深圳");

    person.setCities(cities);

    Map<String,Object> map = new HashMap<>();
    map.put("key1","value1");
    map.put("key2","value2");
    map.put("key3","value3");

    person.setMap(map);

    pageContext.setAttribute("p",person);
%>

//  以下调用的都是get方法
    输出Person：${p}<br/>
    输出Person的name属性：${p.name}<br>
    输出Person的phones数组属性值：${p.phones[1]}<br/>
    输出Person的cities集合中的元素值：${p.cities}<br/>
    输出Person的List集合中的个别元素值：${p.cities[1]}<br/>
    输出Person的Map集合：${p.map}<br>
    输出Person的Map集合中的某个key的值： ${p.map.key1}<br/>
    输出Person的age属性的值：${p.age}
</body>
</html>
