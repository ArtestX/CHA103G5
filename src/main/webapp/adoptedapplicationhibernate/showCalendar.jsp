<%@ page import="java.util.Map" %>
<%@ page import="java.sql.Date" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    Map<Date, boolean[]> reservationMap = (Map<Date, boolean[]>) request.getAttribute("reservationMap");

    Calendar calendar = Calendar.getInstance();
    int year = calendar.get(Calendar.YEAR);
    int month = calendar.get(Calendar.MONTH);
    calendar.set(Calendar.DAY_OF_MONTH, 1);

    int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    int firstDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/adoptedapplicationhibernate/main/main.css">
    <title>行事曆</title>

    <style>
        .all-apply {
            border: 2px solid white; /* 鮮明的白色邊框 */
            border-radius: 5px; /* 圓角邊框 */
            padding: 5px; /* 內邊距 */
            margin: 2px; /* 外邊距 */
            text-align: left;
        }

        td:hover .all-apply {
            border: #e0f7fa;
            background-color: #e0f7fa;
        }

        .reserved-slot {
            border: 2px solid #00aaff; /* 鮮明的藍色邊框 */
            background-color: #f0f0f0; /* 淺灰色背景 */
            box-shadow: 0px 0px 10px rgba(0, 170, 255, 0.5); /* 藍色光暈陰影 */
            border-radius: 5px; /* 圓角邊框 */
            padding: 5px; /* 內邊距 */
            margin: 2px; /* 外邊距 */
            text-align: center; /* 文本居中 */
            transition: all 0.3s ease-in-out; /* 平滑過渡效果 */
        }

        .reserved-slot:hover {
            background-color: #00aaff; /* 滑鼠懸停時背景變藍 */
            /*color: #ffffff; !* 文本顏色變白 *!*/
            transform: scale(1.1); /* 輕微放大效果 */
        }

        tr:hover {
            background-color: white;
        }

        td:hover {
            background-color: #e0f7fa;
        }

        .delete-button {
            color: gray;
            background-color: red;
            border-radius: 50%; /* 圓形 */
            padding: 2px 5px; /* 內邊距 */
            font-size: 12px; /* 字體大小 */
            font-weight: bold; /* 粗體字 */
            cursor: pointer; /* 讓滑鼠顯示為指針形狀 */
            position: absolute; /* 絕對定位 */
            top: 0;
            right: 0;
            transform: translate(50%, -50%); /* 將按鈕稍微移出框框 */
            border: 2px solid #ff6666; /* 較粗的邊框增加深度感 */
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.5), 0 6px 20px rgba(0, 0, 0, 0.1); /* 強烈的外陰影 */
            text-shadow: 1px 1px 2px black; /* 文字陰影 */
            background-image: linear-gradient(to bottom, #ff6666, #cc0000); /* 漸變背景增加深度 */
        }

        .all-apply {
            position: relative; /* 為了絕對定位的 .delete-button */
        }

        form {
            border: none; /* 移除邊框 */
            background: transparent; /* 設定背景為透明 */
        }

    </style>

</head>
<body>
<button class="fixed-button" onclick="location.href='${pageContext.request.contextPath}/adoptedapplicationhibernate/index.jsp'">管理表單首頁</button>
<h1>當月行事曆</h1>
<br>
<img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/adoptedapplicationhibernate/images/cat.png">
<img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/adoptedapplicationhibernate/images/cat.png">
<img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/adoptedapplicationhibernate/images/cat.png">
<br>

<h2><%= year %>年 <%= (month + 1) %>月 行事曆</h2>
<table border="1">
    <tr>
        <th>星期日</th>
        <th>星期一</th>
        <th>星期二</th>
        <th>星期三</th>
        <th>星期四</th>
        <th>星期五</th>
        <th>星期六</th>
    </tr>
    <%
        int dayCounter = 1 - firstDayOfWeek;
        for (int week = 0; week < 6; week++) {
    %>
    <tr>
        <%
            for (int dayOfWeek = 1; dayOfWeek <= 7; dayOfWeek++) {
                if (dayCounter >= 1 && dayCounter <= daysInMonth) {
                    calendar.set(year, month, dayCounter);
                    // 僅使用年、月、日信息創建 java.sql.Date
                    Date currentDate = new Date(calendar.get(Calendar.YEAR) - 1900,
                                                calendar.get(Calendar.MONTH),
                                                calendar.get(Calendar.DATE));
                    boolean[] slots = reservationMap.getOrDefault(currentDate, new boolean[3]);
        %>

    <td>
        <span style="font-size: 36px;"><%= dayCounter %></span><br>

        <div class="<%= slots[0] ? "reserved-slot" : "" %> all-apply">
            早: <%= slots[0] ? "<span style='color:red;'>&#10004;</span>" : "" %>
            <% if (slots[0]) { %>
            <form action="${pageContext.request.contextPath}/adoptedApplicationHibernateServlet" method="post">
                <input type="hidden" name="action" value="deleteCalendar">
                <input type="hidden" name="interactionDate" value="<%= sdf.format(currentDate) %>">
                <input type="hidden" name="timeSlot" value="morning">
                <button type="submit" class="delete-button">&#10005;</button>
            </form>
            <% } %>
        </div>

        <div class="<%= slots[1] ? "reserved-slot" : "" %> all-apply">
            午: <%= slots[1] ? "<span style='color:red;'>&#10004;</span>" : "" %>
            <% if (slots[1]) { %>
            <form action="${pageContext.request.contextPath}/adoptedApplicationHibernateServlet" method="post">
                <input type="hidden" name="action" value="deleteCalendar">
                <input type="hidden" name="interactionDate" value="<%= sdf.format(currentDate) %>">
                <input type="hidden" name="timeSlot" value="afternoon">
                <button type="submit" class="delete-button">&#10005;</button>
            </form>
            <% } %>
        </div>

        <div class="<%= slots[2] ? "reserved-slot" : "" %> all-apply">
            晚: <%= slots[2] ? "<span style='color:red;'>&#10004;</span>" : "" %>
            <% if (slots[2]) { %>
            <form action="${pageContext.request.contextPath}/adoptedApplicationHibernateServlet" method="post">
                <input type="hidden" name="action" value="deleteCalendar">
                <input type="hidden" name="interactionDate" value="<%= sdf.format(currentDate) %>">
                <input type="hidden" name="timeSlot" value="night">
                <button type="submit" class="delete-button">&#10005;</button>
            </form>
            <% } %>
        </div>
    </td>

    <%
        } else {
    %>
    <td></td>
    <%
            }
            if (dayCounter <= daysInMonth) dayCounter++;
        }
    %>
</tr>
    <%
            if (dayCounter > daysInMonth) break;
        }
    %>
</table>

<img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/adoptedapplicationhibernate/images/inversecat.png">
<img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/adoptedapplicationhibernate/images/inversecat.png">
<img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/adoptedapplicationhibernate/images/inversecat.png">
<br><br>


</body>
</html>
