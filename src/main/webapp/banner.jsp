<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<link rel="icon" type="image/png" href="<%=request.getContextPath()%>/img/backend2.png">
<title>浪愛有家</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap-icons.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/banner.css">
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
						<a class="nav-link click-scroll" href="<%=request.getContextPath()%>/member/select_page.jsp">
							<b>最新消息</b>
						</a>
					</li>

					<li class="nav-item">
						<a class="nav-link click-scroll" href="#section_3">
							<b>寵物領養</b>
						</a>
					</li>

					<li class="nav-item">
						<a class="nav-link click-scroll" href="#section_4">
							<b>精選商城</b>
						</a>
					</li>

					<li class="nav-item dropdown hover" id="customerCenter">
						<a class="nav-link click-scroll" href="#section_5" id="navbarLightDropdownMenuLink1" role="button" data-bs-toggle="dropdown" aria-expanded="true">
							<b>聯絡我們</b>
						</a>
						<ul class="dropdown-menu dropdown-menu-light border border-top-0" aria-labelledby="navbarLightDropdownMenuLink">
							<li>
								<a class="dropdown-item" href="<%=request.getContextPath()%>/customer/chat.jsp">即時客服</a>
							</li>

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

					<li class="nav-item dropdown hover" id="membercenter">
						<a class="nav-link dropdown-toggle" href="#" id="navbarLightDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="true"> 
							<b>會員中心</b>
						</a>

						<ul class="dropdown-menu dropdown-menu-light border border-top-0" aria-labelledby="navbarLightDropdownMenuLink">
							<li>
								<a class="dropdown-item" href="<%=request.getContextPath()%>/member/listAllMbr.jsp">會員資料</a>
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
				<button type="button" class="btn btn-primary position-relative" id="bellIcon">
<!--   		 			<span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger"> -->
<!--     						99+ -->
<!--    						<span class="visually-hidden">unread messages</span> -->
<!--   		 			</span> -->
        		</button>

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
		<input type="hidden" value="${user.membername}">
		<!-- 	********搜尋列********* -->
		<nav id="search" class="navbar navbar-expand-lg">
			<div class="container-fluid">
				<form class="d-flex" role="search">
					<input class="form-control me-0" type="search" placeholder="Search"
						aria-label="Search">
					<button class="btn btn-outline-success" type="submit">Search</button>
				</form>
			</div>
		</nav>
	</nav>


	<!-- JAVASCRIPT FILES -->
	<script src="<%=request.getContextPath()%>/js/bootstrap.bundle.min.js"></script>
	<script>
	
		function watchUser() {
			let loginIcon1 = document.getElementById("loginIcon1");
			let logoutIcon1 = document.getElementById("logoutIcon1");
			let loginIcon = document.getElementById("loginIcon");
			let logoutIcon = document.getElementById("logoutIcon");
			let membercenter = document.getElementById("membercenter");
			let memberlogin = document.getElementById("memberlogin");
			let user = "${sessionScope.user}";

			if (user === "") {
				loginIcon.style.display = "block";
				loginIcon1.style.display = "block";
				memberlogin.style.display = "block";
				logoutIcon.style.display = "none";
				logoutIcon1.style.display = "none";
				membercenter.style.display = "none";
			} else {
				loginIcon.style.display = "none";
				loginIcon1.style.display = "none";
				memberlogin.style.display = "none";
				logoutIcon.style.display = "block";
				logoutIcon1.style.display = "block";
				membercenter.style.display = "block";
			}
		}

			watchUser();
			var observer = new MutationObserver(watchUser);
			observer.observe(document.documentElement, {subtree : true,attributes : true
		});
				
	</script>

</body>
</html>