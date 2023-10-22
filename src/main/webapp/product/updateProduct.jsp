<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.cha103g5.product.model.ProductVO" %>

<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <title>產品資料修改</title>

    <!-- 样式表样式可以根据您的需求进行修改 -->
    <style>
    
    	body {
            background-color: #f0f0f0;
            font-family: Arial, sans-serif;
            background-image: url('images/product2.jpg');
            background-position: center -200px; /* 使用像素值調整位置 */
	        background-size: cover; /* 背景圖片覆蓋整個視窗 */
	        background-repeat: no-repeat; /* 防止圖片重複 */
        }
    	
        table#table-1 {
            width: 450px;
            background-color: #CCCCFF;
            border: 2px solid black;
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
        <h3>產品資料修改 - updateProduct.jsp</h3>
        <h4><a href="selectPage.jsp">回首頁</a></h4>
    </td></tr>
</table>

<h3>資料修改:</h3>

<FORM METHOD="post" ACTION="product.do" name="form1">
    <table>
        <tr>
            <td>產品編號:</td>
            <td><input type="text" name="productNo" value="${product.productNo}" size="45"/></td>
        </tr>
        <tr>
            <td>產品名稱:</td>
            <td><input type="text" name="productName" value="${product.productName}" size="45"/></td>
        </tr>
        <tr>
            <td>產品價格:</td>
            <td><input type="text" name="productPrice" value="${product.productPrice}" size="45"/></td>
        </tr>
        <tr>
            <td>產品資訊:</td>
            <td><input type="text" name="productInfo" value="${product.productInfo}" size="45"/></td>
        </tr>
        <tr>
            <td>產品狀態:</td>
            <td><input type="text" name="productStat" value="${product.productStat}" size="45"/></td>
        </tr>
        <tr>
            <td>產品評價:</td>
            <td><input type="text" name="productEval" value="${product.productEval}" size="45"/></td>
        </tr>
        <tr>
            <td>產品總評價:</td>
            <td><input type="text" name="productEvalTotal" value="${product.productEvalTotal}" size="45"/></td>
        </tr>
        <tr>
            <td>銷售數量:</td>
            <td><input type="text" name="productSaleNum" value="${product.productSaleNum}" size="45"/></td>
        </tr>
    </table>
    <br>
    <input type="hidden" name="action" value="update">
    <input type="submit" value="送出修改">
</FORM>
</body>
</html>
