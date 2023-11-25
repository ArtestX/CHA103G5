<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
<%--    <link rel="stylesheet" href="${pageContext.request.contextPath}/adoptedapplicationhibernate/main/main.css">--%>
    <title>結帳頁面</title>
    <style>
        /* 基礎重置 */
        body, h1, h2, h3, p, form, input, select {
            margin: 0;
            padding: 0;
            font-family: 'Arial', sans-serif;
        }

        /* 高科技感的顏色和背景 */
        body {
            background-color: #f4f4f4;
            color: #333;
        }

        /* 標題樣式 */
        h2 {
            color: #0a84ff;
            text-align: center;
            margin-bottom: 20px;
        }

        /* 表單樣式 */
        form {
            width: 300px;
            margin: 20px auto;
            padding: 20px;
            background: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        /* 輸入框和下拉式選單樣式 */
        input[type="text"], input[type="number"], select {
            width: 100%;
            padding: 8px;
            margin: 10px 0;
            border: 1px solid #ddd;
            border-radius: 4px;
            box-sizing: border-box;
        }

        /* 按鈕樣式 */
        input[type="submit"] {
            width: 100%;
            padding: 10px;
            border: none;
            border-radius: 4px;
            background-color: #0a84ff;
            color: white;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }

        /* 段落樣式 */
        p {
            margin-bottom: 10px;
        }

        /* 小提示 */
        .small-text {
            font-size: 0.8em;
            color: #666;
        }

    </style>
</head>
<body>
    <form action="#" method="post">
        <h2>結帳頁面</h2>
        <table>
        <!-- 使用 Servlet 取得參數 -->
    <%--    <%--%>
    <%--        // 假設這些參數已經從 Servlet 傳來--%>
    <%--        int memberNo = Integer.parseInt(request.getParameter("memberNo"));--%>
    <%--        int productNo = Integer.parseInt(request.getParameter("productNo"));--%>
    <%--        int productPrice = Integer.parseInt(request.getParameter("productPrice"));--%>
    <%--        int quantity = Integer.parseInt(request.getParameter("quantity"));--%>
    <%--        int totalAmount = productPrice * quantity; // 計算總金額--%>
    <%--    %>--%>

            <!-- 動態顯示訂單時間 -->
<%--            <tr>--%>
<%--                <td>訂單時間:</td>--%>
<%--                <td><%= new java.util.Date() %></td>--%>
<%--            </tr>--%>

            <tr>
                <td>訂單時間：</td>
                <td id="currentTime"></td>
            </tr>

    <%--    <!-- 顯示計算出的總金額 -->--%>
    <%--    <p>總金額: <%= totalAmount %> 元</p>--%>

        <!-- 隱藏字段 -->
    <%--    <input type="hidden" name="memberNo" value="<%= memberNo %>">--%>
        <input type="hidden" name="orderStat" value="0"> <!-- 訂單狀態預設為0 -->

            <!-- 付款方式選擇 -->
            <tr>
                <td>付款方式:</td>
                <td>
                    <select name="paymentMethod">
                        <option value="0" selected>信用卡</option>
                        <option value="1">貨到付款</option>
                    </select>
                </td>
            </tr>

            <!-- 運送方式選擇 -->
            <tr>
                <td>運送方式:</td>
                <td>
                    <select name="shipMethod">
                        <option value="0" selected>宅配</option>
                        <option value="1">超商取貨</option>
                    </select>
                </td>
            </tr>

            <!-- 提交按鈕 -->
            <tr>
                <td colspan="2">
                    <input type="submit" value="提交訂單">
                </td>
            </tr>
        </table>
    </form>

    <script>
        function updateCurrentTime() {
            let now = new Date();
            let formattedTime = now.getFullYear() + '/' +
                (now.getMonth() + 1).toString().padStart(2, '0') + '/' +
                now.getDate().toString().padStart(2, '0') + ' ' +
                now.getHours().toString().padStart(2, '0') + ':' +
                now.getMinutes().toString().padStart(2, '0') + ':' +
                now.getSeconds().toString().padStart(2, '0');
            document.getElementById("currentTime").innerHTML = formattedTime;
        }

        setInterval(updateCurrentTime, 1000);
    </script>
</body>
</html>
