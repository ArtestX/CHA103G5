<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ page import="com.cha103g5.member.model.*"%>
<%-- �����Ƚm�߱ĥ� Script ���g�k���� --%>

<%
  //EmpVO empVO = (EmpVO) request.getAttribute("empVO"); //EmpServlet.java(Concroller), �s�Jreq��empVO����
%>

<html>
<head>
<title>�d����� - listOnePet.jsp</title>

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
		 <h3>�d����� - listOnePet.jsp</h3>
		 <h4><a href="select_page.jsp"><img src="${pageContext.request.contextPath}/img/ok.png" width="50" height="50" border="0"><br>�^����</a></h4>
	</td></tr>
</table>

<table>
	<tr>
		<th>�d���s��</th>
		<th>�d�����A</th>
		<th>�|���s��</th>
		<th>�d���W��</th>
		<th>�d���ʧO</th>
		<th>�d���~��</th>
		<th>�Ƶ�</th>
		<th>�d�����A</th>
		<th>�I��ɶ�</th>
		
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