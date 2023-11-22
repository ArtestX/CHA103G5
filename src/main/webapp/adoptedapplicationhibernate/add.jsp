<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/adoptedapplicationhibernate/main/main.css">
    <title>新增</title>

    <style>
        .square-button {
            width: 80px;   /* 設置寬度 */
            height: 80px;  /* 設置高度 */
            /* 可以添加額外的樣式，如邊框、背景色等 */
            text-align: center; /* 文字居中 */
            vertical-align: middle; /* 垂直居中 */
            line-height: 25px; /* 調整行高以適應兩行文字 */
        }
    </style>

</head>
<body>
<%--    <a href="${pageContext.request.contextPath}/adoptedapplicationhibernate/index.jsp">申請表單首頁</a>--%>
    <button class="fixed-button" onclick="location.href='${pageContext.request.contextPath}/adoptedapplicationhibernate/index.jsp'">管理表單首頁</button>
    <h1>新增</h1>
    <br>
    <img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/adoptedapplicationhibernate/images/cat.png">
    <img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/adoptedapplicationhibernate/images/cat.png">
    <img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/adoptedapplicationhibernate/images/cat.png">
    <br>
    <form action="${pageContext.request.contextPath}/adoptedApplicationHibernateServlet" method="post" enctype="multipart/form-data">
        <input type="hidden" name="action" value="add" />
        <table>
            <tr>
                <td>管理員編號：</td>
                <td><input type="number" name="adminNo" required /></td>
            </tr>
            <tr>
                <td>會員編號：</td>
                <td><input type="number" name="memberNo" required /></td>
            </tr>
            <tr>
                <td>寵物編號：</td>
                <td><input type="number" name="petId" required /></td>
            </tr>
            <tr>
                <td>抽籤日期：</td>
                <td><input type="date" name="lotteryDate" required /></td>
            </tr>
            <tr>
                <td>抽籤排序：</td>
                <td><input type="number" name="lotteryResult" required /></td>
            </tr>
            <tr>
                <td>申請日期：</td>
                <td>
                    <span id="applicationDateDisplay"></span>
                    <input type="hidden" name="applicationDate" id="applicationDateInput" required />
                </td>
            </tr>
            <tr>
                <td>預約時間：</td>
                <td>
                    <input type="date" name="interactionDate" id="interactionDateInput" required />
                    <input type="time" name="interactionTime" id="interactionTimeInput" step="60" required />
                    <button type="button" onclick="showCalendarPopup();" class="square-button">顯示<br>行事曆</button>
                    <div id="timeError" style="color:black;">請選擇有效時間（早上 9~12, 下午 2~5, 晚上 6~9）</div>
<%--                    <div id="timeError" style="color:red; display:none;">請選擇有效時間（早上 9~12, 下午 2~5, 晚上 6~9）</div>--%>
<%--                    <select name="interactionTime" id="interactionTimeInput">--%>
<%--                        <option value="1">上午 9:00 ~ 上午 10:00</option>--%>
<%--                        <option value="2">上午 10:00 ~ 上午 11:00</option>--%>
<%--                        <option value="3">上午 11:00 ~ 中午 12:00</option>--%>
<%--                        <option value="4">下午 2:00 ~ 下午 3:00</option>--%>
<%--                        <option value="5">下午 3:00 ~ 下午 4:00</option>--%>
<%--                        <option value="6">下午 4:00 ~ 下午 5:00</option>--%>
<%--                        <option value="7">晚上 6:00 ~ 晚上 7:00</option>--%>
<%--                        <option value="8">晚上 8:00 ~ 晚上 9:00</option>--%>
<%--                        <option value="9">晚上 7:00 ~ 晚上 8:00</option>--%>
<%--                    </select>--%>
                    </td>
            </tr>
            <tr>
                <td>申請狀態：</td>
                <td>
                    <span>審核中</span>
                    <input type="hidden" name="applicationStat" value="0" />
                </td>
            </tr>
            <tr>
                <td>簽名：</td>
                <td>
