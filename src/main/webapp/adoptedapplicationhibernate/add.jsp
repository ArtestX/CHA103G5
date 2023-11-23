<%@ page import="com.cha103g5.admin.model.AdminVO" %>
<%@ page import="com.cha103g5.adoptedapplicationhibernate.service.AdoptedApplicationHibernateService" %>
<%@ page import="com.cha103g5.adoptedapplicationhibernate.service.AdoptedApplicationHibernateServiceImpl" %>
<%@ page import="com.cha103g5.member.model.MemberVO" %>
<%@ page import="com.cha103g5.pet.model.PetVO" %>
<%@ page import="com.google.gson.Gson" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    AdoptedApplicationHibernateService aahService = new AdoptedApplicationHibernateServiceImpl();
    AdminVO randomAdmin = aahService.getRandomAdmin();
    pageContext.setAttribute("randomAdminNo", randomAdmin.getAdminNo());
    pageContext.setAttribute("randomAdminName", randomAdmin.getAdminName());
    MemberVO randomMember = aahService.getRandomMember();
    pageContext.setAttribute("randomMemberNo", randomMember.getMemberno());
    pageContext.setAttribute("randomMemberName", randomMember.getMembername());
    PetVO randomPet = aahService.getRandomPet();
    pageContext.setAttribute("randomPetId", randomPet.getPetid());
    pageContext.setAttribute("randomPetName", randomPet.getPetname());
    pageContext.setAttribute("randomPetStat", randomPet.getStat());

    Byte petStatByte = randomPet.getStat();
    boolean isPetAvailableForReservation = (petStatByte != null && petStatByte == 1);
    pageContext.setAttribute("isPetAvailableForReservation", isPetAvailableForReservation);
%>

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
    <div style="display: grid; grid-template-columns: auto auto; align-items: start; gap: 20px;">
        <form id="myForm" action="${pageContext.request.contextPath}/adoptedApplicationHibernateServlet" method="post" enctype="multipart/form-data" onsubmit="return checkReservation()">
            <input type="hidden" name="action" value="add" />
            <div>
            <table>
    <%--            <tr>--%>
    <%--                <td>管理員編號：</td>--%>
    <%--                <td><input type="number" name="adminNo" required /></td>--%>
    <%--            </tr>--%>
                <tr>
                    <td>管理員編號-姓名：</td>
                    <td>
                        ${randomAdminNo} - ${randomAdminName}
                        <input type="hidden" name="adminNo" value="${randomAdminNo}" />
                    </td>
                </tr>
    <%--            <tr>--%>
    <%--                <td>會員編號：</td>--%>
    <%--                <td><input type="number" name="memberNo" required /></td>--%>
    <%--            </tr>--%>
                <tr>
                    <td>會員編號-姓名：</td>
                    <td>
                        ${randomMemberNo} - ${randomMemberName}
                        <input type="hidden" name="memberNo" value="${randomMemberNo}" />
                    </td>
                </tr>
    <%--            <tr>--%>
    <%--                <td>寵物編號：</td>--%>
    <%--                <td><input type="number" name="petId" required /></td>--%>
    <%--            </tr>--%>
                <tr>
                    <td>寵物編號-姓名(狀態)：</td>
                    <td>
                        ${randomPetId} - ${randomPetName}(${randomPetStat}-
                            <c:choose>
                                <c:when test="${randomPetStat == 0}">未上架-不可預約)</c:when>
                                <c:when test="${randomPetStat == 1}">待領養-可預約)</c:when>
                                <c:when test="${randomPetStat == 2}">不可領養-不可預約)</c:when>
                                <c:when test="${randomPetStat == 3}">領養中-不可預約)</c:when>
                                <c:when test="${randomPetStat == 4}">已領養-不可預約)</c:when>
                                <c:otherwise>未知狀態</c:otherwise>
                            </c:choose>
                        <input type="hidden" name="petId" value="${randomPetId}" />
                    </td>
                </tr>
