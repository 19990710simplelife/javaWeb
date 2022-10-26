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
<h1>修改商品</h1>
<hr>
<form action="${pageContext.request.contextPath}/product?cmd=update" method="post">
    <input type="hidden" name="id" value="${requestScope.productDate.id}">
    <label>
        <p>
            商品名称：<input type="text" name="productName" value="${requestScope.productDate.productName}">
        </p>
    </label>
    <label>
        <p>
            分类：
            <select name="dirId">
                <option value="1" ${requestScope.productDate.dirId==1?"selected":""}>鼠标</option>
                <option value="2" ${requestScope.productDate.dirId==2?"selected":""}>有线鼠标</option>
                <option value="3" ${requestScope.productDate.dirId==3?"selected":""}>无线鼠标</option>
                <option value="4" ${requestScope.productDate.dirId==4?"selected":""}>游戏鼠标</option>
            </select>
        </p>
    </label>
    <label>
        <p>
            零售价： <input type="number" name="salePrice" step="0.1" value="${requestScope.productDate.salePrice}">
        </p>
    </label>
    <label>
        <p>
            供应商： <input type="text" name="supplier" value="${requestScope.productDate.supplier}">
        </p>
    </label>
    <label>
        <p>
            品牌名： <input type="text" name="brand" value="${requestScope.productDate.brand}">
        </p>
    </label>
    <label>
        <p>
            折扣： <input type="number" name="cutoff" step="0.1" value="${requestScope.productDate.cutoff}">
        </p>
    </label>
    <label>
        <p>
            进货价： <input type="number" name="costPrice" step="0.01" value="${requestScope.productDate.costPrice}">
        </p>
    </label>
    <label>
        <p>
            <input type="submit" value="修改">
        </p>
    </label>
</form>
</body>
</html>
