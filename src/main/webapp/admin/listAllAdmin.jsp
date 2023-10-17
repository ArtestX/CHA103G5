<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<%@ page import="java.util.*"%>
<%@ page import="com.cha103g5.admin.model.*"%>

<%
    AdminService adminSvc = new AdminService();
    List<AdminVO> list = adminSvc.getAll();
    pageContext.setAttribute("list",list);
%>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>查看所有員工</title>
</head>
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
        width: 800px;
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

<h4>此頁練習採用 EL 的寫法取值:</h4>
<table id="table-1">
    <tr><td>
        <h3>所有員工資料 - listAllEmp.jsp</h3>
        <h4><a href="selectPage.jsp"><img src="images/logo2.png" width="100" height="32" border="0">回首頁</a></h4>
    </td></tr>
</table>

<table>
    <tr>
        <th>員工編號</th>
        <th>員工密碼</th>
        <th>員工姓名</th>
        <th>雇用日期</th>
        <th>薪水</th>
        <th>員工狀態</th>
        <th>員工信箱</th>
        <th>員工電話</th>
        <th>修改</th>
        <th>刪除</th>
    </tr>
    <c:forEach var="adminVO" items="${list}">

        <tr>
            <td>${adminVO.adminNo}</td>
            <td>${adminVO.adminAccount}</td>
            <td>${adminVO.adminPassword}</td>
            <td>${adminVO.adminName}</td>
            <td>${adminVO.createDate}</td>
            <td>${adminVO.adminStat}</td>
            <td>${adminVO.adminEmail}</td>
            <td>${adminVO.adminPhone}</td>
            <td>
                <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/admin/admin.do" style="margin-bottom: 0px;">
                    <input type="submit" value="修改">
                    <input type="hidden" name="adminNo"  value="${adminVO.adminNo}">
                    <input type="hidden" name="action"	value="getOne_For_Update"></FORM>
            </td>
            <td>
                <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/admin/admin.do" style="margin-bottom: 0px;">
                    <input type="submit" value="刪除">
                    <input type="hidden" name="adminNo"  value="${adminVO.adminNo}">
                    <input type="hidden" name="action" value="delete"></FORM>
            </td>
        </tr>
    </c:forEach>
</table>


</body>
</html>