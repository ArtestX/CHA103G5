<%@ page import="com.google.gson.Gson" %>
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
    <button class="fixed-button" onclick="location.href='index.jsp'">管理表單首頁</button>
    <h1>更新</h1>
    <br>
    <img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/adoptedapplicationhibernate/images/cat.png">
    <img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/adoptedapplicationhibernate/images/cat.png">
    <img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/adoptedapplicationhibernate/images/cat.png">
    <br>
    <form id="myForm" action="${pageContext.request.contextPath}/adoptedApplicationHibernateServlet" method="post" enctype="multipart/form-data" onsubmit="return checkReservation()">
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
<%--            <tr>--%>
<%--                <td>抽籤日期：</td>--%>
<%--                <td><input required type="date" name="lotteryDate" value=${application.lotteryDate} /></td>--%>
<%--            </tr>--%>
            <tr>
                <td>處理進度：</td>
                <td>
                    <select name="lotteryResult">
                        <option value="0" ${application.lotteryResult == 0 ? "selected" : ""}>處理表單中</option>
                        <option value="1" ${application.lotteryResult == 1 ? "selected" : ""}>成功領養</option>
                        <option value="2" ${application.lotteryResult == 2 ? "selected" : ""}>領養失敗</option>
                    </select>
                </td>
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
                    <input required type="date" name="interactionDate" id="interactionDateInput" value=${application.interactionDate} />
                    <select required type="time" name="interactionTime" id="interactionTimeInput" value=${application.interactionTime} >
                        <optgroup label="早上">
                            <option value="09:01:00">早上 9:00 ~ 10:00</option>
                            <option value="10:01:00">早上 10:00 ~ 11:00</option>
                            <option value="11:01:00">早上 11:00 ~ 12:00</option>
                        </optgroup>
                        <optgroup label="下午">
                            <option value="14:01:00">早上 2:00 ~ 3:00</option>
                            <option value="15:01:00">早上 3:00 ~ 4:00</option>
                            <option value="16:01:00">早上 4:00 ~ 5:00</option>
                        </optgroup>
                        <optgroup label="晚上">
                            <option value="18:01:00">早上 6:00 ~ 7:00</option>
                            <option value="19:01:00">早上 7:00 ~ 8:00</option>
                            <option value="20:01:00">早上 8:00 ~ 9:00</option>
                        </optgroup>
                    </select>
                    <button type="button" onclick="showCalendarPopup();" class="square-button">顯示<br>行事曆</button>
<%--                    <input required type="time" name="interactionTime" id="interactionTimeInput" value=${application.interactionTime} onchange="checkTime()" />--%>
<%--                    <div id="timeError" style="color:black;">請選擇有效時間（早上 9~12, 下午 2~5, 晚上 6~9）</div>--%>
                </td>
            </tr>
            <tr>
                <td>申請狀態：</td>
                <td>
                    <select name="applicationStat">
                        <option value="0" ${application.applicationStat == 0 ? "selected" : ""}>審核中</option>
                        <option value="1" ${application.applicationStat == 1 ? "selected" : ""}>未通過</option>
                        <option value="2" ${application.applicationStat == 2 ? "selected" : ""}>通過</option>
<%--                        <option value="3" ${application.applicationStat == 3 ? "selected" : ""}>備取中</option>--%>
<%--                        <option value="4" ${application.applicationStat == 4 ? "selected" : ""}>通知後無意願</option>--%>
<%--                        <option value="5" ${application.applicationStat == 5 ? "selected" : ""}>領養成功</option>--%>
<%--                        <option value="6" ${application.applicationStat == 6 ? "selected" : ""}>領養失敗</option>--%>
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
                    <button type="button" id="restoreSignatureBtn">還原簽名</button>
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

    <script src="https://cdnjs.cloudflare.com/ajax/libs/signature_pad/1.5.3/signature_pad.min.js"></script>
    <script>
        var canvas = document.getElementById('signaturePad');
        var signaturePad = new SignaturePad(canvas);
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

        var signaturePhotoShow = document.getElementById('signaturePhotoShow');
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

        document.getElementById('myForm').addEventListener('submit', function(event) {
            let signatureData = document.getElementById('signaturePhoto').value;
            if (!signatureData) {
                alert('請完成簽名後再提交表單。');
                event.preventDefault();
            }
        });

        document.getElementById('clearSignatureBtn').addEventListener('click', function() {
            signaturePad.clear();
            document.getElementById('signaturePhoto').value = '';
            signaturePhotoShow.src = '';
        });

        document.getElementById('restoreSignatureBtn').addEventListener('click', function() {
            restoreSignature();
        });

        function restoreSignature() {
            let originalSignatureData = '${application.signaturePhotoBase64}';
            if (originalSignatureData) {
                signaturePad.clear();
                setTimeout(function() {
                    var restoredData = "data:image/*;base64," + originalSignatureData;
                    signaturePad.fromDataURL(restoredData);
                    document.getElementById('signaturePhoto').value = restoredData;
                    signaturePhotoShow.src = restoredData;
                }, 0);
            }
        }

        window.onload = function() {
            restoreSignature();

            let interactionDateInput = document.getElementById('interactionDateInput');

            let today = new Date();
            let tomorrow = new Date(today);
            tomorrow.setDate(tomorrow.getDate() + 1);

            let maxDate = new Date(tomorrow);
            maxDate.setDate(maxDate.getDate() + 19);

            // interactionDateInput.min = tomorrow.toISOString().split('T')[0];
            interactionDateInput.max = maxDate.toISOString().split('T')[0];

        };

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

        // function checkTime() {
        //     var timeInput = document.getElementById('interactionTimeInput');
        //     var selectedTime = timeInput.value;
        //     var hour = parseInt(selectedTime.split(':')[0], 10);
        //
        //     if (!((hour >= 9 && hour < 12) || (hour >= 14 && hour < 17) || (hour >= 18 && hour < 21))) {
        //         alert('請選擇有效時間: \n早上 9:00~12:00\n下午 2:00~5:00\n晚上 6:00~9:00');
        //         timeInput.value = '';
        //         document.getElementById('timeError').style.color = 'red';
        //     }
        // }
        //
        // window.onload = checkTime; // 在頁面加載時進行檢查

        function showCalendarPopup() {
            var popupWindow = window.open(
                '${pageContext.request.contextPath}/adoptedApplicationHibernateServlet?action=frontendCalendar', // 更改為您的實際路徑
                'CalendarPopup',
                'width=600,height=400,left=200,top=200' // 調整為您想要的尺寸和位置
            );
            popupWindow.focus(); // 將焦點設置到新開啟的窗口
        }

        function checkReservation() {
            let reservationMap = JSON.parse('<%= new Gson().toJson(request.getAttribute("reservationMap")) %>');
            let selectedDate = document.getElementById('interactionDateInput').value;
            let selectedTime = document.getElementById('interactionTimeInput').value;

            let dateReservations = reservationMap[selectedDate];
            if (dateReservations) {
                let timeIndex = getTimeSlotIndex(selectedTime);
                if (dateReservations[timeIndex]) {
                    alert("該預約時段已滿，請參照行事曆重新選擇");
                    return false;
                }
            }
            return true;
        }

        function getTimeSlotIndex(time) {
            let hour = parseInt(time.split(':')[0]);
            if (hour >= 9 && hour < 12) return 0;
            if (hour >= 14 && hour < 17) return 1;
            if (hour >= 18 && hour < 21) return 2;
            return -1;
        }

    </script>

</body>
</html>
