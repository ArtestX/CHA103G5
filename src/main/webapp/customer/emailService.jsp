<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/banner.jsp" flush="true"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/sweetalert2.css">
    <style>
        body {
            min-height: 100vh;
            background-image: url('<%=request.getContextPath()%>/img/cus4.jpg');
            background-size: cover; /* 可以根据需要调整背景图像的尺寸 */
            background-repeat: no-repeat; /* 防止背景图像重复 */
            background-attachment: fixed; /* 可以使背景图像固定不滚动 */
            /* 其他样式属性 */

        }

        .main-wrapper {
            width: 50%;
            height: 550px;
        }
        .custom-header {
            background-color: #5699dc;
            padding: 20px;
            position: relative;
        }
        .custom-textarea {
            height: 100px;
        }
        .error-message {
            color: red;
        }
    </style>
</head>
<body>
<div class="main-wrapper mt-5 bg-body-secondary border border-primary container rounded-5 p-4 align-items-center">
    <div class="container-sm">
        <h1 class="border border-primary mt-3 p-2 rounded-4 text-white text-center custom-header position-relative">
            客服信箱
        </h1>
        <select class="form-select mt-4 mb-3" id="category" aria-label="Default select example">
            <option value="" disabled selected>請選擇問題類別</option>
            <option value="寵物認養相關問題">寵物認養相關問題</option>
            <option value="商城購物問題">商城購物問題</option>
            <option value="會員相關問題">會員相關問題</option>
            <option value="其他問題">其他問題</option>
        </select>
        <div class="error-message" id="category-error"></div>
        <div class="form-floating mb-3">
            <input type="text" class="form-control" id="name" placeholder="name">
            <label for="name">請輸入姓名</label>
            <div class="error-message" id="name-error"></div>
        </div>
        <div class="form-floating mb-3">
            <input type="email" class="form-control" id="email" placeholder="email">
            <label for= "email">請輸入電子郵件</label>
            <div class="error-message" id="email-error"></div>
        </div>
        <div class="form-floating mb-3">
            <textarea class="form-control custom-textarea" id="content" placeholder="content"></textarea>
            <label for="content">請輸入您的問題</label>
            <div class="error-message" id="content-error"></div>
        </div>
        <div class="d-grid gap-4 mt-5 col-7 mx-auto">
            <button class="btn btn-primary" type="submit" id="sendButton" value="Submit">送出</button>
        </div>
    </div>
</div>
<script>
    document.getElementById("sendButton").addEventListener("click", function () {
        // 清空之前的錯誤消息
        document.getElementById("name-error").textContent = "";
        document.getElementById("email-error").textContent = "";
        document.getElementById("content-error").textContent = "";
        document.getElementById("category-error").textContent = "";

        // 獲取表單數據
        let name = document.getElementById("name").value;
        let email = document.getElementById("email").value;
        let content = document.getElementById("content").value;

        // 獲取選擇的問題類別
        let category = document.querySelector(".form-select").value;

        let hasError = false; // 用于跟踪是否有错误

        if (category === "") {
            document.getElementById("category-error").textContent = "請選擇問題類別";
            hasError = true;
        }

        if (name.trim() === "") {
            document.getElementById("name-error").textContent = "姓名不能空白";
            hasError = true;
        }

        if (!email.match(/[^@\s]+@[^@\s]+\.[a-zA-Z]{2,}/)) {
            document.getElementById("email-error").textContent = "請輸入有效的電子郵件地址";
            hasError = true;
        }

        if (content.trim() === "") {
            document.getElementById("content-error").textContent = "問題內容不能空白";
            hasError = true;
        }

        // 創建 customerEmail 對象
        if (!hasError) {
            // 提示的加载中弹窗
            Swal.fire({
                title: '傳送中請稍後...',
                icon: 'info',
                showConfirmButton: false,
            });
            let customerEmail = {
                name: name,
                usermail: email,
                content: content,
                category: category // 將選擇的問題類別包含在對象中
            };
            // 使用 fetch 將數據提交给後端
            fetch("http://localhost:8080/CHA103G5/customer/mail.do", {
                method: "POST",
                body: JSON.stringify(customerEmail), // 將對象轉換為 JSON 字符串
                headers: {
                    'Content-Type': 'application/json' // 設置正確的 Content-Type
                }
            })
                .then(response => {

                    if (response.status !== 200) {
                        Swal.fire({
                            title: '寄送失敗',
                            icon: 'error'
                        });
                    } else {
                        Swal.fire({
                            title: '寄送成功',
                            text: '感謝您的回饋,請耐心等候回應..',
                            icon: 'success',
                            showConfirmButton: false,
                            timer: 2700
                        }).then(() => location.reload());
                    }
                })
                .catch(error => {
                    console.error("發送郵件錯誤:", error);
                });
        }
    });
</script>
<script src="<%= request.getContextPath() %>/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/js/sweetalert2.all.min.js"></script>
</body>
</html>
