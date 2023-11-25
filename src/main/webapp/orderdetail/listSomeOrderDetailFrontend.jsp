<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/orderdetail/main/main.css">
    <title>訂單明細</title>
</head>
<body>
<%--<a href="${pageContext.request.contextPath}/orderdetail/index.jsp">訂單明細首頁</a>--%>
<h6>訂單明細</h6>
<%--<img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/orderdetail/images/cat.png">--%>
<%--<img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/orderdetail/images/cat.png">--%>
<%--<img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/orderdetail/images/cat.png">--%>
<%--<br>--%>
<c:choose>
    <c:when test="${not empty someOrderDetails}">
        <table style="width:50%; text-align:center;">
            <tr style="background-color: orange; white-space: nowrap;">
<%--                <th>訂單明細編號</th>--%>
<%--                <th>訂單編號</th>--%>
                <th>商品編號</th>
                <th>商品數量</th>
                <th>商品價格</th>
                <th>商品總價</th>
<%--                <th>修改</th>--%>
<%--                <th>刪除</th>--%>
            </tr>
            <c:forEach var="orderDetail" items="${someOrderDetails}" varStatus="status">
                <tr style="white-space: nowrap;">
<%--                    <td>${orderDetail.orderDetailNo}</td>--%>
<%--                    <td>${orderDetail.orderTableNo}</td>--%>
                    <td>${orderDetail.productNo}</td>
                    <td>${orderDetail.quantity}</td>
                    <td>${orderDetail.productPrice}</td>
                    <td>${orderDetail.productPrice*orderDetail.quantity}</td>
<%--                    <td>--%>
<%--                        <form action="${pageContext.request.contextPath}/orderDetailServlet" method="post">--%>
<%--                            <input type="hidden" name="action" value="edit" />--%>
<%--                            <input type="hidden" name="orderDetailNo" value="${orderDetail.orderDetailNo}" />--%>
<%--                            <input type="submit" value="修改" />--%>
<%--                        </form>--%>
<%--                    </td>--%>
<%--                    <td>--%>
<%--                        <form action="${pageContext.request.contextPath}/orderDetailServlet" method="post">--%>
<%--                            <input type="hidden" name="action" value="delete" />--%>
<%--                            <input type="hidden" name="orderDetailNo" value="${orderDetail.orderDetailNo}" />--%>
<%--                            <input type="submit" value="刪除" />--%>
<%--                        </form>--%>
<%--                    </td>--%>
                </tr>
            </c:forEach>
        </table>
    </c:when>
    <c:otherwise>
        <p>查無 訂單明細</p>
    </c:otherwise>
</c:choose>
<%--<img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/orderdetail/images/inversecat.png">--%>
<%--<img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/orderdetail/images/inversecat.png">--%>
<%--<img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/orderdetail/images/inversecat.png">--%>
<%--<br><br>--%>
<%--<a href="${pageContext.request.contextPath}/orderdetail/index.jsp">訂單明細首頁</a>--%>
</body>
</html>