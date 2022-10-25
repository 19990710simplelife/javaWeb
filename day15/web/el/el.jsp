<%--
  Created by IntelliJ IDEA.
  User: 17538
  Date: 2022/10/25
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
总数据：${employee}<br>
<hr>
name:${employee.name}
<hr>
salary:${employee.salary}
<hr>
list:${employee.list}---->${employee.list[1]}
<hr>
hobby:${employee.hobby[0]}
<hr>
map:${employee.map}---->${employee.map.name}
</body>
</html>
