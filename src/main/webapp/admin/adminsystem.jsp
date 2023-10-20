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
					<li class="nav-item"><a class="nav-link disabled"
						aria-disabled="true">Disabled</a></li>
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
					<a href="#" class="list-group-item list-group-item-action active"
						aria-current="true"> The current link item </a> <a href="#"
						class="list-group-item list-group-item-action">A second link
						item</a> <a href="#" class="list-group-item list-group-item-action">A
						third link item</a> <a href="#"
						class="list-group-item list-group-item-action">A fourth link
						item</a> <a class="list-group-item list-group-item-action disabled"
						aria-disabled="true">A disabled link item</a>
				</div>
			</div>
			<div class="col-lg-10 g-3">
				<!--右邊-->
				<div class="card">
					<div class="card-header">
						員工列表
						<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
							fill="currentColor" class="bi bi-box-fill" viewBox="0 0 16 16"
							style="float: right;">
                            <path fill-rule="evenodd"
								d="M15.528 2.973a.75.75 0 0 1 .472.696v8.662a.75.75 0 0 1-.472.696l-7.25 2.9a.75.75 0 0 1-.557 0l-7.25-2.9A.75.75 0 0 1 0 12.331V3.669a.75.75 0 0 1 .471-.696L7.443.184l.004-.001.274-.11a.75.75 0 0 1 .558 0l.274.11.004.001 6.971 2.789Zm-1.374.527L8 5.962 1.846 3.5 1 3.839v.4l6.5 2.6v7.922l.5.2.5-.2V6.84l6.5-2.6v-.4l-.846-.339Z" />
                        </svg>
					</div>
					<div class="card-body">
						<div class="row">
							<form method="post" action="admin.do" class="col-md-3">
								<div>
									<div class="input-group">
										<input type="text" class="form-control" placeholder="請輸入員工編號"
											aria-label="Recipient's username"
											aria-describedby="button-addon2">
										<button class="btn btn-outline-secondary" type="button"
											id="button-addon2">搜尋</button>
									</div>
								</div>
							</form>
							<form method="post" action="admin.do" id="adminId"
								class="dropdown col-md-2">
								<div class="dropdown">
									<a class="btn btn-secondary dropdown-toggle" href="#"
										role="button" data-bs-toggle="dropdown" aria-expanded="false">
										選擇員工編號 </a>
									<ul class="dropdown-menu" id="employeeDropdown">
										<c:forEach var="adminVO" items="${adminSvc.all}">
											<li><a class="dropdown-item" href="#"
												data-admin-no="${adminVO.adminNo}">${adminVO.adminNo}</a></li>
										</c:forEach>
									</ul>
								</div>
								<input type="hidden" name="adminNo" value="">
								<input type="hidden" name="action" value="getOne_For_Display">
							</form>

							<form method="post" action="admin.do"
								class="dropdown col-md-4 custom-dropdown">
								<div>
									<a class="btn btn-secondary dropdown-toggle text-start"
										href="#" role="button" data-bs-toggle="dropdown"
										aria-expanded="false"> 選擇員工姓名 </a>
									<ul class="dropdown-menu">
										<li><a class="dropdown-item" href="#">Action</a></li>
										<li><a class="dropdown-item" href="#">Another action</a></li>
										<li><a class="dropdown-item" href="#">Something else
												here</a></li>
									</ul>
								</div>
							</form>
							<div class="col-md-3 d-flex justify-content-end">
								<button class="btn btn-primary" id="navigateButton">新增</button>
							</div>
						</div>
						<!--./row-->
						<div style="margin-top: 20px;">
							<table class="table table-hover table-striped">
								<thead>
									<tr>
										<th>編號</th>
										<th>帳號</th>
										<th>密碼</th>
										<th>姓名</th>
										<th>信箱</th>
										<th>電話</th>
										<th>到職日</th>
										<th>狀態</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="adminVO" items="${list}">
										<tr>
											<th>${adminVO.adminNo}</th>
											<th>${adminVO.adminAccount}</th>
											<th>${adminVO.adminPassword}</th>
											<th>${adminVO.adminName}</th>
											<th>${adminVO.adminEmail}</th>
											<th>${adminVO.adminPhone}</th>
											<th>${adminVO.createDate}</th>
											<th>${adminVO.adminStat}</th>
											<th class="text-center">
											<td>
												<FORM METHOD="post"
													ACTION="<%=request.getContextPath()%>/admin/admin.do">
													<button class="btn btn-success" type="submit">修改</button>
													<input type="hidden" name="adminNo"
														value="${adminVO.adminNo}"> <input type="hidden"
														name="action" value="getOne_For_Update">
												</FORM>
											</td>
											<td>
												<FORM METHOD="post"
													ACTION="<%=request.getContextPath()%>/admin/admin.do">
													<button class="btn btn-danger" type="submit">刪除</button>
													<input type="hidden" name="adminNo"
														value="${adminVO.adminNo}"> <input type="hidden"
														name="action" value="delete">
												</FORM>
											</td>
											</th>
											<!-- 											<th> -->
											<!-- 												<FORM METHOD="post" -->
											<%-- 													ACTION="<%=request.getContextPath()%>/admin/admin.do" --%>
											<!-- 													style="margin-bottom: 0px;"> -->
											<!-- 													<input type="submit" value="修改"> <input -->
											<%-- 														type="hidden" name="adminNo" value="${adminVO.adminNo}"> --%>
											<!-- 													<input type="hidden" name="action" -->
											<!-- 														value="getOne_For_Update"> -->
											<!-- 												</FORM> -->
											<!-- 											</th> -->
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<nav aria-label="Page navigation example" class="text-center">
								<ul class="pagination">
									<li class="page-item"><a class="page-link" href="#"
										aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
									</a></li>
									<li class="page-item"><a class="page-link" href="#">1</a></li>
									<li class="page-item"><a class="page-link" href="#">2</a></li>
									<li class="page-item"><a class="page-link" href="#">3</a></li>
									<li class="page-item"><a class="page-link" href="#"
										aria-label="Next"> <span aria-hidden="true">&raquo;</span>
									</a></li>
								</ul>
							</nav>
						</div>
					</div>
				</div>
			</div>
			<!--右邊-->
		</div>
	</div>
	<script>
		// 获取按钮元素
		let navigateButton = document.getElementById('navigateButton');

		// 添加点击事件处理程序
		navigateButton.addEventListener('click', function() {
			// 执行页面导航，跳转到 addAdmin.jsp
			window.location.href = 'addadminNew.jsp';
		});
		

		document.addEventListener("DOMContentLoaded", function() {
		    let employeeForm = document.getElementById("adminId");
		    let employeeDropdown = document.getElementById("employeeDropdown");

		    employeeDropdown.addEventListener("click", function(event) {
		        let selectedAdminNo = event.target.getAttribute("data-admin-no");
		        if (selectedAdminNo) {
		            let adminNoInput = document.querySelector('input[name="adminNo"]');
		            adminNoInput.value = selectedAdminNo;
		            employeeForm.submit();
		        }
		    });
		});

	</script>

	<script src="../js/popper.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
</body>
</html>
