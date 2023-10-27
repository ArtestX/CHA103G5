<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ page import="com.cha103g5.member.model.*"%>
<%-- 此頁暫練習採用 Script 的寫法取值 --%>

<%
MemberVO memberVO = (MemberVO) request.getAttribute("MemberVO"); //MemberServlet.java(Concroller), 存入req的MemberVO物件
%>

<html>
<head>
<title>會員資料 - listOneMbr.jsp</title>

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
		 <h3>會員資料 - listOneMbr.jsp</h3>
		 <h4><a href="select_page.jsp"><img src="${pageContext.request.contextPath}/img/ok.png" width="50" height="50" border="0"><br>回首頁</a></h4>
	</td></tr>
</table>

<table>
	<tr>
		<th>會員編號</th>
		<th>會員帳號(Email)</th>
		<th>會員姓名</th>
		<th>性別</th>
		<th>會員密碼</th>
		<th>手機</th>
		<th>地址</th>
		<th>註冊時間</th>
		<th>生日</th>
		<th>國籍</th>
		<th>大頭照</th>
		<th>信用卡</th>
		<th>會員點數</th>
		<th>會員狀態</th>
		<th>身分證</th>
		<th>職業</th>
		<th>收入</th>
	</tr>
	<tr>
		    <td>${MemberVO.memberno}</td>
			<td>${MemberVO.memberemail}</td>
			<td>${MemberVO.membername}</td>
			<td>${MemberVO.membergender}</td>
			<td>${MemberVO.memberpassword}</td>
			<td>${MemberVO.memberphone}</td> 
			<td>${MemberVO.memberaddress}</td>
			<td>${MemberVO.memberjointime}</td>
			<td>${MemberVO.memberbirthday}</td>
			<td>${MemberVO.membernation}</td>
			<td>
				<img src="<%=request.getContextPath()%>/ReadMbrIMG?id=${MemberVO.memberno}" width=70px height= 70px>
			</td>
			<td>${MemberVO.membercard}</td>
			<td>${MemberVO.memberpoints}</td> 
			<td>${MemberVO.memberstat}</td>
			<td>${MemberVO.memberid}</td>
			<td>${MemberVO.memberjob}</td>
			<td>${MemberVO.membersal}</td>
	</tr>
</table>

</body>
</html>