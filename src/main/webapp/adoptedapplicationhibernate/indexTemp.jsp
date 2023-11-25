<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*"%>
<%@ page import="com.cha103g5.adoptedapplicationhibernate.model.AdoptedApplicationHibernate" %>
<%@ page import="com.cha103g5.adoptedapplicationhibernate.service.AdoptedApplicationHibernateService" %>
<%@ page import="com.cha103g5.adoptedapplicationhibernate.service.AdoptedApplicationHibernateServiceImpl" %>

<%
    AdoptedApplicationHibernateService aahService = new AdoptedApplicationHibernateServiceImpl();
    List<AdoptedApplicationHibernate> allApplications = aahService.getAllApplications();
    pageContext.setAttribute("allApplications", allApplications);

    Set<Integer> distinctMemberNos = new TreeSet<>();
    for (AdoptedApplicationHibernate oneApplication : allApplications) {
        distinctMemberNos.add(oneApplication.getMemberNo());
    }
    pageContext.setAttribute("distinctMemberNos", distinctMemberNos);

    Set<Integer> distinctPetIds = new TreeSet<>();
    for (AdoptedApplicationHibernate oneApplication : allApplications) {
        distinctPetIds.add(oneApplication.getPetId());
    }
    pageContext.setAttribute("distinctPetIds", distinctPetIds);

//    Object adminAccount = session.getAttribute("adminVO");                 		 // 從 session內取出 (key) adminVO的值
//    if (adminAccount == null) {                                             	 // 如為 null, 代表此user未登入過 , 才做以下工作
//        session.setAttribute("location", request.getRequestURI());       			 //*工作1 : 同時記下目前位置 , 以便於adminLogin登入成功後 , 能夠直接導至此網頁
//        response.sendRedirect(request.getContextPath()+"/admin/adminLogin.jsp");   //*工作2 : 請該user去登入網頁(adminLogin) , 進行登入
//        return;
//    }
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/adoptedapplicationhibernate/main/main.css">

    <title>領養預約管理系統</title>

    <style>
        .table-button {
            transform: scale(1);
            height: 30px; /* 設定按鈕的高度 */
        }

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
        <a class="navbar-brand" href="<%=request.getContextPath()%>/admin/backendMain.jsp">
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
                            <strong><a href="<%=request.getContextPath()%>/ordertable/index.jsp" class="list-group-item list-group-item-action">訂單列表</a></strong>
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

            <h1>領養表單<br>管理系統</h1>

            <button onclick="location.href='${pageContext.request.contextPath}/adoptedApplicationHibernateServletTemp?action=showCalendar'">行事曆管理<br>(後台管理)</button>
            <br><br>

            <button onclick="location.href='${pageContext.request.contextPath}/adoptedApplicationHibernateServletTemp?action=getAll'">所有申請<br>(後台管理)</button>
            <br><br>

            <form action="${pageContext.request.contextPath}/adoptedApplicationHibernateServletTemp" method="get" class="search-form">
                <%--	<form action="${pageContext.request.contextPath}/adoptedApplicationHibernateServletTemp" method="get" class="search-form">--%>
                <div class="form-group">
                    <input type="hidden" name="action" value="getOne">
                    <label for="applicationNo">申請編號:<br>(後台管理)</label>
                    <select name="applicationNo" id="applicationNo">
                        <option value="">請選擇</option>
                        <c:forEach var="application" items="${allApplications}" >
                            <option value="${application.applicationNo}">${application.applicationNo}</option>
                        </c:forEach>
                    </select>
                    &nbsp;<input class="table-button" type="submit" value="查詢">
                </div>
            </form>

            <form action="${pageContext.request.contextPath}/adoptedApplicationHibernateServletTemp" method="get" class="search-form">
                <div class="form-group">
                    <input type="hidden" name="action" value="getByMemberNo">
                    <label for="memberNo">會員編號:<br>(會員頁面)</label>
                    <select name="memberNo" id="memberNo">
                        <option value="">請選擇</option>
                        <c:forEach var="memberNo" items="${distinctMemberNos}" >
                            <option value="${memberNo}">${memberNo}</option>
                        </c:forEach>
                    </select>
                    &nbsp;<input class="table-button" type="submit" value="查詢">
                </div>
            </form>

            <%--	<h2>抽籤排序查詢<br>(後台管理)</h2>--%>
            <form action="${pageContext.request.contextPath}/adoptedApplicationHibernateServletTemp" method="get">
                <div class="form-group">
                    <input type="hidden" name="action" value="compositeQuery">

                    <label>寵物編號:</label>
                    <select name="petId" id="petIdCriteriaQuery">
                        <option value="">請選擇</option>
                        <c:forEach var="petId" items="${distinctPetIds}" >
                            <option value="${petId}">${petId}</option>
                        </c:forEach>
                    </select>
                    <%--			&nbsp;<b>--%>
                    <%--			+</b>&nbsp;--%>
                    <%--			<label>抽籤日期:</label>--%>
                    <%--			<input type="date" name="lotteryDate">--%>
                    &nbsp;<input class="table-button" type="submit" value="查詢">
                </div>
            </form>
            <br>
            <button onclick="location.href='${pageContext.request.contextPath}/adoptedApplicationHibernateServletTemp?action=addOption'">預約<br>(寵物頁面)</button>
            <%--	<button onclick="location.href='${pageContext.request.contextPath}/adoptedapplicationhibernate/add.jsp'">新增申請</button>--%>
            <br><br>

            <!--右邊-->
        </div>
    </div>
</div>




<script src="<%=request.getContextPath()%>/js/popper.min.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>

</body>
</html>