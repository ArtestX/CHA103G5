<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/banner.jsp" flush="true" />
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/memberForgotPassword.css" />
<style>
.form__input:valid + .icon::after { 
  content: '😃';
  font-size: 1.5rem; 
}

.form__input:invalid + .icon::after {
  content: '😳';
  font-size: 1.5rem; 
}

#msform input[name="memberpassword"] {
    margin-bottom: 13px; /* 增加底頂部間距 */
}

#msform input[name="confirmPassword"] {
    margin-top: 13px; /* 增加頂部間距*/
}

.fs-title {
	/*隱藏密碼*/
      position: relative;
}

.password-toggle{
	/*隱藏密碼*/
         position: absolute;
         top: 31%;
         right: 50px; 
         transform: translateY(-50%); 
		 cursor: pointer; 
		 width: 24px;
}

</style>
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
					<input type="text" name="memberemail" value="${param.memberemail}"  placeholder="請輸入Email"  />
					<font color=red>${errorMsgs.memberemail}</font>
					<font color=red>${errorMsgs.forgotpassword}</font><br>
					<input type="hidden" name="action" value="forgot">
					<input type="submit" name="next"  id="forgotpassword"  class="next-action-button" value="送出" />
				</fieldset>
			</form>
			
			<form id="verificationforgot" method="post" action="<%=request.getContextPath()%>/member/sendemail">
				<fieldset>
					<input type="hidden" name="memberemail" value="${param.memberemail}">
					<h2 class="fs-title">輸入驗證碼</h2><br> 
					<input type="text" name=verification value="${param.verification}" placeholder="請輸入驗證碼" />
					<font color=red>${errorMsgs.verification}</font><br>
					<input type="hidden" name="action" value="verificationforgot">
					<input type="submit" name="next"  class="next-action-button" value="送出" />
				</fieldset>
			</form>
			
			<form id="changePassword" method="post" action="<%=request.getContextPath()%>/member/sendemail">
				<fieldset>
					<h2 class="fs-title">更改密碼</h2>
					<input type="password" name="memberpassword" value="${param.memberpassword}" id="inputPassword" placeholder="請輸入新密碼" autocomplete="off" />
					<span class="eye1">
						<img class="password-toggle" id="toggleImage" src="<%=request.getContextPath()%>/img/eyeclose.png" alt="Show Password" onclick="togglePasswordVisibility()">
			 		</span>
					<font  id="passwordError" color=red>${errorMsgs.memberpassword}</font>
					<div class="form__field">
						<input type="password" name="confirmPassword" class="form__input" pattern=".{8,}" required placeholder="請再次輸入新密碼" autocomplete="off" />
						<span class="icon"></span>
					</div>
					<font color=red>${errorMsgs.confirmPassword}</font><br>
					<input type="hidden" name="memberemail" value="${param.memberemail}">
					<input type="hidden" name="action" value="changePassword">
					<input type="submit" name="next" class="next-action-button" value="送出" />
				</fieldset>
			</form>
		</div>
	</section>
    	<script>
		        const form = document.getElementById("msform");
		        const fieldsets = form.querySelectorAll("fieldset");
		        const progressBarItems = form.querySelectorAll("#progressbar li");
		        var isStepOneCompleted = <%= request.getAttribute("isForgotStepOneCompleted") %>;
		    	var isStepTwoCompleted = <%= request.getAttribute("isForgotStepTwoCompleted") %>;
		
		    	// 初始化 currentStep
		    	let currentStep = 0;
		    	 // 初始化表單顯示第一步驟
 		        showStep(currentStep);
		        // 初始化表單顯示第一步驟的颜色
		        updateProgressBarColor(currentStep);
		
		    	console.log(isStepOneCompleted);
		    	console.log(isStepTwoCompleted);
		    	
			        // 顯示當前步驟 跟 隱藏其他步驟
			        function showStep(step) {
			        	if (isStepOneCompleted) {//確保在第2步驟時，不會跳回第1步驟
			                fieldsets[0].style.display = "none";
			                fieldsets[2].style.display = "none";
			                updateProgressBarColor(1);
			                showStep(1);
			            }else if (isStepTwoCompleted) {//確保在第3步驟時，不會跳回第1.2步驟
			                fieldsets[0].style.display = "none";
			                fieldsets[1].style.display = "none";
			                updateProgressBarColor(2);
			                showStep(2);
			            }else{
			            	for (let i = 0; i < fieldsets.length; i++) {
			                    if (i === step) {
			                        fieldsets[i].style.display = "block";
			                    } else {
			                        fieldsets[i].style.display = "none";
			                    }
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
		       
		        form.addEventListener("click", function (event) {
		            if (event.target.classList.contains("next-action-button") && currentStep < fieldsets.length - 1) {
		                currentStep++;
		                showStep(currentStep);
		                updateProgressBarColor(currentStep);
		            }
		            
		        });
		        
		        /**************顯示密碼****************/	
		    	var passwordVisible = false;

		    	function togglePasswordVisibility() {
		    		  var password = document.getElementById("inputPassword");
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