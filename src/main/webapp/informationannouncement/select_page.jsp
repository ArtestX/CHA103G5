<%@page import="com.cha103g5.petinfo.service.PetInfoService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.cha103g5.pet.service.PetService" %>
<%@ page import="com.cha103g5.pet.model.PetServletVO" %>

<%
	Object adminAccount = session.getAttribute("adminAccount");                  // 從 session內取出 (key) adminVO的值
	if (adminAccount == null) {                                             // 如為 null, 代表此user未登入過 , 才做以下工作
		session.setAttribute("location", request.getRequestURI());       		//*工作1 : 同時記下目前位置 , 以便於login.html登入成功後 , 能夠直接導至此網頁
		response.sendRedirect(request.getContextPath()+"/admin/adminLogin.jsp");   //*工作2 : 請該user去登入網頁(login.html) , 進行登入
		return;
	}
%>

<%
	PetService petSvc = new PetService();
	List<PetServletVO> list = petSvc.getAll();
	pageContext.setAttribute("list", list);
%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>公告管理系統</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap.min.css">
	<style>
		body {
			background-image: url('../img/desktop.jpg');
			background-size: cover;
			background-attachment: fixed; /* 固定背景圖片 */
			background-repeat: no-repeat;
		}

		th {
			text-align: center;
		}

		.error-message {
			color: red; /* 設置文字顏色為紅色，你可以根據需要進行調整 */
			margin-top: 5px; /* 設置上邊距，控制它與<input>元素之間的距離 */
			margin-left: 12px;
		}
	</style>

</head>
<body>
<nav class="navbar custom-bg-color">
	<div class="container-fluid">
		<a class="navbar-brand" href="http://localhost:8080/CHA103G5/admin/backendMain.jsp">
			<img src="<%=request.getContextPath()%>/img/backpack2-fill.svg" alt="Logo" width="30" height="24" class="d-inline-block align-text-top">
			後臺管理系統
		</a>
		<div class="ms-auto">
			<form method="POST" action="./admin.do">
				<button class="btn btn-danger">登出</button>
				<input type="hidden" name="action" value="backendlogout">
			</form>
		</div>
	</div>
</nav>
<div class="container-fluid">
	<div class="row">
		<div class="col-lg-2 g-3">
			<!--左邊-->
			<div class="accordion" id="accordionExample">
				<div class="accordion-item">
					<h2 class="accordion-header">
						<button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
							員工管理
						</button>
					</h2>
					<div id="collapseOne" class="accordion-collapse collapse" data-bs-parent="#accordionExample">
						<div class="accordion-body">
							<strong><a href="adminSystem.jsp" class="list-group-item list-group-item-action">員工列表</a></strong>
						</div>
						<%--				      <div class="accordion-body">--%>
						<%--				      	<strong><a href="#" class="list-group-item list-group-item-action">權限管理</a></strong>--%>
						<%--				      </div>--%>
					</div>
				</div>
				<div class="accordion-item">
					<h2 class="accordion-header">
						<button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
							商品管理
						</button>
					</h2>
					<div id="collapseTwo" class="accordion-collapse collapse" data-bs-parent="#accordionExample">
						<div class="accordion-body">
							<strong><a href="#" class="list-group-item list-group-item-action">填寫功能名稱</a></strong>
						</div>
					</div>
				</div>
				<div class="accordion-item">
					<h2 class="accordion-header">
						<button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
							訂單管理
						</button>
					</h2>
					<div id="collapseThree" class="accordion-collapse collapse" data-bs-parent="#accordionExample">
						<div class="accordion-body">
							<strong><a href="#" class="list-group-item list-group-item-action">填寫功能名稱</a></strong>
						</div>
					</div>
				</div>
				<div class="accordion-item">
					<h2 class="accordion-header">
						<button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapse4" aria-expanded="false" aria-controls="collapse4">
							客服管理
						</button>
					</h2>
					<div id="collapse4" class="accordion-collapse collapse" data-bs-parent="#accordionExample">
						<div class="accordion-body">
							<strong><a href="<%=request.getContextPath()%>/customer/old/backendCustomer.jsp" class="list-group-item list-group-item-action">填寫功能名稱</a></strong>
						</div>
					</div>
				</div>
				<div class="accordion-item">
					<h2 class="accordion-header">
						<button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapse5" aria-expanded="false" aria-controls="collapse5">
							寵物領養管理
						</button>
					</h2>
					<div id="collapse5" class="accordion-collapse collapse" data-bs-parent="#accordionExample">
						<div class="accordion-body">
							<strong><a href="<%=request.getContextPath()%>/pet/select_page.jsp" class="list-group-item list-group-item-action">寵物列表</a></strong>
						</div>
					</div>
				</div>
				<div class="accordion-item">
					<h2 class="accordion-header">
						<button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapse6" aria-expanded="false" aria-controls="collapse6">
							會員資料管理
						</button>
					</h2>
					<div id="collapse6" class="accordion-collapse collapse" data-bs-parent="#accordionExample">
						<div class="accordion-body">
							<strong><a href="#" class="list-group-item list-group-item-action">填寫功能名稱</a></strong>
						</div>
					</div>
				</div>
				<div class="accordion-item">
					<h2 class="accordion-header">
						<button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapse7" aria-expanded="false" aria-controls="collapse7">
							公告資訊管理
						</button>
					</h2>
					<div id="collapse7" class="accordion-collapse collapse" data-bs-parent="#accordionExample">
						<div class="accordion-body">
							<strong><a href="<%=request.getContextPath()%>/informationannouncement/select_page.jsp" class="list-group-item list-group-item-action">公告列表</a></strong>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--左邊-->

		<div class="col-lg-10 g-3">
			<!--右邊-->
			<div class="card">
				<div class="card-header">
					公告列表
					<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
						 fill="currentColor" class="bi bi-box-fill" viewBox="0 0 16 16"
						 style="float: right;">
						<path fill-rule="evenodd"
							  d="M15.528 2.973a.75.75 0 0 1 .472.696v8.662a.75.75 0 0 1-.472.696l-7.25 2.9a.75.75 0 0 1-.557 0l-7.25-2.9A.75.75 0 0 1 0 12.331V3.669a.75.75 0 0 1 .471-.696L7.443.184l.004-.001.274-.11a.75.75 0 0 1 .558 0l.274.11.004.001 6.971 2.789Zm-1.374.527L8 5.962 1.846 3.5 1 3.839v.4l6.5 2.6v7.922l.5.2.5-.2V6.84l6.5-2.6v-.4l-.846-.339Z" />
					</svg>
				</div>
				<div class="card-body">
					<div class="row">
							<div class="col-md-3">
								<div class="input-group" >
									<input type="text" class="form-control" placeholder="請輸入公告編號"
										   aria-label="Recipient's username"
										   aria-describedby="button-addon2">
									<button class="btn btn-outline-secondary" type="submit" id="search">搜尋</button>
								</div>

							</div>

						<div class="col-md-4 d-flex justify-content-end"
							 style="margin-left: 400px;">
							<button class="btn btn-primary" id="navigateButton">新增</button>
						</div>
					</div>
					<!--./row-->
					<div>
						<table class="table table-hover table-striped">
							<thead>
							<tr>
								<th>公告編號</th>
								<th>管理員</th>
								<th>公告類型</th>
								<th>公告內容</th>
								<th>公告時間</th>
							</tr>
							</thead>
							<tbody id="announcementTable"></tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
		<!--右邊-->
	</div>
