<%@page import="java.sql.Timestamp"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.cha103g5.admin.model.*"%>

<%
     // AdminVO ampVO = (AdminVO) request.getAttribute("adminVO");
%>

<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <title>員工資料新增</title>

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
    <tr><td>
        <h3>員工資料新增 - addAdmin.jsp</h3></td><td>
        <h4><a href="selectPage.jsp"><img src="images/dog.jpg" width="100" height="100" border="0">回首頁</a></h4>
    </td></tr>
</table>

<h3>資料新增:</h3>

<FORM METHOD="post" ACTION="admin.do" name="form1">
    <table>
        <tr>
            <td>員工編號:</td>
            <td><input type="TEXT" name="adminNo" value="${param.adminNo}" size="45"/></td> <td>${errorMsgs.adminNo}</td>
        </tr>
        <tr>
            <td>員工帳號:</td>
            <td><input type="TEXT" name="adminAccount" value="${param.adminAccount}" size="45"/></td> <td>${errorMsgs.adminAccount}</td>
        </tr>
        <tr>
            <td>員工密碼:</td>
            <td><input type="TEXT" name="adminPassword" value="${param.adminPassword}" size="45"/></td> <td>${errorMsgs.adminPassword}</td>
        </tr>
        <tr>
            <td>員工姓名:</td>
            <td><input type="TEXT" name="adminName" value="${param.adminName}" size="45"/></td> <td>${errorMsgs.adminName}</td>
        </tr>
        <tr>
            <td>雇用日期:</td>
           <td><input type="TEXT" name="createDate"   value="${param.createDate}"   size="45"/></td> <td>${errorMsgs.createDate}</td>
        </tr>
        <tr>
            <td>員工狀態:</td>
            <td><input type="TEXT" name="adminStat"   value="${param.adminStat}"   size="45"/></td> <td>${errorMsgs.adminStat}</td>
        </tr>
        <tr>
            <td>員工信箱:</td>
            <td><input type="TEXT" name="adminEmail"   value="${param.adminEmail}"   size="45"/></td> <td>${errorMsgs.adminEmail}</td>
        </tr>
        <tr>
            <td>員工電話:</td>
            <td><input name="adminPhone" id="adminPhone" type="text" value="${param.adminPhone}"   size="45" ></td> <td>${errorMsgs.adminPhone}</td>
        </tr>

    </table>
    <br>
    <input type="hidden" name="action" value="insert">
    <input type="submit" value="送出新增"></FORM>

</body>



<!-- =========================================以下為 datetimepicker 之相關設定========================================== -->

<%
    Timestamp createDate = null;
    try {
        createDate = Timestamp.valueOf(request.getParameter("createDate").trim());
    } catch (Exception e) {
        createDate = new Timestamp(System.currentTimeMillis());
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
    $('#createDate').datetimepicker({
        theme: '',              //theme: 'dark',
        timepicker:false,       //timepicker:true,
        step: 1,                //step: 60 (這是timepicker的預設間隔60分鐘)
        format:'Y-m-d',         //format:'Y-m-d H:i:s',
        value: '<%=createDate%>', // value:   new Date(),
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