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
    <script>function goToPage(pageNum) {
        const elementById = document.getElementById("currentPageId");
        elementById.value = pageNum;
        changePageSize()
    }

    function changePageSize() {
        const element = document.getElementById("formId");
        element.submit();
        // window.forms[0].submit();
    }

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
欢迎：${sessionScope.USERS_IN_SESSION.username}
<a href="${pageContext.request.contextPath}/loginOut">安全退出</a>
<p style="height: 20px">
    <button>
        <a href="${pageContext.request.contextPath}/product?cmd=input">添加商品</a>
    </button>
</p>

<form action="${pageContext.request.contextPath}/product" id="formId" method="post">

    <label>
        商品名： <input type="text" name="productName" value="${requestScope.queryObject.productName}">
    </label>
    <label>
        关键字： <input type="text" name="keyWord" value="${requestScope.queryObject.keyWord}">
    </label>
    <label>
        价格：<input type="text" name="minSalePrice" value="${requestScope.queryObject.minSalePrice}">
    </label>
    <label>
        —— <input type="text" name="maxSalePrice" value="${requestScope.queryObject.maxSalePrice}">
    </label>
    <input type="submit" value="查询"><br><br>
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
        <c:forEach var="product" items="${requestScope.result.data}">
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
        <tfoot>
        <tr>
            <td colspan="9" align="center">
                <a href="#" onclick="goToPage(1)">首页</a>
                <a href="#" onclick="goToPage(${requestScope.result.prevPage})">上一页</a>
                <a href="#" onclick="goToPage(${requestScope.result.nextPage})">下一页</a>
                <a href="#" onclick="goToPage(${requestScope.result.totalPage})">尾页</a>
                <span>
            当前第${requestScope.result.currentPage}页 共${requestScope.result.totalPage}页
            </span>
                跳转到
                <label>
                    <input id="currentPageId" type="text" name="currentPage" step="1" width="10px"
                           value="${requestScope.result.currentPage}"
                           onchange="changePageSize()"/>
                </label>
                页
                <input type="submit" value="跳转">
                每页
                <label>
                    <select name="pageSize" onchange="changePageSize()">
                        <option ${requestScope.result.pageSize==1?"selected":""} value="1">1</option>
                        <option ${requestScope.result.pageSize==3?"selected":""} value="3">3</option>
                        <option ${requestScope.result.pageSize==5?"selected":""} value="5">5</option>
                        <option ${requestScope.result.pageSize==10?"selected":""} value="10">10</option>
                        <option ${requestScope.result.pageSize==15?"selected":""} value="15">15</option>
                        <option ${requestScope.result.pageSize==20?"selected":""} value="20">20</option>
                    </select>
                </label>
                条数据
            </td>
        </tr>
        </tfoot>
    </table>
</form>
</body>
</html>
