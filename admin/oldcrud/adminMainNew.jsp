<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>員工管理系統</title>
<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
<style>
body {
    
/*     background: #EDEEF0; */
}
.custom-bg-color {
	background-color: #EDEEF0; /* 自定义颜色代码 */
}

.custom-accordion-button {
  background-color: #D1DFE8; /* 自定义颜色代码 */
}

.custom-image {
  max-width: 1050px; /* 调整图片最大宽度 */
  height: 520px; /* 自适应高度 */
  border-radius: 30px; /* 添加圆角 */
}

</style>

</head>
<body>
	<nav class="navbar custom-bg-color">
  <div class="container-fluid">
    <a class="navbar-brand" href="#" --bs-primary-bg-subtle>
      <img src="../img/backpack2-fill.svg" alt="Logo" width="30" height="24" class="d-inline-block align-text-top">
      後臺管理系統
    </a>
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
				      	<strong><a href="#" class="list-group-item list-group-item-action">員工列表</a></strong>
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
			<!--右邊-->
			<div class="col-lg-10 g-3">
			
	
				<div id="carouselExampleDark" class="carousel carousel-dark slide" data-bs-ride="carousel">
				  <div class="carousel-indicators">
				    <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
				    <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="1" aria-label="Slide 2"></button>
				    <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="2" aria-label="Slide 3"></button>
				  </div>
				  <div class="carousel-inner">
				    <div class="carousel-item active" data-bs-interval="2000">
				      <img src="../img/dogg1.jpg" class="d-block w-100 custom-image mx-auto" alt="dogg1">
				    </div>
				    <div class="carousel-item" data-bs-interval="3000">
				      <img src="../img/dogg2.jpeg" class="d-block w-100 custom-image mx-auto" alt="dogg2">
				    </div>
				    <div class="carousel-item" data-bs-interval="4000">
				      <img src="../img/dogg3.jpg" class="d-block w-100 custom-image mx-auto" alt="dogg3">
				    </div>
				  </div>
				  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleDark" data-bs-slide="prev">
				    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
				    <span class="visually-hidden">Previous</span>
				  </button>
				  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleDark" data-bs-slide="next">
				    <span class="carousel-control-next-icon" aria-hidden="true"></span>
				    <span class="visually-hidden">Next</span>
				  </button>
				</div>
			<!--右邊-->
				</div>
		</div>
	</div>
			



	<script src="../js/popper.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
</body>
</html>
