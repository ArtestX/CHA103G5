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

table {
  width: 100%;
  overflow: auto; /* 添加水平滾動條 */
  border-collapse: collapse; /* 合併表格邊框 */
}

th, td {
  white-space: nowrap; /* 防止文字折行 */
  overflow: visible; /* 允許文字溢出 td 元素 */
  text-overflow: ellipsis; /* 如果文字溢出，用省略號表示 */
  vertical-align: middle; /* 垂直居中 */
  text-align: center; /* 文字水平居中 */
}

th, td {
  padding: 15px; /* 調整單元格內邊距 */
  border: 1px solid #ddd; /* 添加邊框 */
}


.error-message {
	color: red; /* 設置文字顏色為紅色，你可以根據需要進行調整 */
	margin-top: 5px; /* 設置上邊距，控制它與<input>元素之間的距離 */
	margin-left: 12px;
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
						<strong><a href="#" class="list-group-item list-group-item-action">填寫功能名稱</a></strong>
				      </div>
				    </div>
				  </div>
				</div>
			</div>
			<!--左邊-->

			<!--右邊-->
			<div class="col-lg-10 g-3">
				<div class="card">
					<div class="card-header">
						會員列表
						<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-box-fill" viewBox="0 0 16 16" style="float: right;">
                            <path fill-rule="evenodd" d="M15.528 2.973a.75.75 0 0 1 .472.696v8.662a.75.75 0 0 1-.472.696l-7.25 2.9a.75.75 0 0 1-.557 0l-7.25-2.9A.75.75 0 0 1 0 12.331V3.669a.75.75 0 0 1 .471-.696L7.443.184l.004-.001.274-.11a.75.75 0 0 1 .558 0l.274.11.004.001 6.971 2.789Zm-1.374.527L8 5.962 1.846 3.5 1 3.839v.4l6.5 2.6v7.922l.5.2.5-.2V6.84l6.5-2.6v-.4l-.846-.339Z" />
                        </svg>
					</div>
					
					<div class="card-body">
						<div class="row">
							<form method="post" action="mem.do" class="col-md-3">
								<div>
									<div class="input-group">
										<input type="text" class="form-control" placeholder="請輸入會員編號" name="memberno" value="${param.memberno}" aria-label="Recipient's username" aria-describedby="button-addon2"> 
										<input type="hidden" name="action" value="getOne_For_Display">
										<button class="btn btn-outline-secondary" type="submit" id="button-addon2">搜尋</button>
									</div>
									<div class="error-message">${errorMsgs.memberno}</div>
								</div>
							</form>
						</div>
						
						<div class="table-responsive">
							<table class="table table-hover table-striped">
								<thead>
									<tr>
										<th>編號</th>
										<th>帳號(Email)</th>
										<th>姓名</th>
										<th>性別</th>
<!-- 										<th>密碼</th> -->
										<th>手機</th>
										<th>地址</th>
										<th>註冊時間</th>
										<th>生日</th>
										<th>大頭照</th>
										<th>信用卡</th>
										<th>點數</th>
										<th>狀態</th>
										<th>身分證</th>
										<th>職業</th>
										<th>收入</th>
									</tr>
								</thead>
								<tbody>
									<%@ include file="page1.file" %> 
									<c:forEach var="MemberVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
								
								<tr>
									<td>${MemberVO.memberno}</td>
									<td>${MemberVO.memberemail}</td>
									<td>${MemberVO.membername}</td>
									<td>${MemberVO.membergender}</td>
<%-- 									<td>${MemberVO.memberpassword}</td> --%>
									<td>${MemberVO.memberphone}</td> 
									<td>${MemberVO.memberaddress}</td>
									<td>${MemberVO.memberjointime}</td>
									<td>${MemberVO.memberbirthday}</td>
									<th>
										<img src="<%=request.getContextPath()%>/ReadMbrIMG?id=${MemberVO.memberno}" width=70px height= 70px>
									</th>
									<td>${MemberVO.membercard}</td>
									<td>${MemberVO.memberpoints}</td> 
									<td>
									    <form method="post" action="<%=request.getContextPath()%>/member/mem.do" style="margin-bottom: 0px;">
										   <div class="form-group">
											    <select class="form-control" id="memberstat" name="memberstat" style="width: 110px;">
											        <option value="0" ${MemberVO.memberstat eq '0' ? 'selected' : ''}>帳號未驗證</option>
											        <option value="1" ${MemberVO.memberstat eq '1' ? 'selected' : ''}>帳號已驗證</option>
											        <option value="2" ${MemberVO.memberstat eq '2' ? 'selected' : ''}>帳號停權</option>
											    </select>
											</div>
									        <input type="hidden" name="memberno"  value="${MemberVO.memberno}">
									        <input type="hidden" name="action" value="updateStat">
									        <button class="btn btn-success" type="submit">修改</button>
									    </form>
									</td>
									<td>${MemberVO.memberid}</td>
									<td>${MemberVO.memberjob}</td>
									<td>${MemberVO.membersal}</td>	
								</tr>
							</c:forEach>
							</table>
							<%@ include file="page2.file" %>
						</div>	
					</div>
				</div>
			</div>	
			<!--右邊-->
		</div>
	</div>

	<script src="<%=request.getContextPath()%>/js/popper.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
	
</body>
</html>
