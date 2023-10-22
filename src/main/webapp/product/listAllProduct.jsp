<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*" %>
<%@ page import="com.cha103g5.product.model.*" %>

<%


	/* 	ProductService productSvc = new ProductService();	*/
/*     List<ProductVO> productList = productSvc.getAll();
     pageContext.setAttribute("productList", productList);*/
%>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>查看所有產品</title>
</head>
<style>

	body {
            background-color: #f0f0f0;
            font-family: Arial, sans-serif;
            background-image: url('images/product2.jpg');
            background-position: center -200px; /* 使用像素值調整位置 */
	        background-size: cover; /* 背景圖片覆蓋整個視窗 */
	        background-repeat: no-repeat; /* 防止圖片重複 */
        }
        
    table#table-1 {
        background-color: #CCCCFF;
        border: 2px solid black;
        text-align: center;
        background-image: url('images/product1.jpg');
        background-size: cover; /* 可調整背景圖片大小以填滿表格 */
    }

    table#table-1 h4 {
        color: red;
        display: block;
        margin-bottom: 1px;
    }

    h4 {
        color: blue;
        display: inline;
    }
</style>

<style>
    table {
        width: 800px;
        background-color: white;
        margin-top: 5px;
        margin-bottom: 5px;
    }

    table, th, td {
        border: 1px solid #CCCCFF;
    }

    th, td {
        padding: 5px;
        text-align: center;
    }
</style>

</head>
<body bgcolor='white'>

<table id="table-1">
    <tr>
        <td>
            <h3>所有產品資訊 - listAllProduct.jsp</h3>
            <h4><a href="selectPage.jsp">回首頁</a></h4>
        </td>
    </tr>
</table>

<table>
    <tr>
        <th>產品編號</th>
        <th>產品名稱</th>
        <th>產品價格</th>
        <th>產品資訊</th>
        <th>產品狀態</th>
        <th>產品評價</th>
        <th>產品總評價</th>
        <th>銷售數量</th>
        <th>修改</th>
        <th>刪除</th>
    </tr>
    <c:forEach var="product" items="${productList}">

        <tr>
            <td>${product.productNo}</td>
            <td>${product.productName}</td>
            <td>${product.productPrice}</td>
            <td>${product.productInfo}</td>
            <td>${product.productStat}</td>
            <td>${product.productEval}</td>
            <td>${product.productEvalTotal}</td>
            <td>${product.productSaleNum}</td>
            <td>
                <form method="post" action="<%=request.getContextPath()%>/product/product.do" style="margin-bottom: 0px;">
                    <input type="submit" value="修改">
                    <input type="hidden" name="productNo" value="${product.productNo}">
                    <input type="hidden" name="action" value="getOne_For_Update">
                </form>
            </td>
            <td>
                <form method="post" action="<%=request.getContextPath()%>/product/product.do" style="margin-bottom: 0px;">
                    <input type="submit" value="刪除">
                    <input type="hidden" name="productNo" value="${product.productNo}">
                    <input type="hidden" name="action" value="delete">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
