<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.cha103g5.animaltype.model.*"%>

<html>
<head>
<title>動物種類首頁</title>

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
   <tr><td><h3>動物種類首頁</h3><h4>( MVC )</h4></td></tr>
</table>

<h3>動物種類查詢:</h3>

<ul>
  <li><a href='listAllAnimalType.jsp'>列出</a> 全部動物種類  <br><br></li>
</ul>


<h3>動物種類管理</h3>

<ul>
  <li><a href='addAnimalType.jsp'>新增</a> 動物種類</li>
</ul>

</body>
</html>