<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.cha103g5.pet.model.*"%>
<% 
	PetVO petVO = (PetVO) request.getAttribute("petVO");
%>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<title>寵物資料新增 - addPet.jsp</title>

<style>
  table#table-1 {
	background-color: #CCCCFF;
    border: 2px solid black;
    text-align: center;
  }
  table#table-1 h4 {
    color: red;
    display: block;
    margin-bottom: 1px;
  }
  h4 {
    color: blue;
    display: inline;
  }
</style>

<style>
  table {
	width: 450px;
	background-color: white;
	margin-top: 1px;
	margin-bottom: 1px;
  }
  table, th, td {
    border: 0px solid #CCCCFF;
  }
  th, td {
    padding: 1px;
  }
</style>

</head>
<body bgcolor='white'>

<table id="table-1">
	<tr><td>
		 <h3>寵物資料新增 - addPet.jsp</h3></td><td>
		 <h4><a href="select_page.jsp"><img src="${pageContext.request.contextPath}/img/ok.png" width="50" height="50" border="0"><br>回首頁</a></h4>
	</td></tr>
</table>

<h3>資料新增:</h3>

<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<FORM METHOD="post" ACTION="pet.do" name="form1">
<table>
	
	
	
	
	<tr>
		<td>寵物類型:</td>
		<td><select size="1" name="pettype">
		<option value="1" ${param.pettype == '1' ? 'selected' : ''}>貓</option>
		<option value="2" ${param.pettype == '2' ? 'selected' : ''}>狗</option>
		</select>
	</tr>
	<tr>
		<td>會員編號:</td>
		<td><input type="TEXT" name="memberno"   value="${param.memberno}" size="45"/></td>
	</tr>
	<tr>
		<td>寵物名稱:</td>
		<td><input type="TEXT" name="petname" value="${param.petname}" ></td>
	</tr>
	<tr>
		<td>性別:</td>
		<td><select size="1" name="petsex" >
		<option value="F" ${param.petsex == '1' ? 'selected' : ''}>公</option>
		<option value="M" ${param.petsex == '2' ? 'selected' : ''}>母</option>
		</select>
	</tr>
	<tr>
		<td>寵物年齡:</td>
		<td><input type="TEXT" name="petage"   value="${param.petage}" size="45"/></td>
	</tr>
	<tr>
		<td>備註:</td>
		<td><input type="TEXT" name="petnote"value="${param.petnote}"/></td>
	</tr>
	<tr>
		<td>狀態:</td>
		<td><select size="1" name="stat">
		<option value="1" ${param.stat == '1' ? 'selected' : ''}>未上架</option>
		<option value="2" ${param.stat == '2' ? 'selected' : ''}>待領養</option>
		<option value="3" ${param.stat == '3' ? 'selected' : ''}>不可領養</option>
		</select>
	</tr>
	<tr>
		<td>截止日期:</td>
		<td><input name="applicationdeadline" id="f_date1" type="date" value="${param.applicationdeadline}"></td>
	</tr>

</table>
<br>
<input type="hidden" name="action" value="insert">
<input type="submit" value="送出新增"></FORM>

</body>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/datetimepicker/jquery.datetimepicker.css" />
<script src="<%=request.getContextPath()%>/datetimepicker/jquery.js"></script>
<script src="<%=request.getContextPath()%>/datetimepicker/jquery.datetimepicker.full.js"></script>
<style>
  .xdsoft_datetimepicker .xdsoft_datepicker {
           width:  300px;   /* width:  300px; */
  }
  .xdsoft_datetimepicker .xdsoft_timepicker .xdsoft_time_box {
           height: 151px;   /* height:  151px; */
  }
</style>
<script> 
        $.datetimepicker.setLocale('zh');
		$('#f_date1').datetimepicker({
		   	theme: ' ',              //theme: 'dark',
		    timepicker:false,       //timepicker:true,
		    step: 60,                //step: 60 (這是timepicker的預設間隔60分鐘)
		    format:'Y-m-d',         //format:'Y-m-d H:i:s',
			value: '${param.applicationdeadline}', // value:   new Date(),
		   //disabledDates:        ['2017/06/08','2017/06/09','2017/06/10'], // 去除特定不含
		   //startDate:	            '2017/07/10',  // 起始日
		   //minDate:               '-1970-01-01', // 去除今日(不含)之前
		   //maxDate:               '+1970-01-01'  // 去除今日(不含)之後
		});
</script>        
		
		<script src="../js/popper.min.js"></script>
		<script src="../js/bootstrap.min.js"></script>



</html>