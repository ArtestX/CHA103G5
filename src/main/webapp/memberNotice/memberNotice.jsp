<%@page import="com.cha103g5.admin.service.AdminService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.cha103g5.admin.model.*"%>
<%@ page import="com.cha103g5.admin.service.*"%>
<%@ page import="com.cha103g5.member.model.*"%>

<%
    Object adminAccount = session.getAttribute("adminAccount");                  // 從 session內取出 (key) adminVO的值
    if (adminAccount == null) {                                             // 如為 null, 代表此user未登入過 , 才做以下工作
    	session.setAttribute("location", request.getRequestURI());       		//*工作1 : 同時記下目前位置 , 以便於login.html登入成功後 , 能夠直接導至此網頁
        response.sendRedirect(request.getContextPath()+"/admin/adminLogin.jsp");   //*工作2 : 請該user去登入網頁(login.html) , 進行登入
     	return;
    }
%>

<%
	MemberService mbrSvc = new MemberService();
    List<MemberVO> list = mbrSvc.getAllMembers();
    pageContext.setAttribute("list",list);
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>員工管理系統</title>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.10.0/dist/sweetalert2.all.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/sweetalert2@11.10.0/dist/sweetalert2.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap.min.css">
<style>
body {
            background-image: url('../img/desktop.jpg');
            background-size: cover;
            background-attachment: fixed; 
            background-repeat: no-repeat;
        }
        
 .custom-bg-color { 
/* 	background-color: #EDEEF0; */
	} 


.error-message {
	color: red; /* 設置文字顏色為紅色，你可以根據需要進行調整 */
	margin-top: 5px; /* 設置上邊距，控制它與<input>元素之間的距離 */
	margin-left: 12px;
}
/*****站內通知*******/
    #announcement-form button {
      background-color: #4caf50;
      color: white;
      padding: 10px 15px;
      border: none;
      border-radius: 3px;
      cursor: pointer;
    }

    #announcement-form button:hover {
      background-color: #45a049;
    }
</style>

</head>
<body>
	<nav class="navbar custom-bg-color">
	  <div class="container-fluid">
	    <a class="navbar-brand" href="backendMain.jsp">
	      <img src="<%=request.getContextPath()%>/img/backpack2-fill.svg" alt="Logo" width="30" height="24" class="d-inline-block align-text-top">
	      後臺管理系統
	    </a>
	    <div class="ms-auto">
	      <form method="POST" action="./admin.do">
	      	<button class="btn btn-danger">登出</button>
	      	<input type="hidden" name="action" value="backendlogout">
	      </form>
	    </div>
	  </div>
	</nav>
	<div class="container-fluid">
		<div class="row">
			<!--左邊-->
			<div class="col-lg-2 g-3">
				<div class="accordion" id="accordionExample">
				  <div class="accordion-item">
				    <h2 class="accordion-header">
				      <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
				        員工管理
				      </button>
				    </h2>
				    <div id="collapseOne" class="accordion-collapse collapse" data-bs-parent="#accordionExample">
				      <div class="accordion-body">
				      	<strong><a href="adminSystem.jsp" class="list-group-item list-group-item-action">員工列表</a></strong>
				      </div>
				      <div class="accordion-body">
				      	<strong><a href="#" class="list-group-item list-group-item-action">權限管理</a></strong>
				      </div>
				    </div>
				  </div>
				  <div class="accordion-item">
				    <h2 class="accordion-header">
				      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
				        商品管理
				      </button>
				    </h2>
				    <div id="collapseTwo" class="accordion-collapse collapse" data-bs-parent="#accordionExample">
				      <div class="accordion-body">
						<strong><a href="#" class="list-group-item list-group-item-action">填寫功能名稱</a></strong>
				      </div>
				    </div>
				  </div>
				  <div class="accordion-item">
				    <h2 class="accordion-header">
				      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
				        訂單管理
				      </button>
				    </h2>
				    <div id="collapseThree" class="accordion-collapse collapse" data-bs-parent="#accordionExample">
				      <div class="accordion-body">
						<strong><a href="#" class="list-group-item list-group-item-action">填寫功能名稱</a></strong>
				      </div>
				    </div>
				  </div>
				  <div class="accordion-item">
				    <h2 class="accordion-header">
				      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapse4" aria-expanded="false" aria-controls="collapse4">
				        客服管理
				      </button>
				    </h2>
				    <div id="collapse4" class="accordion-collapse collapse" data-bs-parent="#accordionExample">
				      <div class="accordion-body">
						<strong><a href="#" class="list-group-item list-group-item-action">填寫功能名稱</a></strong>
				      </div>
				    </div>
				  </div>
				  <div class="accordion-item">
				    <h2 class="accordion-header">
				      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapse5" aria-expanded="false" aria-controls="collapse5">
				        寵物領養管理
				      </button>
				    </h2>
				    <div id="collapse5" class="accordion-collapse collapse" data-bs-parent="#accordionExample">
				      <div class="accordion-body">
						<strong><a href="#" class="list-group-item list-group-item-action">填寫功能名稱</a></strong>
				      </div>
				    </div>
				  </div>
				  <div class="accordion-item">
				    <h2 class="accordion-header">
				      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapse6" aria-expanded="false" aria-controls="collapse6">
				        會員資料管理
				      </button>
				    </h2>
				    <div id="collapse6" class="accordion-collapse collapse" data-bs-parent="#accordionExample">
				      <div class="accordion-body">
						<strong><a href="<%=request.getContextPath()%>/member/allMembers.jsp" class="list-group-item list-group-item-action">會員列表</a></strong>
				      </div>
				    </div>
				  </div>
				  <div class="accordion-item">
				    <h2 class="accordion-header">
				      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapse7" aria-expanded="false" aria-controls="collapse7">
				        公告資訊管理
				      </button>
				    </h2>
				    <div id="collapse7" class="accordion-collapse collapse" data-bs-parent="#accordionExample">
				      <div class="accordion-body">
						<strong><a href="#" class="list-group-item list-group-item-action">站內通知</a></strong>
				      </div>
				    </div>
				  </div>
				</div>
			</div>
			<!--左邊-->

			<!--右邊-->
		    <div class="col-md-6 mx-auto mt-4">
		      <div class="card">
		        <div class="card-body">
		          <!-- 發送公告表單 -->
		          <form id="announcement-form">
		            <h3 class="mb-4">發送公告</h3>
		            <div class="mb-3">
		              <label for="announcement-title" class="form-label">公告標題：</label>
		              <input type="text" class="form-control" id="announcement-title" required>
		            </div>
		            <div class="mb-3">
		              <label for="announcement-content" class="form-label">公告內容：</label>
		              <textarea class="form-control" id="messageInput" required></textarea>
		            </div>
		            <button type="submit" class="btn btn-primary" onclick="sendMessage()">發送公告</button>
		          </form>
		        </div>
		      </div>
		    </div>
			<!--右邊-->
		</div>
	</div>

	<script src="<%=request.getContextPath()%>/js/popper.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.5.0/sockjs.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
	<script>
		// 接到WebSocket
        const socket = new SockJS("<%=request.getContextPath()%>/ws");  
        const stompClient = Stomp.over(socket);

        stompClient.connect({}, function (frame) {
            console.log('Connected: ' + frame);
        });

        function sendMessage() {
            const message = $('#messageInput').val();
            stompClient.send("/app/sendToAll", {}, JSON.stringify({ 'message': message }));
        }
    </script>
	
</body>
</html>
