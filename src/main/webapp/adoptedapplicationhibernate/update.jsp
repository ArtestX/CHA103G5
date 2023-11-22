<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/adoptedapplicationhibernate/main/main.css">
    <title>更新</title>
</head>
<body>
<%--    <a href="${pageContext.request.contextPath}/adoptedapplicationhibernate/index.jsp">申請表單首頁</a>--%>
    <button class="fixed-button" onclick="location.href='${pageContext.request.contextPath}/adoptedapplicationhibernate/index.jsp'">管理表單首頁</button>
    <h1>更新</h1>
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
                <td><input required type="number" name="adminNo" value=${application.adminNo} /></td>
            </tr>
            <tr>
                <td>會員編號：</td>
                <td><input required type="number" name="memberNo" value=${application.memberNo} /></td>
            </tr>
            <tr>
                <td>寵物編號：</td>
                <td><input required type="number" name="petId" value=${application.petId} /></td>
            </tr>
            <tr>
                <td>抽籤日期：</td>
                <td><input required type="date" name="lotteryDate" value=${application.lotteryDate} /></td>
            </tr>
            <tr>
                <td>抽籤排序：</td>
                <td><input required type="number" name="lotteryResult" value=${application.lotteryResult} /></td>
            </tr>
            <tr>
                <td>申請日期：</td>
                <td>
                    <span>${application.applicationDate}</span>
                    <input required type="hidden" name="applicationDate" value="${application.applicationDate}" />
                </td>
            </tr>
            <tr>
                <td>預約時間：</td>
                <td>
                    <input required type="date" name="interactionDate" value=${application.interactionDate} />
                    <input required type="time" name="interactionTime" id="interactionTimeInput" value=${application.interactionTime} onchange="checkTime()" />
                    <div id="timeError" style="color:black;">請選擇有效時間（早上 9~12, 下午 2~5, 晚上 6~9）</div>
                </td>
            </tr>
            <tr>
                <td>申請狀態：</td>
                <td>
                    <select name="applicationStat">
                        <option value="0" ${application.applicationStat == 0 ? "selected" : ""}>審核中</option>
                        <option value="1" ${application.applicationStat == 1 ? "selected" : ""}>未通過</option>
                        <option value="2" ${application.applicationStat == 2 ? "selected" : ""}>通過</option>
                        <option value="3" ${application.applicationStat == 3 ? "selected" : ""}>備取中</option>
                        <option value="4" ${application.applicationStat == 4 ? "selected" : ""}>通知後無意願</option>
                        <option value="5" ${application.applicationStat == 5 ? "selected" : ""}>領養成功</option>
                        <option value="6" ${application.applicationStat == 6 ? "selected" : ""}>領養失敗</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>簽名：</td>
                <td>
<%--                    <input type="file" id="signaturePhotoInput" name="signaturePhoto" accept="image/*" />--%>
<%--                    <c:if test="${not empty application.signaturePhotoBase64}">--%>
                    <img id="signaturePhotoShow" src="data:image/*;base64,${application.signaturePhotoBase64}" alt="Signature Photo"/>
                    <!-- 簽名板區域 -->
                    <canvas id="signaturePad" width="400" height="200" style="border:1px solid #000;"></canvas>
                    <br>
                    <button type="button" id="clearSignatureBtn">清除簽名</button>
                    <input required type="hidden" name="signaturePhoto" id="signaturePhoto" />
<%--                    </c:if>--%>
                </td>
            </tr>
            <tr>
                <td>備註：</td>
                <td><textarea name="applicantNotes" rows="4" cols="50">${application.applicantNotes}</textarea></td>
            </tr>
            <br>
            <br>
            <tr>
                <td colspan="2">
                    <input class="table-button" type="submit" value="更新" />
                </td>
            </tr>
        </table>
    </form>
    <br>
    <img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/adoptedapplicationhibernate/images/inversecat.png">
    <img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/adoptedapplicationhibernate/images/inversecat.png">
    <img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/adoptedapplicationhibernate/images/inversecat.png">
    <br><br>
