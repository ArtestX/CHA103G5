<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.cha103g5.member.model.*"%>
<%@ page import="java.util.*"%>
<jsp:include page="/banner.jsp" flush="true" />



<!DOCTYPE html>
<html>
<head>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

<style>
body {
	background-color: rgb(245, 245, 245);
	margin: 0;
    padding: 0;
}

aside {
    display: flex;
	justify-content: right;
	align-items: center;
    
}

#membercenter {
	padding: 0;
	margin: 0 !important;
}

/*選單樣式*/
.card {
 border: none;
 border-radius: 20px;
 background-color: #f8f9fa;
}

.card-header{
 border: none;
 border-radius: 20px;
 background-color:;
}


.title-icon {
	width: 100px;
	height: auto;
}

.title-box.mb-5 {
	margin-top: 30px !important;
	margin-bottom: 0 !important;
}

h2 {
	/*會員基本資料*/
	color: #422E2F;
	text-align: left;
}

.user-info, .row {
	display: flex;
	justify-content: left;
	align-items: center;
}

.col-md-4, .col-md-8 {
	margin: 10px;
}


font {
	float: right;
	font-size: 15px;
}

.btn {
	/*按鈕*/
	margin-top: 13px;
	margin-bottom: 13px;
	color: #422E2F;
	background-color: #FAE899;
	border: 1px solid rgba(#eeeaea, 0.5);
}

.btn:hover {
	/*按鈕*/
	background-color: #bae5f3fb;
	box-shadow: 0 1px 4px rgba(64, 64, 64, 1);
}

#password-re {
	/*修改密碼按鈕*/
	margin-left: 10px;
}

#btn_address {
	/*修改地址按鈕*/
	margin-top: 30px;
}

/*****相機圖示*****/
.img-box {
	position: relative;
	width: 200px; /* 設定圖片容器寬度 */
	height: 200px; /* 設定圖片容器高度 */
	overflow: hidden;
}

#finalImg1 {
	position: relative;
	width: 180px;
	height: 180px;
	border-radius: 50%;
	object-fit: cover;
}

.camera {
	position: absolute;
	bottom: 0;
	right: 0;
	margin: 10px; /* 加入一些 margin 以改善相機圖示和邊框的間距 */
	cursor: pointer;
}

.camera-icon {
	width: 50px;
	height: 50px;
	border-radius: 50%;
	box-shadow: 0 1px 4px rgba(64, 64, 64, 1);
}

/*儲存按鈕*/
.action-btn-box {
	display: flex;
	justify-content: flex-end; /* 水平方向靠右對齊 */
}

.bookmarkBtn {
	margin-top: 30px;
	width: 100px;
	height: 40px;
	border-radius: 40px;
	border: 1px solid rgba(255, 255, 255, 0.349);
	background-color: rgb(152, 145, 145);
	display: flex;
	align-items: center;
	justify-content: center;
	cursor: pointer;
	transition-duration: .3s;
	overflow: hidden;
}

.IconContainer {
	width: 30px;
	height: 30px;
	background: linear-gradient(to bottom, rgb(230, 224, 230),
		rgb(219, 222, 215));
	border-radius: 50%;
	display: flex;
	align-items: center;
	justify-content: center;
	overflow: hidden;
	z-index: 2;
	transition-duration: .3s;
}

.icon {
	border-radius: 1px;
}

.text {
	height: 100%;
	width: 60px;
	margin-top: 15px;
	display: flex;
	align-items: center;
	justify-content: center;
	color: white;
	z-index: 1;
	transition-duration: .3s;
	font-size: 18px;
}

.bookmarkBtn:hover .IconContainer {
	width: 90px;
	border-radius: 40px;
	transition-duration: .3s;
}

.bookmarkBtn:hover .text {
	transform: translate(10px);
	width: 0;
	font-size: 0;
	transition-duration: .3s;
}

.bookmarkBtn:active {
	transform: scale(0.95);
	transition-duration: .3s;
}
/*填寫地址按鈕*/
#addressButton {
	margin-top: 35px;
	margin-left: 30px;
}


