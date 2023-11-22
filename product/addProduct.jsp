<%@page import="com.cha103g5.product.model.*"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <title>新增產品</title>
    
    <style>
table#table-1 {
	width: 1000px;
	min-height: 250px; /* 設定最小高度，以確保圖片能夠正確顯示 */
	background-color: #CCCCFF;
	border: 2px solid red;
	text-align: center;
	background-image: url('images/product1.jpg');
	background-size: cover; /* 可調整背景圖片大小以填滿表格 */
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
            background-position: center -200px; /* 使用像素值調整位置 */
	        background-size: cover; /* 背景圖片覆蓋整個視窗 */
	        background-repeat: no-repeat; /* 防止圖片重複 */
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
        <h3>產品資料新增 - addProduct.jsp</h3></td><td>
        <h4><a href="selectPage.jsp">回首頁</a></h4>
    </td></tr>
</table>

<h3>新增產品:</h3>

<form method="post" action="product.do" name="form1">
    <table>
        <tr>
            <td>產品編號:</td>
            <td>
                <input type="text" name="productNo" value="${param.productNo}" size="45"/>
            </td>
            <td>${errorMsgs.productNo}</td>
        </tr>
         <tr>
            <td>類別編號:</td>
            <td>
                <input type="text" name="productCatNo" value="${param.productCatNo}" size="45"/>
            </td>
            <td>${errorMsgs.productCatNo}</td>
        </tr>
        <tr>
        <tr>
            <td>產品名稱:</td>
            <td>
                <input type="text" name="productName" value="${param.productName}" size="45"/>
            </td>
            <td>${errorMsgs.productName}</td>
        </tr>
        <tr>
            <td>產品價格:</td>
            <td>
                <input type="text" name="productPrice" value="${param.productPrice}" size="45"/>
            </td>
            <td>${errorMsgs.productPrice}</td>
        </tr>
        <tr>
            <td>產品資訊:</td>
            <td>
                <input type="text" name="productInfo" value="${param.productInfo}" size="45"/>
            </td>
            <td>${errorMsgs.productInfo}</td>
        </tr>
        <tr>
            <td>產品狀態:</td>
            <td>
                <input type="text" name="productStat" value="${param.productStat}" size="45"/>
            </td>
            <td>${errorMsgs.productStat}</td>
        </tr>
        <tr>
            <td>產品評價:</td>
            <td>
                <input type="text" name="productEval" value="${param.productEval}" size="45"/>
            </td>
            <td>${errorMsgs.productEval}</td>
        </tr>
        <tr>
            <td>產品總評價:</td>
            <td>
                <input type="text" name="productEvalTotal" value="${param.productEvalTotal}" size="45"/>
            </td>
            <td>${errorMsgs.productEvalTotal}</td>
        </tr>
        <tr>
            <td>銷售數量:</td>
            <td>
                <input type="text" name="productSaleNum" value="${param.productSaleNum}" size="45"/>
            </td>
            <td>${errorMsgs.productSaleNum}</td>
        </tr>
    </table>
    <br>
    <input type="hidden" name="action" value="insert">
    <input type="submit" value="送出新增">
</form>

</body>
</html>
