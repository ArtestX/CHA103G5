<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.cha103g5.animaltype.model.*"%>

<html>
<head>
<title>�ʪ���������</title>

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
   <tr><td><h3>�ʪ���������</h3><h4>( MVC )</h4></td></tr>
</table>

<h3>�ʪ������d��:</h3>

<ul>
  <li><a href='listAllAnimalType.jsp'>�C�X</a> �����ʪ�����  <br><br></li>
</ul>


<h3>�ʪ������޲z</h3>

<ul>
  <li><a href='addAnimalType.jsp'>�s�W</a> �ʪ�����</li>
</ul>

</body>
</html>