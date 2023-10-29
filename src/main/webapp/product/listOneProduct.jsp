<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.cha103g5.product.model.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*" %>

<%
    String productNo = request.getParameter("productNo");
    if (productNo != null) {
        ProductService productSvc = new ProductService();
        ProductVO product = productSvc.getOneProduct(Integer.parseInt(productNo));
        List<ProductVO> list = new ArrayList<>();
        list.add(product); // 將查詢結果添加到list
        pageContext.setAttribute("list", list); // 設置list到listOneproduct.jsp
    }
%>


<html>
<head>
<title>產品資料</title>

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
	width: 600px;
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
				<h3>產品資料 - listOneproduct.jsp</h3>
				<h4>
					<a href="selectPage.jsp">回首頁</a>
				</h4>
			</td>
		</tr>
	</table>

	<table>
		<tr>
			<th>產品編號</th>
			<th>類別編號</th>
			<th>產品名稱</th>
			<th>產品價格</th>
			<th>產品資訊</th>
			<th>產品狀態</th>
			<th>產品評價</th>
			<th>產品總評價</th>
			<th>銷售數量</th>
		</tr>
		<c:forEach var="productVO" items="${list}">
		<tr>
			<td>${productVO.productNo}</td>
			<td>${productVO.productCatNo}</td>
			<td>${productVO.productName}</td>
			<td>${productVO.productPrice}</td>
			<td>${productVO.productInfo}</td>
			<td>${productVO.productStat}</td>
			<td>${productVO.productEval}</td>
			<td>${productVO.productEvalTotal}</td>
			<td>${productVO.productSaleNum}</td>
		</tr>
		</c:forEach>
	</table>

</body>
</html>
