<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/adoptedapplicationhibernate/main/main.css">
    <title>單一 申請表單</title>
</head>
<body>
    <a href="${pageContext.request.contextPath}/adoptedapplicationhibernate/index.jsp">回首頁</a>
    <h1>單一 申請表單</h1>
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
                    <th>寵物ID</th>
                    <th>抽籤日期</th>
                    <th>抽籤結果</th>
                    <th>申請日期</th>
                    <th>互動日期</th>
                    <th>申請狀態</th>
                    <th>簽名照片</th>
                    <th>申請者備註</th>
                    <th>修改</th>
                    <th>刪除</th>
                </tr>
                <tr>
                    <td>${oneApplication.applicationNo}</td>
                    <td>${oneApplication.adminNo}</td>
                    <td>${oneApplication.memberNo}</td>
                    <td>${oneApplication.petId}</td>
                    <td>${oneApplication.lotteryDate}</td>
                    <td>${oneApplication.lotteryResult}</td>
                    <td>${oneApplication.applicationDate}</td>
                    <td>${oneApplication.interactionDate}</td>
                    <td>${oneApplication.applicationStat}</td>
                    <td>
                        <c:if test="${not empty oneApplication.signaturePhotoBase64}">
                            <img src="data:image/png;base64,${oneApplication.signaturePhotoBase64}" alt="Signature Photo"/>
                        </c:if>
                    </td>
                    <td>${oneApplication.applicantNotes}</td>
                    <td>
                        <form action="${pageContext.request.contextPath}/adoptedApplicationHibernateServlet" method="post">
                            <input type="hidden" name="action" value="edit" />
                            <input type="hidden" name="applicationNo" value="${oneApplication.applicationNo}" />
                            <input type="submit" value="修改" />
                        </form>
                    </td>
                    <td>
                        <form action="${pageContext.request.contextPath}/adoptedApplicationHibernateServlet" method="post">
                            <input type="hidden" name="action" value="delete" />
                            <input type="hidden" name="applicationNo" value="${oneApplication.applicationNo}" />
                            <input type="submit" value="刪除" />
                        </form>
                    </td>
                </tr>
            </table>
        </c:when>
        <c:otherwise>
            <p>查無 申請表單</p>
        </c:otherwise>
    </c:choose>
    <br>
    <img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/adoptedapplicationhibernate/images/inversecat.png">
    <img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/adoptedapplicationhibernate/images/inversecat.png">
    <img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/adoptedapplicationhibernate/images/inversecat.png">
    <br><br>
    <a href="${pageContext.request.contextPath}/adoptedapplicationhibernate/index.jsp">回首頁</a>
</body>
</html>