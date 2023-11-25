<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="/banner.jsp" flush="true" />
<%@ page import="com.cha103g5.member.model.*"%>
<%@ page import="java.util.*"%>

<%
    // 把MemberVO的資料從session取出
    com.cha103g5.member.model.MemberVO user = (com.cha103g5.member.model.MemberVO) session.getAttribute("user");

%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/adoptedapplicationhibernate/main/main.css">
    <%-- <link rel="stylesheet" href="<%=request.getContextPath()%>/css/sweetalert2.css"> --%>
    <title>領養表單</title>

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
<%--    <a href="${pageContext.request.contextPath}/adoptedapplicationhibernate/index.jsp">申請表單首頁</a>--%>
<%--<button class="fixed-button" onclick="location.href='${pageContext.request.contextPath}/adoptedapplicationhibernate/index.jsp'">管理表單首頁</button>--%>
<h1>領養表單</h1>
<br>
<img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/adoptedapplicationhibernate/images/cat.png">
<img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/adoptedapplicationhibernate/images/cat.png">
<img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/adoptedapplicationhibernate/images/cat.png">
<br>
<c:choose>
    <c:when test="${not empty someApplications}">
        <table style="width:50%; text-align:center;">
            <tr>
                <th>申請編號</th>
<%--                <th>管理員編號</th>--%>
<%--                <th>會員編號</th>--%>
                <th>寵物編號</th>
                    <%--                    <th>抽籤日期</th>--%>
                <th>處理進度</th>
                <th>申請日期</th>
                <th>預約時間</th>
                <th>申請狀態</th>
                <th>簽名</th>
                <th class="notes-header">備註</th>
<%--                <th>修改</th>--%>
<%--                <th>刪除</th>--%>
            </tr>
            <c:forEach var="application" items="${someApplications}" varStatus="status">
                <tr>
                    <td>${application.applicationNo}</td>
<%--                    <td>${application.adminNo}</td>--%>
<%--                    <td>${application.memberNo}</td>--%>
                    <td>${application.petId}</td>
                        <%--                        <td class="date-cell">${application.lotteryDate}</td>--%>
                        <%--                        <td>${application.lotteryResult}</td>--%>
                    <td class="date-cell">
                        <c:choose>
                            <c:when test="${application.lotteryResult == 0}">處理表單</c:when>
                            <c:when test="${application.lotteryResult == 1}">成功領養</c:when>
                            <c:when test="${application.lotteryResult == 2}">領養失敗</c:when>
                            <c:otherwise>未知狀態</c:otherwise>
                        </c:choose>
                    </td>
                    <td class="date-cell">${application.applicationDate}</td>
                    <td class="date-cell">${application.interactionDate}&nbsp;&nbsp;${application.interactionTime}</td>
                    <td class="date-cell">
                        <c:choose>
                            <c:when test="${application.applicationStat == 0}">審核中</c:when>
                            <c:when test="${application.applicationStat == 1}">未通過</c:when>
                            <c:when test="${application.applicationStat == 2}">通過</c:when>
                            <%--                                <c:when test="${application.applicationStat == 3}">備取中</c:when>--%>
                            <%--                                <c:when test="${application.applicationStat == 4}">通知後無意願</c:when>--%>
                            <%--                                <c:when test="${application.applicationStat == 5}">領養成功</c:when>--%>
                            <%--                                <c:when test="${application.applicationStat == 6}">領養失敗</c:when>--%>
                            <c:otherwise>未知狀態</c:otherwise>
                        </c:choose>
                    </td>
                    <td>
                        <c:if test="${not empty application.signaturePhotoBase64}">
                            <img src="data:image/png;base64,${application.signaturePhotoBase64}" alt="Signature Photo"/>
                        </c:if>
                    </td>
                    <td class="notes-cell">${application.applicantNotes}</td>
<%--                    <td>--%>
<%--                        <form class=form-button action="${pageContext.request.contextPath}/adoptedApplicationHibernateServletTemp" method="post">--%>
<%--                            <input type="hidden" name="action" value="edit" />--%>
<%--                            <input type="hidden" name="applicationNo" value="${application.applicationNo}" />--%>
<%--                            <input class="table-button" type="submit" value="修改" />--%>
<%--                        </form>--%>
<%--                    </td>--%>
<%--                    <td>--%>
<%--                        <form class=form-button action="${pageContext.request.contextPath}/adoptedApplicationHibernateServletTemp" method="post">--%>
<%--                            <input type="hidden" name="action" value="delete" />--%>
<%--                            <input type="hidden" name="applicationNo" value="${application.applicationNo}" />--%>
<%--                            <input class="table-button" type="submit" value="刪除" />--%>
<%--                        </form>--%>
<%--                    </td>--%>
                </tr>
            </c:forEach>
        </table>
    </c:when>
    <c:otherwise>
        <p>查無領養表單</p>
    </c:otherwise>
</c:choose>
<br>
<img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/adoptedapplicationhibernate/images/inversecat.png">
<img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/adoptedapplicationhibernate/images/inversecat.png">
<img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/adoptedapplicationhibernate/images/inversecat.png">
<br><br>
<%--    <a href="${pageContext.request.contextPath}/adoptedapplicationhibernate/index.jsp">申請表單首頁</a>--%>

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

<script>
    document.addEventListener('DOMContentLoaded', function() {
        var rows = document.querySelectorAll('table tr:not(:first-child)'); // 選擇除了表頭之外的所有行
        rows.forEach(function(row) {
            row.addEventListener('click', function() {
                var applicationNo = this.cells[0].textContent.trim(); // 獲取第一個單元格的文本，也就是 applicationNo
                // 構造一個請求URL，並將action和applicationNo作為參數
                var url = '${pageContext.request.contextPath}/adoptedApplicationHibernateServletTemp?action=getOne&applicationNo=' + encodeURIComponent(applicationNo);
                window.location.href = url; // 將瀏覽器的地址改為構造的URL
            });
        });
    });
</script>
</body>
</html>