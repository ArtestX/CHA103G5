<%@page import="com.cha103g5.product.model.*"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <title>�s�W���~</title>
    
    <style>
table#table-1 {
	width: 1000px;
	min-height: 250px; /* �]�w�̤p���סA�H�T�O�Ϥ�������T��� */
	background-color: #CCCCFF;
	border: 2px solid red;
	text-align: center;
	background-image: url('images/product1.jpg');
	background-size: cover; /* �i�վ�I���Ϥ��j�p�H�񺡪�� */
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
    	body {
            background-color: #f0f0f0;
            font-family: Arial, sans-serif;
            background-image: url('images/product2.jpg');
            background-position: center -200px; /* �ϥι����Ƚվ��m */
	        background-size: cover; /* �I���Ϥ��л\��ӵ��� */
	        background-repeat: no-repeat; /* ����Ϥ����� */
        }
    
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
        <h3>���~��Ʒs�W - addProduct.jsp</h3></td><td>
        <h4><a href="selectPage.jsp">�^����</a></h4>
    </td></tr>
</table>

<h3>�s�W���~:</h3>

<form method="post" action="product.do" name="form1">
    <table>
        <tr>
            <td>���~�s��:</td>
            <td>
                <input type="text" name="productNo" value="${param.productNo}" size="45"/>
            </td>
            <td>${errorMsgs.productNo}</td>
        </tr>
         <tr>
            <td>���O�s��:</td>
            <td>
                <input type="text" name="productCatNo" value="${param.productCatNo}" size="45"/>
            </td>
            <td>${errorMsgs.productCatNo}</td>
        </tr>
        <tr>
        <tr>
            <td>���~�W��:</td>
            <td>
                <input type="text" name="productName" value="${param.productName}" size="45"/>
            </td>
            <td>${errorMsgs.productName}</td>
        </tr>
        <tr>
            <td>���~����:</td>
            <td>
                <input type="text" name="productPrice" value="${param.productPrice}" size="45"/>
            </td>
            <td>${errorMsgs.productPrice}</td>
        </tr>
        <tr>
            <td>���~��T:</td>
            <td>
                <input type="text" name="productInfo" value="${param.productInfo}" size="45"/>
            </td>
            <td>${errorMsgs.productInfo}</td>
        </tr>
        <tr>
            <td>���~���A:</td>
            <td>
                <input type="text" name="productStat" value="${param.productStat}" size="45"/>
            </td>
            <td>${errorMsgs.productStat}</td>
        </tr>
        <tr>
            <td>���~����:</td>
            <td>
                <input type="text" name="productEval" value="${param.productEval}" size="45"/>
            </td>
            <td>${errorMsgs.productEval}</td>
        </tr>
        <tr>
            <td>���~�`����:</td>
            <td>
                <input type="text" name="productEvalTotal" value="${param.productEvalTotal}" size="45"/>
            </td>
            <td>${errorMsgs.productEvalTotal}</td>
        </tr>
        <tr>
            <td>�P��ƶq:</td>
            <td>
                <input type="text" name="productSaleNum" value="${param.productSaleNum}" size="45"/>
            </td>
            <td>${errorMsgs.productSaleNum}</td>
        </tr>
    </table>
    <br>
    <input type="hidden" name="action" value="insert">
    <input type="submit" value="�e�X�s�W">
</form>

</body>
</html>
