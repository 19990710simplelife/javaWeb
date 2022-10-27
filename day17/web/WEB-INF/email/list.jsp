<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 17538
  Date: 2022/10/27
  Time: 10:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
欢迎：${requestScope.username}
列表：
<c:forEach items="${requestScope.list}" var="item">
    <a href="${pageContext.request.contextPath}/email/content">${item}</a>
</c:forEach>
</body>
</html>
