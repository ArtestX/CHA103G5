<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.*"%>

<%--<%--%>
<%--  Object adminAccount = session.getAttribute("adminVO");                 		 // 從 session內取出 (key) adminVO的值--%>
<%--  if (adminAccount == null) {                                             	 // 如為 null, 代表此user未登入過 , 才做以下工作--%>
<%--    session.setAttribute("location", request.getRequestURI());       			 //*工作1 : 同時記下目前位置 , 以便於adminLogin登入成功後 , 能夠直接導至此網頁--%>
<%--    response.sendRedirect(request.getContextPath()+"/admin/adminLogin.jsp");   //*工作2 : 請該user去登入網頁(adminLogin) , 進行登入--%>
<%--    return;--%>
<%--  }--%>
<%--%>--%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">

  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/ordertable/main/main.css">
  <title>所有 訂單</title>


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
              <strong><a href="<%=request.getContextPath()%>/ordertable/listAllOrderTableBackend.jsp" class="list-group-item list-group-item-action">訂單列表</a></strong>
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
<%--      <a href="${pageContext.request.contextPath}/ordertable/index.jsp">訂單首頁</a>--%>
      <h1>所有 訂單</h1>
      <br>
      <img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/ordertable/images/cat.png">
      <img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/ordertable/images/cat.png">
      <img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/ordertable/images/cat.png">
      <br>
      <c:if test="${orderTablesPageQty > 0}">
        <b><font color=red>第${currentPage}/${orderTablesPageQty}頁</font></b>
      </c:if>
      <c:if test="${currentPage > 1}">
        <a href="${pageContext.request.contextPath}/orderTableServlet?action=getAll&page=1">至第一頁</a>&nbsp;
      </c:if>
      <c:if test="${currentPage - 1 != 0}">
        <a href="${pageContext.request.contextPath}/orderTableServlet?action=getAll&page=${currentPage - 1}">上一頁</a>&nbsp;
      </c:if>
      <c:if test="${currentPage + 1 <= orderTablesPageQty}">
        <a href="${pageContext.request.contextPath}/orderTableServlet?action=getAll&page=${currentPage + 1}">下一頁</a>&nbsp;
      </c:if>
      <c:if test="${currentPage != orderTablesPageQty}">
        <a href="${pageContext.request.contextPath}/orderTableServlet?action=getAll&page=${orderTablesPageQty}">至最後一頁</a>&nbsp;
      </c:if>
      <c:choose>
        <c:when test="${not empty allOrderTables}">
          <c:forEach var="orderTable" items="${allOrderTables}" varStatus="status">
          <table style="width:50%; text-align:center;">

            <tr style="background-color: lightgreen; white-space: nowrap;">
              <th>訂單編號</th>
              <th>會員編號</th>
              <th>訂單時間</th>
              <th>商品總價</th>
              <th>訂單狀態</th>
              <th>付費方式</th>
              <th>運送方式</th>
              <th>送貨地址</th>
              <th>明細</th>
              <th>修改</th>
              <th>刪除</th>
            </tr>

              <tr style="white-space: nowrap;">
                <td>${orderTable.orderTableNo}</td>
                <td>${orderTable.memberNo}</td>
                <td>
                  <fmt:formatDate value="${orderTable.orderTime}" pattern="yyyy-MM-dd HH:mm:ss" />
                </td>
                <td>${orderTable.totalAmount}</td>
                <td>
                  <c:choose>
                    <c:when test="${orderTable.orderStat == 0}">訂單成立</c:when>
                    <c:when test="${orderTable.orderStat == 1}">配送中</c:when>
                    <c:when test="${orderTable.orderStat == 2}">訂單取消</c:when>
                    <c:when test="${orderTable.orderStat == 3}">訂單退貨</c:when>
                    <c:when test="${orderTable.orderStat == 4}">訂單換貨</c:when>
                    <c:when test="${orderTable.orderStat == 5}">訂單完成</c:when>
                  </c:choose>
                </td>
                <td>
                  <c:choose>
                    <c:when test="${orderTable.paymentMethod == 0}">信用卡</c:when>
                    <c:when test="${orderTable.paymentMethod == 1}">貨到付款</c:when>
                  </c:choose>
                </td>
                <td>
                  <c:choose>
                    <c:when test="${orderTable.shipMethod == 0}">宅配</c:when>
                    <c:when test="${orderTable.shipMethod == 1}">超商取貨</c:when>
                  </c:choose>
                </td>
                <td>${orderTable.shippingAddress}</td>
                <td>
                  <button onclick="loadOrderDetails(${orderTable.orderTableNo}, 'detail${status.index}')">顯示/隱藏<br>訂單明細</button>
                </td>
                <td>
                  <form action="${pageContext.request.contextPath}/orderTableServlet" method="post">
                    <input type="hidden" name="action" value="edit" />
                    <input type="hidden" name="orderTableNo" value="${orderTable.orderTableNo}" />
                    <input type="submit" value="修改" />
                  </form>
                </td>
                <td>
                  <form action="${pageContext.request.contextPath}/orderTableServlet" method="post">
                    <input type="hidden" name="action" value="delete" />
                    <input type="hidden" name="orderTableNo" value="${orderTable.orderTableNo}" />
                    <input type="submit" value="刪除" />
                  </form>
                </td>
              </tr>
            <table>
              <tr>
                <td colspan="7" id="detail${status.index}" style="display:none;">
                  <jsp:include page="../orderdetail/listSomeOrderDetailFrontend.jsp" />
                </td>
              </tr>
            </table>
            </c:forEach>
          </table>
        </c:when>
        <c:otherwise>
          <p>查無 訂單</p>
        </c:otherwise>
      </c:choose>
      <c:if test="${currentPage > 1}">
        <a href="${pageContext.request.contextPath}/orderTableServlet?action=getAll&page=1">至第一頁</a>&nbsp;
      </c:if>
      <c:if test="${currentPage - 1 != 0}">
        <a href="${pageContext.request.contextPath}/orderTableServlet?action=getAll&page=${currentPage - 1}">上一頁</a>&nbsp;
      </c:if>
      <c:if test="${currentPage + 1 <= orderTablesPageQty}">
        <a href="${pageContext.request.contextPath}/orderTableServlet?action=getAll&page=${currentPage + 1}">下一頁</a>&nbsp;
      </c:if>
      <c:if test="${currentPage != orderTablesPageQty}">
        <a href="${pageContext.request.contextPath}/orderTableServlet?action=getAll&page=${orderTablesPageQty}">至最後一頁</a>&nbsp;
      </c:if>
      <c:if test="${orderTablesPageQty > 0}">
        <b><font color=red>第${currentPage}/${orderTablesPageQty}頁</font></b>
      </c:if>
      <br>
      <img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/ordertable/images/inversecat.png">
      <img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/ordertable/images/inversecat.png">
      <img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/ordertable/images/inversecat.png">
<%--      <br><br>--%>
<%--      <a href="${pageContext.request.contextPath}/ordertable/index.jsp">訂單首頁</a>--%>



      <!--右邊-->
    </div>
  </div>
</div>


<script>

  function loadOrderDetails(orderTableNo, detailId) {
    let detailElement = document.getElementById(detailId);

    if (detailElement.style.display === 'table-row') {
      detailElement.style.display = 'none';
    } else {
      let xhttp = new XMLHttpRequest();
      xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
          detailElement.innerHTML = this.responseText;
          detailElement.style.display = 'table-row';
        }
      };
      xhttp.open("GET", "${pageContext.request.contextPath}/orderDetailServlet?action=getByOrderTableNoFrontend&currentOrderTableNo=" + orderTableNo, true);
      xhttp.send();
    }
  }

</script>

<script src="<%=request.getContextPath()%>/js/popper.min.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
</body>
</html>
