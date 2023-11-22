<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.cha103g5.pet.model.*"%>

<%
PetServletVO petVO = (PetServletVO) request.getAttribute("petVO");
%>

<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>寵物資料修改</title>

<style>
table#table-1 {
	width: 450px;
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
		<tr>
			<td>
				<h3>寵物資料修改 - updatePet.jsp</h3>
				<h4>
					<a href="select_page.jsp"><img
						src="${pageContext.request.contextPath}/img/ok.png" width="50"
						height="50" border="0"><br>回首頁</a>
				</h4>
			</td>
		</tr>
	</table>

	<h3>資料修改:</h3>

<!-- 	錯誤表列 -->
	<c:if test="${not empty errorMsgs}">
		<font style="color:red">請修正以下錯誤:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color:red">${message.value}</li>
			</c:forEach>
		</ul>
	</c:if>

	<FORM method="post" action="pet.do" name="form1">
		<table>
			<tr>
				<td>寵物編號:<font color=red><b>*</b></font></td>
				<td>${param.petid}</td>
			</tr>
			<tr>
				<td>寵物類型:</td>
				<td><select size="1" name="pettype">
						<option value="1" ${param.pettype == '1' ? 'selected' : ''}>貓</option>
						<option value="2" ${param.pettype == '2' ? 'selected' : ''}>狗</option>
				</select>
			</tr>
			<tr>
				<td>會員編號:</td>
				<td><input type="TEXT" name="memberno"
					value="${param.memberno}" size="45" /></td>
			</tr>
			<tr>
				<td>寵物名稱:</td>
				<td><input type="TEXT" name="petname" value="${param.petname}"></td>
			</tr>
			<tr>
				<td>性別:</td>
				<td><select size="1" name="petsex">
						<option value="公" ${param.petsex == '1' ? 'selected' : ''}>公</option>
						<option value="母" ${param.petsex == '2' ? 'selected' : ''}>母</option>
				</select>
			</tr>
			<tr>
				<td>寵物年齡:</td>
				<td><input type="TEXT" name="petage" value="${param.petage}"
					size="45" /></td>
			</tr>
			<tr>
				<td>備註:</td>
				<td><input type="TEXT" name="petnote" value="${param.petnote}" /></td>
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
				<td><input name="applicationdeadline" id="f_date1" type="text"></td>
			</tr>

		</table>
		<br> <input type="hidden" name="action" value="update"> <input
			type="hidden" name="petid" value="${param.petid}"> <input
			type="submit" value="送出修改">
	</FORM>
</body>



<!-- =========================================以下為 datetimepicker 之相關設定========================================== -->

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/datetimepicker/jquery.datetimepicker.css" />
<script src="<%=request.getContextPath()%>/datetimepicker/jquery.js"></script>
<script
	src="<%=request.getContextPath()%>/datetimepicker/jquery.datetimepicker.full.js"></script>

<style>
.xdsoft_datetimepicker .xdsoft_datepicker {
	width: 300px; /* width:  300px; */
}

.xdsoft_datetimepicker .xdsoft_timepicker .xdsoft_time_box {
	height: 151px; /* height:  151px; */
}
</style>

<script>
	$.datetimepicker.setLocale('zh');
	$('#f_date1').datetimepicker({
		theme : '', //theme: 'dark',
		timepicker : false, //timepicker:true,
		step : 1, //step: 60 (這是timepicker的預設間隔60分鐘)
		format : 'Y-m-d', //format:'Y-m-d H:i:s',
		value : '${param.applicationdeadline}', // value:   new Date(),
	//disabledDates:        ['2017/06/08','2017/06/09','2017/06/10'], // 去除特定不含
	//startDate:	            '2017/07/10',  // 起始日
	//minDate:               '-1970-01-01', // 去除今日(不含)之前
	//maxDate:               '+1970-01-01'  // 去除今日(不含)之後
	});

	// ----------------------------------------------------------以下用來排定無法選擇的日期-----------------------------------------------------------

	//      1.以下為某一天之前的日期無法選擇
	//      var somedate1 = new Date('2017-06-15');
	//      $('#f_date1').datetimepicker({
	//          beforeShowDay: function(date) {
	//        	  if (  date.getYear() <  somedate1.getYear() ||
	//		           (date.getYear() == somedate1.getYear() && date.getMonth() <  somedate1.getMonth()) ||
	//		           (date.getYear() == somedate1.getYear() && date.getMonth() == somedate1.getMonth() && date.getDate() < somedate1.getDate())
	//              ) {
	//                   return [false, ""]
	//              }
	//              return [true, ""];
	//      }});

	//      2.以下為某一天之後的日期無法選擇
	//      var somedate2 = new Date('2017-06-15');
	//      $('#f_date1').datetimepicker({
	//          beforeShowDay: function(date) {
	//        	  if (  date.getYear() >  somedate2.getYear() ||
	//		           (date.getYear() == somedate2.getYear() && date.getMonth() >  somedate2.getMonth()) ||
	//		           (date.getYear() == somedate2.getYear() && date.getMonth() == somedate2.getMonth() && date.getDate() > somedate2.getDate())
	//              ) {
	//                   return [false, ""]
	//              }
	//              return [true, ""];
	//      }});

	//      3.以下為兩個日期之外的日期無法選擇 (也可按需要換成其他日期)
	//      var somedate1 = new Date('2017-06-15');
	//      var somedate2 = new Date('2017-06-25');
	//      $('#f_date1').datetimepicker({
	//          beforeShowDay: function(date) {
	//        	  if (  date.getYear() <  somedate1.getYear() ||
	//		           (date.getYear() == somedate1.getYear() && date.getMonth() <  somedate1.getMonth()) ||
	//		           (date.getYear() == somedate1.getYear() && date.getMonth() == somedate1.getMonth() && date.getDate() < somedate1.getDate())
	//		             ||
	//		            date.getYear() >  somedate2.getYear() ||
	//		           (date.getYear() == somedate2.getYear() && date.getMonth() >  somedate2.getMonth()) ||
	//		           (date.getYear() == somedate2.getYear() && date.getMonth() == somedate2.getMonth() && date.getDate() > somedate2.getDate())
	//              ) {
	//                   return [false, ""]
	//              }
	//              return [true, ""];
	//      }});
</script>
</html>
