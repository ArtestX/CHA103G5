<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<link rel="icon" type="image/png" href="<%=request.getContextPath()%>/img/backend2.png">
<title>浪愛有家</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap-icons.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/banner.css">
<style>
#messageList {
        position: absolute;
        top: 50px; /* 距離頂部的距離，根據實際需要調整 */
        right: 10px; /* 距離右側的距離，根據實際需要調整 */
       
    }
</style>
</head>
<body>

	<nav class="navbar navbar-expand-lg">
		<div class="container">
			<a class="navbar-brand"
				href="<%=request.getContextPath()%>/index.jsp"> <img
				src="<%=request.getContextPath()%>/img/logo3.png" class="logo img"
				alt="You can Adopt" style="width: 125px; height: 70px">
			</a>

			<div class="d-lg-none ms-auto me-4">
				<a href="<%=request.getContextPath()%>/member/memberLogin.jsp" class="navbar-icon"> 
					<img src="<%=request.getContextPath()%>/img/login.png" alt="Login in" id="loginIcon1">
				</a>

				<form METHOD="post" ACTION="<%=request.getContextPath()%>/member/mem.do" class="form">
					<input type="hidden" name="action" value="logout"> 
					<a href="<%=request.getContextPath()%>/member/mem.do?action=logout" class="navbar-icon"> 
						<img src="<%=request.getContextPath()%>/img/logout.png" alt="Login out" id="logoutIcon1">
					</a>
				</form>
			</div>

			<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav ms-lg-5 me-lg-auto">
					<li class="nav-item">
						<a class="nav-link click-scroll" href="<%=request.getContextPath()%>/index.jsp">
							<b>首頁</b>
						</a>
					</li>

					<li class="nav-item">
						<a class="nav-link click-scroll" href="#">
							<b>最新消息</b>
						</a>
					</li>

					<li class="nav-item">
						<a class="nav-link click-scroll" href="#section_3">
							<b>寵物領養</b>
						</a>
					</li>

					<li class="nav-item">
						<a class="nav-link click-scroll" href="${pageContext.request.contextPath}/mall">
							<b>精選商城</b>
						</a>
					</li>


					<li class="nav-item dropdown hover" id="customerCenter">
						<a class="nav-link click-scroll" href="<%=request.getContextPath()%>/customer/emailService.jsp" id="navbarLightDropdownMenuLink1" role="button" data-bs-toggle="dropdown" aria-expanded="true">
							<b>聯絡我們</b>
						</a>
						<ul class="dropdown-menu dropdown-menu-light border border-top-0" aria-labelledby="navbarLightDropdownMenuLink">
							 <li>
								<a class="dropdown-item" href="<%=request.getContextPath()%>/customer/emailService.jsp">客服信箱</a>
							</li>
						</ul>
					</li>

					<li class="nav-item" id="memberlogin">
						<a class="nav-link click-scroll" href="<%=request.getContextPath()%>/member/memberLogin.jsp" id="memberlogin">
						    <b>會員登入</b>
						</a>
					</li>

					<li class="nav-item dropdown hover" id="membercenter" >
						<a class="nav-link dropdown-toggle" href="#" id="navbarLightDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="true"> 
							<b>會員中心</b>
						</a>

						<ul class="dropdown-menu dropdown-menu-light border border-top-0" aria-labelledby="navbarLightDropdownMenuLink">
							<li>
								<a class="dropdown-item" href="<%=request.getContextPath()%>/member/memberCenter.jsp">會員資料</a>
							</li>

							<li>
								<form METHOD="post"
									ACTION="<%=request.getContextPath()%>/member/mem.do"
									class="form">
									<input type="hidden" name="action" value="logout"> <a
										class="dropdown-item"
										href="<%=request.getContextPath()%>/member/mem.do?action=logout"
										id="memberlogout">登出</a>
								</form>
							</li>
						</ul>
					</li>
				</ul>
			<!-- 	********購物車按鈕********* -->
				<a href="#" class="navbar-icon"> 
   					<img src="<%=request.getContextPath()%>/img/cart.png" alt="Shopping Cart" id="CartIcon">
  				</a>
			<!-- 	********小鈴鐺按鈕********* -->
			<div class="navbar-nav me-lg-2" id="bellicon">
			        <div class="nav-item text-nowrap d-flex align-items-center">
			           <div class="dropdown ps-3">
						    <button type="button" class="btn btn-primary position-relative" id="bellIcon">
						        <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger" id="badge">
						           <!-- 這裡放置未讀消息數字，動態生成 --> 
						        </span>
						    </button>
						
						    <ul class="dropdown-menu notifications-block-wrap bg-white shadow" id="messageList" style="padding:10px;">
						                <!-- 這裡放置消息內容 -->
						    </ul>
						</div>
			        </div>
			    </div>  
				
				<div class="d-none d-lg-block narrow-div">
			<!-- 	********登入按鈕********* -->
					<a href="<%=request.getContextPath()%>/member/memberLogin.jsp" class="navbar-icon"> 
						<img src="<%=request.getContextPath()%>/img/login.png" alt="Login in" id="loginIcon">
					</a>
			<!-- 	********登出按鈕********* -->
					<form METHOD="post" ACTION="<%=request.getContextPath()%>/member/mem.do" class="form">
						<input type="hidden" name="action" value="logout"> 
						<a href="<%=request.getContextPath()%>/member/mem.do?action=logout" class="navbar-icon">
						  <img src="<%=request.getContextPath()%>/img/logout.png" alt="Login out" id="logoutIcon">
						</a>
					</form>	
				</div>	
			</div>
		</div>
		<input type="hidden"  id="userMemberName" value="${user.membername}">
		<!-- 	********搜尋列********* -->
