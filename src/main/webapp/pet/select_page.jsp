<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Cha103G5 Pet:首頁</title>

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
   <tr><td><h3>Cha103G5 Pet:首頁</h3><h4>( MVC )</h4></td></tr>
</table>

<p>This is the Home page for Cha103G5 Pet:首頁</p>

<h3>資料查詢:</h3>

<%-- 錯誤表列 --%>
<%-- <c:if test="${not empty errorMsgs}"> --%>
<!-- 	<font style="color:red">請修正以下錯誤:</font> -->
<!-- 	<ul> -->
<%-- 		<c:forEach var="message" items="${errorMsgs}"> --%>
<%-- 			<li style="color:red">${message.value}</li> --%>
<%-- 		</c:forEach> --%>
<!-- 	</ul> -->
<%-- </c:if> --%>

<ul>
  <li><a href='listAllPet.jsp'>List</a> all Members.  <br><br></li>
  
  
  <li>
    <FORM METHOD="post" ACTION="pet.do" >
        <b>輸入寵物編號:</b>
        <input type="text" name="petid" value="${param.petid}"><font color=red>${errorMsgs.petid}</font>
        <input type="hidden" name="action" value="getOne_For_Display">
        <input type="submit" value="送出">
    </FORM>
  </li>

<%--   <jsp:useBean id="empSvc" scope="page" class="com.cha103g5.pet.model.PetService" /> --%>
   
<!--   <li> -->
<!--      <FORM METHOD="post" ACTION="pet.do" > -->
<!--        <b>選擇寵物編號:</b> -->
<!-- <!--        <select size="1" name="petid"> -->
<%-- <%--          <c:forEach var="membernoVO" items="${empSvc.all}" >  --%>
<%-- <%--           <option value="${petVO.petid}">${petVO.petid} --%>
<%-- <%--          </c:forEach>    --%>
<!-- <!--        </select> -->
<!--        <input type="hidden" name="action" value="getOne_For_Display"> -->
<!--        <input type="submit" value="送出"> -->
<!--     </FORM> -->
<!--   </li> -->
  
<!--   <li> -->
<!--      <FORM METHOD="post" ACTION="pet.do" > -->
<!--        <b>選擇寵物名稱:</b> -->
<!-- <!--        <select size="1" name="petid"> -->
<%-- <%--          <c:forEach var="petVO" items="${empSvc.all}" >  --%>
<%-- <%--           <option value="${petVO.petid}">${petVO.petname} --%>
<%-- <%--          </c:forEach>    --%> 
<!-- <!--        </select> -->
<!--        <input type="hidden" name="action" value="getOne_For_Display"> -->
<!--        <input type="submit" value="送出"> -->
<!--      </FORM> -->
<!--   </li> -->
</ul>

</body>
</html>