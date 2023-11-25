<%@ page import="java.util.Map" %>
<%@ page import="java.sql.Date" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="/banner.jsp" flush="true" />
<%@ page import="com.cha103g5.member.model.*"%>
<%@ page import="java.util.*"%>

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

<%
    // 把MemberVO的資料從session取出
    com.cha103g5.member.model.MemberVO user = (com.cha103g5.member.model.MemberVO) session.getAttribute("user");

%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%-- <link rel="stylesheet" href="<%=request.getContextPath()%>/css/sweetalert2.css"> --%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/adoptedapplicationhibernate/main/main.css">
    <title>行事曆</title>

    <style>

        body {
            background-color: rgb(243, 243, 243);
            margin: 0;
            padding: 0;
        }

        a{
            text-decoration: none;
            color:black;
        }

        font {
            color:red;
            margin-top:10px;
            float: right;
            font-size: 15px;
        }

        #passwordError, #checkpasswordError{
            color: red ;
            float: left;
            font-size: 14px;
            margin-top: 5px;
            width: 200px;
        }

        /*****側邊選單*****/
        .card {
            margin-top: 70px;
            width:220px;
            border: none;
            text-align: center;
            font-weight: bold;
        }

        .card-header{
            background-color: #655353;
            color: white;
        }

        .list-group-item:hover {
            background-color: rgb(222, 215, 212);
        }

        /*****按鈕樣式*****/
        .btn {
            color: #422E2F;
            background-color: #FAE899;
            border: 1px solid rgba(238, 234, 234, 0.5);
        }

        .btn:hover {
            background-color: #bae5f3fb;
            box-shadow: 0 1px 4px rgba(64, 64, 64, 1);
        }

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
            margin: 0;
            padding: 0;
        }

        table td {
            background-color: white;
            border: 1px solid black;
        }

    </style>

</head>
<body>
<div class="container">
    <div class="row">
        <!-- ----------left start---------- -->
        <div class="col-md-9">

<%--<button class="fixed-button" onclick="location.href='${pageContext.request.contextPath}/adoptedapplicationhibernate/index.jsp'">管理表單首頁</button>--%>
<h1>當月行事曆</h1>
<br>
<img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/adoptedapplicationhibernate/images/cat.png">
<img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/adoptedapplicationhibernate/images/cat.png">
<img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/adoptedapplicationhibernate/images/cat.png">
<br>

<h2><%= year %>年 <%= (month + 1) %>月 行事曆</span></h2>
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

        <td id="deleteButton" >
            <span style="font-size: 36px;"><%= dayCounter %></span><br>

            <div class="<%= slots[0] ? "reserved-slot" : "" %> all-apply">
                早: <%= slots[0] ? "<span style='color:red;'>&#10005;</span>" : "" %>
<%--                <% if (slots[0]) { %>--%>
<%--                <form action="${pageContext.request.contextPath}/adoptedApplicationHibernateServletTemp" method="post">--%>
<%--                    <input type="hidden" name="action" value="deleteCalendar">--%>
<%--                    <input type="hidden" name="interactionDate" value="<%= sdf.format(currentDate) %>">--%>
<%--                    <input type="hidden" name="timeSlot" value="morning">--%>
<%--                    <button type="submit" class="delete-button">&#10005;</button>--%>
<%--                </form>--%>
<%--                <% } %>--%>
            </div>

            <div class="<%= slots[1] ? "reserved-slot" : "" %> all-apply">
                午: <%= slots[1] ? "<span style='color:red;'>&#10005;</span>" : "" %>
<%--                <% if (slots[1]) { %>--%>
<%--                <form action="${pageContext.request.contextPath}/adoptedApplicationHibernateServletTemp" method="post">--%>
<%--                    <input type="hidden" name="action" value="deleteCalendar">--%>
<%--                    <input type="hidden" name="interactionDate" value="<%= sdf.format(currentDate) %>">--%>
<%--                    <input type="hidden" name="timeSlot" value="afternoon">--%>
<%--                    <button type="submit" class="delete-button">&#10005;</button>--%>
<%--                </form>--%>
<%--                <% } %>--%>
            </div>

            <div class="<%= slots[2] ? "reserved-slot" : "" %> all-apply">
                晚: <%= slots[2] ? "<span style='color:red;'>&#10005;</span>" : "" %>
<%--                <% if (slots[2]) { %>--%>
<%--                <form action="${pageContext.request.contextPath}/adoptedApplicationHibernateServletTemp" method="post">--%>
<%--                    <input type="hidden" name="action" value="deleteCalendar">--%>
<%--                    <input type="hidden" name="interactionDate" value="<%= sdf.format(currentDate) %>">--%>
<%--                    <input type="hidden" name="timeSlot" value="night">--%>
<%--                    <button type="submit" class="delete-button">&#10005;</button>--%>
<%--                </form>--%>
<%--                <% } %>--%>
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

    <div class="row" style="min-height: 350px;"></div>




        </div>
        <!-- ----------left end---------- -->
        <!-- ----------right start---------- -->
        <div class="col-md-3">
            <div class="card" >
                <div class="card-header">
                    <c:out value="您好，${user.membername}！" />
                </div>

                <ul class="list-group list-group-flush">

                    <li class="list-group-item">
                        <a href="<%=request.getContextPath()%>/member/memberCenter.jsp">基本資料</a>
                    </li>

                    <li class="list-group-item">
                        <a href="#" onclick="document.getElementById('orderForm').submit();">訂單明細</a>
                        <form style="display: none;" id="orderForm" action="${pageContext.request.contextPath}/orderTableServlet" method="GET">
                            <input type="hidden" name="action" value="getByMemberNoFrontend">
                            <input type="hidden" name="memberNo" value="${user.memberno}">
                        </form>
                    </li>

                    <li class="list-group-item">
                        <a href="#" onclick="document.getElementById('applicationForm').submit();">預約詳情</a>
                        <form style="display: none;" id="applicationForm" action="${pageContext.request.contextPath}/adoptedApplicationHibernateServletTemp" method="GET">
                            <input type="hidden" name="action" value="frontendGetByMemberNo">
                            <input type="hidden" name="memberNo" value="${user.memberno}">
                        </form>
                    </li>

                </ul>
            </div>
        </div>
        <!-- ----------right end---------- -->
    </div>
</div>
<jsp:include page="/footer.jsp" flush="true" />
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
</body>
</html>
