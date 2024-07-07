<%@page import="com.cha103g5.admin.service.AdminService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.cha103g5.admin.model.*"%>

<%
	Object adminAccount = session.getAttribute("adminAccount");                  // 從 session內取出 (key) adminVO的值
	if (adminAccount == null) {                                             // 如為 null, 代表此user未登入過 , 才做以下工作
		session.setAttribute("location", request.getRequestURI());       		//*工作1 : 同時記下目前位置 , 以便於login.html登入成功後 , 能夠直接導至此網頁
		response.sendRedirect(request.getContextPath()+"/admin/adminLogin.jsp");   //*工作2 : 請該user去登入網頁(login.html) , 進行登入
		return;
	}

%>

<%
	AdminService adminSvc = new AdminService();
	List<AdminVO> list = adminSvc.getAll();
	pageContext.setAttribute("list", list);
%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap.min.css">
	<title>新增寵物資訊</title>
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
	<div
			class="container d-flex justify-content-center align-items-center min-vh-100">
		<div class="row border rounded-5 p-3 bg-white shadow box-area">
			<div class="header-text text-center">
				<div class="d-flex justify-content-end">
					<button type="button" class="btn btn-primary" id="mainPage">返回</button>
				</div>
				<h3>新增公告資訊</h3>
			</div>

			<div class="row g-1 align-items-center ms-5">
				<div class="col-auto offset-1">
					<label class="col-form-label">管理員帳號 :</label>
				</div>
				<div class="col-auto">
					<input type="text" name="adminAccount" id="adminAccount" readonly class="form-control">
				</div>
			</div>

			<div class="row g-1 align-items-center ms-5">
				<div class="col-auto offset-1">
					<label  class="col-form-label">公告類型 :
						<select class="col-form-label" id="infoTitle" name="infoTitle">
							<option value="商城公告">商城公告</option>
							<option value="系統公告">系統公告</option>
							<option value="活動公告">活動公告</option>
						</select>
					</label>
				</div>
			</div>


			<div class="row g-1 align-items-center ms-5">
				<div class="col-auto offset-1">
					<label class="col-form-label">公告內容 :</label>
				</div>
				<div class="col-auto">
					<div class="col-auto">
						<input type="text" name="infoContent" placeholder="請輸入公告內容" id="infoContent">
					</div>
				</div>
			</div>

			<div class="row g-1 align-items-center ms-5">
				<div class="col-auto offset-1">
					<label class="col-form-label">公告日期 :</label>
				</div>
				<div class="col-auto">
					<input type="date" name="infoTime" id="infoTime">
				</div>
			</div>

			<div class="input-group g-3 mb-2">
				<button type="submit" class="btn btn-lg btn-primary w-100 fs-6" id="executeFunctionButton">送出</button>
			</div>
		</div>
	</div>

<script>

	let pathName = window.document.location.pathname;
	let projectName = pathName.substring(0, pathName.substring(1).indexOf("/") + 1);

	// 假設 ${adminAccount} 是從伺服器端動態獲取的值
	const adminAccountValue = "${adminAccount}";

	// 找到相應的 <input> 元素
	const adminAccountInput = document.getElementById("adminAccount");

	// 設置 <input> 元素的值
	adminAccountInput.value = adminAccountValue;

		document.getElementById('executeFunctionButton').addEventListener('click',async function() {
			// 要發送的數據
			const infoTitle = document.getElementById('infoTitle').value;
			const infoContent = document.getElementById('infoContent').value;
			const infoTime = document.getElementById('infoTime').value;


			// 錯誤訊息容器
			let errorMessage = "";

			// 驗證公告類型
			if (infoTitle === "") {
				errorMessage += "請選擇公告類型。\n";
			}

			// 驗證公告內容
			if (infoContent === "") {
				errorMessage += "請輸入公告內容。\n";
			}

			// 驗證截止日期
			if (infoTime === "") {
				errorMessage += "請選擇公告日期。\n";
			}


			// 如果有錯誤，顯示錯誤訊息
			if (errorMessage !== "") {
				alert(errorMessage);
				return;
			}

			// 如果通過前端驗證，則繼續發送POST請求

				// 建立要傳送的數據對象
				const data = {
					infoTitle: infoTitle,
					infoContent: infoContent,
					infoTime: infoTime,
					adminNo: adminAccountValue,
				};
				console.log(data);

				try {
					const response = await fetch('/CHA103G5/informationAnnouncement', {
						method: 'POST',
						headers: {
							'Content-Type': 'application/json',
						},
						body: JSON.stringify(data),
					});

					if (response.ok) {
						// 請求成功
						// const responseData = await response.json();
						// console.log(responseData);
						alert("新增寵物資訊成功");
						window.location.href = '/CHA103G5/informationannouncement/select_page.jsp';
					} else {
						// 請求失敗
						console.error('請求失敗。');
					}
				} catch (error) {
					console.error('發生錯誤:', error);
				}
		});
</script>

<script>
	let mainPage = document.getElementById('mainPage');
	mainPage.addEventListener('click', function() {
		window.location.href = projectName + '/informationannouncement/select_page.jsp';
	});
</script>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/datetimepicker/jquery.datetimepicker.css" />
<script src="<%=request.getContextPath()%>/datetimepicker/jquery.js"></script>
<script src="<%=request.getContextPath()%>/datetimepicker/jquery.datetimepicker.full.js"></script>
<style>
	.xdsoft_datetimepicker .xdsoft_datepicker {
		width:  300px;   /* width:  300px; */
	}
	.xdsoft_datetimepicker .xdsoft_timepicker .xdsoft_time_box {
		height: 151px;   /* height:  151px; */
	}
</style>
<script>
	$.datetimepicker.setLocale('zh');
	$('#text7').datetimepicker({
		theme: ' ',              //theme: 'dark',
		timepicker:false,       //timepicker:true,
		step: 60,                //step: 60 (這是timepicker的預設間隔60分鐘)
		format:'Y-m-d',         //format:'Y-m-d H:i:s',
		value: '${param.createDate}', // value:   new Date(),
		//disabledDates:        ['2017/06/08','2017/06/09','2017/06/10'], // 去除特定不含
		//startDate:	            '2017/07/10',  // 起始日
		//minDate:               '-1970-01-01', // 去除今日(不含)之前
		//maxDate:               '+1970-01-01'  // 去除今日(不含)之後
	});
</script>

<script src="../js/popper.min.js"></script>
<script src="../js/bootstrap.min.js"></script>


</body>
</html>
