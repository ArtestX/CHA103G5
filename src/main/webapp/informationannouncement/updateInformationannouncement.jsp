<%@page import="java.sql.Timestamp" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.cha103g5.admin.model.*" %>

<%
    Object adminAccount = session.getAttribute("adminAccount");                  // 從 session內取出 (key) adminVO的值
    if (adminAccount == null) {                                             // 如為 null, 代表此user未登入過 , 才做以下工作
        session.setAttribute("location", request.getRequestURI());       		//*工作1 : 同時記下目前位置 , 以便於login.html登入成功後 , 能夠直接導至此網頁
        response.sendRedirect(request.getContextPath()+"/admin/adminLogin.jsp");   //*工作2 : 請該user去登入網頁(login.html) , 進行登入
        return;
    }
%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
    <title>修改寵物資料</title>
    <style>
        body {
            font-family: 'Poppins', sans-serif;
            background: linear-gradient(45deg, #c5deea 0%, #8abbd7 31%, #066dab 100%);
        }

        .box-area {
            width: 630px;
        }

        ::placeholder {
            font-size: 14px;
        }

        span {
            font-size: 13px;
            color: red;
            white-space: nowrap;
        }
    </style>
</head>

<body>
<div
        class="container d-flex justify-content-center align-items-center min-vh-100">
    <div class="row border rounded-5 p-3 bg-white shadow box-area">
        <div class="header-text text-center">
            <div class="d-flex justify-content-end">
                <button type="button" class="btn btn-primary" id="mainPage">返回</button>
            </div>
            <h3>修改公告資料</h3>

            <div class="row g-1 align-items-center ms-5">
                <div class="row g-1 align-items-center ms-5">
                    <div class="col-auto offset-1">
                        <label class="col-form-label">管理員帳號 :</label>
                    </div>
                    <div class="col-auto">
                        <input type="text" id="adminAccount" value="${adminAccount}" readonly class="form-control">
                    </div>
                </div>

                <div class="row g-1 align-items-center ms-5">
                    <div class="col-auto offset-1">
                        <label class="col-form-label">公告編號:</label>
                    </div>
                    <div class="col-auto">
                        <input type="text" id="infoNo" value="${infoNo}" readonly class="form-control">
                    </div>
                </div>

                <div class="row g-1 align-items-center ms-5">
                    <div class="col-auto offset-1">
                        <label class="col-form-label">公告類型 :</label>
                    </div>
                    <div class="col-auto">
                        <select class="col-form-label" id="infoTitle" name="infoTitle">
                            <option value="商城公告">商城公告</option>
                            <option value="系統公告">系統公告</option>
                            <option value="活動公告">活動公告</option>
                            <option value="領養公告">領養公告</option>
                        </select>
                    </div>
                </div>

                <div class="row g-1 align-items-center ms-5">
                    <div class="col-auto offset-1">
                        <label class="col-form-label">公告內容 :</label>
                    </div>
                    <div class="col-auto">
                        <input type="text" name="infoContent" placeholder="請輸入公告內容" id="infoContent">
                    </div>
                </div>

                <div class="row g-1 align-items-center ms-5">
                    <div class="col-auto offset-1">
                        <label class="col-form-label">公告日期 :</label>
                    </div>
                    <div class="col-auto">
                        <input type="date" name="infoTime" id="infoTime">
                    </div>
                </div>

                <div class="input-group g-3 mb-2">
                    <button type="submit" class="btn btn-lg btn-primary w-100 fs-6" id="executeFunctionButton">更新公告</button>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    let mainPage = document.getElementById('mainPage');
    mainPage.addEventListener('click', function () {
        window.location.href = 'select_page.jsp';
    });
</script>

<link rel="stylesheet" type="text/css"
      href="<%=request.getContextPath()%>/datetimepicker/jquery.datetimepicker.css"/>
<script src="<%=request.getContextPath()%>/datetimepicker/jquery.js"></script>
<script
        src="<%=request.getContextPath()%>/datetimepicker/jquery.datetimepicker.full.js"></script>
<style>
    .xdsoft_datetimepicker .xdsoft_datepicker {
        width: 300px; /* width:  250px; */
    }

    .xdsoft_datetimepicker .xdsoft_timepicker .xdsoft_time_box {
        height: 151px; /* height:  151px; */
    }
</style>
<script>

    let pathName = window.document.location.pathname;
    let projectName = pathName.substring(0, pathName.substring(1).indexOf("/") + 1);

    document.addEventListener('DOMContentLoaded', function () {
        loadFirst();
        console.log('頁面已經載入並解析完成！');
    });


    $.datetimepicker.setLocale('zh');
    $('#text7').datetimepicker({
        theme: ' ', //theme: 'dark',
        timepicker: false, //timepicker:true,
        step: 60, //step: 60 (這是timepicker的預設間隔60分鐘)
        format: 'Y-m-d', //format:'Y-m-d H:i:s',
        value: '${param.createDate}', // value:   new Date(),
        //disabledDates:        ['2017/06/08','2017/06/09','2017/06/10'], // 去除特定不含
        //startDate:	            '2017/07/10',  // 起始日
        //minDate:               '-1970-01-01', // 去除今日(不含)之前
        //maxDate:               '+1970-01-01'  // 去除今日(不含)之後
    });

    //========================拿URL的值去查資料======================
    function loadFirst() {
        // 獲取 URL 中的查詢參數
        const urlParams = new URLSearchParams(window.location.search);
        const infoNo = urlParams.get('infoNo');
        // 使用 fetch 發送 GET 請求
        fetch(`/CHA103G5/informationAnnouncement/` + infoNo)
            .then(response => {
                if (!response.ok) {
                    throw new Error(`無法查詢公告訊息. Status: ${response.status}`);
                }
                return response.json();
            })
            .then(info => {
                // 在這裡處理 Info，將其填充到相應的欄位中
                document.getElementById('infoNo').value = info.infoNo;
                document.getElementById('infoTitle').value = info.infoTitle;
                document.getElementById('infoContent').value = info.infoContent;
                document.getElementById('infoTime').value = info.infoTime;
            })
            .catch(error => {
                console.error(error);
            });

    }


    document.getElementById('executeFunctionButton').addEventListener('click', function () {
        console.log("送出按鈕有被綁到");
        // 要發送的數據
        const adminNo = document.getElementById('adminAccount').value;
        const infoTitle = document.getElementById('infoTitle').value;
        const infoContent = document.getElementById('infoContent').value;
        const infoTime = document.getElementById('infoTime').value;

        // 錯誤訊息容器
        let errorMessage = "";

        // 驗證公告類型
        if (infoTitle === "") {
            errorMessage += "請選擇公告類型。\n";
        }


        // 驗證公告內容
        if (infoContent === "") {
            errorMessage += "請輸入寵物名稱。\n";
        } else if (infoContent.length > 25) {
            errorMessage += "公告內容太長，請輸入不超過" + 25 + "個字元。\n";
        }

        // 驗證公告日期
        if (infoTime === "") {
            errorMessage += "請更新日期。\n";
        }

        // 如果有錯誤，顯示錯誤訊息
        if (errorMessage !== "") {
            alert(errorMessage);
            return;
        }

            // 執行 fetch
            const a = document.getElementById('infoNo').value

                const putData = {
                    "infoNo": a,
                    "adminNo": adminNo,
                    "infoTitle": infoTitle,
                    "infoContent": infoContent,
                    "infoTime": infoTime,
                };

                console.log(putData);

                // API端點
                const apiUrl = projectName + '/informationAnnouncement/' + a;

                // 發送 PUT 請求
                fetch(apiUrl, {
                    method: 'PUT',  // 將方法改為 PUT
                    headers: {
                        'Content-Type': 'application/json',
                        // 如果需要身份驗證或其他標頭，請在此處添加
                    },
                    body: JSON.stringify(putData),
                })
                    .then(response => {
                        if (!response.ok) {
                            throw new Error(`HTTP錯誤: ${response.status}`);
                        }
                        return response.text(); // 繼續使用 response.text() 處理純文字訊息
                    })
                    .then(data => {
                        // 處理成功響應
                        console.log('成功：', data);

                        // 在這裡跳轉到 select_page.jsp
                        window.location.href = 'select_page.jsp';
                    })
                    .catch(error => {
                        // 處理錯誤
                        console.error('錯誤：', error);
                    });

        // window.location.href = 'select_page.jsp';

    });

</script>


<script src="../js/popper.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
</body>
</html>