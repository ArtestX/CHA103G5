<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.cha103g5.member.model.*"%>
<jsp:include page="/banner.jsp" flush="true"/>
<%-- �����m�߱ĥ� EL ���g�k���� --%>

<%
	MemberService mbrSvc = new MemberService();
    List<MemberVO> list = mbrSvc.getAllMembers();
    pageContext.setAttribute("list",list);
%>


<html>
<head>
<title>�Ҧ��|����� - listAllMbrEmp.jsp</title>

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
    text-decoration: none;
    
  }
</style>

<style>
  table {
	width: 800px;
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

<h4>�����m�߱ĥ� EL ���g�k����:</h4>
<table id="table-1">
	<tr><td>
		 <h3>�Ҧ��|����� - listAllMbrEmp.jsp</h3>
		 <h4><a href="select_page.jsp"><img src="${pageContext.request.contextPath}/img/login.png" width="70" height="70" border="0"><br>Home</a>
		 </h4>
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
	<%@ include file="page1.file" %> 
	<c:forEach var="MemberVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
		
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
			<th>
				<img src="<%=request.getContextPath()%>/ReadMbrIMG?id=${MemberVO.memberno}" width=70px height= 70px>
			</th>
			<td>${MemberVO.membercard}</td>
			<td>${MemberVO.memberpoints}</td> 
			<td>${MemberVO.memberstat}</td>
			<td>${MemberVO.memberid}</td>
			<td>${MemberVO.memberjob}</td>
			<td>${MemberVO.membersal}</td>	
			
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/member/mem.do" style="margin-bottom: 0px;">
			     <input type="submit" value="�ק�">
			     <input type="hidden" name="memberno"  value="${MemberVO.memberno}">
			     <input type="hidden" name="action"	value="getOne_For_Update"></FORM>
			</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/member/mem.do" style="margin-bottom: 0px;">
			     <input type="submit" value="�R��">
			     <input type="hidden" name="memberno"  value="${MemberVO.memberno}">
			     <input type="hidden" name="action" value="delete"></FORM>
			</td>
		</tr>
	</c:forEach>
</table>
<%@ include file="page2.file" %>

</body>
</html>