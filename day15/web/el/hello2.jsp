<%--
  Created by IntelliJ IDEA.
  User: 17538
  Date: 2022/10/25
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    pageContext.setAttribute("msg", "pageContext.setAttribute");
    request.setAttribute("msg", "request.setAttribute");
    session.setAttribute("msg", "session.setAttribute");
    application.setAttribute("msg", "application.setAttribute");
%>
${pageScope.msg}
<hr>
${requestScope.msg}
<hr>
${sessionScope.msg}
<hr>
${applicationScope.msg}
</body>
</html>
