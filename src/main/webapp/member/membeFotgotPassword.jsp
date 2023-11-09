<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/banner.jsp" flush="true" />
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/memberForgotPassword.css" />
</head>
<body>
	<section class="hero-section d-flex justify-content-center align-items-center" id="forgot">
		<div id="msform">
			<!-- progressbar -->
			<div class="page-title top-lightgrey">
				<h4 class="title main-title-h1">
					<b>忘記密碼?</b>
				</h4>
			</div>

			<ul id="progressbar">
				<li id="step1" class="active">輸入信箱</li>
				<li id="step2" class="active">輸入驗證碼</li>
				<li id="step3" class="active">更改密碼</li>
			</ul>

			<!-- fieldsets -->
			<form id="forgot" method="post" action="<%=request.getContextPath()%>/member/sendemail">
				<fieldset>
					<h2 class="fs-title">輸入信箱</h2><br>
					<input type="text" name="memberemail" value="${param.memberemail}" placeholder="請輸入Email" />
					<input type="hidden" name="action" value="forgot">
					<input type="submit" name="next" class="next-action-button" value="送出" />
				</fieldset>
			</form>
			<fieldset>
				<h2 class="fs-title">輸入驗證碼</h2><br> 
				<input type="text" name="verificationforgot" placeholder="請輸入驗證碼" />
				<input type="button" name="next" class="next-action-button" value="送出" />
			</fieldset>

			<fieldset>
				<h2 class="fs-title">更改密碼</h2><br> 
				<input type="password" name="pass" placeholder="請輸入新密碼" autocomplete="off" />
				<div class="form__field">
					<input type="password" name="cpass" class="form__input" pattern=".{8,}" required placeholder="請再次輸入新密碼" autocomplete="off" />
					<span class="icon"></span>
				</div>
				<input type="button" name="next" class="next-action-button" value="送出" />
			</fieldset>
		</div>
	</section>
	<%-- 	<script src="<%=request.getContextPath()%>/js/bootstrap.bundle.min.js"></script> --%>
	<script>
        const form = document.getElementById("msform");
        const fieldsets = form.querySelectorAll("fieldset");
        const progressBarItems = form.querySelectorAll("#progressbar li");

        let currentStep = 0;

        // 顯示當前步驟 跟 隱藏其他步驟
        function showStep(step) {
            for (let i = 0; i < fieldsets.length; i++) {
                if (i === step) {
                    fieldsets[i].style.display = "block";
                } else {
                    fieldsets[i].style.display = "none";
                }
            }

        }

        // 更新步驟指示條的顏色
        function updateProgressBarColor(step) {
            progressBarItems.forEach((item, index) => {
                if (index <= step) {
                    item.classList.add("active");
                    item.classList.remove("completed");
                } else {
                    item.classList.remove("active");
                    item.classList.remove("completed");
                }
            });
        }
       
        // 初始化表單顯示第一步驟
        showStep(currentStep);
        // 初始化表單顯示第一步驟的颜色
        updateProgressBarColor(currentStep);

        form.addEventListener("click", function (event) {
            if (event.target.classList.contains("next-action-button") && currentStep < fieldsets.length - 1) {
                currentStep++;
                showStep(currentStep);
                updateProgressBarColor(currentStep);
                
            }
        });
    </script>

</body>
</html>