</style>
</head>
<body>
	<%
	// 把MemberVO的資料從session取出
	com.cha103g5.member.model.MemberVO user = (com.cha103g5.member.model.MemberVO) session.getAttribute("user");
	%>
    <aside>
    	<div class="card col-lg-3" >
			<div class="card-header">
				<!-- 再次使用 sessionScope 來獲取用戶名 -->
				<b>
				   <c:out value="您好，${user.membername}！" />
				</b>
			</div>
			<ul class="list-group list-group-flush">
				<li class="list-group-item">
					<a>基本資料</a>
				</li>
				<li class="list-group-item">
					<a onclick="toggleOrderManagement()" style="cursor: pointer;"><i class="fa-solid fa-clipboard-list"></i>
						訂單管理
					</a>
					<div class="left-icon">
						<ul id="orderManagementOptions" style="display: none;">
							<li class="list-group-item"><a
								onclick="toggleShopOrderManagement()" style="cursor: pointer;"><i
									class="fa-solid fa-shop"></i> 商城訂單查詢</a>
								<ul id="shopManagementOptions" style="display: none;">
									<li class="list-group-item"><a href="#">訂單查詢</a></li>
									<li class="list-group-item"><a href="#">訂單追蹤</a></li>
									<li class="list-group-item"><a href="#">商品退貨</a></li>
								</ul></li>
						</ul>
					</div>
				</li>
			</ul>
		</div>                       
    </aside>                         
	<section class="main-container" id="membercenter">
		<div class="container">
			<div class="row">
				<!-- main start -->
				<!-- ================ -->
				<form method="post" enctype="multipart/form-data" action="mem.do"
					name="form1">
					<div class="main col-lg-8">
						<div class="title-box mb-5">
							<div class="row">
								<div class="col-md-12">
									<img
										src="${pageContext.request.contextPath}/img/MBRcenter2.png"
										class="title-icon">
									<h2 class="title-c-1 d-inline-block align-bottom mb-0 pl-10">
										<b>會員基本資料</b>
									</h2>
									<input type="hidden" name="memberno" value="${user.memberno}">
								</div>

							</div>
						</div>
					</div>

					<div class="user-info">
						<div class="col-md-6">
							<p id="memberDataToggle"
								style="margin-top: 20px; width: 540px; background: #E6E1D7; padding: 15px 23px; border-radius: 20px; font-size: 20px; height: 150px;">
								<strong style="margin-bottom: 10px;">會員帳號(Email)</strong> <span
									style="color: #555">${user.memberemail}</span>
								<svg width="100" height="60" xmlns="http://www.w3.org/2000/svg">
							    <!-- 方形 -->
							    <rect width="80" height="40" x="10" y="8" rx="10" ry="10"
										fill="${user.memberstat == 1 ? '#2ecc71' : '#e74c3c'}" />
							
							    <!-- 文字 -->
							    <text x="50%" y="50%" alignment-baseline="middle"
										text-anchor="middle" fill="#fff" font-size="15">							        ${user.memberstat == 1 ? '已認證' : '未認證'}
							    </text>
							 </svg>
								<br> <strong style="margin-bottom: 10px;">會員密碼 </strong> <span><button
										type="button" class="btn btn-default" id="password-re"
										onclick="togglePasswordFields()">修改密碼</button></span> <span
									class="password-col" style="display: none"> <span
									class="row"> <span class="col-md-6"> <input
											type="password" id="memberpassword"
											class="form-control radius-4" placeholder="請輸入新密碼"
											autocomplete="off" oninput="validatePassword()"> <font
											id="passwordError" color="red" style="font-size: 15px;">${errorMsgs.memberpassword}</font>
									</span> <span class="col-md-6"> <input type="password"
											id="confirmPassword" class="form-control radius-4"
											placeholder="請再次輸入新密碼" autocomplete="off"
											oninput="validatePassword()"> <font
											id="confirmPasswordError" color=red style="font-size: 15px;">${errorMsgs.confirmPassword}</font>
									</span>
								</span>
								</span>
							</p>
						</div>
						<label for="fileInput" class="img-box"> 
						<%-- <img id="finalImg1" src="${pageContext.request.contextPath}/img/member.png"> --%>
					   <%--<img id="finalImg1" name="memberpic" src="data:image/png;base64,${base64Image}"  value="${param.memberpic}" > --%>
							<img id="finalImg1" name="memberpic"
							src="<%=request.getContextPath()%>/ReadMbrIMG?id=${user.memberno}">
							<div class="camera">
								<img src="${pageContext.request.contextPath}/img/camera.png"
									class="camera-icon">
							</div>
						</label> <input type="file" name="memberpic" id="fileInput"
							style="display: none;" value="${param.memberpic}">
					</div>

					<div class="row">
						<div class="col-md-4">
							<div class="form-group">
								<font color=red>${errorMsgs.membername}</font> <label
									class="control-label col-form-label"> 會員姓名 </label> <input
									type="text" class="form-control radius-4" name="membername"
									value="${user.membername}">
							</div>
						</div>

						<div class="col-md-4">
							<label class="control-label col-form-label"> 會員性別 </label>
							<div class="form-group">
								<font color=red>${errorMsgs.membergender}</font> <select
									class="form-control" name="membergender">
									<option value=0
										${empty user.membergender? '請選擇性別' : user.membergender}>請選擇性別</option>
									<option value=1 ${user.membergender == 1 ? 'selected' : ''}>男</option>
									<option value=2 ${user.membergender == 2 ? 'selected' : ''}>女</option>
								</select>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-md-4">
							<div class="form-group">
								<font color=red>${errorMsgs.memberid}</font> <label
									class="control-label col-form-label"> 身分證 </label>
								<div class="form-group">
									<input type="text" name="memberid"
										value="${empty user.memberid ? '請輸入身分證' : user.memberid}"
										class="form-control dtpicker-datetoday">
								</div>
							</div>
						</div>

						<div class="col-md-4">
							<div class="form-group">
								<font color=red>${errorMsgs.memberbirthday}</font> <label
									class="control-label col-form-label"> 出生日期 </label> <input
									type="text" name="memberbirthday"
									value="${empty user.memberbirthday ? '請輸入生日' : user.memberbirthday}"
									class="form-control dtpicker-datetoday">
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-md-4">
							<div class="form-group">
								<font color=red>${errorMsgs.memberphone}</font> <label
									class="control-label col-form-label"> 手機號碼 </label> <input
									type="text" class="form-control radius-4" name="memberphone"
									value="${empty user.memberphone ? '請輸入手機號碼' : user.memberphone}">
							</div>
						</div>

						<div class="col-md-4">
							<label class="control-label col-form-label"> 職業 </label>
							<div class="form-group">
								<input type="text" class="form-control radius-4"
									name="memberjob"
									value="${empty user.memberjob ? '請輸入職業' : user.memberjob}">
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-md-8">
								<label class="control-label col-form-label"> 地址 </label>
								<div class="form-group">
									<input type="text" class="form-control dtpicker-datetoday"
										id="onlyReadAddress" name="memberaddress"
										value="${empty user.memberaddress ? '請填寫地址' : user.memberaddress}">
								</div>
						</div>
					</div>

					<input type="hidden" name="membercard" />
					<div class="row">
						<div class="col-md-4" style="margin-bottom: 40px;">
							<label class="control-label col-form-label"> 收入 </label>
							<div class="form-group">
								<select class="form-control" name="membersal">
									<option value=3
										${empty user.membersal ? '請選擇收入' : user.membersal}>請選擇收入</option>
									<option value=0 ${user.membersal == 0 ? 'selected' : ''}>30W
										~ 50W</option>
									<option value=1 ${user.membersal == 1 ? 'selected' : ''}>50w
										~ 80W</option>
									<option value=2 ${user.membersal == 2 ? 'selected' : ''}>80W
										UP</option>
								</select>
							</div>
						</div>

						<div class="col-md-4">
							<div class="form-group">
								<div class="action-btn-box">
									<input type="hidden" name="memberemail"
										value="${user.memberemail}"> <input type="hidden"
										name="action" value="update">
									<button class="bookmarkBtn" id="check_btn">
										<span class="IconContainer"> <svg viewBox="0 0 384 512"
												height="0.9em" class="icon">
												<path
													d="M0 48V487.7C0 501.1 10.9 512 24.3 512c5 0 9.9-1.5 14-4.4L192 400 345.7 507.6c4.1 2.9 9 4.4 14 4.4c13.4 0 24.3-10.9 24.3-24.3V48c0-26.5-21.5-48-48-48H48C21.5 0 0 21.5 0 48z"></path></svg>
										</span>
										<p class="text">儲存</p>
									</button>
								</div>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</section>



	<%--     <script src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script> --%>
	<script src="${pageContext.request.contextPath}/js/twzipcode.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
	<script>
		/******修改密碼******/
		function togglePasswordFields() {
			var passwordFields = document.querySelector('.password-col');
			passwordFields.style.display = (passwordFields.style.display === 'none') ? 'block'
					: 'none';

			var memberpasswordInput = document.getElementById('memberpassword');
			var confirmPasswordInput = document
					.getElementById('confirmPassword');

			// 修改高度
			var memberDataToggle = document.getElementById('memberDataToggle');
			memberDataToggle.style.height = (memberDataToggle.style.height === '150px') ? '200px'
					: '150px';

			if (passwordFields.style.display === 'block') {
				// 如果不存在，則動態添加 name 屬性
				if (memberpasswordInput
						&& !memberpasswordInput.hasAttribute('name')) {
					memberpasswordInput.setAttribute('name', 'memberpassword');
				}

				if (confirmPasswordInput
						&& !confirmPasswordInput.hasAttribute('name')) {
					confirmPasswordInput
							.setAttribute('name', 'confirmPassword');
				}
			} else {
				// 如果隱藏密碼欄位，則移除 name 屬性
				if (memberpasswordInput
						&& memberpasswordInput.hasAttribute('name')) {
					memberpasswordInput.removeAttribute('name');
				}

				if (confirmPasswordInput
						&& confirmPasswordInput.hasAttribute('name')) {
					confirmPasswordInput.removeAttribute('name');
				}
			}

		}

		function validatePassword() {
			var memberpasswordInput = document.getElementById('memberpassword');
			var confirmPasswordInput = document
					.getElementById('confirmPassword');
			var passwordError = document.getElementById('passwordError');
			var confirmPasswordError = document
					.getElementById('confirmPasswordError');

			// 密碼格式檢查
			var passwordRegex = /^(?![\s])(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d@#$%^&+=!]{8,30}$/;
			var isPasswordValid = passwordRegex.test(memberpasswordInput.value);

			// 確認密碼是否與輸入密碼一致
			var isConfirmPasswordMatch = memberpasswordInput.value === confirmPasswordInput.value;

			// 更新錯誤提示
			passwordError.textContent = isPasswordValid ? ''
					: '設定至少8碼以上(含字母跟數字)';
			confirmPasswordError.textContent = isConfirmPasswordMatch ? ''
					: '確認密碼不一致';
		}
	</script>

</body>
</html>