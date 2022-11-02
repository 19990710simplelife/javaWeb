<%--
  Created by IntelliJ IDEA.
  User: 17538
  Date: 2022/10/28
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>用户登录</h1>
<hr>
<span style="color: red">${requestScope.error}</span>
<form action="${pageContext.request.contextPath}/login" method="post">
    <p>
        <label>
            用户名 <input type="text" name="username">
        </label>
    </p>
    <p>
        <label>
            用户名 <input type="password" name="password">
        </label>
    </p>
    <label>
        <input type="submit" value="登录">
    </label>
</form>

</body>
</html>
