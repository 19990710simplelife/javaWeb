<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 17538
  Date: 2022/10/25
  Time: 9:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<label>
    <form action="${pageContext.request.contextPath}/user/search" method="post">
        <input type="text" name="key" placeholder="请输入要查询员工的id">
        <input type="submit" value="查询"/>
    </form>
</label>
<button><a href="${pageContext.request.contextPath}/employee/addUser.jsp">添加员工</a></button>
<table border="1">
    <thead>
    <th>ID</th>
    <th>姓名</th>
    <th>年龄</th>
    <th>工资</th>
    <th>操作</th>
    </thead>
    <tbody>
    <tr>
        <td>${requestScope.users.id}</td>
        <td>${requestScope.users.name}</td>
        <td>${requestScope.users.age}</td>
        <td>${requestScope.users.salary}</td>
        <td>
            <c:if test="${requestScope.users.id!=null}">
                <a href="${pageContext.request.contextPath}/employee/updateUser?id=${user.id}">修改</a>
                <a href="${pageContext.request.contextPath}/user/delete?id=${user.id}">删除</a>
            </c:if>
        </td>
    </tr>
    </tbody>
</table>
</body>
</html>
