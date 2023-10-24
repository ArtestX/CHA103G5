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
            background-image: url('../img/desktop.jpg');
            background-size: cover;
            background-attachment: fixed; /* 可选，固定背景图片 */
            background-repeat: no-repeat;
        }
        
</style>

</head>
<body>
	<nav class="navbar custom-bg-color">
  <div class="container-fluid">
    <a class="navbar-brand" href="/admin/backendMain.jsp">
      <img src="../img/backpack2-fill.svg" alt="Logo" width="30" height="24" class="d-inline-block align-text-top">
      後臺管理系統
    </a>
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
			
				
				
				
			<!--右邊-->
			</div>
		</div>
	</div>
			



	<script src="../js/popper.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
</body>
</html>
