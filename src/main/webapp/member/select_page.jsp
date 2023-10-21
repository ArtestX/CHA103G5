<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Cha103G5 Member: Home</title>

<style>
  table#table-1 {
	width: 450px;
	background-color: #7d979b;
	margin-top: 5px;
	margin-bottom: 10px;
    border: 3px ridge white;
    height: 80px;
    text-align: center;
  }
  table#table-1 h4 {
    color: white;
    display: block;
    margin-bottom: 1px;
  }
  h4 {
    color: blue;
    display: inline;
  }
</style>

</head>
<body bgcolor='white'>

<table id="table-1">
   <tr><td><h3>Cha103G5 Member: Home</h3><h4>( MVC )</h4></td></tr>
</table>

<p>This is the Home page for Cha103G5 Member: Home</p>

<h3>��Ƭd��:</h3>

<%-- ���~��C --%>
<%-- <c:if test="${not empty errorMsgs}"> --%>
<!-- 	<font style="color:red">�Эץ��H�U���~:</font> -->
<!-- 	<ul> -->
<%-- 		<c:forEach var="message" items="${errorMsgs}"> --%>
<%-- 			<li style="color:red">${message.value}</li> --%>
<%-- 		</c:forEach> --%>
<!-- 	</ul> -->
<%-- </c:if> --%>

<ul>
  <li><a href='listAllMbr.jsp'>List</a> all Members.  <br><br></li>
  
  
  <li>
    <FORM METHOD="post" ACTION="mem.do" >
        <b>��J�|���s��:</b>
        <input type="text" name="memberno" value="${param.memberno}"><font color=red>${errorMsgs.memberno}</font>
        <input type="hidden" name="action" value="getOne_For_Display">
        <input type="submit" value="�e�X">
    </FORM>
  </li>

  <jsp:useBean id="empSvc" scope="page" class="com.cha103g5.member.model.MemberService" />
   
  <li>
     <FORM METHOD="post" ACTION="mem.do" >
       <b>��ܷ|���s��:</b>
<!--        <select size="1" name="memberno"> -->
<%--          <c:forEach var="membernoVO" items="${empSvc.all}" >  --%>
<%--           <option value="${membernoVO.memberno}">${membernoVO.memberno} --%>
<%--          </c:forEach>    --%>
<!--        </select> -->
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="�e�X">
    </FORM>
  </li>
  
  <li>
     <FORM METHOD="post" ACTION="mem.do" >
       <b>��ܷ|���m�W:</b>
<!--        <select size="1" name="memberno"> -->
<%--          <c:forEach var="membernoVO" items="${empSvc.all}" >  --%>
<%--           <option value="${membernoVO.memberno}">${membernoVO.membername} --%>
<%--          </c:forEach>    --%>
<!--        </select> -->
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="�e�X">
     </FORM>
  </li>
</ul>


<h3>�|�����U</h3>

<ul>
  <li><a href='signUpMbr.jsp'>Sign Up</a> a new Member</li>
</ul>

</body>
</html>