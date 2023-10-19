<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!--<link rel="stylesheet" href="${pageContext.request.contextPath}/main/main.css">-->
<title>Hibernate Demo</title>
</head>
<body>

	<h1>這是一位後端人員作的網頁 QQ</h1>
	<h2>員工系統</h2>
	<a href="${pageContext.request.contextPath}/mem/mem.do?action=getAll">查詢所有員工</a>
	<br><br>
	<h3><b>複合查詢 (使用 Criteria Query)：</b></h3>
	<form action="${pageContext.request.contextPath}/mem/mem.do" method="post">
		<p><label>會員名字模糊查詢：</label></p>
		<input type="text" name="membername"><br>
		
		<p><label>註冊日期間範圍</label></p>
		<input type="date" name="startmemberjointime"> ～ <input type="date" name="endmemberjointime"><br>
		
		<p><input type="submit" value="送出"></p>
		<input type="hidden" name="action" value="compositeQuery">
	</form>	
</body>
</html>