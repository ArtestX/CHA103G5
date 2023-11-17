<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/orderdetail/main/main.css">
    <title>新增 訂單明細</title>
</head>
<body>
    <a href="${pageContext.request.contextPath}/orderdetail/index.jsp">訂單明細首頁</a>
    <h1>新增 訂單明細</h1>
    <br>
    <img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/orderdetail/images/cat.png">
    <img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/orderdetail/images/cat.png">
    <img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/orderdetail/images/cat.png">
    <br>
    <form action="${pageContext.request.contextPath}/orderDetailServlet" method="post">
        <input type="hidden" name="action" value="add" />
        <table>
            <tr>
                <td>訂單編號：</td>
                <td><input type="text" name="orderTableNo" /></td>
            </tr>
            <tr>
                <td>商品編號：</td>
                <td><input type="text" name="productNo" /></td>
            </tr>
            <tr>
                <td>商品數量：</td>
                <td><input type="text" name="quantity" /></td>
            </tr>
            <tr>
                <td>商品價格：</td>
                <td><input type="text" name="productPrice" /></td>
            </tr>
            <br>
            <br>
            <tr>
                <td colspan="2">
                    <input type="submit" value="新增" />
                </td>
            </tr>
        </table>
    </form>
    <br>
    <img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/orderdetail/images/inversecat.png">
    <img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/orderdetail/images/inversecat.png">
    <img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/orderdetail/images/inversecat.png">
    <br><br>
    <a href="${pageContext.request.contextPath}/orderdetail/index.jsp">訂單明細首頁</a>
</body>
</html>
