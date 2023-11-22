<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/banner.jsp" flush="true"/>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/datetimepicker/jquery.datetimepicker.css" />
        
<style>
* {
    padding: 0;
    margin: 0;
    list-style: none;
}

.hero-section#sign_up {
    background: url(../img/bg.png) no-repeat center center / cover;
    height: 100vh;
}

.hero-section#sign_up  > :first-child {
    width:700px;
    height: auto;
    padding: 25px;
    background-color: rgba(#000, 0.6);
    border-radius: 50px;
    border: 5px solid #fff;
    box-shadow: 0 0 30px #000;
    backdrop-filter: blur(5px);
    display: flex;
    justify-content: center;
    align-items: center;
    margin-top: 30px;
}

h4 {
    /*註冊會員*/
    color: #422E2F;
    text-align: left;
}

div.col-md-6{ 
    color: #422E2F;
    margin-top: 13px;
    margin-left: 27px;
    width: 250px;
    margin-right: 28px; /* 欄位間距调整 */
}

.login_btn {
    /*註冊按鈕*/
    padding: 13px 5px 0px;
    color: #422E2F;
    text-align: right;
    margin-right: 65px;
    margin-bottom: 0x;
}

.btnAccess {
    /*註冊按鈕*/
    color: #422E2F;
    background-color: #FAE899;
    border: 1px solid  rgba(#eeeaea, 0.5);
    
}

.btnAccess:hover {
	 /*註冊按鈕*/
    background-color: #bae5f3fb;
    box-shadow: 0 1px 4px rgba(64, 64, 64, 1);
}

/* 性别按鈕 */
.btn-outline-primary, .btn-outline-danger {
    color: #422E2F;
    background-color:  rgba(#000, 1);
    border-color: #422E2F; 
    border-radius: 40px;
}

.btn-outline-primary{
    margin-left: 10px;
    margin-right: 10px;
    margin-top: ;
    width: 65px;
}

.btn-outline-danger{
    width: 65px;
}

div.col-md-6 b{ 
    margin-top: 30px;
}

.login_btn img#imgValidate{
    margin-right:350px;
    padding:0px;
}

/*帳號檢查*/
#accountExistsMessage{
    float: right;
    font-size: 14px;
     margin-top: 5px;
}

.form-label {
	/*隱藏密碼*/
      position: relative;
}

.password-toggle{
	/*隱藏密碼*/
         position: absolute;
         top: 44%;
         right: 390px; 
         transform: translateY(-50%); 
		 cursor: pointer; 
		 width: 24px;
}

/*確認密碼檢查*/
#passwordErrorMessage{
	color: red ;
    float: right;
    font-size: 14px;
     margin-top: 5px;
}

font{
	 float: right;
    font-size: 13px;
     margin-top: 5px;
}

@media screen and (max-width: 768px) {
    body {
        min-width: 768px; /* 設置最小寬度 */
    }
}
/*日期欄位*/
  .xdsoft_datetimepicker .xdsoft_datepicker {
           width:  300px;   /* width:  300px; */
  }
  .xdsoft_datetimepicker .xdsoft_timepicker .xdsoft_time_box {
           height: 151px;   /* height:  151px; */
  }

