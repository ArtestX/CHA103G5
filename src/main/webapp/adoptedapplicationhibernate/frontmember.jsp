<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.cha103g5.member.model.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.cha103g5.order.ordertable.model.OrderTableVO" %>
<jsp:include page="/banner.jsp" flush="true" />

<%
	// 把MemberVO的資料從session取出
	com.cha103g5.member.model.MemberVO user = (com.cha103g5.member.model.MemberVO) session.getAttribute("user");

	Random rand = new Random();
	int memberNo = rand.nextInt(6) + 1;

%>
<!DOCTYPE html>
<html>
<head>
<%-- <link rel="stylesheet" href="<%=request.getContextPath()%>/css/sweetalert2.css"> --%>
<style>
body {
	background-color: rgb(243, 243, 243);
	margin: 0;
    padding: 0;
}

a{
 text-decoration: none;
 color:black;
}

font {
	color:red;
	margin-top:10px;
	float: right;
	font-size: 15px;
}

#passwordError, #checkpasswordError{
	color: red ;
    float: left;
    font-size: 14px;
    margin-top: 5px;
    width: 200px;
}

/*****側邊選單*****/
.card {
 margin-top: 70px;
 width:220px;
 border: none;
 text-align: center;
 font-weight: bold; 
}

.card-header{
 background-color: #655353;
 color: white;
}

.list-group-item:hover {
    background-color: rgb(222, 215, 212); 
}

/*****按鈕樣式*****/
.btn {
	color: #422E2F;
	background-color: #FAE899;
	border: 1px solid rgba(238, 234, 234, 0.5);
}

.btn:hover {
	background-color: #bae5f3fb;
	box-shadow: 0 1px 4px rgba(64, 64, 64, 1);
}

</style>

</head>
<body>
<div class="container">
	<div class="row">
		<!-- ----------left start---------- -->
		<div class="col-md-9">

			<%
				String orderTableIncludePath = (String) request.getAttribute("orderTableIncludePath");
//				String orderDetailIncludePath = (String) request.getAttribute("orderDetailIncludePath");
				String applicationIncludePath = (String) request.getAttribute("applicationIncludePath");

//				List<OrderTableVO> someOrderTablesList = (List<OrderTableVO>) request.getAttribute("someOrderTables");
			%>

			<% if (orderTableIncludePath != null) { %>
			<jsp:include page="<%= orderTableIncludePath %>" />
<%--			<jsp:include page="<%= orderDetailIncludePath %>" />--%>
			<% } %>

			<% if (applicationIncludePath != null) { %>
			<jsp:include page="<%= applicationIncludePath %>" />
			<% } %>

			<div class="row" style="min-height: 350px;"></div>




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

					<li class="list-group-item">
						<a href="#" onclick="document.getElementById('orderForm').submit();">訂單明細</a>
						<form style="display: none;" id="orderForm" action="${pageContext.request.contextPath}/orderTableServlet" method="GET">
							<input type="hidden" name="action" value="getByMemberNoFrontend">
							<input type="hidden" name="memberNo" value="<%= memberNo %>">
						</form>
					</li>

					<li class="list-group-item">
						<a href="#" onclick="document.getElementById('applicationForm').submit();">預約詳情</a>
						<form style="display: none;" id="applicationForm" action="${pageContext.request.contextPath}/adoptedApplicationHibernateServlet" method="GET">
							<input type="hidden" name="action" value="frontendGetByMemberNo">
							<input type="hidden" name="memberNo" value="<%= memberNo %>">
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
</body>
</html>
