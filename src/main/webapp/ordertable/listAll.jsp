<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/ordertable/main/main.css">
	<title>所有 訂單</title>
</head>
<body>
	<a href="${pageContext.request.contextPath}/ordertable/index.jsp">訂單首頁</a>
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
			<table style="width:50%; text-align:center;">
				<tr>
					<th>訂單編號</th>
					<th>會員編號</th>
					<th>訂單時間</th>
					<th>商品總價</th>
					<th>訂單狀態</th>
					<th>付費方式</th>
					<th>運送方式</th>
					<th>修改</th>
					<th>刪除</th>
				</tr>
				<c:forEach var="orderTable" items="${allOrderTables}" varStatus="status">
					<tr>
						<td>${orderTable.orderTableNo}</td>
						<td>${orderTable.memberNo}</td>
						<td>${orderTable.orderTime}</td>
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
	<br><br>
	<a href="${pageContext.request.contextPath}/ordertable/index.jsp">訂單首頁</a>
</body>
</html>