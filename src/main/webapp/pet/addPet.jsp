<%@page import="com.cha103g5.admin.service.AdminService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.cha103g5.admin.model.*"%>
<%@ page import="com.cha103g5.admin.service.*"%>

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
				<h3>新增寵物資料</h3>
			</div>

			<div class="row g-1 align-items-center ms-5">
				<div class="col-auto offset-1">
					<label  class="col-form-label">寵物類型 :
						<select class="col-form-label" id="petType" name="petType">
							<option value="1">貓</option>
							<option value="2">狗</option>
						</select>
					</label>
				</div>
			</div>

			<jsp:useBean id="memSvc" scope="page" class="com.cha103g5.member.model.MemberService" />

			<div class="row g-1 align-items-center ms-5">
				<div class="col-auto offset-1">
					<label  class="col-form-label">會員編號 :</label>
					<label>
						<select size="1" name="memberNo" id="memberNo">
								<option value="">無</option>
							<c:forEach var="MemberVO" items="${memSvc.allMembers}" >
								<option value="${MemberVO.memberno}">${MemberVO.memberno}</option>
							</c:forEach>
						</select>
					</label>
				</div>
			</div>

			<div class="row g-1 align-items-center ms-5">
				<div class="col-auto offset-1">
					<label class="col-form-label" >寵物名稱 :</label>
				</div>
				<div class="col-auto">
					<label>
						<input type="text" name="petName" placeholder="請輸入寵物名稱" id="petName">
					</label>
				</div>
			</div>

			<div class="row g-1 align-items-center ms-5">
				<div class="col-auto offset-1">
					<label class="col-form-label" >寵物性別 :</label>
				</div>
				<div class="col-auto">
					<label class="form-check-label">
						<input type="radio" name="petSex" value="M" > 公
					</label>
				</div>
				<div class="col-auto">
					<label class="form-check-label">
						<input type="radio" name="petSex" value="F" > 母
					</label>
				</div>
			</div>

			<div class="row g-1 align-items-center ms-5">
				<div class="col-auto offset-1">
					<label class="col-form-label">寵物年齡 :</label>
				</div>
				<div class="col-auto">
					<input type="text" name="petAge" id="petAge" placeholder="請輸入寵物年齡">
				</div>
			</div>

			<div class="row g-1 align-items-center ms-5">
				<div class="col-auto offset-1">
					<label class="col-form-label" >寵物備註:</label>
				</div>
				<div class="col-auto">
					<input type="text" name="petNote" placeholder="請輸入備註" id="petNote">
				</div>
			</div>

			<div class="row g-1 align-items-center ms-5">
				<div class="col-auto offset-1">
					<label class="col-form-label">截止日期 :</label>
				</div>
				<div class="col-auto">
					<input type="date" name="ApplicationDeadLine" id="applicationDeadLine">
				</div>
			</div>

			<div class="row g-1 align-items-center ms-5">
				<div class="col-auto offset-1">
					<label  class="col-form-label">寵物狀態 :</label>
					<select class="col-form-label" id="stat" name="stat">
						<option value="1">未上架</option>
						<option value="2">待領養</option>
						<option value="3">領養中</option>
						<option value="4">已領養</option>
						<option value="21">待領養已預約</option>
						<option value="31">領養中第一順位</option>
						<option value="32">領養中第二順位</option>
						<option value="33">領養中第三順位</option>
						<option value="34">領養中第四順位</option>
						<option value="35">領養中第五順位</option>
						<option value="41">已領養第一順位</option>
						<option value="42">已領養第二順位</option>
						<option value="43">已領養第三順位</option>
						<option value="44">已領養第四順位</option>
						<option value="45">已領養第五順位</option>
					</select>
				</div>

			</div>


			<div class="row g-1 align-items-center ms-5">
				<div class="col-auto offset-1">
					<label class="col-form-label">寵物照片:</label>
				</div>
				<div class="col-auto">
					<input type="file" name="petPhotos" id="petPic" multiple>
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


		document.getElementById('executeFunctionButton').addEventListener('click', function() {
			// 要發送的數據
			const petType = document.getElementById('petType').value;
			const memberNo = document.getElementById('memberNo').value;
			const petName = document.getElementById('petName').value;
			const petSex = document.querySelector('[name="petSex"]').value;
			const petAge = document.getElementById('petAge').value;
			const petNote = document.getElementById('petNote').value;
			const applicationDeadLine = document.getElementById('applicationDeadLine').value;
			const stat = document.getElementById('stat').value;
			const fileInput = document.getElementById('petPic');
			const files = fileInput.files;
			const petPic = [];

			// 錯誤訊息容器
			let errorMessage = "";

			// 驗證寵物類型
			if (petType === "") {
				errorMessage += "請選擇寵物類型。\n";
			}


			// 驗證寵物名稱
			if (petName === "") {
				errorMessage += "請輸入寵物名稱。\n";
			}else if (petName.length > 10 ) {
				errorMessage += "寵物名稱太長，請輸入不超過" + 10 + "個字元。\n";
			}

			// 驗證寵物性別
			if (!petSex) {
				errorMessage += "請選擇寵物性別。\n";
			}

			// 驗證寵物年齡
			if (petAge === "") {
				errorMessage += "請輸入寵物年齡。\n";
			} else if (isNaN(petAge) || parseInt(petAge) <= 0) {
				errorMessage += "請輸入有效的寵物年齡(數字)。\n";
			}

			// 驗證截止日期
			if (applicationDeadLine === "") {
				errorMessage += "請選擇截止日期。\n";
			}

			// 驗證寵物狀態
			if (stat === "") {
				errorMessage += "請選擇寵物狀態。\n";
			}

			// 驗證寵物照片
			if (files.length === 0) {
				errorMessage += "請上傳寵物照片。\n";
			}

			// 如果有錯誤，顯示錯誤訊息
			if (errorMessage !== "") {
				alert(errorMessage);
				return;
			}

			// 如果通過前端驗證，則繼續發送POST請求
			const promises = [];

			if (files.length > 0) {
				const promises = [];

				for (let i = 0; i < files.length; i++) {
					const file = files[i];
					const reader = new FileReader();

					promises.push(new Promise((resolve, reject) => {
						reader.onloadend = function () {
							petPic.push(reader.result);
							resolve();
						}
						reader.readAsDataURL(file);
					}));
				}

				// 等待所有 Promise 完成後再執行 fetch
				Promise.all(promises).then(() => {
					const postData = {
						"animalTypeNo": petType,
						"memberNo": memberNo,
						"petName": petName,
						"petSex": petSex,
						"petAge": petAge,
						"petNote": petNote,
						"stat": stat,
						"applicationDeadLine": applicationDeadLine,
						"petPic": petPic
					};

					// API端點
					const apiUrl = projectName + '/addPetInfo';

					// 發送POST請求
					fetch(apiUrl, {
						method: 'POST',
						headers: {
							'Content-Type': 'application/json',
							// 如果需要身份驗證或其他標頭，請在此處添加
						},
						body: JSON.stringify(postData),
					})
							.then(response => response.json())
							.then(data => {
								// 處理成功響應
								console.log('成功：', data);

								// 在這裡跳轉到 select_page.jsp
								window.location.href = 'select_page.jsp';
							})
							.catch(error => {
								// 處理錯誤
								console.error('錯誤：', error);
							});
				});
			}
		});
</script>

<script>
	let mainPage = document.getElementById('mainPage');
	mainPage.addEventListener('click', function() {
		window.location.href = projectName + '/pet/select_page.jsp';
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
