<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
					<a href="${pageContext.request.contextPath}/member/membeFotgotPassword.jsp" class="btn btn-primary"> <b>忘記密碼</b></a>
				</div>
			</form>
		</div>
	</section>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/memberLogin.js"></script>
	<script>
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