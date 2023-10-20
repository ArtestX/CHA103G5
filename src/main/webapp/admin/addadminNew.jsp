<%@page import="java.sql.Timestamp"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.cha103g5.admin.model.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
<title>新增員工</title>
<style>
body {
	font-family: 'Poppins', sans-serif;
	background: linear-gradient(45deg, #c5deea 0%, #8abbd7 31%, #066dab 100%);
}

.box-area {
	width: 530px;
}

::placeholder {
	font-size: 14px;
}

span {
        font-size: 13px;
        color : red;
        white-space: nowrap;
}		

</style>
</head>

<body>
	<FORM METHOD="post" ACTION="admin.do" name="form1">
		<div
			class="container d-flex justify-content-center align-items-center min-vh-100">
			<div class="row border rounded-5 p-3 bg-white shadow box-area">
				<div class="header-text text-center">
					<div class="d-flex justify-content-end">
						<button type="button" class="btn btn-primary" id="mainPage">首頁</button>
					</div>
					<h3>請填寫員工資料</h3>
				</div>
				<div class="row g-1 align-items-center ms-5">
					<div class="col-auto offset-1">
						<label for="text1" class="col-form-label">員工編號 :</label>
					</div>
					<div class="col-auto">
						<div class="d-flex align-items-center">
							<input type="text" id="text1" class="form-control" name="adminNo" value="${param.adminNo}" size="15"
								placeholder="請輸入編號"> <span class="float-end ms-2">
								${errorMsgs.adminNo} </span>
						</div>
					</div>
				</div>
				<div class="row g-1 align-items-center ms-5">
					<div class="col-auto offset-1">
						<label for="text2" class="col-form-label">員工帳號 :</label>
					</div>
					<div class="col-auto">
						<div class="d-flex align-items-center">
							<input type="text" id="text2" class="form-control"
								placeholder="請輸入帳號" name="adminAccount" value="${param.adminAccount}" size="15"> <span class="float-end  ms-2">
								${errorMsgs.adminAccount}</span>
						</div>
					</div>
				</div>
				<div class="row g-1 align-items-center ms-5">
					<div class="col-auto offset-1">
						<label for="password" class="col-form-label">員工密碼 :</label>
					</div>
					<div class="col-auto">
						<div class="d-flex align-items-center">
							<input type="password" id="password" class="form-control" name="adminPassword" value="${param.adminPassword}" size="15"
								placeholder="請輸入密碼"> <span class="float-end  ms-2">
								${errorMsgs.adminPassword}</span>
						</div>
					</div>
				</div>
				<div class="row g-1 align-items-center ms-5">
					<div class="col-auto offset-1">
						<label for="text4" class="col-form-label">員工姓名 :</label>
					</div>
					<div class="col-auto">
						<div class="d-flex align-items-center">
							<input type="text" id="text4" class="form-control" name="adminName" value="${param.adminName}" size="15"
								placeholder="請輸入姓名"> 
								<span class="float-end  ms-2">
								${errorMsgs.adminName}</span>
						</div>
					</div>
				</div>
				<div class="row g-1 align-items-center ms-5">
					<div class="col-auto offset-1">
						<label for="text5" class="col-form-label">員工信箱 :</label>
					</div>
					<div class="col-auto">
						<div class="d-flex align-items-center">
							<input type="text" id="text5" class="form-control" name="adminEmail" value="${param.adminEmail}" size="15"
								placeholder="請輸入信箱"> <span class="float-end  ms-2">
								${errorMsgs.adminEmail}</span>
						</div>
					</div>
				</div>
				<div class="row g-1 align-items-center ms-5">
					<div class="col-auto offset-1">
						<label for="text6" class="col-form-label">員工電話 :</label>
					</div>
					<div class="col-auto">
						<div class="d-flex align-items-center">
							<input type="text" id="text6" class="form-control" name="adminPhone" value="${param.adminPhone}"  size="15"
								placeholder="請輸入電話"> <span class="float-end  ms-2">
								${errorMsgs.adminPhone}</span>
						</div>
					</div>
				</div>
				<div class="row g-1 align-items-center ms-5">
					<div class="col-auto offset-1">
						<label for="text7" class="col-form-label">到職日期 :</label>
					</div>
					<div class="col-auto ">
						<div class="d-flex align-items-center">
							<input type="text" id="text7" class="form-control" name="createDate"   value="${param.createDate}"   size="15"
								placeholder="請輸入日期"> <span class="float-end  ms-2">
								${errorMsgs.createDate}</span>
						</div>
					</div>
				</div>
				<div class="row g-1 ms-5 align-items-center">
					<div class="col-auto offset-1">
						<label for="text8" class="col-form-label">員工狀態 :</label>
					</div>
					<div class="col-auto">
						<div class="d-flex align-items-center">
							<input type="text" id="text8" class="form-control" name="adminStat"   value="${param.adminStat}"   size="15"
								placeholder="請輸入狀態"> <span class="float-end ms-2">${errorMsgs.adminStat}</span>
						</div>
					</div>
				</div>
				<div class="input-group g-3 mb-2">
					<button type="submit" class="btn btn-lg btn-primary w-100 fs-6">送出</button>
					<input type="hidden" name="action" value="insert">
				</div>
			</div>
		</div>
		<script>
			let mainPage = document.getElementById('mainPage');
			// 添加点击事件处理程序
			mainPage.addEventListener('click', function() {
				// 执行页面导航，跳转到 addAdmin.jsp
				window.location.href = 'adminsystem.jsp';
			});
		</script>

		<script src="../js/popper.min.js"></script>
		<script src="../js/bootstrap.min.js"></script>
	
	</FORM>
</body>
</html>
