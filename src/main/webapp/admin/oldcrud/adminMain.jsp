<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.cha103g5.admin.model.*"%>

<%
AdminService adminSvc = new AdminService();
List<AdminVO> list = adminSvc.getAll();
pageContext.setAttribute("list", list);
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>員工管理系統</title>
<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
<style>
.error-message {
	color: red; /* 設置文字顏色為紅色，你可以根據需要進行調整 */
	margin-top: 5px; /* 設置上邊距，控制它與<input>元素之間的距離 */
	margin-left: 12px;
}

#navigateButton {
	width: 100px; /* 设置按钮的宽度 */
	height: 40px; /* 设置按钮的高度 */
}
</style>

</head>
<body>
	<nav class="navbar navbar-expand-lg bg-body-tertiary">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">後台管理系統</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="#">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" role="button"
						data-bs-toggle="dropdown" aria-expanded="false"> Dropdown </a>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="#">Action</a></li>
							<li><a class="dropdown-item" href="#">Another action</a></li>
							<li>
								<hr class="dropdown-divider">
							</li>
							<li><a class="dropdown-item" href="#">Something else
									here</a></li>
						</ul></li>
					<!-- 					<li class="nav-item"><a class="nav-link disabled" -->
					<!-- 						aria-disabled="true">Disabled</a></li> -->
				</ul>
				<form class="d-flex" role="search">
					<input class="form-control me-2" type="search" placeholder="Search"
						aria-label="Search">
					<button class="btn btn-outline-success" type="submit">Search</button>
				</form>
			</div>
		</div>
	</nav>

	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-2 g-3">
				<!--左邊-->
				<div class="list-group">
					<a href="adminSystem.jsp" class="list-group-item list-group-item-action active" aria-current="true">員工管理</a>
					<a href="#" class="list-group-item list-group-item-action">商品管理</a> 
					<a href="#" class="list-group-item list-group-item-action">訂單管理</a>
					<a href="#" class="list-group-item list-group-item-action">客服管理</a>
					<a href="#" class="list-group-item list-group-item-action">寵物領養管理</a>
					<a href="#" class="list-group-item list-group-item-action">公告資訊管理</a>
					<a href="#" class="list-group-item list-group-item-action" aria-disabled="true">會員資料管理</a>
				</div>
			</div>
				



	<script src="../js/popper.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
</body>
</html>
