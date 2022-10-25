<%@ page import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: 17538
  Date: 2022/10/25
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <thead>
    <th>序号</th>
    <th>姓名</th>
    <th>工资</th>
    <th>职称</th>
    <th>水平</th>
    <th>入职时间</th>
    <th>操作</th>
    </thead>
    <tbody>
    <c:forEach items="${requestScope.employeeList}" var="item" varStatus="vs">
        <tr>
            <td>${vs.count}</td>
            <td>${item.name}</td>
            <td>${item.salary}</td>
            <td>
                <c:if test="${item.salary>10000}">高薪程序员</c:if>
                <c:if test="${item.salary<=10000}">垃圾程序员</c:if>
            </td>
            <td>
                <c:choose>
                    <c:when test="${item.salary>=5000 && item.salary<=10000}">初级</c:when>
                    <c:when test="${item.salary>=10000 && item.salary<=20000}">中级</c:when>
                    <c:when test="${item.salary>=20000 && item.salary<=30000}">高级</c:when>
                    <c:otherwise>垃圾</c:otherwise>
                </c:choose>
            </td>
            <td>
                <%
                    Date date = new Date();
                    request.setAttribute("date",date);
                %>
               <fmt:formatDate value="${date}" pattern="yyyy-MM-dd HH:mm:ss"/>
            </td>
            <td>
                <a href="#">修改</a>
                <a href="#">删除</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
