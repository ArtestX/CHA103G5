<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.cha103g5.member.model.*"%>
<%@ page import="java.util.*"%>
<jsp:include page="/banner.jsp" flush="true" />

<%
	// 把MemberVO的資料從session取出
	com.cha103g5.member.model.MemberVO user = (com.cha103g5.member.model.MemberVO) session.getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/memberCenter.css" />

</head>
<body>
<div class="container">
	<div class="row">
		<!-- ----------left start---------- -->
		<div class="col-md-9">
			<!-- ----------title--------- -->
			<div class="row">
				<div class="col-md-12">
					<img src="${pageContext.request.contextPath}/img/MBRcenter2.png" class="title-icon">
					<h2 class="title-c-1 d-inline-block align-bottom mb-0 pl-10">
					 	會員基本資料
					</h2>
					<input type="hidden" name="memberno" value="${user.memberno}">
				</div>
			</div>
			
			<!-- ----------user-top-information--------- -->
			<div class="row">	
				<div class="user-info col-md-3">
				<form method="post" enctype="multipart/form-data" action="mem.do" name="form1">
					<label for="fileInput" class="img-box"> 
						<c:choose>
						    <c:when test="${not empty user.memberpic}">
						        <img id="finalImg1" name="memberpic" src="<%=request.getContextPath()%>/ReadMbrIMG?id=${user.memberno}">
						    </c:when>
						    <c:otherwise>
						        <img id="finalImg1" name="memberpic" src="<%=request.getContextPath()%>/img/member.png">
						    </c:otherwise>
						</c:choose>
						<img  src="${pageContext.request.contextPath}/img/camera.png" class="camera-icon">
					</label> 
					<input type="file" name="memberpic" id="fileInput" style="display: none;" value="${param.memberpic}" onchange="showSubmitButton()">
					<input type="hidden" name="memberemail"value="${user.memberemail}"> 
					<input type="hidden" name="action" value="updatePic">
					<input type="submit" id="checkmemberpic" value="確定" style="display: none">
				</form>
				</div>
				
				<div class="user-info col-md-9">
					<div id="memberData" class="member-data">
						<form method="post" action="<%=request.getContextPath()%>/member/sendemail">
						<input type="submit"  id="resendButton" onclick="resendVerification()" value="重新發送驗證信">
							<strong style="margin-top:-30px;">
								會員帳號(Email)
								<span>${user.memberemail}</span>
								<c:choose>
								    <c:when test="${user.memberstat == 0}">
								        <div id="status" class="status unverified">未認證</div>
								    </c:when>
								    <c:when test="${user.memberstat != 0}">
								        <div id="status" class="status verified">已認證</div>
								    </c:when>
								</c:choose>
							</strong>
							<input type="hidden" name="memberemail"value="${user.memberemail}"> 
							<input type="hidden" name="action" value="verificationResendEmail">
						
						</form>
						<div></div> <!-- 調整間距 -->
						<strong>
							會員密碼
							<span>
								<button type="button" class="btn btn-default"  onclick="togglePasswordFields()">修改密碼</button>
							</span> 
						</strong> 
						<form method="post" action="mem.do" name="form2">
						<div class="password-col" style="display: none; margin-top:-10px;">
							 <div class="row"> 
								 <div class="col-md-5"> 
									 <input type="password" id="memberPassword" class="form-control radius-4" placeholder="請輸入新密碼"  autocomplete="off"> 
									 <font id="passwordError">${errorMsgs.memberpassword}</font>
									  <span class="eye1">
											<img class="password-toggle" id="toggleImage" src="<%=request.getContextPath()%>/img/eyeclose.png" alt="Show Password" onclick="togglePasswordVisibility()">
								   </span>
								</div> 
								
								<div class="col-md-5">
									 <input type="password" id="confirmPassword" class="form-control radius-4" placeholder="請再次輸入新密碼" autocomplete="off">
									  <font id="checkpasswordError">${errorMsgs.confirmPassword}</font>
								</div>
								<input type="hidden" name="memberemail"value="${user.memberemail}"> 
								<input type="hidden" name="action" value="updatePassword">
								<input type="submit"  id="checkmemberpassword" value="確定">
							</div>
						</div>
						</form>
					</div>
				</div>
			</div>	
			<!-- ----------user-information--------- -->
			<form method="post"  action="mem.do" name="form1">
			<div class="row">
				<div class="col-md-4">
					<div class="form-group">
							<font color=red>${errorMsgs.membername}</font> 
							<label class="control-label col-form-label"> 會員姓名 </label> 
							<input type="text" class="form-control radius-4" name="membername" value="${user.membername}">
					</div>
				</div>				
		
				<div class="col-md-4">
					<div class="form-group">
						<font color=red>${errorMsgs.membergender}</font> 
					 	<label class="control-label col-form-label"> 會員性別 </label>
						<select class="form-control" name="membergender">
							<option value=0 ${empty user.membergender? '請選擇性別' : user.membergender}>請選擇性別</option>
							<option value=1 ${user.membergender == 1 ? 'selected' : ''}>男</option>
							<option value=2 ${user.membergender == 2 ? 'selected' : ''}>女</option>
						</select>
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="col-md-4">
					<div class="form-group">
						<font color=red>${errorMsgs.memberid}</font> 
						<label class="control-label col-form-label"> 身分證 </label>
						<input type="text" name="memberid"	value="${empty user.memberid ? '尚未填寫' : user.memberid}" class="form-control dtpicker-datetoday">
					</div>
				</div>

				<div class="col-md-4">
					<div class="form-group">
						<font color=red>${errorMsgs.memberbirthday}</font> 
						<label class="control-label col-form-label"> 出生日期 </label> 
						<input type="date" name="memberbirthday" value="${empty user.memberbirthday ? '尚未填寫' : user.memberbirthday}" class="form-control dtpicker-datetoday">
					</div>
				</div>
			</div>
		
			<div class="row">
				<div class="col-md-4">	
					<div class="form-group">
						<font color=red>${errorMsgs.memberphone}</font> 
						<label class="control-label col-form-label"> 手機號碼 </label> 
						<input type="text" class="form-control radius-4" name="memberphone" value="${empty user.memberphone ? '尚未填寫' : user.memberphone}">
					</div>
				</div>
				
				<div class="col-md-4">	
					<div class="form-group">
						<label class="control-label col-form-label"> 職業 </label>
						<input type="text" class="form-control radius-4" name="memberjob" value="${empty user.memberjob ? '尚未填寫' : user.memberjob}">
					</div>
				</div>
			</div>	
			
			<div class="twzipcode">
				  <div class="row">
					   <div class="col-md-4">
						    <label class="control-label col-form-label"> 縣市 </label> 
						    <select data-role="county" name="county" class="form-select"></select>
					   </div>
					   
				  		<input type="hidden" name="zipcode" data-role="zipcode" />
					   <div class="col-md-4">
						    <label class="control-label col-form-label"> 鄉鎮市區 </label> 
						    <select data-role="district" name="district" class="form-select"></select>
					   </div>
				 </div>
				 
				  <div class="row">
					   <div class="col-md-8">
						    <label class="control-label col-form-label"> 詳細地址 </label>
						     <input  type="text" name="address" class="form-control">
					   </div>
				  </div>
			 </div>
			
			<input type="hidden" name="membercard" />
			
			<div class="row">
				<div class="col-md-4">
					<div class="form-group">
						<label class="control-label col-form-label"> 收入 </label>
							<select class="form-control" name="membersal">
								<option value=3 ${empty user.membersal ? '請選擇收入' : user.membersal}>請選擇收入</option>
								<option value=0 ${user.membersal == 0 ? 'selected' : ''}>30W~ 50W</option>
								<option value=1 ${user.membersal == 1 ? 'selected' : ''}>50w~ 80W</option>
								<option value=2 ${user.membersal == 2 ? 'selected' : ''}>80WUP</option>
							</select>
					</div>
				</div>
				
				<div class="col-md-4">
					<div class="form-group">
						<div class="btn-box">
							<input type="hidden" name="memberemail"value="${user.memberemail}"> 
							<input type="hidden" name="action" value="update">
							<button  id="check_btn">
								<div class="scene">
								  <div class="cube">
								    <span class="side top">確定送出</span>
								    <span class="side front">儲存</span>
								  </div>
								</div>
							</button>	
						</div>		
					</div>
				</div>	
			</div>	
		</form>
		</div>
		<!-- ----------left end---------- -->
		<!-- ----------right start---------- -->
		<div class="col-md-3">
			<div class="card" >
				<div class="card-header">
					<c:out value="您好，${user.membername}！" />
				</div>
				
				<ul class="list-group list-group-flush">
					<li class="list-group-item">
						<a href="<%=request.getContextPath()%>/member/memberCenter.jsp">基本資料</a>
					</li>
