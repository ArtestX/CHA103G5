<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:include page="/customer/banner.jsp" flush="true"/>
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
	  background-size: cover; /* 可以根据需要调整背景图像的尺寸 */
	  background-repeat: no-repeat; /* 防止背景图像重复 */
	  background-attachment: fixed; /* 可以使背景图像固定不滚动 */
	  /* 其他样式属性 */
	  
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
	  margin-top: 20px; /* 根据需要调整间距 */
	}
	
	.chat-box {
 	  max-width: 800px; /* 调整您希望的最大宽度值 */ 
      margin: 0 auto; /* 让聊天框水平居中 */ 
	  height: 568px;
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
	  color: black; /* 设置标题文本颜色为黑色 */
	  font-weight: bold; /* 加粗标题文本 */
	}
	
	.text-center p {
	  color: black; /* 设置段落文本颜色为黑色 */
	  font-weight: bold; /* 加粗段落文本 */
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
</body>
</html>
