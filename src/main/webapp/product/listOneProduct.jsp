<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.cha103g5.product.model.*"%>

<%
//Product product = (Product) request.getAttribute("product"); //ProductServlet.java(Concroller), 存入req的product物件
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
				<h3>產品資料 - listOneProduct.jsp</h3>
				<h4>
					<a href="selectPage.jsp">回首頁</a>
				</h4>
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
		</tr>
		<tr>
			<td>${product.productNo}</td>
			<td>${product.productName}</td>
			<td>${product.productPrice}</td>
			<td>${product.productInfo}</td>
			<td>${product.productStat}</td>
			<td>${product.productEval}</td>
			<td>${product.productEvalTotal}</td>
			<td>${product.productSaleNum}</td>
		</tr>
	</table>

</body>
</html>
