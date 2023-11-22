<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:include page="/customer/old/banner.jsp" flush="true"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap-v431.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
	<style>
	    
	body {
	  min-height: 100vh;
	  background-image: url('<%=request.getContextPath()%>/img/cus4.jpg');
	  background-size: cover;
	  background-repeat: no-repeat;
	  background-attachment: fixed;
	}
	
	::-webkit-scrollbar {
	  width: 5px;
	}
	
	::-webkit-scrollbar-track {
	  width: 5px;
	  background: #f5f5f5;
	}
	
	::-webkit-scrollbar-thumb {
	  width: 1em;
	  background-color: #ddd;
	  outline: 1px solid slategrey;
	  border-radius: 1rem;
	}
	
	.text-small {
	  font-size: 0.9rem;
	}
	
	.typing-area {
	  margin-top: 20px; /* 调整間距 */
	}
	
	.chat-box {
 	  max-width: 500px; /* 調整最大宽度值 */
      margin: 0 auto; /* 聊天框水平居中 */
	  height: 550px;
	  overflow-y: scroll;
	  border-radius: 1rem
	}
	
	.rounded-lg {
	  border-radius: 0.5rem;
	}
	
	input::placeholder {
	  font-size: 0.9rem;
	  color: #999;
	}
	
	.text-center h1 {
	  color: black; /* 標题黑色 */
	  font-weight: bold; /* 加粗標题 */
	}
	
	.text-center p {
	  color: black; /* 段落黑色 */
	  font-weight: bold; /* 加粗段落 */
	}

	</style>
    <title>即時客服</title>
</head>

<body>
    <div class="container py-5 px-4">
        <!-- Title-->
        <header class="text-center">
          <h1 class="display-4 text-black">汪汪Chat</h1>
          <p class="text-blue lead mb-0">即時解決您的任何問題,是我們的榮幸...</p>
        </header>
          <!-- Chat Box-->
          <div class="col-12 px-0">
            <div class="px-4 py-5 msg_Container_Base bg-white" id="msgContainer">
              <!-- Sender Message-->
              <div class="media w-50 mb-3"><img src="https://bootstrapious.com/i/snippets/sn-chat/avatar.svg" alt="user" width="50" class="rounded-circle">
                <div class="media-body ml-3">
                  <div class="bg-light rounded py-2 px-3 mb-2">
                    <p class="text-small mb-0 text-muted">Test which is a new approach all solutions</p>
                  </div>
                  <p class="small text-muted">12:00 PM | Aug 13</p>
                </div>
              </div>
              <!-- Reciever Message-->
              <div class="media w-50 ml-auto mb-3">
                <div class="media-body">
                  <div class="bg-primary rounded py-2 px-3 mb-2">
                    <p class="text-small mb-0 text-white">Test which is a new approach to have all solutions</p>
                  </div>
                  <p class="small text-muted">12:00 PM | Aug 13</p>
                </div>
              </div>
              <!-- Sender Message-->
              <div class="media w-50 mb-3"><img src="https://bootstrapious.com/i/snippets/sn-chat/avatar.svg" alt="user" width="50" class="rounded-circle">
                <div class="media-body ml-3">
                  <div class="bg-light rounded py-2 px-3 mb-2">
                    <p class="text-small mb-0 text-muted">Test which is a new approach all solutions</p>
                  </div>
                  <p class="small text-muted">12:00 PM | Aug 13</p>
                </div>
              </div>
              <!-- Reciever Message-->
              <div class="media w-50 ml-auto mb-3">
                <div class="media-body">
                  <div class="bg-primary rounded py-2 px-3 mb-2">
                    <p class="text-small mb-0 text-white">Test which is a new approach to have all solutions</p>
                  </div>
                  <p class="small text-muted">12:00 PM | Aug 13</p>
                </div>
              </div>
            <!-- Typing area -->
            <form action="#" class="bg-light typing-area" style="background-color: #f5f5f5;">
              <div class="input-group">
                <input type="text" placeholder="Type a message" aria-describedby="button-addon2" class="form-control rounded-0 border-0 py-4 bg-light">
                <div class="input-group-append">
                  <button id="button-addon2" type="submit" class="btn btn-link"> <i class="fa fa-paper-plane"></i></button>
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>
     </div>
    <script src="<%=request.getContextPath()%>/js/jquery-3.3.1.slim.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/bootstrap-v431.bundle.min.js"></script>
