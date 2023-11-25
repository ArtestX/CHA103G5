<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*"%>
<%--<%--%>
<%--    Object adminAccount = session.getAttribute("adminVO");                 		 // 從 session內取出 (key) adminVO的值--%>
<%--    if (adminAccount == null) {                                             	 // 如為 null, 代表此user未登入過 , 才做以下工作--%>
<%--        session.setAttribute("location", request.getRequestURI());       			 //*工作1 : 同時記下目前位置 , 以便於adminLogin登入成功後 , 能夠直接導至此網頁--%>
<%--        response.sendRedirect(request.getContextPath()+"/admin/adminLogin.jsp");   //*工作2 : 請該user去登入網頁(adminLogin) , 進行登入--%>
<%--        return;--%>
<%--    }--%>
<%--%>--%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/adoptedapplicationhibernate/main/main.css">

    <title>領養表單</title>

    <style>
        body {
            background-image: url('<%=request.getContextPath()%>/img/desktop.jpg');
            background-size: cover;
            background-attachment: fixed; /* 固定背景圖片 */
            background-repeat: no-repeat;
        }

    </style>

</head>
<body>

<nav class="navbar custom-bg-color">
    <div class="container-fluid">
        <a class="navbar-brand" href="/admin/backendMain.jsp">
            <img src="./img/backpack2-fill.svg" alt="Logo" width="30" height="24" class="d-inline-block align-text-top">
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
                            <strong><a href="adminSystem.jsp" class="list-group-item list-group-item-action">員工列表</a></strong>
                        </div>
                        <div class="accordion-body">
                            <strong><a href="#" class="list-group-item list-group-item-action">權限管理</a></strong>
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
                            <strong><a href="#" class="list-group-item list-group-item-action">填寫功能名稱</a></strong>
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
                            <strong><a href="#" class="list-group-item list-group-item-action">填寫功能名稱</a></strong>
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
                            <strong><a href="#" class="list-group-item list-group-item-action">填寫功能名稱</a></strong>
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
                            <strong><a href="#" class="list-group-item list-group-item-action">領養預約管理</a></strong>
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
                            <strong><a href="#" class="list-group-item list-group-item-action">填寫功能名稱</a></strong>
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
                            <strong><a href="#" class="list-group-item list-group-item-action">填寫功能名稱</a></strong>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--左邊-->

        <div class="col-lg-10 g-3">
            <!--右邊-->
            <%--    <a href="${pageContext.request.contextPath}/adoptedapplicationhibernate/indexTemp.jsp">申請表單首頁</a>--%>
            <button class="fixed-button" onclick="location.href='${pageContext.request.contextPath}/adoptedapplicationhibernate/index.jsp'">管理表單首頁</button>
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
                            <th>管理員編號</th>
                            <th>會員編號</th>
                            <th>寵物編號</th>
                                <%--                    <th>抽籤日期</th>--%>
                            <th>處理進度</th>
                            <th>申請日期</th>
                            <th>預約時間</th>
                            <th>申請狀態</th>
                            <th>簽名</th>
                            <th class="notes-header">備註</th>
                            <th>修改</th>
                            <th>刪除</th>
                        </tr>
                        <c:forEach var="application" items="${someApplications}" varStatus="status">
                            <tr>
                                <td>${application.applicationNo}</td>
                                <td>${application.adminNo}</td>
                                <td>${application.memberNo}</td>
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
                                <td>
                                    <form class=form-button action="${pageContext.request.contextPath}/adoptedApplicationHibernateServletTemp" method="post">
                                        <input type="hidden" name="action" value="edit" />
                                        <input type="hidden" name="applicationNo" value="${application.applicationNo}" />
                                        <input class="table-button" type="submit" value="修改" />
                                    </form>
                                </td>
                                <td>
                                    <form class=form-button action="${pageContext.request.contextPath}/adoptedApplicationHibernateServletTemp" method="post">
                                        <input type="hidden" name="action" value="delete" />
                                        <input type="hidden" name="applicationNo" value="${application.applicationNo}" />
                                        <input class="table-button" type="submit" value="刪除" />
                                    </form>
                                </td>
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
            <%--    <a href="${pageContext.request.contextPath}/adoptedapplicationhibernate/indexTemp.jsp">申請表單首頁</a>--%>



            <!--右邊-->
        </div>
    </div>
</div>




<script src="<%=request.getContextPath()%>/js/popper.min.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
</body>
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

</html>