</style>
</head>
<body>
 <section class="hero-section d-flex justify-content-center align-items-center" id="sign_up"> 
        <form class="row g-3" METHOD="post" ACTION="mem.do"  name="form1">
            <div class="page-title top-lightgrey">
                <h4 class="title main-title-h1"><b>註冊會員</b></h4>
            </div>
            
            <input type="hidden" name="memberno" value="${param.memberno}">

            <div class="col-md-6">
                <label for="memberemail" class="form-label"><b>會員帳號(Email)*</b></label><span id="accountExistsMessage" ></span><font color=red>${errorMsgs.memberemail}</font>
                <input type="text"  name="memberemail" value="${param.memberemail}" class="form-control" id="memberemail" placeholder="請輸入E-mail">
            </div>

            <div class="col-md-6">
                <label for="inputname4" class="form-label"><b>會員姓名*</b></label><font color=red>${errorMsgs.membername}</font>
                <input type="text" name="membername" value="${param.membername}" class="form-control" id="inputname4" placeholder="請輸入真實姓名">
            </div>

            <div class="col-md-6">
                <label for="inputPassword4" class="form-label"><b>密碼*</b></label><font color=red>${errorMsgs.memberpassword}</font>
                <input type="password"  name="memberpassword" value="${param.memberpassword}" class="form-control" id="inputPassword4" placeholder="請輸入密碼" autocomplete="off">
               <span class="eye1">
						<img class="password-toggle" id="toggleImage" src="<%=request.getContextPath()%>/img/eyeclose.png" alt="Show Password" onclick="togglePasswordVisibility()">
			   </span>
            </div>
            <div class="col-md-6">
                <label for="inputCheckPassword" class="form-label"><b>確認密碼*</b></label> <span id="passwordErrorMessage"></span><font id="confirmPasswordError" color=red>${errorMsgs.confirmPassword}</font>
                <input type="password" name="confirmPassword" class="form-control" id="inputCheckPassword" placeholder="請再次輸入密碼"  autocomplete="off" >
            </div>
            
            <div class="col-md-6">
                <label for="inputPhone" class="form-label"><b>手機號碼</b></label><font color=red>${errorMsgs.memberphone}</font>
                <input type="text" name="memberphone" value="${param.memberphone}" class="form-control" id="inputPhone">
            </div>
           
            <input name="memberjointime" id="f_date1" type="hidden" >
            
            <div class="col-md-6">
                <label for="f_date2" class="form-label"><b>出生日期</b></label><font color=red>${errorMsgs.memberbirthday}</font>
                <input type="text" class="form-control"  name="memberbirthday" id="f_date2" autocomplete="off">
            </div>
            
            <input type="hidden" name="memberpoints" value=0>
            
            <input type="hidden" name="memberstat" value=0>

            <div class="col-md-6">
                <label for="inputCheckNumber" class="form-label"><b>驗證碼</b></label><font color=red>${errorMsgs.verificationCode}</font>
                <input type="text" name="verificationCode" class="form-control" id="inputCheckNumber" placeholder="請輸入驗證碼">
            </div>

            <div class="col-md-6">
                <b>性別</b>
                	 <input type="radio" name="membergender" value=1  class="btn-check" id="gender_boy">  
                	 <label class="btn btn-outline-primary" for="gender_boy"><b>男</b></label>
                	 
	       			 <input type="radio" name="membergender" value=2  class="btn-check" id="gender_girl">  
	       			 <label class="btn btn-outline-danger" for="gender_girl"><b>女</b></label><br>
	       			 <font color=red>${errorMsgs.membergender}</font>
            </div>

            <div class="login_btn">
                <!--點選圖片可進行驗證碼重新整理-->
                 <img name="imgValidate" id="imgValidate" src="<%=request.getContextPath()%>/member/mem.do"  alt="驗證碼" onclick="refresh()" >
                <!--  圖片驗證 ===================-->
                <input type="hidden" name="action" value="insert">
	            <button class="btn btnAccess" id="loginButton">
	                  <b>註冊</b>
	             </button>
            </div>
        </form>
    </section>
 <% 
  java.sql.Timestamp memberjointime = null;
  try {
	   memberjointime = java.sql.Timestamp.valueOf(request.getParameter("memberjointime").trim());
   } catch (Exception e) {
	   memberjointime = new java.sql.Timestamp(System.currentTimeMillis());
   }
%>

<script src="<%=request.getContextPath()%>/datetimepicker/jquery.js"></script>
<script src="<%=request.getContextPath()%>/datetimepicker/jquery.datetimepicker.full.js"></script>

