<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="BIG5"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Product</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<style>
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
</style>
</head>
<body>

	<ul>
		<li><a
			href="${pageContext.request.contextPath}/product/selectPage.jsp">select.jsp</a></li>
		<li><a href='addProduct.jsp'>新增/刪除產品</a></li>
		<li><a href='updateProduct.jsp'>編輯產品</a></li>
		<li><a href='listAllProduct.jsp'>查詢多筆</a></li>
		<li><a href='listOneProduct.jsp'>查詢單筆</a></li>
	</ul>
	<select class="form-select" aria-label="Disabled select example"
		disabled>
		<option selected>Open this select menu</option>
		<option value="1">One</option>
		<option value="2">Two</option>
		<option value="3">Three</option>
	</select>

	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
		integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
		integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>
</body>
</html>