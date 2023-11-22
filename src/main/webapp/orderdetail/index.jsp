<%@ page import="com.cha103g5.order.orderdetail.service.OrderDetailService" %>
<%@ page import="com.cha103g5.order.orderdetail.service.OrderDetailServiceImpl" %>
<%@ page import="com.cha103g5.order.orderdetail.model.OrderDetailVO" %>
<%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
	OrderDetailService odService = new OrderDetailServiceImpl();
	List<OrderDetailVO> allOrderDetails = odService.getAllOrderDetails();
	pageContext.setAttribute("allOrderDetails", allOrderDetails);

	Set<Integer> distinctOrderTableNos = new TreeSet<>();
	for (OrderDetailVO oneOrderDetail : allOrderDetails) {
		distinctOrderTableNos.add(oneOrderDetail.getOrderTableNo());
	}
	pageContext.setAttribute("distinctOrderTableNos", distinctOrderTableNos);
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/orderdetail/main/main.css">
	<title>訂單明細 首頁</title>
</head>
<body>
	<h1>訂單明細 管理系統</h1>

	<h2>基本查詢</h2>
	<a href="${pageContext.request.contextPath}/orderDetailServlet?action=getAll">所有 訂單明細</a>
	<br><br>

	<form action="${pageContext.request.contextPath}/orderDetailServlet" method="get">
		<input type="hidden" name="action" value="getOne">
		<label for="orderDetailNo">訂單明細編號:</label>
		<select name="orderDetailNo" id="orderDetailNo">
			<option value="">請選擇</option>
			<c:forEach var="orderDetail" items="${allOrderDetails}" >
				<option value="${orderDetail.orderDetailNo}">${orderDetail.orderDetailNo}</option>
			</c:forEach>
		</select>
		<input type="submit" value="搜尋">
	</form>
	<br><br>

	<form action="${pageContext.request.contextPath}/orderDetailServlet" method="get">
		<input type="hidden" name="action" value="getByOrderTableNo">
		<label for="orderTableNo">訂單編號:</label>
		<select name="orderTableNo" id="orderTableNo">
			<option value="">請選擇</option>
			<c:forEach var="orderTableNo" items="${distinctOrderTableNos}" >
				<option value="${orderTableNo}">${orderTableNo}</option>
			</c:forEach>
		</select>
		<input type="submit" value="搜尋">
	</form>
	<br><br>

	<h2>新增申請</h2>
	<a href="${pageContext.request.contextPath}/orderdetail/add.jsp">新增 訂單明細</a>
	<br><br>

	<h2>複合查詢</h2>
	<form action="${pageContext.request.contextPath}/orderDetailServlet" method="get">
		<input type="hidden" name="action" value="compositeQuery">

		<label for="orderTableNoCriteriaQuery">訂單編號:</label>
		<select name="orderTableNo" id="orderTableNoCriteriaQuery">
			<option value="">請選擇</option>
			<c:forEach var="orderTableNo" items="${distinctOrderTableNos}" >
				<option value="${orderTableNo}">${orderTableNo}</option>
			</c:forEach>
		</select>
		&nbsp;<b>+</b>&nbsp;
		<label for="productNoCriteriaQuery">商品編號:</label>
		<select name="productNo" id="productNoCriteriaQuery">
			<option value="">請選擇</option>
			<c:forEach var="productNo" items="${distinctProductNos}" >
				<option value="${productNo}">${productNo}</option>
			</c:forEach>
		</select>

		<p><input type="submit" value="複合查詢"></p>
	</form>

</body>
</html>