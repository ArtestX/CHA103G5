const baseUrl = window.location.protocol + "//" + window.location.host + "CHA103G5";

//設定websocket連線
const ServerPoint = `/chat/host`;
const lohost = window.location.host;
const path = window.location.pathname;
const webCtx = path.substring(0, path.indexOf("/", 1));
const endPointURL = "ws://" + lohost + webCtx + ServerPoint;

const msgBody = document.querySelector("#modal-body");
// const self = host;
let webSocket;

function connect() {
    // create a websocket
    webSocket = new WebSocket(endPointURL);
    webSocket.onopen = function (event) {
        console.log("Connect Success!");
        initChatRoom();
    };

    function initChatRoom() {
        let jsonObj = {
            type: "userList",
            sender: "host",
        };
        if (webSocket.readyState === WebSocket.OPEN) {
            // 確保 WebSocket 已經連接成功
            webSocket.send(JSON.stringify(jsonObj));
        }
    }

    webSocket.onmessage = function (event) {
        let data = JSON.parse(event.data);
        console.log(data);

        // 一般訊息
        if (data.type === 0) {
            console.log("data.type === 0");
            buildMessage(data.data);
            initChatRoom();
        }

        // 建立聊天室清單
        if (data.type === 1) {
            buildChatRoomList(data.data);
        }

        // 歷史訊息
        if (data.type === 2) {
            buildHisMessage(data.data);
        }
    }
}

// 建立聊天室清單
function buildChatRoomList(data) {
    console.log("Received data:", data);
    let userList = data;
    let chatRoomList = document.getElementById("online-list");

    chatRoomList.innerHTML = "";

    // 過濾出已上線的會員
    // let onlineUsers = userList.filter(user => user.isOnline === "true");
    for (let user of userList) {
        let userRow = "";
        userRow =
            `<a href="#" class="d-flex align-items-center a target-member" id="user${user.userName}" data-user-id="${user.userNo}" onclick="showUserChatBox(event);">
                    <div class="flex-shrink-0">
                        <img class="img-fluid ps-1" src="../img/backend.png" style="width: 40px;">
                        <img class="d-flex align-items-center" id="alert${user.userName}" src="../img/alert1.png" style="position: absolute; bottom: 8px; left: 38px; width: 15px;">
                    </div>
                    <div class="flex-grow-1 ms-3">
                        <h3>${user.userName}</h3>
                        <p>${user.lastMessage.message}</p>
                    </div>
                </a>`;

        chatRoomList.innerHTML += userRow;

         if (user.lastMessage && user.lastMessage.status === "read" || currentMember === user.userName) {
             console.log(user.lastMessage.status);
             document.querySelector(`#alert${user.userName}`).classList.toggle("hide");
         }

    }
}

function buildHisMessage(data) {
    // 歷史訊息時
    document.querySelector("#userName").innerText = currentMember; // jsonObj.receiver
    document.querySelector("#userImg").innerHTML = '<img style="width: 50px;" src="../img/backend.png">';
    document.querySelector("#userNo").innerText = "u" + JSON.parse(data[0]).receiver;
    let ul = $("#message-list");
    ul.html("");
    for (let i = 0; i < data.length; i++) {
        let historyData = JSON.parse(data[i]);
        let className = historyData.sender === "host" ? "repaly" : "sender";
        let showMsg = "<li class='" + className + "'><p>" + historyData.message + "</p>" + '<span class="time">' + historyData.time + "</span></li>";
        // 根據發送者是自己還是對方來給予不同的class名, 以達到訊息左右區分
        ul.append(showMsg);
    }
    document.querySelector("#chatbox").style.display = "flex";
    msgBody.scrollTop = msgBody.scrollHeight;
}

let currentMember = "";
function showUserChatBox(e) {

    // 被觸擊的元素
    let triggerEl = $(e.target);
    // 找出共同父層且轉為jQuery Object
    let targetParent = $(triggerEl.parents(".target-member")[0]);
    // 找出目標img且轉為jQuery Object
    let alertImg = $(targetParent.find(".flex-shrink-0").find("img")[1]);
    // 移除img
    alertImg.remove();

    // 找出userName
    let userName = $(targetParent.find("h3")).text();

    // // 更新currentMember
    // currentMember = userName;
    //
    //
    // // 在確保 currentMember 被正確更新後再發送請求
    // let jsonObj = {
    //     type: "openChatRoom",
    //     sender: "host",
    //     receiver: currentMember,
    // };
    // webSocket.send(JSON.stringify(jsonObj));


    let jsonObj = {
        type: "openChatRoom",
        sender: "host",
        receiver: userName,
    };
    currentMember = userName;
    webSocket.send(JSON.stringify(jsonObj));
}

//-- input 欄位按Enter(keycode:13)傳送訊息出去 --//
$(document).on("keydown", function (e) {
    if (e.which === 13) {
        e.preventDefault();
        $("#btn-chat").click();
    }
});

function sendMessage() {
    let inputMessage = document.getElementById("btn-input");
    let message = inputMessage.value.trim();

    if (message === "") {
        alert("您未輸入訊息");
        inputMessage.focus();
    } else {
        // let userIds = document.querySelector("#userName").innerText.substring(1);
        let now = new Date();
        let nowStr = now.getFullYear() + "-" + (now.getMonth() + 1) + "-" + now.getDate() + " " + now.getHours() + ":" + now.getMinutes();
        let jsonObj = {
            type: "message",
            sender: "host",
            receiver: currentMember,
            message: message,
            time: nowStr,
        };
        webSocket.send(JSON.stringify(jsonObj));
        inputMessage.value = "";
        inputMessage.focus();
        buildMessage(jsonObj);
    }
}

function buildMessage(data) {
    console.log(currentMember);
    console.log(data.receiver);
    console.log(data.sender);

    if (currentMember && (data.receiver === currentMember || data.sender === currentMember)) {
        let ul = $("#message-list");
        let historyData = data;
        let className = historyData.sender === "host" ? "repaly" : "sender";
        let showMsg = "<li class='" + className + "'><p>" + historyData.message + "</p>" + '<span class="time">' + historyData.time + "</span></li>";
        // 根據發送者是自己還是對方來給予不同的class名, 以達到訊息左右區分
        ul.append(showMsg);
        document.querySelector("#chatbox").style.display = "flex";
        msgBody.scrollTop = msgBody.scrollHeight;
    }
}

function disconnect() {
    webSocket.close();
}


