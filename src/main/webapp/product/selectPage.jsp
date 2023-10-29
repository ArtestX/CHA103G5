<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>產品選擇頁面</title>

<style>
body {
	background-color: #f0f0f0;
	font-family: Arial, sans-serif;
	background-image: url('images/product2.jpg');
	background-position: center -300px; /* 使用像素值調整位置 */
	background-size: cover; /* 背景圖片覆蓋整個視窗 */
	background-repeat: no-repeat; /* 防止圖片重複 */
}

h3 {
	color: #333;
}

ul {
	list-style-type: none;
	padding: 0;
}

li {
	margin: 10px 0;
}

a {
	display: inline-block;
	background-color: #3498db;
	color: #fff;
	padding: 10px 20px;
	text-decoration: none;
	border-radius: 5px;
}

a:hover {
	background-color: #258cd1;
}

b {
	color: #333;
}

select {
	padding: 5px;
}

table#table-1 {
	width: 450px;
	background-color: #CCCCFF;
	margin-top: 5px;
	margin-bottom: 10px;
	border: 3px ridge Gray;
	height: 80px;
	text-align: center;
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

img {
	max-width: 100%;
}
</style>
</head>
<body bgcolor="white">

 
	<h3>產品管理</h3>

	<ul>
		<li><a href='addProduct.jsp'>新增產品</a></li>
		<li><a href='updateProduct.jsp'>編輯產品</a></li>
		<li><a href='listAllProduct.jsp'>查詢/刪除產品</a></li>
		
	</ul>

	<h3>資料查詢:</h3>

	<ul>
		<li>
			<FORM METHOD="post" ACTION="product.do">
				<b>輸入產品編號:</b> 
				<input type="text" name="productNo" value="${param.productNo}"> <font color=red>${errorMsgs.productNo}</font>
				<input type="hidden" name="action" value="getOne_For_Display"> 
				<input type="submit" value="送出">
			</FORM>
		</li>
<jsp:useBean id="productSvc" scope="page" class="com.cha103g5.product.model.ProductService"/>
		<li>
			<FORM METHOD="post" ACTION="product.do">
				<b>選擇產品編號:</b> <select size="1" name="productNo">
					<c:forEach var="productVO" items="${productSvc.all}">
						<option value="${productVO.productNo}">${productVO.productNo}
					</c:forEach>
				</select> <input type="hidden" name="action" value="getOne_For_Display">
				<input type="submit" value="送出">
			</FORM>
		</li>


		<li>
			<FORM METHOD="post" ACTION="product.do">
				<b>選擇產品名稱:</b> 
				<select size="1" name="productNo">
					<c:forEach var="productVO" items="${productSvc.all}">
						<option value="${productVO.productNo}">${productVO.productName}
					</c:forEach>
				</select> <input type="hidden" name="action" value="getOne_For_Display">
				<input type="submit" value="送出">
			</FORM>
		</li>
	</ul>

</body>
</html>