<%--					<li class="list-group-item">--%>
<%--						<a href="#">訂單管理</a>--%>
<%--					</li>							--%>
					<li class="list-group-item">
						<a href="#" onclick="document.getElementById('orderForm').submit();">訂單明細</a>
						<form style="display: none;" id="orderForm" action="${pageContext.request.contextPath}/orderTableServlet" method="GET">
							<input type="hidden" name="action" value="getByMemberNoFrontend">
							<input type="hidden" name="memberNo" value="${user.memberno}">
						</form>
					</li>

					<li class="list-group-item">
						<a href="#" onclick="document.getElementById('applicationForm').submit();">預約詳情</a>
						<form style="display: none;" id="applicationForm" action="${pageContext.request.contextPath}/adoptedApplicationHibernateServletTemp" method="GET">
							<input type="hidden" name="action" value="frontendGetByMemberNo">
							<input type="hidden" name="memberNo" value="${user.memberno}">
						</form>
					</li>
				</ul>				
			</div>
		</div>
		<!-- ----------right end---------- -->
	</div>
</div>
<jsp:include page="/footer.jsp" flush="true" />
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script src="<%=request.getContextPath()%>/js/twzipcode.min.js"></script>
    
<script>
/************顯示修改密碼************/
function togglePasswordFields() {
	var passwordFields = document.querySelector('.password-col');
	passwordFields.style.display = (passwordFields.style.display === 'none') ? 'block' : 'none';

	// 添加或移除 show-password 類別
    var memberData = document.getElementById('memberData');
    memberData.classList.toggle('show-password');
    
 // 添加或移除 name 屬性
    var memberPasswordInput = document.getElementById('memberPassword');
    var confirmPasswordInput = document.getElementById('confirmPassword');

    if (passwordFields.style.display === 'block') {
        memberPasswordInput.setAttribute('name', 'memberpassword');
        confirmPasswordInput.setAttribute('name', 'confirmPassword');
    } else {
        memberPasswordInput.removeAttribute('name');
        confirmPasswordInput.removeAttribute('name');
    }
}	

