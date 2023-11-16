<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/adoptedapplicationhibernate/main/main.css">
    <title>修改 申請表單</title>
</head>
<body>
    <a href="${pageContext.request.contextPath}/adoptedapplicationhibernate/index.jsp">申請表單首頁</a>
    <h1>修改 申請表單</h1>
    <br>
    <img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/adoptedapplicationhibernate/images/cat.png">
    <img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/adoptedapplicationhibernate/images/cat.png">
    <img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/adoptedapplicationhibernate/images/cat.png">
    <br>
    <form action="${pageContext.request.contextPath}/adoptedApplicationHibernateServlet" method="post" enctype="multipart/form-data">
        <input type="hidden" name="action" value="update" />
        <input type="hidden" name="applicationNo" value="${application.applicationNo}" />
        <table>
            <tr>
                <td>申請編號：</td>
                <td>${application.applicationNo}</td>
            </tr>
            <tr>
                <td>管理員編號：</td>
                <td><input type="text" name="adminNo" value=${application.adminNo} /></td>
            </tr>
            <tr>
                <td>會員編號：</td>
                <td><input type="text" name="memberNo" value=${application.memberNo} /></td>
            </tr>
            <tr>
                <td>寵物ID：</td>
                <td><input type="text" name="petId" value=${application.petId} /></td>
            </tr>
            <tr>
                <td>抽籤日期：</td>
                <td><input type="date" name="lotteryDate" value=${application.lotteryDate} /></td>
            </tr>
            <tr>
                <td>抽籤結果：</td>
                <td><input type="number" name="lotteryResult" value=${application.lotteryResult} /></td>
            </tr>
            <tr>
                <td>申請日期：</td>
                <td><input type="date" name="applicationDate" value=${application.applicationDate} /></td>
            </tr>
            <tr>
                <td>互動日期：</td>
                <td><input type="date" name="interactionDate" value=${application.interactionDate} /></td>
            </tr>
            <tr>
                <td>申請狀態：</td>
                <td><input type="number" name="applicationStat" value=${application.applicationStat} /></td>
            </tr>
            <tr>
                <td>簽名照片：</td>
                <td><input type="file" id="signaturePhotoInput" name="signaturePhoto" accept="image/*" />
                    <c:if test="${not empty application.signaturePhotoBase64}">
                        <img id="signaturePhoto" src="data:image/*;base64,${application.signaturePhotoBase64}" alt="Signature Photo"/>
                    </c:if>
                </td>
            </tr>
            <tr>
                <td>申請者備註：</td>
                <td><textarea name="applicantNotes" rows="4" cols="50">${application.applicantNotes}</textarea></td>
            </tr>
            <br>
            <br>
            <tr>
                <td colspan="2">
                    <input type="submit" value="更新" />
                </td>
            </tr>
        </table>
    </form>
    <br>
    <img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/adoptedapplicationhibernate/images/inversecat.png">
    <img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/adoptedapplicationhibernate/images/inversecat.png">
    <img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/adoptedapplicationhibernate/images/inversecat.png">
    <br><br>
    <a href="${pageContext.request.contextPath}/adoptedapplicationhibernate/index.jsp">申請表單首頁</a>
    <script>
        document.getElementById('signaturePhotoInput').addEventListener('change', function(event) {
            if (event.target.files && event.target.files[0]) {
                var reader = new FileReader();

                reader.onload = function(e) {
                    document.getElementById('signaturePhoto').src = e.target.result;
                };

                reader.readAsDataURL(event.target.files[0]);
            }
        });
    </script>
</body>
</html>
