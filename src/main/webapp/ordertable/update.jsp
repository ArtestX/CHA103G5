<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/ordertable/main/main.css">
    <title>修改 訂單</title>
</head>
<body>
    <a href="${pageContext.request.contextPath}/ordertable/index.jsp">訂單首頁</a>
    <h1>修改 訂單</h1>
    <br>
    <img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/ordertable/images/cat.png">
    <img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/ordertable/images/cat.png">
    <img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/ordertable/images/cat.png">
    <br>
    <form action="${pageContext.request.contextPath}/orderTableServlet" method="post">
        <input type="hidden" name="action" value="update" />
        <input type="hidden" name="orderTableNo" value="${orderTable.orderTableNo}" />
        <table>
            <tr>
                <td>訂單編號：</td>
                <td>${orderTable.orderTableNo}</td>
            </tr>
            <tr>
                <td>會員編號：</td>
                <td><input type="text" name="memberNo" value=${orderTable.memberNo}></td>
            </tr>
            <tr>
                <td>訂單時間：</td>
                <td>${orderTable.orderTime}</td>
            </tr>
            <tr>
                <td>商品總價：</td>
                <td><input type="text" name="totalAmount" value=${orderTable.totalAmount}></td>
            </tr>
            <tr>
                <td>訂單狀態：</td>
                <td>
                    <select name="orderStat">
                        <option value="0" <c:if test="${orderTable.orderStat == 0}">selected</c:if>>訂單成立</option>
                        <option value="1" <c:if test="${orderTable.orderStat == 1}">selected</c:if>>配送中</option>
                        <option value="2" <c:if test="${orderTable.orderStat == 2}">selected</c:if>>訂單取消</option>
                        <option value="3" <c:if test="${orderTable.orderStat == 3}">selected</c:if>>訂單退貨</option>
                        <option value="4" <c:if test="${orderTable.orderStat == 4}">selected</c:if>>訂單換貨</option>
                        <option value="5" <c:if test="${orderTable.orderStat == 5}">selected</c:if>>訂單完成</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>付費方式：</td>
                <td>
                    <select name="paymentMethod">
                        <option value="0" <c:if test="${orderTable.paymentMethod == 0}">selected</c:if>>信用卡</option>
                        <option value="1" <c:if test="${orderTable.paymentMethod == 1}">selected</c:if>>貨到付款</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>運送方式：</td>
                <td>
                    <select name="shipMethod">
                        <option value="0" <c:if test="${orderTable.shipMethod == 0}">selected</c:if>>宅配</option>
                        <option value="1" <c:if test="${orderTable.shipMethod == 1}">selected</c:if>>超商取貨</option>
                    </select>
                </td>
            </tr>
            <br>
            <br>
            <tr>
                <td colspan="2">
                    <input type="submit" value="更新" />
                </td>
            </tr>
        </table>
    </form>
    <br>
    <img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/ordertable/images/inversecat.png">
    <img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/ordertable/images/inversecat.png">
    <img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/ordertable/images/inversecat.png">
    <br><br>
    <a href="${pageContext.request.contextPath}/ordertable/index.jsp">訂單首頁</a>
</body>
</html>
