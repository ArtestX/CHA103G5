<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*"%>
<%@ page import="com.cha103g5.adoptedapplicationhibernate.model.AdoptedApplicationHibernate" %>
<%@ page import="com.cha103g5.adoptedapplicationhibernate.service.AdoptedApplicationHibernateService" %>
<%@ page import="com.cha103g5.adoptedapplicationhibernate.service.AdoptedApplicationHibernateServiceImpl" %>

<%
	AdoptedApplicationHibernateService aahService = new AdoptedApplicationHibernateServiceImpl();
	List<AdoptedApplicationHibernate> allApplications = aahService.getAllApplications();
	pageContext.setAttribute("allApplications", allApplications);

	Set<Integer> distinctMemberNos = new TreeSet<>();
	for (AdoptedApplicationHibernate oneApplication : allApplications) {
		distinctMemberNos.add(oneApplication.getMemberNo());
	}
	pageContext.setAttribute("distinctMemberNos", distinctMemberNos);

	Set<Integer> distinctPetIds = new TreeSet<>();
	for (AdoptedApplicationHibernate oneApplication : allApplications) {
		distinctPetIds.add(oneApplication.getPetId());
	}
	pageContext.setAttribute("distinctPetIds", distinctPetIds);
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/adoptedapplicationhibernate/main/main.css">
	<title>主頁</title>
</head>
<body>
	<h1>申請表單 管理系統</h1>

	<h2>基本查詢</h2>
	<a href="${pageContext.request.contextPath}/adoptedApplicationHibernateServlet?action=getAll">所有 申請表單</a>
	<br><br>

	<form action="${pageContext.request.contextPath}/adoptedApplicationHibernateServlet" method="get">
		<input type="hidden" name="action" value="getOne">
		<label for="applicationNo">申請編號:</label>
		<select name="applicationNo" id="applicationNo">
			<option value="">請選擇</option>
			<c:forEach var="application" items="${allApplications}" >
				<option value="${application.applicationNo}">${application.applicationNo}</option>
			</c:forEach>
		</select>
		<input type="submit" value="搜尋">
	</form>
	<br><br>

	<form action="${pageContext.request.contextPath}/adoptedApplicationHibernateServlet" method="get">
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
	<a href="${pageContext.request.contextPath}/adoptedapplicationhibernate/add.jsp">新增 申請表單</a>
	<br><br>

	<h2>複合查詢</h2>
	<form action="${pageContext.request.contextPath}/adoptedApplicationHibernateServlet" method="get">
		<input type="hidden" name="action" value="compositeQuery">

		<label>寵物ID:</label>
		<select name="petId" id="petIdCriteriaQuery">
			<option value="">請選擇</option>
			<c:forEach var="petId" items="${distinctPetIds}" >
				<option value="${petId}">${petId}</option>
			</c:forEach>
		</select>
		&nbsp;<b>+</b>&nbsp;
		<label>抽籤日期:</label>
		<input type="date" name="lotteryDate">

		<p><input type="submit" value="複合查詢"></p>
	</form>

</body>
</html>