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
<style>

 #adopt-info {
    background-color: #f8f8f8;
    padding: 20px;
    border-radius: 10px;
    margin-top: 20px;
    font-weight: bold;
}

#adopt-info h2 {
	font-weight: bold;
    color: #333;
     padding: 15px 25px;
}

#adopt-info p {
    color: #555;
    line-height: 1.8;
    margin-left: 60px;
    font-size:15px;
    font-weight: bold;
}

#adopt-info button {
    padding: 10px 20px;
    font-size: 16px;
    font-weight: bold;
    color: #fff;
    background-color: #1f9d9d;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    transition: background-color 0.3s ease;
}

#adopt-dont-shop button:hover {
    background-color: #157575;
}

h1 {
            font-size: 50px;
            color: #867362;
            text-align: center;
            padding: 60px 100px;
            font-weight: bold;
 }

 .col-md-12 img {
            max-width: 100%;
            height: auto;
            display: block;
            margin: 0 auto;
 }

/* 調整即時客服按鈕樣式 */
#chat-icon {
    background-color: #1f9d9d;
    color: #fff;
    border-radius: 50%;
    padding: 10px;
    cursor: pointer;
    position: fixed;
    bottom: 20px;
    right: 20px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
    transition: background-color 0.3s ease;
}

#chat-icon:hover {
    background-color: #157575;
}
</style>

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
        
        <section id="adopt-info">
        	<div class="container-fluid">
             	<div class="row">
             		<div class="col-md-2">
	           		 	 <img src="${pageContext.request.contextPath}/img/indexBG.png" alt="滿版圖片" style="width: 100%; height: auto;">
	           		 </div>
	             	<div class="col-md-9"  style=" margin-left: 10px;">
				    <h2>領養代替購買</h2>
					    <p style="padding-right: 40px; text-indent: 40px;">
					    	在這個充滿愛的季節，讓我們一起支持「領養代替購買」的理念，給予無家可歸的動物一個溫馨的家。
					    </p>
					
					    <p>每年有數以百萬計的動物被遺棄或流浪，他們渴望一個愛的家庭。你不僅能浪浪一個溫暖的家，還能為動物收容所減輕壓力。</p>
					
					    <p style="padding-right: 40px; text-indent: 40px;">
					    	無論你是想要一個忠誠的伴侶、一隻療癒的寵物，還是想要給予浪浪一個家，領養都是一個美好的選擇。
					    </p>
					
					    <p>在這個特殊的時刻，讓我們攜手，一起為「領養代替購買」的理念發聲，為每一隻生命注入溫暖和愛。</p>
					
					    <p>探索我們的領養計畫，成為一個愛心家庭的一員，共同建立一個更美好的世界。</p>
					
					    <a href="#">
					        <button>開始領養</button>
					    </a>
	             	</div>
	             	
	             	
	             	
				</div>
			</div> 
		</section>
		
		<div class="row" style=" margin: 40px; padding:0px;">
			 <h1>了解領養流程</h1>
		     <div class="col-md-12" style="padding:0px;">
		           <img src="${pageContext.request.contextPath}/img/indexBG2.png" alt="領養流程" style="max-width: 100%; height: auto;">
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
	                        <input id="btn-input" type="text" class="input-sm chat_input" placeholder="Enter a message"
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
	<jsp:include page="/footer.jsp" flush="true" />
    
        <!-- JAVASCRIPT FILES -->
        <script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
	    <script src="<%=request.getContextPath()%>/js/customerChat.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
	    <script src="https://kit.fontawesome.com/616f19a0b0.js" crossorigin="anonymous"></script>
	    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
		
</body>
</html>