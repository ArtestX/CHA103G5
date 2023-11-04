<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/banner.jsp" flush="true"/>


<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/memberlogin.css" />


</head>
<body>
	<section class="hero-section d-flex justify-content-center align-items-center">
		<div class="container">
			<form METHOD="post" ACTION="<%=request.getContextPath()%>/member/mem.do" class="form">
				<h3><b>會員登入</b></h3>
				<font color=red>${errorMsgs.memberlogin}</font><br>
				
				<div class="loginGroup">
					<label for="login" class="form-label"><b>帳號</b></label> 	 <font class="error-message">${errorMsgs.memberemail}</font>
					<input type="text" id="username" class="form-control" name="memberemail" value="${param.memberemail}" placeholder="name@example.com">
					<br>
					
					<label for="password" class="form-label"><b>密碼</b></label> <font class="error-message">${errorMsgs.memberpassword}</font>
					<input type="password" id="password" class="form-control" name="memberpassword" value="${param.memberpassword}" autocomplete="off">
					<span class="eye1">
						<img class="password-toggle" id="toggleImage" src="<%=request.getContextPath()%>/img/eyeclose.png" alt="Show Password" onclick="togglePasswordVisibility()">
					</span>
				</div>

				<div class="login_btn">
					<input type="hidden" name="action" value="memberlogin">
					<button class="btn btnAccess" id="loginButton">
						<b>登入</b>
					</button>
				</div>

				<div id="rmbr">
					<input type="checkbox" name="rememberme" id="rememberme"> 
					<label for="rememberme"><b>記住帳號</b></label>
				</div>
			

				<div class="btn-group" id="btn-group-login" role="group"
					aria-label="Basic example">
					<a href="${pageContext.request.contextPath}/member/memberSignUp.jsp" class="btn btn-primary"> 
						<b>註冊會員</b>
					</a> 
					<a href="#" class="btn btn-primary"> <b>忘記密碼</b></a>
				</div>

<!-- 				<div class="br-style-1 my-4"></div> -->

<!-- 				<div class="form-group has-feedback row"> -->
<!-- 					<div class="col-md-12"> -->
<!-- 						<div class="social-link text-center mt-40"> -->
<!-- 							<div class="facebook"> -->
<!-- 								<a href="https://www.facebook.com/v2.5/dialog/oauth?client_id=130903614662985&amp;state=fd47ec52dad200d2b801f302ab03299d&amp;response_type=code&amp;sdk=php-sdk-5.0.0&amp;redirect_uri=https%3A%2F%2Fnoramichi.app%2Fmember%2Foauth%2Ffacebook&amp;scope=public_profile%2Cemail&amp;state=%7B%22ref%22%3A%22https%3A%5C%2F%5C%2Fnoramichi.app%5C%2Fmember%22%7D"> -->
<%-- 									<img src="${pageContext.request.contextPath}/img/facebook.png" class="facebook-icon" alt="透過FaceBook登入">  --%>
<!-- 									<i class="fa fa-facebook-square pr-2"></i> -->
<!-- 								</a> -->
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 				</div> -->
			</form>
		</div>
	</section>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	/************記住帳號************/
	$(document).ready(function() {
	    $("#loginButton").click(function(e) {
	
	        var username = $("#username").val(); // 獲取使用者輸入的帳號
	        var rememberMe = $("#rememberme").is(":checked"); // 檢查"記住帳號"是否勾選
	
	        // 根據記住帳號的勾選狀態，保存帳號到localStorage
	        if (rememberMe) {
	            localStorage.setItem("savedUsername", username);
	        } else {
	            localStorage.removeItem("savedUsername");
	        }
	
	});
	
	    // 在頁面載入時，檢查localStorage並填充帳號輸入框
	    var savedUsername = localStorage.getItem("savedUsername");
	    if (savedUsername) {
	        $("#username").val(savedUsername);
	        $("#rememberme").prop("checked", true);
	    }
	});
	
	/************隱藏密碼************/
	var passwordVisible = false;
	
	function togglePasswordVisibility() {
	  var passwordField = document.getElementById("password");
	  var toggleImage = document.getElementById("toggleImage");
	
	  if (passwordVisible) {
		 password.type = "password";
	    toggleImage.src ="<%=request.getContextPath()%>/img/eyeclose.png";
	    toggleImage.alt = "Show Password";
	  } else {
		password.type = "text";
	    toggleImage.src ="<%=request.getContextPath()%>/img/eyeopen.png";
	    toggleImage.alt = "Hide Password";
	  }
	
	  passwordVisible = !passwordVisible;
	}

   
</script>

</body>
</html>