<script>
$(document).ready(function() {

	
			var timeout;
			$('#memberemail').on('input', function() {
			    clearTimeout(timeout);
			    timeout = setTimeout(function() {
			        var memberemail = $('#memberemail').val();
			        var memailReg = "^[A-Za-z0-9+_.-]+@(.+)$";
			        if (memberemail !== "") {
			        	if (!memberemail.trim().match(memailReg)) {
			                $("#accountExistsMessage").text("不符合信箱格式");
			                $("#accountExistsMessage").css("color", "red");
			            } else {
					            $.ajax({
					                url: "<%=request.getContextPath()%>/member/mem.do?action=checkAccount",
					                method: "POST",
					                data: { "memberemail": memberemail },
					                success: function(data) {
					                    console.log("ttt");
					                    if (data.exists) {
					                        $("#accountExistsMessage").text("此帳號已存在");
					                        $("#accountExistsMessage").css("color", "red");
					                    } else {
					                        $("#accountExistsMessage").text("此帳號可使用");
					                        $("#accountExistsMessage").css("color", "blue");
					                    }
					                },
					                error: function() {
					                    $("#accountExistsMessage").text("檢查帳號有錯誤");
					                }
					            });
			              }      
			        } else {
			            $("#accountExistsMessage").text('');
			        }
			    }, 500); // 500毫秒延迟
			});
			
			var memberemailInput = $("#memberemail");
		    var errorMsgMemberEmail = $("font[color='red']");

		     // 监听输入框的输入事件
		     memberemailInput.on('input', function() {
		        // 获取输入框的值
		        var inputValue = memberemailInput.val();

		        // 如果输入框中有文字，清除错误消息
		        if (inputValue.trim() !== "") {
		            errorMsgMemberEmail.text('');
		        }
		    });

/**************日期****************/	
			$.datetimepicker.setLocale('zh');
			$('#f_date1').datetimepicker({
			    theme: '',              //theme: 'dark',
			   timepicker:false,       //timepicker:true,
			   step: 1,                //step: 60 (這是timepicker的預設間隔60分鐘)
			   format:'Y-m-d H:i:s',         //format:'Y-m-d H:i:s',
			   value: '<%=memberjointime%>', // value:   new Date(),
			   //disabledDates:        ['2017/06/08','2017/06/09','2017/06/10'], // 去除特定不含
			   //startDate:	            '2017/07/10',  // 起始日
			   //minDate:               '-1970-01-01', // 去除今日(不含)之前
			   //maxDate:               '+1970-01-01'  // 去除今日(不含)之後
			});

			$.datetimepicker.setLocale('zh');
			$('#f_date2').datetimepicker({
			   theme: '',              //theme: 'dark',
			    timepicker:false,       //timepicker:true,
			    step: 60,                //step: 60 (這是timepicker的預設間隔60分鐘)
			    format:'Y-m-d',         //format:'Y-m-d H:i:s',
				value: '${param.memberbirthday}', // value:   new Date(),
			   //disabledDates:        ['2017/06/08','2017/06/09','2017/06/10'], // 去除特定不含
			   //startDate:	            '2017/07/10',  // 起始日
			   //minDate:               '-1970-01-01', // 去除今日(不含)之前
			   //maxDate:               '+1970-01-01'  // 去除今日(不含)之後
			});

});
/**************顯示密碼****************/	
	var passwordVisible = false;

	function togglePasswordVisibility() {
		  var password = document.getElementById("inputPassword4");
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
/**************確認密碼****************/	
	var passwordField = document.getElementById("inputPassword4");
	var checkPasswordField = document.getElementById("inputCheckPassword");
	var passwordErrorMessage = document.getElementById("passwordErrorMessage");
	var confirmPasswordError = document.getElementById("confirmPasswordError");

	checkPasswordField.addEventListener("blur", checkPasswordMatch);

	function checkPasswordMatch() {
	    var password = inputPassword4.value;
	    var checkPassword = inputCheckPassword.value;

	    if (password === checkPassword) {
	        passwordErrorMessage.textContent = "";
	        passwordErrorMessage.style.display = "none";
	    } else {
	        passwordErrorMessage.textContent = "密碼不一致";
	        passwordErrorMessage.style.display = "block";
	        confirmPasswordError.style.display = "none";
	    }

	}
	/**************驗證碼刷新************/	
	document.getElementById("imgValidate").addEventListener("click", refresh, { passive: true });
	
	function refresh() {
	    var imgValidate = document.getElementById("imgValidate");
	    var currentSrc = imgValidate.src;
	    var newSrc = (currentSrc.indexOf("?") === -1) ? currentSrc + "?id=" + Math.random() : currentSrc.replace(/(\?id=\d+)/, "?id=" + Math.random());
	    imgValidate.src = newSrc;

	} 
	
</script>        

</body>
</html>