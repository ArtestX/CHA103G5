<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.cha103g5.admin.model.*"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>員工管理系統</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/sweetalert2.css">

	<!-- 傳送icon圖片 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css" integrity="sha384-b6lVK+yci+bfDmaY1u0zE8YYJt0TZxLEAFyYSLHId4xoVvsrQu3INevFKo+Xir8e" crossorigin="anonymous" />
    
    <!-- 後台客服css -->
    <link href="<%=request.getContextPath()%>/css/backchat.css" rel="stylesheet">
    
<style>
body {
            background-image: url('<%=request.getContextPath()%>/img/desktop.jpg');
            background-size: cover;
            background-attachment: fixed;
            background-repeat: no-repeat;
        }
</style>

</head>
<body onload="connect();" onunload="disconnect();">
	<nav class="navbar custom-bg-color">
  <div class="container-fluid">
    <a class="navbar-brand" href="<%=request.getContextPath()%>/admin/backendMain.jsp">
      <img src="<%=request.getContextPath()%>/img/backpack2-fill.svg" alt="Logo" width="30" height="24" class="d-inline-block align-text-top">
      後臺管理系統
    </a>
    <div class="ms-auto">
      <form method="POST" action="<%=request.getContextPath()%>/admin/admin.do">
      	<button class="btn btn-danger">登出</button>
      	<input type="hidden" name="action" value="backendlogout">
      </form>
    </div>
  </div>
</nav>
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-2 g-3">
			<!--左邊-->
				<div class="accordion" id="accordionExample">
				  <div class="accordion-item">
				    <h2 class="accordion-header">
				      <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
				        員工管理
				      </button>
				    </h2>
				    <div id="collapseOne" class="accordion-collapse collapse" data-bs-parent="#accordionExample">
				      <div class="accordion-body">
				      	<strong><a href="<%=request.getContextPath()%>/admin/adminSystem.jsp" class="list-group-item list-group-item-action" onclick="return checkAdminStat();">員工列表</a></strong>
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
						<strong><a href="<%=request.getContextPath()%>/customer/backChat.jsp" class="list-group-item list-group-item-action">即時客服</a></strong>
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
						<strong><a href="#" class="list-group-item list-group-item-action">填寫功能名稱</a></strong>
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
						<strong><a href="#" class="list-group-item list-group-item-action">填寫功能名稱</a></strong>
				      </div>
				    </div>
				  </div>
				</div>
			</div>
			<!--左邊-->
			
			<div class="col-lg-10 g-3">
			<!--右邊-->
			<!-- chat-area -->
    <section class="chatroom-area">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <div class="chat-area">
                        <!-- chatlist -->
                        <div class="chatlist">
                            <div class="modal-dialog-scrollable">
                                <div class="modal-content">
                                    <div class="chat-header">
                                        <ul class="nav nav-tabs " id="myTab" role="tablist">
                                            <li class="nav-item " role="presentation">
                                                <span style="margin: 0px 95px;">聊天室清單</span>
                                            </li>
                                        </ul>
                                    </div>

                                    <div class="modal-body">
                                        <!-- users -->
                                        <div class="chat-lists">
                                            <div class="tab-content" id="myTabContent">
                                                <!-- online-users -->
                                                <div class="tab-pane fade show active" id="Open" role="tabpanel"
                                                    aria-labelledby="Open-tab">

                                                    <div class="chat-list" id="online-list">

                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <!-- users -->
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- chatlist -->

                        <!-- chatbox -->
                        <div class="chatbox">
                            <div class="modal-dialog-scrollable">
                                <div class="modal-content" id="chatbox">
                                    <!--  style="display: none;"-->
                                    <div class="msg-head">
                                        <div class="row">
                                            <div class="d-flex align-items-center">
                                                <div class="flex-shrink-0" id="userImg"></div>
                                                <div class="flex-grow-1 ms-3">
                                                    <!-- 會員姓名 -->
                                                    <h3 id="userName"></h3>
                                                    <div id="userEmail" style="display: none"></div>
                                                </div>

                                            </div>

                                        </div>

                                    </div>

                                    <div class="modal-body" id="modal-body">
                                        <div class="msg-body">
                                            <ul id="message-list">

                                            </ul>
                                        </div>
                                    </div>

                                    <div class="send-box">
                                        <form autocomplete="off">
                                            <input type="text" class="form-control" id="btn-input" placeholder="Enter a message"/>

                                            <button id="btn-chat" type="button" onclick="sendMessage();"><i
                                                    class="bi bi-send-fill text-white"></i></button>
                                        </form>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- chatbox -->
                </div>
            </div>
        </div>
    </section>
					
			<!--右邊-->
			</div>
		</div>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/backchat.js"></script>
	<script src="<%=request.getContextPath()%>/js/popper.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/sweetalert2.all.min.js"></script>

	<script>
		function checkAdminStat() {
			let adminStat = <%= session.getAttribute("adminStat") %>;
			if (adminStat === 1) {
				Swal.fire({
					icon: 'error',
					title: '權限不足!!',
					text: '請聯繫系統管理員',
					showConfirmButton: false,
					timer: 2500
				})
				return false;
			}
			return true;
		}
	</script>

</body>
</html>
