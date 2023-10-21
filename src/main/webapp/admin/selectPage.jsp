<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>員工管理系統</title>
    <style>
        table#table-1 {
            width: 450px;
            background-color: #CCCCFF;
            margin-top: 5px;
            margin-bottom: 10px;
            border: 3px ridge Gray;
            height: 80px;
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

</head>
<body bgcolor='white'>

<table id="table-1">
    <tr>
        <td><h3>員工管理系統首頁</h3><h4>( MVC )</h4></td>
    </tr>
</table>

<h3>資料查詢:</h3>

<ul>
    <li><a href='adminsystem.jsp'>List</a> all Emps. <br><br></li>


    <li>
        <FORM METHOD="post" ACTION="admin.do">
            <b>輸入員工編號 (如40010):</b>
            <input type="text" name="adminNo" value="${param.adminNo}"><font color=red>${errorMsgs.adminNo}</font>
            <input type="hidden" name="action" value="getOne_For_Display">
            <input type="submit" value="送出">
        </FORM>
    </li>

    <jsp:useBean id="adminSvc" scope="page" class="com.cha103g5.admin.model.AdminService"/>

    <li>
        <FORM METHOD="post" ACTION="admin.do">
            <b>選擇員工編號:</b>
            <select size="1" name="adminNo">
                <c:forEach var="adminVO" items="${adminSvc.all}">
                <option value="${adminVO.adminNo}">${adminVO.adminNo}
                    </c:forEach>
            </select>
            <input type="hidden" name="action" value="getOne_For_Display">
            <input type="submit" value="送出">
        </FORM>
    </li>

    <li>
        <FORM METHOD="post" ACTION="admin.do">
            <b>選擇員工姓名:</b>
            <select size="1" name="adminNo">
                <c:forEach var="adminVO" items="${adminSvc.all}">
                <option value="${adminVO.adminNo}">${adminVO.adminName}
                    </c:forEach>
            </select>
            <input type="hidden" name="action" value="getOne_For_Display">
            <input type="submit" value="送出">
        </FORM>
    </li>
</ul>


<h3>員工管理</h3>

<ul>
    <li><a href='addAdmin.jsp'>Add</a> a new Emp.</li>
</ul>

</body>
</html>