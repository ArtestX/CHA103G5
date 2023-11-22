<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>





<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>員工資料 - listOneEmp.jsp</title>

<%@ include file="included-fragment.file" %>
<style type="text/css">
	
    span {
		display: inline-block;
		width: 150px;
		text-align: left;
		font-weight: bold;
	}
</style>
</head>
<body>

<nav class="navbar navbar-expand-md navbar-dark bg-success fixed-top justify-content-center">
		 <div align="center"> <h2>員工個人資料 - listOneEmp.jsp</h2>
		 <h3><a class="navbar-brand" href="<spring:url value='/emp/select_page'/>"><img src="<spring:url value='/images/back1.gif'/>">回查詢頁${success}</a></h3></div>
</nav>

	<div align="center">
		<h3><span>查詢結果 :</span></h3>
		<span>員工編號:</span><span>${empVO.empno}</span><br/>
		<span>員工姓名:</span><span>${empVO.ename}</span><br/>
		<span>職位:</span><span>${empVO.job}</span><br/>
		<span>雇用日期:</span><span>${empVO.hiredate}</span><br/>
		<span>薪水:</span><span>${empVO.sal}</span><br/>
		<span>獎金:</span><span>${empVO.comm}</span><br/>
		<span>部門:</span><span>${empVO.deptVO.deptno}-[${empVO.deptVO.dname}]</span><br/>
		<span>照片:</span><span><img src="<spring:url value='/emp/DBGifReader?empno=${empVO.empno}'/>" width="100px"></span><br/>
	</div>


</body>
</html>