<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/ordertable/main/main.css">
    <title>訂單</title>

    <style>

        td[colspan="7"] {
            background-color: #e7e7e7; /* 設定背景顏色，以便於辨識 */
        }

    </style>

</head>
<body>
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