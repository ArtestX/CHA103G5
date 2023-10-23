<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ page import="com.cha103g5.member.model.*"%>
<%-- 此頁暫練習採用 Script 的寫法取值 --%>

<%
  //EmpVO empVO = (EmpVO) request.getAttribute("empVO"); //EmpServlet.java(Concroller), 存入req的empVO物件
%>

<html>
<head>
<title>寵物資料 - listOnePet.jsp</title>

<style>
  table#table-1 {
	background-color: #7d979b;
    border: 2px solid white;
    text-align: center;
  }
  table#table-1 h4 {
    color: red;
    display: block;
    margin-bottom: 1px;
  }
  h3{
  	color: white;
  }
  h4 {
    color: blue;
    display: inline;
  }
</style>

<style>
  table {
	width: 600px;
	background-color: white;
	margin-top: 5px;
	margin-bottom: 5px;
  }
  table, th, td {
    border: 1px solid #7d979b;
  }
  th, td {
    padding: 5px;
    text-align: center;
  }
</style>

</head>
<body bgcolor='white'>

<h4>此頁暫練習採用 Script 的寫法取值:</h4>
<table id="table-1">
	<tr><td>
		 <h3>寵物資料 - listOnePet.jsp</h3>
		 <h4><a href="select_page.jsp"><img src="${pageContext.request.contextPath}/img/ok.png" width="50" height="50" border="0"><br>回首頁</a></h4>
	</td></tr>
</table>

<table>
	<tr>
		<th>寵物編號</th>
		<th>寵物狀態</th>
		<th>會員編號</th>
		<th>寵物名稱</th>
		<th>寵物性別</th>
		<th>寵物年齡</th>
		<th>備註</th>
		<th>寵物狀態</th>
		<th>截止時間</th>
		
	</tr>
	<tr>
		    <td>${PetVO.petid}</td>
			<td>${PetVO.pettype}</td>
			<td>${PetVO.memberno}</td>
			<td>${PetVO.petname}</td>
			<td>${PetVO.petsex}</td>
			<td>${PetVO.petage}</td> 
			<td>${PetVO.petnote}</td>
			<td>${PetVO.stat}</td>
			<td>${PetVO.applicationdeadline}</td>
	</tr>
</table>

</body>
</html>