<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.cha103g5.pet.model.*"%>

<%
PetServletVO petVO = (PetServletVO) request.getAttribute("petVO");
%>

<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>�d����ƭק�</title>

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
				<h3>�d����ƭק� - updatePet.jsp</h3>
				<h4>
					<a href="select_page.jsp"><img
						src="${pageContext.request.contextPath}/img/ok.png" width="50"
						height="50" border="0"><br>�^����</a>
				</h4>
			</td>
		</tr>
	</table>

	<h3>��ƭק�:</h3>

<!-- 	���~��C -->
	<c:if test="${not empty errorMsgs}">
		<font style="color:red">�Эץ��H�U���~:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color:red">${message.value}</li>
			</c:forEach>
		</ul>
	</c:if>

	<FORM method="post" action="pet.do" name="form1">
		<table>
			<tr>
				<td>�d���s��:<font color=red><b>*</b></font></td>
				<td>${param.petid}</td>
			</tr>
			<tr>
				<td>�d������:</td>
				<td><select size="1" name="pettype">
						<option value="1" ${param.pettype == '1' ? 'selected' : ''}>��</option>
						<option value="2" ${param.pettype == '2' ? 'selected' : ''}>��</option>
				</select>
			</tr>
			<tr>
				<td>�|���s��:</td>
				<td><input type="TEXT" name="memberno"
					value="${param.memberno}" size="45" /></td>
			</tr>
			<tr>
				<td>�d���W��:</td>
				<td><input type="TEXT" name="petname" value="${param.petname}"></td>
			</tr>
			<tr>
				<td>�ʧO:</td>
				<td><select size="1" name="petsex">
						<option value="��" ${param.petsex == '1' ? 'selected' : ''}>��</option>
						<option value="��" ${param.petsex == '2' ? 'selected' : ''}>��</option>
				</select>
			</tr>
			<tr>
				<td>�d���~��:</td>
				<td><input type="TEXT" name="petage" value="${param.petage}"
					size="45" /></td>
			</tr>
			<tr>
				<td>�Ƶ�:</td>
				<td><input type="TEXT" name="petnote" value="${param.petnote}" /></td>
			</tr>
			<tr>
				<td>���A:</td>
				<td><select size="1" name="stat">
						<option value="1" ${param.stat == '1' ? 'selected' : ''}>���W�[</option>
						<option value="2" ${param.stat == '2' ? 'selected' : ''}>�ݻ�i</option>
						<option value="3" ${param.stat == '3' ? 'selected' : ''}>���i��i</option>
				</select>
			</tr>
			<tr>
				<td>�I����:</td>
				<td><input name="applicationdeadline" id="f_date1" type="text"></td>
			</tr>

		</table>
		<br> <input type="hidden" name="action" value="update"> <input
			type="hidden" name="petid" value="${param.petid}"> <input
			type="submit" value="�e�X�ק�">
	</FORM>
</body>



<!-- =========================================�H�U�� datetimepicker �������]�w========================================== -->

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
		step : 1, //step: 60 (�o�Otimepicker���w�]���j60����)
		format : 'Y-m-d', //format:'Y-m-d H:i:s',
		value : '${param.applicationdeadline}', // value:   new Date(),
	//disabledDates:        ['2017/06/08','2017/06/09','2017/06/10'], // �h���S�w���t
	//startDate:	            '2017/07/10',  // �_�l��
	//minDate:               '-1970-01-01', // �h������(���t)���e
	//maxDate:               '+1970-01-01'  // �h������(���t)����
	});

	// ----------------------------------------------------------�H�U�ΨӱƩw�L�k��ܪ����-----------------------------------------------------------

	//      1.�H�U���Y�@�Ѥ��e������L�k���
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

	//      2.�H�U���Y�@�Ѥ��᪺����L�k���
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

	//      3.�H�U����Ӥ�����~������L�k��� (�]�i���ݭn������L���)
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
