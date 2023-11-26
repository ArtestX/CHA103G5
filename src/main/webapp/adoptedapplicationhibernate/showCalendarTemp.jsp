<%@ page import="java.util.Map" %>
<%@ page import="java.sql.Date" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%--<%--%>
<%--    Object adminAccount = session.getAttribute("adminVO");                 		 // 從 session內取出 (key) adminVO的值--%>
<%--    if (adminAccount == null) {                                             	 // 如為 null, 代表此user未登入過 , 才做以下工作--%>
<%--      session.setAttribute("location", request.getRequestURI());       			 //*工作1 : 同時記下目前位置 , 以便於adminLogin登入成功後 , 能夠直接導至此網頁--%>
<%--      response.sendRedirect(request.getContextPath()+"/admin/adminLogin.jsp");   //*工作2 : 請該user去登入網頁(adminLogin) , 進行登入--%>
<%--      return;--%>
<%--    }--%>
<%--%>--%>

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
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>行事曆</title>
  
  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/adoptedapplicationhibernate/main/main.css">
  
  <style>
    body {
      background-image: url('<%=request.getContextPath()%>/img/desktop.jpg');
      background-size: cover;
      background-attachment: fixed; /* 固定背景圖片 */
      background-repeat: no-repeat;
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
<nav class="navbar custom-bg-color">
  <div class="container-fluid">
    <a class="navbar-brand" href="<%=request.getContextPath()%>/admin/backendMain.jsp">
      <img src="<%=request.getContextPath()%>/img/backpack2-fill.svg" alt="Logo" width="30" height="24" class="d-inline-block align-text-top">
      後臺管理系統
    </a>
    <div class="ms-auto">
      <form method="POST" action="./admin.do">
        <button class="btn btn-danger">登出</button>
        <input type="hidden" name="action" value="backendlogout">
      </form>
    </div>
  </div>
</nav>
<div class="container-fluid">
  <div class="row">
    <div class="col-lg-2 g-3">
      <!--左邊-->
      <div class="accordion" id="accordionExample">
        <div class="accordion-item">
          <h2 class="accordion-header">
            <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
              員工管理
            </button>
          </h2>
          <div id="collapseOne" class="accordion-collapse collapse" data-bs-parent="#accordionExample">
            <div class="accordion-body">
              <strong><a href="adminSystem.jsp" class="list-group-item list-group-item-action" onclick="return checkAdminStat();">員工列表</a></strong>
            </div>
          </div>
        </div>
        <div class="accordion-item">
          <h2 class="accordion-header">
            <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
              商品管理
            </button>
          </h2>
          <div id="collapseTwo" class="accordion-collapse collapse" data-bs-parent="#accordionExample">
            <div class="accordion-body">
              <strong><a href="${pageContext.request.contextPath}/allProduct" class="list-group-item list-group-item-action">商品編輯</a></strong>
            </div>
          </div>
        </div>
        <div class="accordion-item">
          <h2 class="accordion-header">
            <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
              訂單管理
            </button>
          </h2>
          <div id="collapseThree" class="accordion-collapse collapse" data-bs-parent="#accordionExample">
            <div class="accordion-body">
              <strong><a href="<%=request.getContextPath()%>/orderTableServlet?action=getAll" class="list-group-item list-group-item-action">訂單列表</a></strong>
            </div>
          </div>
        </div>
        <div class="accordion-item">
          <h2 class="accordion-header">
            <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapse4" aria-expanded="false" aria-controls="collapse4">
              客服管理
            </button>
          </h2>
          <div id="collapse4" class="accordion-collapse collapse" data-bs-parent="#accordionExample">
            <div class="accordion-body">
              <strong><a href="<%=request.getContextPath()%>/customer/backChat.jsp" class="list-group-item list-group-item-action">即時客服</a></strong>
            </div>
          </div>
        </div>
        <div class="accordion-item">
          <h2 class="accordion-header">
            <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapse5" aria-expanded="false" aria-controls="collapse5">
              寵物領養管理
            </button>
          </h2>
          <div id="collapse5" class="accordion-collapse collapse" data-bs-parent="#accordionExample">
            <div class="accordion-body">
              <strong><a href="<%=request.getContextPath()%>/pet/select_page.jsp" class="list-group-item list-group-item-action">寵物列表</a></strong>
            </div>
            <div class="accordion-body">
              <strong><a href="<%=request.getContextPath()%>/adoptedapplicationhibernate/indexTemp.jsp" class="list-group-item list-group-item-action">領養查詢</a></strong>
            </div>
            <div class="accordion-body">
              <strong><a href="<%=request.getContextPath()%>/adoptedApplicationHibernateServletTemp?action=getAll" class="list-group-item list-group-item-action">所有預約查詢</a></strong>
            </div>
            <div class="accordion-body">
              <strong><a href="<%=request.getContextPath()%>/adoptedApplicationHibernateServletTemp?action=showCalendar" class="list-group-item list-group-item-action">行事曆管理</a></strong>
            </div>
          </div>

        </div>
        <div class="accordion-item">
          <h2 class="accordion-header">
            <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapse6" aria-expanded="false" aria-controls="collapse6">
              會員資料管理
            </button>
          </h2>
          <div id="collapse6" class="accordion-collapse collapse" data-bs-parent="#accordionExample">
            <div class="accordion-body">
              <strong><a href="<%=request.getContextPath()%>/member/allMembers.jsp" class="list-group-item list-group-item-action">會員列表</a></strong>
            </div>
          </div>
        </div>
        <div class="accordion-item">
          <h2 class="accordion-header">
            <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapse7" aria-expanded="false" aria-controls="collapse7">
              公告資訊管理
            </button>
          </h2>
          <div id="collapse7" class="accordion-collapse collapse" data-bs-parent="#accordionExample">
            <div class="accordion-body">
              <strong><a href="http://localhost:8080/CHA103G5/informationannouncement/select_page.jsp" class="list-group-item list-group-item-action">公告列表</a></strong>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!--左邊-->

    <div class="col-lg-10 g-3">
      <!--右邊-->

      <%--<button class="fixed-button" onclick="location.href='${pageContext.request.contextPath}/adoptedapplicationhibernate/index.jsp'">管理表單首頁</button>--%>
      <button class="fixed-button" onclick="location.href='${pageContext.request.contextPath}/admin/backendMain.jsp'">後台首頁</button>
      <h1>當月行事曆</h1>
      <br>
      <img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/adoptedapplicationhibernate/images/cat.png">
      <img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/adoptedapplicationhibernate/images/cat.png">
      <img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/adoptedapplicationhibernate/images/cat.png">
      <br>

      <h2><%= year %>年 <%= (month + 1) %>月 行事曆   <span style='color:red;'>(&#10004;為已選時段)</span></h2>
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
              早: <%= slots[0] ? "<span style='color:red;'>&#10004;</span>" : "" %>
              <% if (slots[0]) { %>
              <form action="${pageContext.request.contextPath}/adoptedApplicationHibernateServletTemp" method="post">
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
              <form action="${pageContext.request.contextPath}/adoptedApplicationHibernateServletTemp" method="post">
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
              <form action="${pageContext.request.contextPath}/adoptedApplicationHibernateServletTemp" method="post">
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


      <!--右邊-->
    </div>
  </div>
</div>




<script src="<%=request.getContextPath()%>/js/popper.min.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
</body>
</html>