<%--    <a href="${pageContext.request.contextPath}/adoptedapplicationhibernate/index.jsp">申請表單首頁</a>--%>

<%--    <script>--%>
<%--        document.getElementById('signaturePhotoInput').addEventListener('change', function(event) {--%>
<%--            if (event.target.files && event.target.files[0]) {--%>
<%--                var reader = new FileReader();--%>

<%--                reader.onload = function(e) {--%>
<%--                    document.getElementById('signaturePhotoShow').src = e.target.result;--%>
<%--                };--%>

<%--                reader.readAsDataURL(event.target.files[0]);--%>
<%--            }--%>
<%--        });--%>
<%--    </script>--%>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/signature_pad/1.5.3/signature_pad.min.js"></script>
    <script>
        var canvas = document.getElementById('signaturePad');
        var signaturePad = new SignaturePad(canvas);
        var originalSignatureData = '${application.signaturePhotoBase64}';
        var isSigning = false;
        var shouldStopSigning = false;

        canvas.addEventListener('mousedown', function() {
            isSigning = true;
            shouldStopSigning = false;
        });

        canvas.addEventListener('mousemove', function() {
            if (shouldStopSigning) {
                signaturePad.clear();
                isSigning = false;
            }
        });

        canvas.addEventListener('mouseup', function() {
            if (isSigning) {
                var signatureData = signaturePad.toDataURL('image/png');
                document.getElementById('signaturePhoto').value = signatureData;

                signaturePhotoShow.src = signatureData;
            }
            isSigning = false;
        });

        canvas.addEventListener('mouseleave', function() {
            if (isSigning) {
                alert('請不要超出簽名範圍，請重新簽名。');
                shouldStopSigning = true;
            }
        });

        document.getElementById('clearSignatureBtn').addEventListener('click', function() {
            signaturePad.clear();
            document.getElementById('signaturePhoto').value = '';
            signaturePhotoShow.src = '';
        });

        document.getElementById('restoreSignatureBtn').addEventListener('click', function() {
            if (originalSignatureData) {
                signaturePad.clear();
                setTimeout(function() {
                    var restoredData = "data:image/*;base64," + originalSignatureData;
                    signaturePad.fromDataURL(restoredData);
                    document.getElementById('signaturePhoto').value = restoredData;
                    signaturePhotoShow.src = restoredData;
                }, 0);
            }
        });

        // document.getElementById('interactionTimeInput').addEventListener('change', function() {
        //     var selectedTime = this.value;
        //     var hour = parseInt(selectedTime.split(':')[0], 10);
        //
        //     if (!((hour >= 9 && hour < 12) || (hour >= 14 && hour < 17) || (hour >= 18 && hour < 21))) {
        //         // 如果選擇的時間不在指定範圍內
        //         alert('請選擇有效時間: \n早上 9:00~12:00\n下午 2:00~5:00\n晚上 6:00~9:00');
        //         this.value = ''; // 可以選擇清空輸入或設置為一個默認值
        //         document.getElementById('timeError').style.color = 'red';
        //         // document.getElementById('timeError').style.display = 'block'; // 顯示錯誤信息
        //     }
        //     // else {
        //     //     document.getElementById('timeError').style.display = 'none'; // 隱藏錯誤信息
        //     // }
        // });

        function checkTime() {
            var timeInput = document.getElementById('interactionTimeInput');
            var selectedTime = timeInput.value;
            var hour = parseInt(selectedTime.split(':')[0], 10);

            if (!((hour >= 9 && hour < 12) || (hour >= 14 && hour < 17) || (hour >= 18 && hour < 21))) {
                alert('請選擇有效時間: \n早上 9:00~12:00\n下午 2:00~5:00\n晚上 6:00~9:00');
                timeInput.value = '';
                document.getElementById('timeError').style.color = 'red';
            }
        }

        window.onload = checkTime; // 在頁面加載時進行檢查

    </script>

</body>
</html>
