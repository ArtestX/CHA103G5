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
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/adoptedapplicationhibernate/main/main.css">
	<title>領養表單首頁</title>

	<style>
		.table-button {
			transform: scale(1);
			height: 30px; /* 設定按鈕的高度 */
		}
	</style>

</head>
<body>
	<h1>領養表單<br>管理系統</h1>

	<button onclick="location.href='${pageContext.request.contextPath}/adoptedApplicationHibernateServlet?action=showCalendar'">行事曆管理<br>(後台管理)</button>
	<br><br>

	<button onclick="location.href='${pageContext.request.contextPath}/adoptedApplicationHibernateServlet?action=getAll'">所有申請<br>(後台管理)</button>
	<br><br>

	<form action="${pageContext.request.contextPath}/adoptedApplicationHibernateServlet" method="get" class="search-form">
<%--	<form action="${pageContext.request.contextPath}/adoptedApplicationHibernateServlet" method="get" class="search-form">--%>
		<div class="form-group">
			<input type="hidden" name="action" value="getOne">
			<label for="applicationNo">申請編號:<br>(後台管理)</label>
			<select name="applicationNo" id="applicationNo">
				<option value="">請選擇</option>
				<c:forEach var="application" items="${allApplications}" >
					<option value="${application.applicationNo}">${application.applicationNo}</option>
				</c:forEach>
			</select>
			&nbsp;<input class="table-button" type="submit" value="查詢">
		</div>
	</form>

	<form action="${pageContext.request.contextPath}/adoptedApplicationHibernateServlet" method="get" class="search-form">
		<div class="form-group">
			<input type="hidden" name="action" value="getByMemberNo">
			<label for="memberNo">會員編號:<br>(會員頁面)</label>
			<select name="memberNo" id="memberNo">
				<option value="">請選擇</option>
				<c:forEach var="memberNo" items="${distinctMemberNos}" >
					<option value="${memberNo}">${memberNo}</option>
				</c:forEach>
			</select>
			&nbsp;<input class="table-button" type="submit" value="查詢">
		</div>
	</form>

<%--	<h2>抽籤排序查詢<br>(後台管理)</h2>--%>
	<form action="${pageContext.request.contextPath}/adoptedApplicationHibernateServlet" method="get">
		<div class="form-group">
			<input type="hidden" name="action" value="compositeQuery">

			<label>寵物編號:</label>
			<select name="petId" id="petIdCriteriaQuery">
				<option value="">請選擇</option>
				<c:forEach var="petId" items="${distinctPetIds}" >
					<option value="${petId}">${petId}</option>
				</c:forEach>
			</select>
<%--			&nbsp;<b>--%>
<%--			+</b>&nbsp;--%>
<%--			<label>抽籤日期:</label>--%>
<%--			<input type="date" name="lotteryDate">--%>
			&nbsp;<input class="table-button" type="submit" value="查詢">
		</div>
	</form>
	<br>
	<button onclick="location.href='${pageContext.request.contextPath}/adoptedApplicationHibernateServlet?action=addOption'">預約<br>(寵物頁面)</button>
<%--	<button onclick="location.href='${pageContext.request.contextPath}/adoptedapplicationhibernate/add.jsp'">新增申請</button>--%>
	<br><br>
</body>
</html>