<%--
  Created by IntelliJ IDEA.
  User: 17538
  Date: 2022/10/24
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--需求：根据年龄数值来做不同的显示--%>
<%
    Integer age = 100;
    if (age < 18) {
%>
少儿不宜
<%} else if (age == 18) {%>
欢迎成年
<%} else {%>
欢迎光临
<%}%>
</body>
</html>
