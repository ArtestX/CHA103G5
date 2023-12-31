<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.cha103g5.admin.model.*"%>
<%-- 此頁暫練習採用 Script 的寫法取值 --%>

<%
  AdminVO adminVO = (AdminVO) request.getAttribute("adminVO"); //EmpServlet.java(Concroller), 存入req的empVO物件
%>

<html>
<head>
    <title>員工資料</title>

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
            width: 600px;
            background-color: white;
            margin-top: 5px;
            margin-bottom: 5px;
        }
        table, th, td {
            border: 1px solid #CCCCFF;
        }
        th, td {
            padding: 5px;
            text-align: center;
        }
    </style>

</head>
<body bgcolor='white'>

<table id="table-1">
    <tr><td>
        <h3>員工資料 - listOneAdmin.jsp</h3>
        <h4><a href="selectPage.jsp"><img src="images/dog.jpg" width="100" height="32" border="0">回首頁</a></h4>
    </td></tr>
</table>

<table>
    <tr>
        <th>員工編號</th>
        <th>員工帳號</th>
        <th>員工密碼</th>
        <th>員工姓名</th>
        <th>雇用日期</th>
        <th>員工狀態</th>
        <th>員工信箱</th>
        <th>員工電話</th>
    </tr>
    <tr>
        <td>${AdminVO.adminNo}</td>
        <td>${AdminVO.adminAccount}</td>
        <td>${AdminVO.adminPassword}</td>
        <td>${AdminVO.adminName}</td>
        <td>${AdminVO.createDate}</td>
        <td>${AdminVO.adminStat}</td>
        <td>${AdminVO.adminEmail}</td>
        <td>${AdminVO.adminPhone}</td>
    </tr>
</table>

</body>
</html>