<script>
  //連接websocket
  let userId = '';
  let userName = '';
  const ServerPoint = `/chat/${userName}`;
  const lohost = window.location.host;
  const path = window.location.pathname;
  const webCtx = path.substring(0, path.indexOf("/", 1));
  const endPointURL = "ws://" + lohost + webCtx + ServerPoint;

  const msgContainer = document.querySelector("#msgContainer");
  let webSocket;

  let con = false;
  let chatbox = document.querySelector("#chatBox"); // 點擊聊天圖示 (#chat-icon) 時才會開啟連線
  document.querySelector("#chat-icon").addEventListener("click", function () {

    if (userName.trim() === '') {
      memberLogin();
    } else {
      // memberLogin();
      chatbox.classList.toggle("hide");
      msgContainer.scrollTop = msgContainer.scrollHeight;
      if (!document.querySelector("#alert").classList.contains("hide")) {
        document.querySelector("#alert").classList += " hide";
      }
      if (con === false) {
        connect();
      }

    }

  });

  document.querySelector("#close").addEventListener("click", function () {
    chatbox.classList += " hide";
  });

  const user = '<div class="col-md-2 col-xs-2 avatar">' + '<img src="../dist/img/chat/kittybleft.png" class="img-responsive_self">' + "</div>";
  const hoster = '<div class="col-md-2 col-xs-2 avatar">' + '<img src="../dist/img/chat/customer-service.png" class="img-responsive_user">' + "</div>";

  let isEmpOline = true;
  function connect() {

    // 建立 websocket
    webSocket = new WebSocket(endPointURL + userName);
    webSocket.onopen = function (event) {
      // 初始化連線，只會連線一次
      console.log("Connect Success!");
      con = true;
      let jsonObj = {
        type: "openChatRoom",
        sender: userName,
        receiver: userName,
      };
      webSocket.send(JSON.stringify(jsonObj));
    }

    webSocket.onmessage = function (event) {
      let data = JSON.parse(event.data);
      console.log(data);

      // 一般訊息
      if (data.type === 0) {
        buildMessage(data.data);
      }

      // 建立聊天室清單
      if (data.type === 1) {
        buildChatRoomList(data.data);
      }


      //歷史訊息
      if (data.type === 2) {
        buildHisMessage(data.data);
      }

      // 客服上線
      if (data.type === 3) {
        isEmpOline = true;
        buildHisMessage(data.data);
      }

      // 客服不在線上
      if (data.type === 4) {
        isEmpOline = false;
        buildOfflineMessage();
      }
    }
  }

  //-- input 欄位按Enter(keycode:13)傳送訊息出去 --//
  $("#btn-input").on("keydown", function (e) {
    if (e.which === 13) {
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
      let now = new Date();
      let nowStr = now.getFullYear() + "-" + (now.getMonth() + 1) + "-" + now.getDate() + " " + now.getHours() + ":" + now.getMinutes();
      let jsonObj = {
        type: "message",
        sender: userName,
        receiver: "host",
        message: message,
        time: nowStr,
        status: "unread",
      };
      webSocket.send(JSON.stringify(jsonObj));
      inputMessage.value = "";
      inputMessage.focus();
      buildMessage(jsonObj);
    }
  }

  function buildHisMessage(data) {
    msgContainer.innerHTML = "";
    // 這行的jsonObj.message是從redis撈出跟客服的歷史訊息，再parse成JSON格式處理
    let messages = data;
    for (let i = 0; i < messages.length; i++) {
      let div = document.createElement("div");
      div.className = "row msg_container";
      let historyData = JSON.parse(messages[i]);
      let showMsg = historyData.message;
      let time = historyData.time;
      let content = "";
      // 根據發送者是自己還是對方來給予不同的html
      if (historyData.sender === userName) {
        content =
                '<div class="col-md-10 col-xs-10">' +
                '<div class="messages_self msg_receive_self">' +
                '<p>' + showMsg + '</p>' +
                '<time>' + `${userName} - ` + time +
                '</time></div></div>' +
                user;
      } else {
        content =
                hoster +
                '<div class="col-md-10 col-xs-10">' +
                '<div class="messages_user msg_receive_user">' +
                '<p>' + showMsg + '</p>' +
                '<time>客服 - ' + time +
                '</time></div></div>';
      }
      div.innerHTML = content;
      msgContainer.appendChild(div);
    }
    msgContainer.scrollTop = msgContainer.scrollHeight;
  }

  function buildMessage(data) {
    let div = document.createElement("div");
    div.className = "row msg_container";
    let jsonObj = data;
    let showMsg = jsonObj.message;
    let time = jsonObj.time;
    let content = "";
    // 根據發送者是自己還是對方來給予不同的html
    if (jsonObj.sender === userName) {
      content =
              '<div class="col-md-10 col-xs-10">' +
              '<div class="messages_self msg_receive_self">' +
              '<p>' + showMsg + '</p>' +
              '<time>' + `${userName} - ` + time +
              '</time></div></div>' +
              user;
    } else {
      content =
              hoster +
              '<div class="col-md-10 col-xs-10">' +
              '<div class="messages_user msg_receive_user">' +
              '<p>' + showMsg + '</p>' +
              '<time>客服 - ' + time +
              '</time></div></div>';
    }
    div.innerHTML = content;
    msgContainer.appendChild(div);
    if (chatbox.classList.contains("hide")) {
      document.querySelector("#alert").classList.toggle("hide");
    } else {
      msgContainer.scrollTop = msgContainer.scrollHeight;
    }
  }

  function buildOfflineMessage() {
    let div = document.createElement("div");
    div.className = "row msg_container";
    let now = new Date();
    let time = now.getFullYear() + "-" + (now.getMonth() + 1) + "-" + now.getDate() + " " + now.getHours() + ":" + now.getMinutes();
    let content =
            hoster +
            `<div class="col-md-10 col-xs-10">
    <div class="messages_user msg_receive_user">
    <p>您好，目前客服未在線～！請留下想詢問的問題，將於營業時間回覆您(❀╹◡╹)</p>
    <time>客服 - ${time}</time>
    </div>
    </div>`;
    div.innerHTML = content;
    msgContainer.appendChild(div);
    msgContainer.scrollTop = msgContainer.scrollHeight;
  }
</script>


</body>
</html>
