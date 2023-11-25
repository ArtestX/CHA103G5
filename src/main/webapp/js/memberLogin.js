/**
 * 
 */
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
	
	