<%--                <tr>--%>
<%--                    <td>抽籤日期：</td>--%>
<%--                    <td><input type="date" name="lotteryDate" required /></td>--%>
<%--                </tr>--%>
                <tr>
                    <td>處理進度：</td>
                    <td>
                        <span>處理表單</span>
                        <input type="hidden" name="lotteryResult" value="0" />
                    </td>
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
                        <select type="time" name="interactionTime" id="interactionTimeInput" required>
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
    <%--                    <input type="time" name="interactionTime" id="interactionTimeInput" step="60" required />--%>
                        <button type="button" onclick="showCalendarPopup();" class="square-button">顯示<br>行事曆</button>
    <%--                    <div id="timeError" style="color:black;">請選擇有效時間（早上 9~12, 下午 2~5, 晚上 6~9）</div>--%>
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
            </div>
        </form>
        <div>
            <img src="${pageContext.request.contextPath}/adoptedapplicationhibernate/images/領養協議書.png" alt="領養協議書範例" style="width: 800px; height: 1000px;" />
        </div>
    </div>

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

        document.getElementById('myForm').addEventListener('submit', function(event) {
            var signatureData = document.getElementById('signaturePhoto').value;
            if (!signatureData) {
                alert('請完成簽名後再提交表單。');
                event.preventDefault();
            }
        });

        document.getElementById('clearSignatureBtn').addEventListener('click', function() {
            signaturePad.clear();
            document.getElementById('signaturePhoto').value = '';
        });

        window.onload = function() {
            let today = new Date();
            let formattedDate = today.getFullYear() + '-' +
                ('0' + (today.getMonth() + 1)).slice(-2) + '-' +
                ('0' + today.getDate()).slice(-2);

            document.getElementById('applicationDateDisplay').textContent = formattedDate;
            document.getElementById('applicationDateInput').value = formattedDate;

            let isPetAvailableForReservation = <%= pageContext.getAttribute("isPetAvailableForReservation") %>;
            let interactionDateInput = document.getElementById('interactionDateInput');
            let interactionTimeInput = document.getElementById('interactionTimeInput');

            let tomorrow = new Date(today);
            tomorrow.setDate(tomorrow.getDate() + 1);
            let maxDate = new Date(tomorrow);
            maxDate.setDate(maxDate.getDate() + 19);

            interactionDateInput.min = tomorrow.toISOString().split('T')[0];
            interactionDateInput.max = maxDate.toISOString().split('T')[0];

            interactionDateInput.disabled = !isPetAvailableForReservation;
            interactionTimeInput.disabled = !isPetAvailableForReservation;

        };

        // var today = new Date();
        // var maxDate = new Date();
        // maxDate.setDate(today.getDate() + 7);
        //
        // var formattedToday = formatDate(today);
        // var formattedMaxDate = formatDate(maxDate);
        //
        // var interactionDateInput = document.getElementById('interactionDateInput');
        // interactionDateInput.min = formattedToday;
        // interactionDateInput.max = formattedMaxDate;

        // function formatDate(date) {
        //     return date.getFullYear() + '-' +
        //         ('0' + (date.getMonth() + 1)).slice(-2) + '-' +
        //         ('0' + date.getDate()).slice(-2);
        // }

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

        function showCalendarPopup() {
            var popupWindow = window.open(
                '${pageContext.request.contextPath}/adoptedApplicationHibernateServlet?action=frontendCalendar', // 更改為您的實際路徑
                'CalendarPopup',
                'width=600,height=400,left=200,top=200' // 調整為您想要的尺寸和位置
            );
            popupWindow.focus(); // 將焦點設置到新開啟的窗口
        }

        // window.onload = function() {
        //     var interactionDateInput = document.getElementById('interactionDateInput');
        //     var today = new Date();
        //     interactionDateInput.min = today.toISOString()   .split('T')[0];
        //
        //     var maxDate = new Date();
        //     maxDate.setDate(today.getDate() + 7);
        //     interactionDateInput.max = maxDate.toISOString().split('T')[0];
        // };

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
