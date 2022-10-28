<%--
  Created by IntelliJ IDEA.
  User: 17538
  Date: 2022/10/28
  Time: 10:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/register" method="post" enctype="multipart/form-data">
    <p>
        <label>
            账号： <input type="text" name="username">
        </label>
    </p>

    <p>
        <label>
            头像： <input type="file" name="headImg">
        </label>
    </p>

    <p>
        <label>
            <input type="submit" value="注册">
        </label>
    </p>
</form>
<img src="upload/25898241-019a-4090-8268-b8c09edaa560.jpg" width="200px">
</body>
</html>
