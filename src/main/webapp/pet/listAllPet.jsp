<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.cha103g5.pet.model.*"%>

<%-- <% --%>
// PetService petSvc = new PetService();
//     List<PetVO> list = petSvc.getAll();
//     pageContext.setAttribute("list",list);
<%-- %> --%>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>查看所有寵物</title>
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

<table id="table-1">
    <tr><td>
        <h3>所有寵物資料 - listAllPet.jsp</h3>
        <h4><a href="select_page.jsp"><img src="${pageContext.request.contextPath}/img/ok.png" width="50" height="50" border="0"><br>回首頁</a></h4>
    </td></tr>
</table>

<table>
    <tr>
        <th>寵物編號</th>
		<th>寵物狀態</th>
		<th>會員編號</th>
		<th>寵物名稱</th>
		<th>寵物性別</th>
		<th>寵物年齡</th>
		<th>備註</th>
		<th>寵物狀態</th>
		<th>截止時間</th>
        <th>修改</th>
        <th>刪除</th>
    </tr>
    <c:forEach var="petVO" items="${list}">

        <tr>
            <td>${petVO.petid}</td>
            <td>${petVO.animaltypeno}</td>
            <td>${petVO.memberno}</td>
            <td>${petVO.petname}</td>
            <td>${petVO.petsex}</td>
            <td>${petVO.petage}</td>
            <td>${petVO.petnote}</td>
            <td>${petVO.stat}</td>
            <td>${petVO.applicationdeadline}</td>
            <td>
                <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/pet/pet.do" style="margin-bottom: 0px;">
                    <input type="submit" value="修改">
                    <input type="hidden" name="petid"  value="${petVO.petid}">
                    <input type="hidden" name="action"	value="getOne_For_Update"></FORM>
            </td>
            <td>
                <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/pet/pet.do" style="margin-bottom: 0px;">
                    <input type="submit" value="刪除" onclick="return deleteSubmit();">
                    <input type="hidden" name="petid"  value="${petVO.petid}">
                    <input type="hidden" name="action" value="delete"></FORM>
            </td>
        </tr>
    </c:forEach>
</table>
	<script>
		function deleteSubmit(){
			if (confirm("確定刪除此資料?")){
				return true;
			} else{
				return false;
			}
		}
	</script>

</body>
</html>