<%@ page import="javax.xml.crypto.Data" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: 17538
  Date: 2022/10/24
  Time: 11:21
  To change this template use File | Settings | File Templates.
--%>
<%@page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
北京时间：<%= new Date()%><br>
<%--
与html中的注释区别：
    html中的注释会在网页源代码中显示出来，但是在jsp中不会显示出来，也不会翻译到jsp的servlet中
--%>
<%--北京时间：<%= new Date()%>--%>

<%--jsp脚本片段--%>
<%--
<% 一行或多行代码 %>
--%>
<%
    String name = "张三";
%>

<%--
脚本表达式
<%=%>
--%>
<%=name%><br>

<%!
    private String email = "545645@qq.com";

    public void doWork() {
        email = "sdasda@qq.com";
    }
%>
<%--先打印email再调用doWork--%>
<%=email%><br>
<%
    doWork();
%>
<%=email%>
</body>
</html>
