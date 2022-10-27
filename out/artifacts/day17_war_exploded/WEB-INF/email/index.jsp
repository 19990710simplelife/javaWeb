<%--
  Created by IntelliJ IDEA.
  User: 17538
  Date: 2022/10/27
  Time: 10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
首页
欢迎${requestScope.username}
<a href="${pageContext.request.contextPath}/email/list">收件箱</a>
</body>
</html>
