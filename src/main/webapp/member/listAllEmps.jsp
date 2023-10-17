<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
<title>List Members</title>
</head>
<body>
	<h1>會員列表</h1>
	<c:if test="${empPageQty > 0}">
  		<b><font color=red>第${currentPage}/${empPageQty}頁</font></b>
	</c:if>
	<br>
	<img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/img/TitleLogo.png">
	<table style="width:50%; text-align:center;">
		<tr>
			<th>會員編號</th>
			<th>會員帳號</th>
			<th>會員姓名</th>
			<th>性別</th>
			<th>密碼</th>
			<th>手機</th>
			<th>信箱</th>
			<th>地址</th>
			<th>註冊時間</th>
			<th>生日</th>
			<th>國籍</th>
			<th>大頭照</th>
			<th>信用卡號</th>
			<th>會員點數</th>
			<th>會員狀態</th>
			<th>身分證</th>
			<th>職業</th>
			<th>收入</th>
			
		</tr>
		<c:forEach var="member" items="${memberList}">
			<tr>
				<td>${member.memberno}</td>
				<td>${member.memberaccount}</td>
				<td>${member.membername}</td>
				<td>${member.membergender}</td>
				<td>${member.memberpassword}</td>
				<td>${member.memberphone}</td>
				<td>${member.memberemail}</td>
				<td>${member.memberaddress}</td>
				<td>${member.memberjointime}</td>
				<td>${member.memberbirthday}</td>
				<td>${member.membernation}</td>
				<td>${member.memberpic}</td>
				<td>${member.membercard}</td>
				<td>${member.memberpoints}</td>
				<td>${member.memberstat}</td>
				<td>${member.memberid}</td>
				<td>${member.memberjob}</td>
				<td>${member.membersal}</td>
			</tr>
		</c:forEach>
	</table>
	<c:if test="${currentPage > 1}">
		<a href="${pageContext.request.contextPath}/mem/mem.do?action=getAll&page=1">至第一頁</a>&nbsp;
	</c:if>
	<c:if test="${currentPage - 1 != 0}">
		<a href="${pageContext.request.contextPath}/mem/mem.do?action=getAll&page=${currentPage - 1}">上一頁</a>&nbsp;
	</c:if>
	<c:if test="${currentPage + 1 <= empPageQty}">
		<a href="${pageContext.request.contextPath}/mem/mem.do?action=getAll&page=${currentPage + 1}">下一頁</a>&nbsp;
	</c:if>
	<c:if test="${currentPage != empPageQty}">
		<a href="${pageContext.request.contextPath}/emp/emp.do?action=getAll&page=${empPageQty}">至最後一頁</a>&nbsp;
	</c:if>
	<br>
<img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/img/TitleLogo.png">
	<br><br>
	
	<a href="${pageContext.request.contextPath}/member/index1.jsp">回首頁</a>	
</body>
</html>