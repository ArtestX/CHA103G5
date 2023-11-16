<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/ordertable/main/main.css">
    <title>新增 訂單</title>
    <script>
        function updateCurrentTime() {
            var now = new Date();
            var formattedTime = now.getFullYear() + '/' +
                (now.getMonth() + 1).toString().padStart(2, '0') + '/' +
                now.getDate().toString().padStart(2, '0') + ' ' +
                now.getHours().toString().padStart(2, '0') + ':' +
                now.getMinutes().toString().padStart(2, '0') + ':' +
                now.getSeconds().toString().padStart(2, '0');
            document.getElementById("currentTime").innerHTML = formattedTime;
        }

        setInterval(updateCurrentTime, 1000);
    </script>
</head>
<body>
    <a href="${pageContext.request.contextPath}/ordertable/index.jsp">訂單首頁</a>
    <h1>新增 訂單</h1>
    <br>
    <img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/ordertable/images/cat.png">
    <img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/ordertable/images/cat.png">
    <img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/ordertable/images/cat.png">
    <br>
    <form action="${pageContext.request.contextPath}/orderTableServlet" method="post">
        <input type="hidden" name="action" value="add" />
        <table>
            <tr>
                <td>會員編號：</td>
                <td><input type="text" name="memberNo" /></td>
            </tr>
            <tr>
                <td>訂單時間：</td>
                <td id="currentTime"></td>
            </tr>
            <tr>
                <td>商品總價：</td>
                <td><input type="text" name="totalAmount" /></td>
            </tr>
            <tr>
                <td>訂單狀態：</td>
                <td>
                    <select name="orderStat">
                        <option value="0" selected>訂單成立</option>
                        <option value="1">配送中</option>
                        <option value="2">訂單取消</option>
                        <option value="3">訂單退貨</option>
                        <option value="4">訂單換貨</option>
                        <option value="5">訂單完成</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>付費方式：</td>
                <td>
                    <select name="paymentMethod">
                        <option value="0" selected>信用卡</option>
                        <option value="1">貨到付款</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>運送方式：</td>
                <td>
                    <select name="shipMethod">
                        <option value="0" selected>宅配</option>
                        <option value="1">超商取貨</option>
                    </select>
                </td>
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
    <img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/ordertable/images/inversecat.png">
    <img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/ordertable/images/inversecat.png">
    <img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/ordertable/images/inversecat.png">
    <br><br>
    <a href="${pageContext.request.contextPath}/ordertable/index.jsp">訂單首頁</a>
</body>
</html>
