<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ page import="com.cha103g5.member.model.*"%>
<%-- �����Ƚm�߱ĥ� Script ���g�k���� --%>

<%
MemberVO memberVO = (MemberVO) request.getAttribute("MemberVO"); //MemberServlet.java(Concroller), �s�Jreq��MemberVO����
%>

<html>
<head>
<title>�|����� - listOneMbr.jsp</title>

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

<h4>�����Ƚm�߱ĥ� Script ���g�k����:</h4>
<table id="table-1">
	<tr><td>
		 <h3>�|����� - listOneMbr.jsp</h3>
		 <h4><a href="select_page.jsp"><img src="${pageContext.request.contextPath}/img/ok.png" width="50" height="50" border="0"><br>�^����</a></h4>
	</td></tr>
</table>

<table>
	<tr>
		<th>�|���s��</th>
		<th>�|���b��(Email)</th>
		<th>�|���m�W</th>
		<th>�ʧO</th>
		<th>�|���K�X</th>
		<th>���</th>
		<th>�a�}</th>
		<th>���U�ɶ�</th>
		<th>�ͤ�</th>
		<th>���y</th>
		<th>�j�Y��</th>
		<th>�H�Υd</th>
		<th>�|���I��</th>
		<th>�|�����A</th>
		<th>������</th>
		<th>¾�~</th>
		<th>���J</th>
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