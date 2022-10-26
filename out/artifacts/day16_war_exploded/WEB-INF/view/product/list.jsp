<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 17538
  Date: 2022/10/26
  Time: 22:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script>

        function deleteProduct(deleteId) {
            let flag = window.confirm("亲，确定要删除吗？");
            if (flag) {
                location.href = "${pageContext.request.contextPath}/product?cmd=delete&id=" + deleteId;
            }
        }

        window.onload = function () {
            const className = document.getElementsByClassName("trClz");
            for (let i = 0; i < className.length; i++) {
                className[i].onmouseover = function () {
                    this.style.background = "grey";
                };
                className[i].onmouseout = function () {
                    this.style.background = "";
                }
            }
        }
    </script>
</head>
<body>
<p style="height: 20px">
    <button>
        <a href="${pageContext.request.contextPath}/product?cmd=input">添加商品</a>
    </button>
</p>
<table border="1" cellpadding="0" cellspacing="0" width="80%">
    <thead style="background: pink">
    <th>编号</th>
    <th>商品名称</th>
    <th>分类编号</th>
    <th>零售价</th>
    <th>供应商</th>
    <th>品牌</th>
    <th>折扣</th>
    <th>进货价</th>
    <th>操作</th>
    </thead>
    <tbody>
    <c:forEach var="product" items="${requestScope.products}">
        <tr class="trClz">
            <td>${product.id}</td>
            <td>${product.productName}</td>
            <td>${product.dirId}</td>
            <td>${product.salePrice}</td>
            <td>${product.supplier}</td>
            <td>${product.brand}</td>
            <td>${product.cutoff}</td>
            <td>${product.costPrice}</td>
            <td>
                <a href="${pageContext.request.contextPath}/product?cmd=edit&id=${product.id}">修改</a>
                <a onclick="deleteProduct(${product.id})">删除</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