<!-- 		<nav id="search" class="navbar navbar-expand-lg"> -->
<!-- 			<div class="container-fluid"> -->
<!-- 				<form class="d-flex" role="search"> -->
<!-- 					<input class="form-control me-0" type="search" placeholder="Search" -->
<!-- 						aria-label="Search"> -->
<!-- 					<button class="btn btn-outline-success" type="submit">Search</button> -->
<!-- 				</form> -->
<!-- 			</div> -->
<!-- 		</nav> -->
	</nav>


	<!-- JAVASCRIPT FILES -->
	<script src="<%=request.getContextPath()%>/js/bootstrap.bundle.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.5.1/sockjs.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
	<script>
	
		function watchUser() {
			let loginIcon1 = document.getElementById("loginIcon1");
			let logoutIcon1 = document.getElementById("logoutIcon1");
			let loginIcon = document.getElementById("loginIcon");
			let logoutIcon = document.getElementById("logoutIcon");
			let membercenter = document.getElementById("membercenter");
			let memberlogin = document.getElementById("memberlogin");
			let user = document.getElementById("userMemberName").value;
			let bellicon = document.getElementById("bellicon");
			
			if (user === "") {
				loginIcon.style.display = "block";
				loginIcon1.style.display = "block";
				memberlogin.style.display = "block";
				logoutIcon.style.display = "none";
				logoutIcon1.style.display = "none";
				membercenter.style.display = "none";
				bellicon.style.display = "none";
			} else {
				loginIcon.style.display = "none";
				loginIcon1.style.display = "none";
				memberlogin.style.display = "none";
				logoutIcon.style.display = "block";
				logoutIcon1.style.display = "block";
				membercenter.style.display = "block";
				bellicon.style.display = "block";
			}
		}

			watchUser();
			var observer = new MutationObserver(watchUser);
			observer.observe(document.documentElement, {subtree : true,attributes : true
		});
				
			// 連接 WebSocket
			const socket = new SockJS("<%=request.getContextPath()%>/ws");
			const stompClient = Stomp.over(socket);

			// 連接成功後的處理
			stompClient.connect({}, function (frame) {
			    console.log('Connected: ' + frame);

			    // 訂閱主題，監聽新消息
			    stompClient.subscribe('/topic/messages', function (response) {
			        console.log("New message received");
			        const newMessage = JSON.parse(response.body);
			        onNewMessageReceived(newMessage);
			    });
			});

			// 存儲消息的陣列
			const messages = [];

			// 動態更新通知區域
			function updateNotificationArea() {
			    const badge = document.getElementById("badge");
			    const bellIcon = document.getElementById("bellIcon");

			    if (messages.length > 0) {
			        // 有消息時，顯示未讀消息數字和使按鈕可點擊
			        badge.innerText = messages.length > 99 ? '99+' : messages.length;
			        badge.style.display = "block";
			        bellIcon.disabled = false;

			        // 顯示消息內容
			        const messageList = document.getElementById("messageList");
			        messageList.innerHTML = ''; // 清空原有內容

			        messages.forEach(message => {
			            const messageItem = document.createElement("li");
			            messageItem.classList.add("notifications-block", "border-bottom", "pb-2", "mb-2");
			            messageItem.innerHTML = '<b style="font-size:20px;">' + message.title + '</b><br>' + message.content + '<br>' + message.formattedTimestamp;
			            messageList.appendChild(messageItem);
			        });
			    } else {
			        // 沒有消息時，隱藏未讀消息數字並使按鈕不可點擊
			        badge.style.display = "none";
			        bellIcon.disabled = true;
			        messageList.style.display = "none"; // 隱藏消息列表
			    }
			}

			// 動態偵測消息的函數，當有新消息時調用
			function onNewMessageReceived(newMessage) {
			    messages.push(newMessage);
			    console.log(newMessage);
			    updateNotificationArea();
			}

			// 初始化通知區域
			updateNotificationArea();
			
			// 添加事件監聽器，在滑鼠移動到小鈴鐺時顯示消息列表
			bellIcon.addEventListener("mouseover", function() {
			    if (messages.length > 0) {
			        messageList.style.display = "block";
			    }
			});

			// 添加事件監聽器，在滑鼠離開小鈴鐺時隱藏消息列表
			bellIcon.addEventListener("mouseout", function() {
			    messageList.style.display = "none";
			});
	</script>


</body>
</html>