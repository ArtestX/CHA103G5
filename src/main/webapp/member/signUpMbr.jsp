<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.cha103g5.member.model.*"%>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<title>���U�|�� - SignUp Mbr.jsp</title>

<style>
  table#table-1 {
    width: 450px;
	background-color: #7d979b;
    text-align: center;
  }
  table#table-1 h4 {
    color: red;
    display: block;
    margin-bottom: 1px;
  }
  h3 {
    color: white;
  }
  h4 {
    color: blue;
    display: inline;
  }
  h5 {
    color: black;
    font-size:20px;
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
	<tr><td>
		 <h3>���U�|�� - SignUp Mbr.jsp</h3></td><td>
		 <h4><a href="select_page.jsp"><img src="${pageContext.request.contextPath}/img/ok.png" width="50" height="50" border="0">�^����</a></h4>
	</td></tr>
</table>

<h5>��Ʒs�W:</h5>

<FORM METHOD="post" ACTION="mem.do" name="form1">
<table>
	<tr>
	  	<!-- <td>�|���s��:<font color=red><b>*</b></font></td>-->
	  	<td><input type="hidden" value="${param.memberno}"></td>
     </tr>
	
	<tr>
		<td>�|���b��(Email):</td>
		<td><input type="TEXT" name="memberemail" value="${param.memberemail}" size="10"/></td> <td>${errorMsgs.memberemail}</td>
	</tr>
	
	<tr>
		<td>�W�r:</td>
		<td><input type="TEXT" name="membername" value="${param.membername}" size="20"/></td> <td>${errorMsgs.membername}</td>
	</tr>
	
	<tr>
		<td>�ʧO:</td>
	    <td>
	        <input type="radio" name="membergender" value=1 checked/> �k
	        <input type="radio" name="membergender" value=2> �k
	    </td>
    </tr>
    
    <tr>
		<td>�K�X:</td>
		<td><input type="TEXT" name="memberpassword" value="${param.memberpassword}" size="20"/></td> <td>${errorMsgs.memberpassword}</td>
	</tr>
    
    <tr>
		<td>������X:</td>
		<td><input type="TEXT" name="memberphone" value="${param.memberphone}" size="10"/></td> <td>${errorMsgs.memberphone}</td>
	</tr>
    
	 <tr>
		<td>�a�}:</td>
		<td><input type="TEXT" name="memberaddress" value="${param.memberaddress}" size="45"/></td> 
	</tr>
    
    <tr>
		<td>���U�ɶ�:</td>
		<td><input name="memberjointime" id="f_date1" type="text" ></td> <td>${errorMsgs.memberjointime}</td>
	</tr>
	
	<tr>
		<td>�ͤ�:</td>
		<td><input name="memberbirthday" id="f_date2" type="text" ></td> <td>${errorMsgs.memberbirthday}</td>
	</tr>
    
	<tr>
		<td>���y:</td>
		<td><input type="TEXT" name="membernation" value="${param.membernation}" size="45"/></td> 
	</tr>
	
	<tr>
		<td>�j�Y��:</td>
		<td><input type="file" name="memberpic" value="${param.memberpic}"/></td> 
	</tr>
	
	<tr>
		<td>�H�Υd:</td>
		<td><input type="text" name="membercard" value="${param.membercard}" placeholder="xxxx-xxxx-xxxx-xxxx"/></td> <td>${errorMsgs.membercard}</td>
	</tr>
	
	<tr>
		<!-- �|���I��: -->
		<td><input type="hidden" name="memberpoints" value=0></td> 
	</tr>
	
	<tr>
		<!-- �|�����A: -->
		<td><input type="hidden" name="memberstat" value=0></td> 
	</tr>
	
	<tr>
		<td>������:</td>
		<td><input type="TEXT" name="memberid" value="${param.memberid}" size="10"/></td> <td>${errorMsgs.memberid}</td>
	</tr>
	
	<tr>
		<td>¾�~:</td>
		<td><input type="TEXT" name="memberjob" value="${param.memberjob}" size="10"/></td> <td>${errorMsgs.memberjob}</td>
	</tr>
	
	<tr>
		<td>���J:</td>
		<td>
			<select name="membersal">
			    <option value= 0>30W ~ 50W</option>
			    <option value= 1 >50w ~ 80W</option>
			    <option value= 2 >80W UP</option>
			</select>
		</td> 
	</tr>
</table>
<br>
<input type="hidden" name="action" value="insert">
<input type="submit" value="�e�X�s�W"></FORM>

<% 
  java.sql.Timestamp memberjointime = null;
  try {
	   memberjointime = java.sql.Timestamp.valueOf(request.getParameter("memberjointime").trim());
   } catch (Exception e) {
	   memberjointime = new java.sql.Timestamp(System.currentTimeMillis());
   }
%>
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
 	       theme: '',              //theme: 'dark',
	       timepicker:false,       //timepicker:true,
	       step: 1,                //step: 60 (�o�Otimepicker���w�]���j60����)
	       format:'Y-m-d H:i:s',         //format:'Y-m-d H:i:s',
		   value: '<%=memberjointime%>', // value:   new Date(),
           //disabledDates:        ['2017/06/08','2017/06/09','2017/06/10'], // �h���S�w���t
           //startDate:	            '2017/07/10',  // �_�l��
           //minDate:               '-1970-01-01', // �h������(���t)���e
           //maxDate:               '+1970-01-01'  // �h������(���t)����
        });
        
        $.datetimepicker.setLocale('zh');
		$('#f_date2').datetimepicker({
		   theme: 'dark',              //theme: 'dark',
		    timepicker:false,       //timepicker:true,
		    step: 60,                //step: 60 (�o�Otimepicker���w�]���j60����)
		    format:'Y-m-d',         //format:'Y-m-d H:i:s',
			value: '${param.memberbirthday}', // value:   new Date(),
		   //disabledDates:        ['2017/06/08','2017/06/09','2017/06/10'], // �h���S�w���t
		   //startDate:	            '2017/07/10',  // �_�l��
		   //minDate:               '-1970-01-01', // �h������(���t)���e
		   //maxDate:               '+1970-01-01'  // �h������(���t)����
		});
</script>        

</body>

</html>