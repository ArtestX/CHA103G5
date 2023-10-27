<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/banner.jsp" flush="true"/>

<html>
<head>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/banner.css">
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
    </section>

    
        <!-- JAVASCRIPT FILES -->
        <script src="js/jquery.min.js"></script>
  
		
</body>
</html>