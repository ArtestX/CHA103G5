<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:include page="/banner.jsp" flush="true"/>
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
	  background-size: cover; /* 調整背景圖像的尺寸 */
	  background-repeat: no-repeat; /* 防止背景圖像重複 */
	  background-attachment: fixed; /* 可以使背景圖像固定不滾動 */

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
	
	.messages-box {
	  height: 520px;
	  overflow-y: scroll;
	}
	
	.typing-area {
	  margin-top: 20px; /* 调整間距 */
	}
	
	.chat-box {
/* 	  max-width: 600px; /* 調整最大宽度 */
/*    margin: 0 auto; /* 聊天框水平置中 */
	  height: 568px;
	  overflow-y: scroll;
	}
	
	.rounded-lg {
	  border-radius: 0.5rem;
	}
	
	input::placeholder {
	  font-size: 0.9rem;
	  color: #999;
	}
	
	.text-center h1 {
	  color: black; /* 標题颜色黑色 */
	  font-weight: bold; /* 加粗標題*/
	}
	
	.text-center p {
	  color: black; /* 段落颜色黑色 */
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
        <div class="row rounded-lg overflow-hidden shadow bg-white">
          <!-- Users box-->
          <div class="col-5 px-0">
            <div class="bg-white">
              <div class="bg-gray px-4 py-2 bg-light">
                <p class="h5 mb-0 py-1">Recent</p>
              </div>
              <div class="messages-box">
                <div class="list-group rounded-0">
                  <a href="#" class="list-group-item list-group-item-action list-group-item-light rounded-0">
                    <div class="media"><img src="https://bootstrapious.com/i/snippets/sn-chat/avatar.svg" alt="user" width="50" class="rounded-circle">
                      <div class="media-body ml-4">
                        <div class="d-flex align-items-center justify-content-between mb-1">
                          <h6 class="mb-0">Jason Doe</h6><small class="small font-weight-bold">30 Aug</small>
                        </div>
                        <p class="font-italic text-muted mb-0 text-small">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore.</p>
                      </div>
                    </div>
                  </a>
                  <a href="#" class="list-group-item list-group-item-action list-group-item-light rounded-0">
                    <div class="media"><img src="https://bootstrapious.com/i/snippets/sn-chat/avatar.svg" alt="user" width="50" class="rounded-circle">
                      <div class="media-body ml-4">
                        <div class="d-flex align-items-center justify-content-between mb-3">
                          <h6 class="mb-0">Jason Doe</h6><small class="small font-weight-bold">21 Aug</small>
                        </div>
                        <p class="font-italic text-muted mb-0 text-small">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore.</p>
                      </div>
                    </div>
                  </a>
                </div>
              </div>
            </div>
          </div>
          <!-- Chat Box-->
          <div class="col-7 px-0">
            <div class="px-4 py-5 chat-box bg-white">
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
            <form action="#" class="bg-light typing-area">
              <div class="input-group">
                <input type="text" placeholder="Type a message" aria-describedby="button-addon2" class="form-control rounded-0 border-0 py-4 bg-light">
                <div class="input-group-append">
                  <button id="submitButton" type="submit" class="btn btn-link"> <i class="fa fa-paper-plane"></i></button>
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>
     </div>



    <script>
      // document.addEventListener('DOMContentLoaded', function() {
      //   document.getElementById("submitButton").addEventListener("click", function() {
      //     console.log("button 成功");
      //
      //     var userName = "yourUsername"; // 替換為實際使用者名稱
      //     fetch('http://localhost:8080/getMemberName', {
      //       method: 'POST',
      //       headers: {
      //         'Content-Type': 'application/json'
      //       },
      //       body: JSON.stringify({ userName: userName })
      //     })
      //             .then(response => {
      //               if (response.ok) {
      //                 return response.json();
      //               } else {
      //                 throw new Error('新增失败');
      //               }
      //             })
      //             .then(data => {
      //               // 處裡回應數據
      //               console.log(data);
      //             })
      //             .catch(error => {
      //               console.log("Error: " + error);
      //             });
      //   });
      // });

    </script>
    <script src="<%=request.getContextPath()%>/js/jquery-3.3.1.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/bootstrap-v431.bundle.min.js"></script>
</body>
</html>
