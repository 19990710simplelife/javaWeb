<%--
  Created by IntelliJ IDEA.
  User: 17538
  Date: 2022/10/26
  Time: 23:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>添加商品</h1>
<hr>
<form action="${pageContext.request.contextPath}/product?cmd=save" method="post">
    <label>
        <p>
            商品名称：<input type="text" name="productName">
        </p>
    </label>
    <label>
        <p>
            分类：
            <select name="dirId">
                <option value="1">鼠标</option>
                <option value="2">有线鼠标</option>
                <option value="3">无线鼠标</option>
                <option value="4">游戏鼠标</option>
            </select>
        </p>
    </label>
    <label>
        <p>
            零售价： <input type="number" name="salePrice" step="0.1">
        </p>
    </label>
    <label>
        <p>
            供应商： <input type="text" name="supplier">
        </p>
    </label>
    <label>
        <p>
            品牌名： <input type="text" name="brand">
        </p>
    </label>
    <label>
        <p>
            折扣： <input type="number" name="cutoff" step="0.1">
        </p>
    </label>
    <label>
        <p>
            进货价： <input type="number" name="costPrice" step="0.01">
        </p>
    </label>
    <label>
        <p>
            <input type="submit" value="添加">
        </p>
    </label>
</form>
</body>
</html>
