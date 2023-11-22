<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>





<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>動物種類管理 - select_page.jsp</title>

<%@ include file="included-fragment.file" %>
<style type="text/css">
	
	button {
		padding: 5px;
	}
	form {
		display: table;
	}
	form div {
		display: table-row;
	}
	label, input, span, select {
		display: table-cell;
		margin: 2px;
		text-align: left;		
	}
	input[type=text], input[type=password], select, textarea {
		width: 200px;
		margin: 2px;
	}
	form div div {
		display: table-cell;
	}
	.center {
        margin-left: auto;
        margin-right: auto;
    }
    span {
		display: inline-block;
		width: 150px;
		text-align: left;
		font-weight: bold;
	}
	div.a {
        display: inline-block;
        width: 50%;
        height: auto;
        padding: 5px;
        border: 0px solid blue;    
        background-color: white; 
    }
    div.b {
        display: inline-block;
        width: 45%;
        height: auto;
        padding: 5px;
        border: 1px solid blue;    
        background-color: white;
    }
</style>
</head>
<body>

<nav class="navbar navbar-expand-md navbar-dark bg-success fixed-top justify-content-center">
		 <div align="center"> <h2>動物種類管理 - select_page.jsp</h2>
		 <h3><a class="navbar-brand" href="<spring:url value='/'/>"><img src="<spring:url value='/images/back1.gif'/>">回index.jsp</a></h3></div>
</nav>

	<h4><span>資料查詢:</span></h4>
	<%-- 錯誤表列 --%>
	<div class="errorblock">${errorMessage}</div><br>
    <div class="a">
	  <ul>
		<li><h5><a href='listAll'>List</a> all AnimalTypes. <br><br></h5></li>

		<li>
			<form method="post" action="getOneForDisplay">
				輸入動物種類編號:
				<input type="text" name="animalTypeNo" value="${param.animalTypeNo}" >
				<input type="submit" value="送出"> (輸入如1, 2, 3)
			</form><br>
		</li>
		
		<li><form:form method="post" action="getOneForDisplay" modelAttribute="animalType">
				選擇動物種類:
				<form:select path="animalTypeNo" items="${animalTypeListData}" itemValue="animalTypeNo" itemLabel="animalTypeName" />
				<input type="submit" value="送出">
			</form:form><br>
		</li>


<%-- 萬用複合查詢-以下欄位-可隨意增減 --%>
  
  <li>   
    <FORM METHOD="post" ACTION="listByCompositeQuery">
        <font color=blue>萬用複合查詢:</font><br>
        輸入員工編號: 
        <input type="text" name="empno" value="7001"><br>
    
        選擇部門: 
        <select size="1" name="deptno" >
            <option value="">
          <c:forEach var="deptVO" items="${deptListData}" > 
            <option value="${deptVO.deptno}">${deptVO.dname}
          </c:forEach>   
        </select><br>
		        
        <input type="submit" value="送出">
     
     </FORM>
  </li>
</ul>
	
      <h4><span>動物種類管理</span></h4>
	  <ul>
		  <li><h5><a href='add'>Add</a> a new AnimalTye.</h5></li>
	  </ul>
    </div>

    <c:if test="${getOneForDisplay}">
         <div class="b">
	      <%@ include file="listOneEmp-div-fragment.file" %>
	     </div>  
    </c:if>

</body>
</html>