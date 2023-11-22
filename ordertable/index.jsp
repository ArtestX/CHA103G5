<%@ page import="com.cha103g5.order.ordertable.service.OrderTableService" %>
<%@ page import="com.cha103g5.order.ordertable.service.OrderTableServiceImpl" %>
<%@ page import="com.cha103g5.order.ordertable.model.OrderTableVO" %>
<%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
	OrderTableService otService = new OrderTableServiceImpl();
	List<OrderTableVO> allOrderTables = otService.getAllOrderTables();
	pageContext.setAttribute("allOrderTables", allOrderTables);

	Set<Integer> distinctMemberNos = new TreeSet<>();
	for (OrderTableVO oneOrderTable : allOrderTables) {
		distinctMemberNos.add(oneOrderTable.getMemberNo());
	}
	pageContext.setAttribute("distinctMemberNos", distinctMemberNos);
	Set<Byte> distinctOrderStats = new TreeSet<>();
	for (OrderTableVO oneOrderTable : allOrderTables) {
		distinctOrderStats.add(oneOrderTable.getOrderStat());
	}
	pageContext.setAttribute("distinctOrderStats", distinctOrderStats);
	Set<Byte> distinctShipMethods = new TreeSet<>();
	for (OrderTableVO oneOrderTable : allOrderTables) {
		distinctShipMethods.add(oneOrderTable.getShipMethod());
	}
	pageContext.setAttribute("distinctShipMethods", distinctShipMethods);
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/ordertable/main/main.css">
	<title>訂單 首頁</title>
</head>
<body>
	<h1>訂單 管理系統</h1>

	<h2>基本查詢</h2>
	<a href="${pageContext.request.contextPath}/orderTableServlet?action=getAll">所有 訂單</a>
	<br><br>

	<form action="${pageContext.request.contextPath}/orderTableServlet" method="get">
		<input type="hidden" name="action" value="getOne">
		<label for="orderTableNo">訂單編號:</label>
		<select name="orderTableNo" id="orderTableNo">
			<option value="">請選擇</option>
			<c:forEach var="orderTable" items="${allOrderTables}" >
				<option value="${orderTable.orderTableNo}">${orderTable.orderTableNo}</option>
			</c:forEach>
		</select>
		<input type="submit" value="搜尋">
	</form>
	<br><br>

	<form action="${pageContext.request.contextPath}/orderTableServlet" method="get">
		<input type="hidden" name="action" value="getByMemberNo">
		<label for="memberNo">會員編號:</label>
		<select name="memberNo" id="memberNo">
			<option value="">請選擇</option>
			<c:forEach var="memberNo" items="${distinctMemberNos}" >
				<option value="${memberNo}">${memberNo}</option>
			</c:forEach>
		</select>
		<input type="submit" value="搜尋">
	</form>
	<br><br>

	<h2>新增申請</h2>
	<a href="${pageContext.request.contextPath}/ordertable/add.jsp">新增 訂單</a>
	<br><br>

	<h2>複合查詢</h2>
	<form action="${pageContext.request.contextPath}/orderTableServlet" method="get">
		<input type="hidden" name="action" value="compositeQuery">

		<label for="memberNoCriteriaQuery">會員編號:</label>
		<select name="memberNo" id="memberNoCriteriaQuery">
			<option value="">請選擇</option>
			<c:forEach var="memberNo" items="${distinctMemberNos}" >
				<option value="${memberNo}">${memberNo}</option>
			</c:forEach>
		</select>
		&nbsp;<b>+</b>&nbsp;
		<label for="orderStatCriteriaQuery">訂單狀態:</label>
		<select name="orderStat" id="orderStatCriteriaQuery">
			<option value="">請選擇</option>
			<option value="0">訂單成立</option>
			<option value="1">配送中</option>
			<option value="2">訂單取消</option>
			<option value="3">訂單退貨</option>
			<option value="4">訂單換貨</option>
			<option value="5">訂單完成</option>
		</select>
		&nbsp;<b>+</b>&nbsp;
		<label for="shipMethodCriteriaQuery">運送方式:</label>
		<select name="shipMethod" id="shipMethodCriteriaQuery">
			<option value="">請選擇</option>
			<option value="0">宅配</option>
			<option value="1">超商取貨</option>
		</select>
		<p><label>購買日期範圍</label></p>
		<input type="date" name="startOrderDate"> &nbsp;<b>～</b>&nbsp; <input type="date" name="endOrderDate">
		<br><br>

		<p><input type="submit" value="複合查詢"></p>
	</form>

</body>
</html>