</div>

<script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/js/popper.min.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>

<script>
	$(document).ready(function() {
		// 頁面加載時自動執行的代碼
		callSpringBootAPI();
	});

	function callSpringBootAPI() {
		$.ajax({
			url: '/CHA103G5/GetAllInformationAnnouncement', //Spring Boot Controller的API端點
			type: 'GET', // 或 'POST'
			dataType: 'json',
			success: function(data) {
				let petHtml = data.map(info => {
					return	'<tr>' +
							'<th>' + info.infoNo + '</th>' +
							'<th>' + info.adminNo + '</th>' +
							'<th>' + info.infoTitle + '</th>' +
							'<th>' + info.infoContent + '</th>' +
							'<th>' + info.infoTime + '</th>' +
							'<td class="text-center">' +
							'<button class="btn btn-success updatebtn" type="submit" onClick="update(' + info.infoNo + ')">修改</button>' +
							'</td>' +
							'</tr>'

				}).join('');
				// 插入到表格中
				$('#announcementTable').html(petHtml);
				// 在這裡處理從API返回的數據
			},
			error: function(xhr, status, error) {
				// 處理錯誤
				console.error('API呼叫失敗: ' + status + ', ' + error);
			},

		});
	}

	document.addEventListener("DOMContentLoaded", function() {
		// 監聽搜尋按鈕的點擊事件
		let searchButton = document.getElementById('search');
		searchButton.addEventListener('click', function () {
			// 獲取搜尋關鍵字
			let searchKeyword = document.querySelector('.form-control').value.trim();
			console.log(searchKeyword);

			// 獲取所有公告行
			let petRows = document.querySelectorAll('.table tbody tr');
			console.log(petRows);

			// 遍歷所有公告行，根據搜尋關鍵字過濾顯示
			petRows.forEach(function (row) {
				let petNumber = row.querySelector('th:first-child').innerText;
				if (petNumber.includes(searchKeyword)) {
					// 如果公告包含搜尋關鍵字，顯示該行
					row.style.display = 'table-row';
				} else {
					// 如果寵物名字不包含搜尋關鍵字，隱藏該行
					row.style.display = 'none';
				}
			});
		});
	});


	document.addEventListener("DOMContentLoaded", function() {
		// 監聽導航按鈕的點擊事件
		let navigateButton = document.getElementById('navigateButton');
		navigateButton.addEventListener('click', function() {
			window.location.href = 'addInformationAnnouncement.jsp';

		});

		let updatebtns = document.querySelectorAll('.updatebtn');
		console.log("按鈕有綁到");

		updatebtns.forEach(function(btn) {
			btn.addEventListener('click', function() {
				// 獲取所選公告的 infoNo
				let infoNo = btn.closest('tr').querySelector('th:first-child').innerText;

				update(infoNo);
				// 將 infoNo 帶到新頁面
				window.location.href = 'updateInformationannouncement.jsp?infoNo=' + infoNo;
			});
		});

	});

	function update(infoNo) {
		console.log(infoNo);

		window.location.href = 'updateInformationannouncement.jsp?infoNo=' + infoNo;
	}


</script>


</body>
</html>
