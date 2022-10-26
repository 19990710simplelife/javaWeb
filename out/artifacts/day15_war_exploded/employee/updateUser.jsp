<%--
  Created by IntelliJ IDEA.
  User: 17538
  Date: 2022/10/26
  Time: 11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>修改员工</h1>
<hr>
<form action="${pageContext.request.contextPath}/user/update" method="post">
    <label>
        <input type="hidden" name="id" value="${requestScope.user.id}">
    </label>
    <label>
        <p>姓名：<input type="text" name="name" value="${requestScope.user.name}" placeholder="请输入姓名"></p>
    </label>
    <label>
        <p>年龄：<input type="text" name="age" value="${requestScope.user.age}" placeholder="请输入年龄"></p>
    </label>
    <label>
        <p>工资：<input type="text" name="salary" value="${requestScope.user.salary}" placeholder="请输入工资"></p>
    </label>

    <label>
        <p>
            <input type="submit" value="修改" style="width: 100px">
            <button>
                <a href="${pageContext.request.contextPath}/user/selectAll">返回</a>
            </button>
        </p>
    </label>
</form>
</body>
</html>