/************顯示密碼內容************/
var passwordVisible = false;

function togglePasswordVisibility() {
	  var password = document.getElementById("memberPassword");
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
/************檢查密碼內容************/
var passwordRegex = /^(?![\s])(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d@#$%^&+=!]{8,30}$/;
var passwordInput = document.getElementById('memberPassword');
var confirmPasswordInput = document.getElementById('confirmPassword');
var passwordError = document.getElementById('passwordError');
var checkpasswordError = document.getElementById('checkpasswordError');


passwordInput.addEventListener('blur', function () {
    var isValidPassword = passwordRegex.test(passwordInput.value);
    passwordError.innerHTML = isValidPassword ? '' : '請設定8碼以上(含字母跟數字)';
    passwordError.style.display = isValidPassword ? 'none' : 'block';
});

confirmPasswordInput.addEventListener('blur', function () {
	 var isMatch = confirmPasswordInput.value === passwordInput.value;
	 checkpasswordError.innerHTML = isMatch ? '' : '密碼不一致';
	 checkpasswordError.style.display = isMatch ? 'none' : 'block';
});
/************提交修改密碼表單************/
function showSuccessAlert() {
    return Swal.fire({
        icon: "success",
        title: "成功更換密碼",
        text: "您的密碼已成功更換",
        confirmButtonText: "OK",
        iconHtml: '<img src="<%=request.getContextPath()%>/img/v.png " width="50" height="50">',
    });
}

document.forms['form2'].addEventListener('submit', async function (e) {
    if (passwordInput.value === confirmPasswordInput.value) {
        e.preventDefault(); 
        await showSuccessAlert();
        document.forms['form2'].submit();
    }
});
/************隱藏檔案送出按鈕************/
function showSubmitButton() {
    var fileInput = document.getElementById('fileInput');
    var checkmemberpic = document.getElementById('checkmemberpic');
    checkmemberpic.style.display = fileInput.files.length > 0 ? 'block' : 'none';
}

function validateForm() {
    var fileInput = document.getElementById('fileInput');
    if (fileInput.files.length === 0) {
        alert('請選擇一個檔案');
        return false;
    }
    return true;
}

document.addEventListener('DOMContentLoaded', function () {
    const statusElement = document.getElementById('status');
    const resendButton = document.getElementById('resendButton');

    function updateStatus() {
        const user = ${user.memberstat};
        console.log(user);

        if (user === 0) {
            statusElement.innerHTML = '未認證';
            statusElement.classList.add('unverified');
            resendButton.style.display = 'block';
        } else {
            statusElement.innerHTML = '已認證';
            statusElement.classList.add('verified');
            resendButton.style.display = 'none';
        }
    }

    // 初始更新
    updateStatus();

 // 使用 EL 語法獲取後端的值
    var addressString = "${user.memberaddress}";
	    // 找到市的位置
	 var cityIndex = addressString.indexOf("市");
	 var countyIndex = addressString.indexOf("縣");
	 var cityOrCountyIndex = -1;
	 
	 // 如果 cityIndex 和 countyIndex 都非負，取第一個出現的索引
	 if (cityIndex >= 0 && countyIndex >= 0) {
	     cityOrCountyIndex = Math.min(cityIndex, countyIndex);
	 } else {
	     // 取非負的索引，如果有一個是負的就取另一個
	     cityOrCountyIndex = Math.max(cityIndex, countyIndex);
	 }
	 
	 let twzipcode = new TWzipcode({
		 "district" : {
		  onChange : function(id) {
		   console.log(this.nth(id).get());
		  }
		 }
		});
	
	 ////////////////////////////// 使用正則表達式匹配以市或縣結尾的數字部分
	    var match = addressString.match(/(?:市|縣)(\d+)/);
	
	    // 如果有匹配，取得匹配的結果
	    var numberPart = match ? match[1] : null;
	
	    var numberAsInt = parseInt(numberPart, 10);
	 ///////////////////////////////////////// 在控制台上輸出結果
	    
	    // 定義可能的行政區域
	    var regions = ["區", "鄉", "鎮", "市"];
	
	    // 初始化變數
	    var regionIndex = -1;
	
	    // 尋找可能的行政區域
	    for (var i = 0; i < regions.length; i++) {
	        var index = addressString.indexOf(regions[i]);
	        if (index !== -1 && (regionIndex === -1 || index < regionIndex) && index > cityOrCountyIndex) {
	            regionIndex = index;
	        }
	    }
	
	    // 提取行政區域名稱
	    var districtOrTown = addressString.substring(cityOrCountyIndex + 1, regionIndex + 1);
	
	    // 剩下的部分視為具體地址
	    var addressPart = addressString.substring(regionIndex + 1);
	
	    
	    twzipcode.nth(1).set(numberAsInt);
	
	   
	    $('input[name="address"]').val(addressPart);
	    
	});
</script>
</body>
</html>
