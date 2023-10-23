<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="icon" type="image/png" href="./img/backend.png">
    <title>
        浪愛有家
    </title>
    <link rel="stylesheet" href="./css/bootstrap.min.css">
    <link rel="stylesheet" href="./css/bootstrap-icons.css">
    
    <style>
    	.navbar {
		    position: sticky;;
		    top: 0;
		    z-index: 1000; /* 確定導覽列在其他元素上層顯示 */
		    background-color: #FAE899; 
		}
		
		.nav-item b{
			color: #422E2F;
			font-size: 20px;
		}		
    </style>
</head> 
<body>
	<nav class="navbar navbar-expand-md">
		<div class="container">
			<a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp"> 
				<img src="./img/logo3.png" class="logo img" alt="You can Adopt" style="width: 125px; height: 75px">
			</a>

			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNav"
				aria-controls="navbarNav" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav" style="margin-right: auto">
					<li class="nav-item"><a class="nav-link click-scroll"
						href="${pageContext.request.contextPath}/index.jsp">
						<b>首頁</b></a></li>

					<li class="nav-item"><a class="nav-link click-scroll"
						href="#section_2"><b>最新消息</b></a></li>

					<li class="nav-item"><a class="nav-link click-scroll"
						href="#section_3"><b>寵物領養</b></a></li>

					<li class="nav-item"><a class="nav-link click-scroll"
						href="#section_4"><b>精選商城</b></a></li>

					<li class="nav-item"><a class="nav-link click-scroll"
						href="#section_5"><b>聯絡我們</b></a></li>

					<!-- <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarLightDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">Pages</a>

                    <ul class="dropdown-menu dropdown-menu-light" aria-labelledby="navbarLightDropdownMenuLink">
                        <li><a class="dropdown-item" href="topics-listing.html">Topics Listing</a></li>

                        <li><a class="dropdown-item" href="contact.html">Contact Form</a></li>
                    </ul>
                </li> -->
				</ul>

				<div class="d-none d-lg-block">
					<a href="${pageContext.request.contextPath}/memberlogin.jsp" class="navbar-icon"> <img src="./img/login.png"  id="login"  alt="Login in"></a> 
					<a href="#top" class="navbar-icon"> <img src="./img/logout.png" id="logout" alt="Login out"></a> 
				
				</div>
			</div>
		</div>
	</nav>

	<!-- JAVASCRIPT FILES -->
	<script src="./js/bootstrap.bundle.min.js"></script>
	<script src="./js/bootstrap.min.js"></script>
	<script>
		document.addEventListener("DOMContentLoaded", function() {
	        var loginIcon = document.getElementById("login");
	        var logoutIcon = document.getElementById("logout");
	        var userLoggedIn = false; 

	        if (userLoggedIn) {
	            loginIcon.style.display  = "none";
	            logoutIcon.style.display = "block";
	        } else {
	            loginIcon.style.display  = "block";
	            logoutIcon.style.display = "none";
	        }
	    });
	</script>

</body>
</html>