<%--                    <input type="file" id="signaturePhotoInput" name="signaturePhoto" accept="image/*" />--%>
<%--                    <img id="signaturePhoto" />--%>
                    <!-- 簽名板區域 -->
                    <canvas id="signaturePad" width="400" height="200" style="border:1px solid #000;"></canvas>
                    <br>
                    <button type="button" id="clearSignatureBtn">清除簽名</button>
                    <input required type="hidden" name="signaturePhoto" id="signaturePhoto">
                </td>
            </tr>
            <tr>
                <td>備註：</td>
                <td><textarea name="applicantNotes" rows="4" cols="50"></textarea></td>
            </tr>
            <br>
            <br>
            <tr>
                <td colspan="2">
                    <input class="table-button" type="submit" value="新增" />
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
<%--                    document.getElementById('signaturePhoto').src = e.target.result;--%>
<%--                };--%>

<%--                reader.readAsDataURL(event.target.files[0]);--%>
<%--            }--%>
<%--        });--%>
<%--    </script>--%>

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

        canvas.addEventListener('mouseup', function() {
            if (isSigning) {
                var signatureData = signaturePad.toDataURL('image/png');
                document.getElementById('signaturePhoto').value = signatureData;
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
        });

        window.onload = function() {
            var today = new Date();
            var formattedDate = today.getFullYear() + '-' +
                ('0' + (today.getMonth() + 1)).slice(-2) + '-' +
                ('0' + today.getDate()).slice(-2);

            document.getElementById('applicationDateDisplay').textContent = formattedDate;
            document.getElementById('applicationDateInput').value = formattedDate;
        };

        var today = new Date();
        var maxDate = new Date();
        maxDate.setDate(today.getDate() + 7);

        var formattedToday = formatDate(today);
        var formattedMaxDate = formatDate(maxDate);

        var interactionDateInput = document.getElementById('interactionDateInput');
        interactionDateInput.min = formattedToday;
        interactionDateInput.max = formattedMaxDate;

        function formatDate(date) {
            return date.getFullYear() + '-' +
                ('0' + (date.getMonth() + 1)).slice(-2) + '-' +
                ('0' + date.getDate()).slice(-2);
        }

        document.getElementById('interactionTimeInput').addEventListener('change', function() {
            var selectedTime = this.value;
            var hour = parseInt(selectedTime.split(':')[0], 10);

            if (!((hour >= 9 && hour < 12) || (hour >= 14 && hour < 17) || (hour >= 18 && hour < 21))) {
                // 如果選擇的時間不在指定範圍內
                alert('請選擇有效時間: \n早上 9:00~12:00\n下午 2:00~5:00\n晚上 6:00~9:00');
                this.value = ''; // 可以選擇清空輸入或設置為一個默認值
                document.getElementById('timeError').style.color = 'red';
                // document.getElementById('timeError').style.display = 'block'; // 顯示錯誤信息
            }
            // else {
            //     document.getElementById('timeError').style.display = 'none'; // 隱藏錯誤信息
            // }
        });

        function showCalendarPopup() {
            var popupWindow = window.open(
                '${pageContext.request.contextPath}/adoptedApplicationHibernateServlet?action=showCalendar', // 更改為您的實際路徑
                'CalendarPopup',
                'width=600,height=400,left=200,top=200' // 調整為您想要的尺寸和位置
            );
            popupWindow.focus(); // 將焦點設置到新開啟的窗口
        }

        function showCalendarPopup() {
            var popupWindow = window.open(
                '${pageContext.request.contextPath}/adoptedApplicationHibernateServlet?action=showCalendar', // 更改為您的實際路徑
                'CalendarPopup',
                'width=600,height=400,left=200,top=200,toolbar=no,status=no,menubar=no,location=no,resizable=no' // 禁用多數互動特性
            );
            popupWindow.focus(); // 將焦點設置到新開啟的窗口
        }

    </script>

</body>
</html>
