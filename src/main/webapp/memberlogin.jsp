<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="BIG5"%>
<jsp:include page="banner.jsp" flush="true" />
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<link rel="stylesheet" href="./css/bootstrap.min.css" />
<link rel="stylesheet" href="./css/memberlogin.css" />
</head>
<body>
	<section
		class="hero-section d-flex justify-content-center align-items-center">
		<div class="container">
			<form METHOD="post"
				ACTION="${pageContext.request.contextPath}/member/mem.do"
				class="form">
				<h3>
					<b>會員登入</b>
				</h3>
				<div class="loginGroup">
					<label for="login" class="form-label"><b>帳號</b></label> <input
						type="text" id="username" class="form-control"
						placeholder="name@example.com" name="memberemail"
						value="${param.memberemail}"><font color=red>${errorMsgs.memberemail}</font>

					<label for="password" class="form-label"><b>密碼</b></label> <input
						type="password" id="password" class="form-control"
						name="memberpassword" value="${param.memberpassword}"><font
						color=red>${errorMsgs.memberpassword}</font>
				</div>

				<div class="login_btn">
					<input type="hidden" name="action" value="memberlogin">
					<button class="btn btnAccess">
						<b>登入</b>
					</button>
				</div>

				<div id="rmbr">
					<input type="checkbox" name="remberme" required> <label
						for="remberme" id="remberme0"><b>記住我</b></label>
				</div>

				<div class="btn-group" id="btn-group-login" role="group"
					aria-label="Basic example">
					<a href="${pageContext.request.contextPath}/member/signUpMbr.jsp"
						class="btn btn-primary"> <b>註冊會員</b>
					</a> <a href="#" class="btn btn-primary"> <b>忘記密碼</b>
					</a>
				</div>

				<div class="br-style-1 my-4"></div>

				<div class="form-group has-feedback row">
					<div class="col-md-12">
						<div class="social-link text-center mt-40">
							<div class="facebook">
								<a
									href="https://www.facebook.com/v2.5/dialog/oauth?client_id=130903614662985&amp;state=fd47ec52dad200d2b801f302ab03299d&amp;response_type=code&amp;sdk=php-sdk-5.0.0&amp;redirect_uri=https%3A%2F%2Fnoramichi.app%2Fmember%2Foauth%2Ffacebook&amp;scope=public_profile%2Cemail&amp;state=%7B%22ref%22%3A%22https%3A%5C%2F%5C%2Fnoramichi.app%5C%2Fmember%22%7D"
									title="FaceBook登入"> <img
									src="${pageContext.request.contextPath}/img/facebook.png"
									class="facebook-icon" alt="透過FaceBook登入"> <i
									class="fa fa-facebook-square pr-2"></i>
								</a>
							</div>
						</div>
					</div>
				</div>

			</form>
		</div>
	</section>
	<script src="./js/bootstrap.bundle.min.js"></script>
	<script src="./js/bootstrap.min.js"></script>
	<script>
		const loginForm = document.querySelector(".form");
		const loginEmailInput = document.getElementById("username");
		const loginPasswordInput = document.getElementById("password");

		loginForm.addEventListener('submit', function(event) {
			event.preventDefault();
			const loginData = {
				username : loginEmailInput.value,
				password : loginPasswordInput.value,
				action : "memberlogin"
			};

			$.ajax({
				type : "POST",
				url : "/cha103g5/member/mem.do",
				data : loginData,
				dataType : "json",
				success : function(response) {
					if (response.success) {
						window.location.href = "/cha103g5/index.jsp";
					} else {
						if (response.errors) {
							alert("帳號密碼錯誤");
						}
					}
				}
			});
		});
	</script>
</body>
</html>