<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/adoptedapplicationhibernate/main/main.css">
    <title>領養表單</title>
</head>
<body>
<%--    <a href="${pageContext.request.contextPath}/adoptedapplicationhibernate/index.jsp">申請表單首頁</a>--%>
    <button class="fixed-button" onclick="location.href='index.jsp'">管理表單首頁</button>
    <h1>領養表單</h1>
    <br>
    <img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/adoptedapplicationhibernate/images/cat.png">
    <img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/adoptedapplicationhibernate/images/cat.png">
    <img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/adoptedapplicationhibernate/images/cat.png">
    <br>
    <c:choose>
        <c:when test="${not empty oneApplication}">
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
                <tr>
                    <td>${oneApplication.applicationNo}</td>
                    <td>${oneApplication.adminNo}</td>
                    <td>${oneApplication.memberNo}</td>
                    <td>${oneApplication.petId}</td>
<%--                    <td class="date-cell">${oneApplication.lotteryDate}</td>--%>
<%--                    <td>${oneApplication.lotteryResult}</td>--%>
                    <td class="date-cell">
                        <c:choose>
                            <c:when test="${application.lotteryResult == 0}">處理表單</c:when>
                            <c:when test="${application.lotteryResult == 1}">成功領養</c:when>
                            <c:when test="${application.lotteryResult == 2}">領養失敗</c:when>
                            <c:otherwise>未知狀態</c:otherwise>
                        </c:choose>
                    </td>
                    <td class="date-cell">${oneApplication.applicationDate}</td>
                    <td class="date-cell">${oneApplication.interactionDate}&nbsp;&nbsp;${oneApplication.interactionTime}</td>
                    <td class="date-cell">
                        <c:choose>
                            <c:when test="${oneApplication.applicationStat == 0}">審核中</c:when>
                            <c:when test="${oneApplication.applicationStat == 1}">未通過</c:when>
                            <c:when test="${oneApplication.applicationStat == 2}">通過</c:when>
<%--                            <c:when test="${oneApplication.applicationStat == 3}">備取中</c:when>--%>
<%--                            <c:when test="${oneApplication.applicationStat == 4}">通知後無意願</c:when>--%>
<%--                            <c:when test="${oneApplication.applicationStat == 5}">領養成功</c:when>--%>
<%--                            <c:when test="${oneApplication.applicationStat == 6}">領養失敗</c:when>--%>
                            <c:otherwise>未知狀態</c:otherwise>
                        </c:choose>
                    </td>
                    <td>
                        <c:if test="${not empty oneApplication.signaturePhotoBase64}">
                            <img src="data:image/png;base64,${oneApplication.signaturePhotoBase64}" alt="Signature Photo"/>
                        </c:if>
                    </td>
                    <td class="notes-cell">${oneApplication.applicantNotes}</td>
                    <td>
                        <form class=form-button action="${pageContext.request.contextPath}/adoptedApplicationHibernateServlet" method="post">
                            <input type="hidden" name="action" value="edit" />
                            <input type="hidden" name="applicationNo" value="${oneApplication.applicationNo}" />
                            <input class="table-button" type="submit" value="修改" />
                        </form>
                    </td>
                    <td>
                        <form class=form-button action="${pageContext.request.contextPath}/adoptedApplicationHibernateServlet" method="post">
                            <input type="hidden" name="action" value="delete" />
                            <input type="hidden" name="applicationNo" value="${oneApplication.applicationNo}" />
                            <input class="table-button" type="submit" value="刪除" />
                        </form>
                    </td>
                </tr>
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
</body>
</html>