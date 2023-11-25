<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="com.cha103g5.member.model.*"%>
<%@ page import="java.util.*"%>
<jsp:include page="/banner.jsp" flush="true" />

<%
    // 把MemberVO的資料從session取出
    com.cha103g5.member.model.MemberVO user = (com.cha103g5.member.model.MemberVO) session.getAttribute("user");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/ordertable/main/main.css">
    <%-- <link rel="stylesheet" href="<%=request.getContextPath()%>/css/sweetalert2.css"> --%>
    <title>訂單</title>

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

        td[colspan="7"] {
            background-color: #e7e7e7; /* 設定背景顏色，以便於辨識 */
        }

    </style>

</head>
<body>
<div class="container">
    <div class="row">
        <!-- ----------left start---------- -->
        <div class="col-md-9">

<%--<a href="${pageContext.request.contextPath}/ordertable/index.jsp">訂單首頁</a>--%>
<h3>訂單</h3>
<%--<br>--%>
<img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/ordertable/images/cat.png">
<img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/ordertable/images/cat.png">
<img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/ordertable/images/cat.png">
<%--<br>--%>
<c:choose>
    <c:when test="${not empty someOrderTables}">
        <c:forEach var="orderTable" items="${someOrderTables}" varStatus="status">
        <table border="50" style="width:50%; text-align:center;">

            <tr style="background-color: lightgreen; white-space: nowrap;">
                <th>訂單編號</th>
<%--                <th>會員編號</th>--%>
                <th>訂單時間</th>
                <th>商品總價</th>
                <th>訂單狀態</th>
                <th>付費方式</th>
                <th>運送方式</th>
                <th>明細</th>
            </tr>

            <tr style="white-space: nowrap;">
                <td>${orderTable.orderTableNo}</td>
<%--                <td>${orderTable.memberNo}</td>--%>
<%--                <td>${orderTable.orderTime}</td>--%>
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
                <td>
                    <button onclick="loadOrderDetails(${orderTable.orderTableNo}, 'detail${status.index}')">顯示/隱藏<br>訂單明細</button>
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
<%--<br>--%>
<img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/ordertable/images/inversecat.png">
<img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/ordertable/images/inversecat.png">
<img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/ordertable/images/inversecat.png">
<%--<br><br>--%>
<%--<a href="${pageContext.request.contextPath}/ordertable/index.jsp">訂單首頁</a>--%>

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

</body>
</html>