<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/adoptedapplicationhibernate/main/main.css">
	<title>所有 申請表單</title>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">

	<style>
		.page-nav {
			color: grey; /* 預設顏色 */
			cursor: default;
			pointer-events: none; /* 禁用點擊事件 */
		}

		.page-nav.active {
			color: orange; /* 啟用時的顏色 */
			cursor: pointer;
			pointer-events: auto; /* 啟用點擊事件 */
		}

		.large-icon {
			transform: scale(1.6);
		}

	</style>

</head>
<body>
<%--	<a href="${pageContext.request.contextPath}/adoptedapplicationhibernate/index.jsp">申請表單首頁</a>--%>
	<button class="fixed-button" onclick="location.href='${pageContext.request.contextPath}/adoptedapplicationhibernate/index.jsp'">管理表單首頁</button>
	<h1>所有 申請表單</h1>
	<br>
	<img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/adoptedapplicationhibernate/images/cat.png">
	<img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/adoptedapplicationhibernate/images/cat.png">
	<img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/adoptedapplicationhibernate/images/cat.png">
	<br>
<%--	<c:if test="${applicationsPageQty > 0}">--%>
<%--		<b><font color=red>第${currentPage}/${applicationsPageQty}頁</font></b>--%>
<%--	</c:if>--%>
	<br>
<%--	<c:if test="${currentPage > 1}">--%>
		<a href="${pageContext.request.contextPath}/adoptedApplicationHibernateServlet?action=getAll&page=1" class="page-nav ${(currentPage > 1) ? 'active' : ''}">
			<i class="fas fa-caret-square-left large-icon"></i>
		</a>&nbsp;
<%--	</c:if>--%>
<%--	<c:if test="${currentPage - 1 != 0}">--%>
		<a href="${pageContext.request.contextPath}/adoptedApplicationHibernateServlet?action=getAll&page=${currentPage - 1}" class="page-nav ${(currentPage > 1) ? 'active' : ''}">
			<i class="fas fa-caret-left large-icon"></i>
		</a>&nbsp;
<%--	</c:if>--%>
<%--	<c:if test="${currentPage + 1 <= applicationsPageQty}">--%>
		<a href="${pageContext.request.contextPath}/adoptedApplicationHibernateServlet?action=getAll&page=${currentPage + 1}" class="page-nav ${(currentPage < applicationsPageQty) ? 'active' : ''}">
			<i class="fas fa-caret-right large-icon"></i>
		</a>&nbsp;
<%--	</c:if>--%>
<%--	<c:if test="${currentPage != applicationsPageQty}">--%>
		<a href="${pageContext.request.contextPath}/adoptedApplicationHibernateServlet?action=getAll&page=${applicationsPageQty}" class="page-nav ${(currentPage < applicationsPageQty) ? 'active' : ''}">
			<i class="fas fa-caret-square-right large-icon"></i>
		</a>&nbsp;&nbsp;&nbsp;
<%--	</c:if>--%>
		<b><font color=darkolivegreen>${currentPage}/${applicationsPageQty}, Total ${applicationsDataTotal}筆</font></b>
	<br>
	<c:choose>
		<c:when test="${not empty allApplications}">
			<table style="width:50%; text-align:center;">
				<tr>
					<th>申請編號</th>
					<th>管理員編號</th>
					<th>會員編號</th>
					<th>寵物編號</th>
					<th>抽籤日期</th>
					<th>抽籤排序</th>
					<th>申請日期</th>
					<th>預約時間</th>
					<th>申請狀態</th>
					<th>簽名</th>
					<th class="notes-header">備註</th>
					<th>修改</th>
					<th>刪除</th>
				</tr>
				<c:forEach var="application" items="${allApplications}" varStatus="status">
					<tr>
						<td>${application.applicationNo}</td>
						<td>${application.adminNo}</td>
						<td>${application.memberNo}</td>
						<td>${application.petId}</td>
						<td class="date-cell">${application.lotteryDate}</td>
						<td>${application.lotteryResult}</td>
						<td class="date-cell">${application.applicationDate}</td>
						<td class="date-cell">${application.interactionDate}&nbsp;&nbsp;${application.interactionTime}</td>
						<td class="date-cell">
							<c:choose>
								<c:when test="${application.applicationStat == 0}">審核中</c:when>
								<c:when test="${application.applicationStat == 1}">未通過</c:when>
								<c:when test="${application.applicationStat == 2}">通過</c:when>
								<c:when test="${application.applicationStat == 3}">備取中</c:when>
								<c:when test="${application.applicationStat == 4}">通知後無意願</c:when>
								<c:when test="${application.applicationStat == 5}">領養成功</c:when>
								<c:when test="${application.applicationStat == 6}">領養失敗</c:when>
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
							<form class=form-button action="${pageContext.request.contextPath}/adoptedApplicationHibernateServlet" method="post">
								<input type="hidden" name="action" value="edit" />
								<input type="hidden" name="applicationNo" value="${application.applicationNo}" />
								<input class="table-button" type="submit" value="修改" />
							</form>
						</td>
						<td>
							<form class=form-button action="${pageContext.request.contextPath}/adoptedApplicationHibernateServlet" method="post">
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
			<p>查無申請表格</p>
		</c:otherwise>
	</c:choose>
	<br>
