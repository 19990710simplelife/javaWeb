<%--
  Created by IntelliJ IDEA.
  User: 17538
  Date: 2022/10/27
  Time: 10:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<span style="color: red">${requestScope.error}</span>
<form action="${pageContext.request.contextPath}/cookies/login" method="post">
    <p>
        <label>
            账号：<input type="text" name="username">
        </label>
    </p>

    <p>
        <label>
            密码：<input type="text" name="password">
        </label>
    </p>

    <p>
        <label>
            <input type="submit" value="登录">
        </label>
    </p>
</form>
</body>
</html>
