<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/banner.jsp" flush="true"/>

<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/banner.css">
<!-- 傳送圖片icon -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css" integrity="sha384-b6lVK+yci+bfDmaY1u0zE8YYJt0TZxLEAFyYSLHId4xoVvsrQu3INevFKo+Xir8e" crossorigin="anonymous" />
<!-- 即時客服 -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/customerChat.css">
</head>
<body>

    <section class="hero-section hero-section-full-height">
        <div class="container-fluid">
            <div class="row">

                <div class="col-lg-12 col-12 p-0">
                    <div id="hero-slide" class="carousel carousel-fade slide" data-bs-ride="carousel">
                        <div class="carousel-inner">
                            <div class="carousel-item active">
                                <img src="${pageContext.request.contextPath}/img/slide/1.jpg" class="carousel-image img-fluid" alt="...">
                            </div>

                            <div class="carousel-item">
                                <img src="${pageContext.request.contextPath}/img/slide/2.jpg" class="carousel-image img-fluid" alt="...">
                            </div>

                            <div class="carousel-item">
                                <img src="${pageContext.request.contextPath}/img/slide/3.jpg" class="carousel-image img-fluid" alt="...">
                            </div>
                        </div>

                        <button class="carousel-control-prev" type="button" data-bs-target="#hero-slide" data-bs-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Previous</span>
                        </button>

                        <button class="carousel-control-next" type="button" data-bs-target="#hero-slide" data-bs-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Next</span>
                        </button>
                    </div>
                </div>

            </div>
        </div>
        <!-- 即時客服 -->
        <div class="btn" id="chat-icon" style="position: fixed;">
	        <img src="<%=request.getContextPath()%>/img/talk.png" style="width: 70px" />
	        <img src="<%=request.getContextPath()%>/img/alert1.png" style="width: 20px" id="alert" class="hide" />
	    </div>
	
	    <div class="hide" id="chatBox" style="width: 410px">
	        <div class="chat-window">
	
	            <div class="panel panel-default">
	
	                <!-- chat-title -->
	                <div class="panel-heading top-bar d-flex">
	                    <div class="col-md-8 col-xs-8">
	                        <h5 class="panel-title">即時客服</h5>
	                    </div>
	                    <div class="col-md-4 col-xs-4" style="margin-top: 5px; margin-left: 90px;">
	                        <i class="bi bi-x-lg fs-5" id="close"></i>
	                    </div>
	                </div>
	
	                <!-- chat-body -->
	                <div class="panel-body msg_container_base" id="msgContainer">
	
	                </div>
	
	                <!-- chat-input -->
	                <div class="panel-footer">
	                    <div class="input-group" style="padding: 6px;">
	                        <input id="btn-input" type="text" class="input-sm chat_input" placeholder="Message..."
	                            autocomplete="off" />
	                        <span class="input-group-btn">
	                            <button class="btn" id="btn-chat" style="background-color: #1f9d9d"
	                                onclick="sendMessage();">
	                                <i class="bi bi-send-fill text-white"></i>
	                            </button>
	                        </span>
	                    </div>
	                </div>
	
	            </div>
	
	        </div>
	    </div>
	    <!-- 即時客服 -->
    </section>

    
        <!-- JAVASCRIPT FILES -->
        <script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
	    <script src="<%=request.getContextPath()%>/js/customerChat.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
	    <script src="https://kit.fontawesome.com/616f19a0b0.js" crossorigin="anonymous"></script>
	    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
		
</body>
</html>