<%--	<c:if test="${currentPage > 1}">--%>
		<a href="${pageContext.request.contextPath}/adoptedApplicationHibernateServlet?action=getAll&page=1" class="page-nav ${(currentPage > 1) ? 'active' : ''}">
			<i class="fas fa-caret-square-left large-icon"></i>
		</a>&nbsp;
<%--	</c:if>--%>
<%--	<c:if test="${currentPage - 1 != 0}">--%>
		<a href="${pageContext.request.contextPath}/adoptedApplicationHibernateServlet?action=getAll&page=${currentPage - 1}" class="page-nav ${(currentPage > 1) ? 'active' : ''}">
			<i class="fas fa-caret-left large-icon"></i>
		</a>&nbsp;
<%--	</c:if>--%>
<%--	<c:if test="${currentPage + 1 <= applicationsPageQty}">--%>
		<a href="${pageContext.request.contextPath}/adoptedApplicationHibernateServlet?action=getAll&page=${currentPage + 1}" class="page-nav ${(currentPage < applicationsPageQty) ? 'active' : ''}">
			<i class="fas fa-caret-right large-icon"></i>
		</a>&nbsp;
<%--	</c:if>--%>
<%--	<c:if test="${currentPage != applicationsPageQty}">--%>
		<a href="${pageContext.request.contextPath}/adoptedApplicationHibernateServlet?action=getAll&page=${applicationsPageQty}" class="page-nav ${(currentPage < applicationsPageQty) ? 'active' : ''}">
			<i class="fas fa-caret-square-right large-icon"></i>
		</a>&nbsp;&nbsp;&nbsp;
		<b><font color=darkolivegreen>${currentPage}/${applicationsPageQty}, Total ${applicationsDataTotal}筆</font></b>
<%--	</c:if>--%>
	<br>
<%--	<c:if test="${applicationsPageQty > 0}">--%>
<%--		<b><font color=red>第${currentPage}/${applicationsPageQty}頁</font></b>--%>
<%--	</c:if>--%>
	<br>
	<img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/adoptedapplicationhibernate/images/inversecat.png">
	<img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/adoptedapplicationhibernate/images/inversecat.png">
	<img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/adoptedapplicationhibernate/images/inversecat.png">
	<br><br>
<%--	<a href="${pageContext.request.contextPath}/adoptedapplicationhibernate/index.jsp">申請表單首頁</a>--%>
</body>

<script>
	document.addEventListener('DOMContentLoaded', function() {
		var rows = document.querySelectorAll('table tr:not(:first-child)'); // 選擇除了表頭之外的所有行
		rows.forEach(function(row) {
			row.addEventListener('click', function() {
				var applicationNo = this.cells[0].textContent.trim(); // 獲取第一個單元格的文本，也就是 applicationNo
				// 構造一個請求URL，並將action和applicationNo作為參數
				var url = '${pageContext.request.contextPath}/adoptedApplicationHibernateServlet?action=getOne&applicationNo=' + encodeURIComponent(applicationNo);
				window.location.href = url; // 將瀏覽器的地址改為構造的URL
			});
		});
	});
</script>

</html>