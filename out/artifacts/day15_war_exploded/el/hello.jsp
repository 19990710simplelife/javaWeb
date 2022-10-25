<%--
  Created by IntelliJ IDEA.
  User: 17538
  Date: 2022/10/25
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% pageContext.setAttribute("msg", "pageContext");%>
request: <%=request.getAttribute("msg")%><br>
session: <%=session.getAttribute("msg")%><br>
application: <%=application.getAttribute("msg")%><br>
pageContext:<%=pageContext.getAttribute("msg")%><br>
${msg}
</body>
</html>
