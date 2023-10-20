<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
    <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/img/TitleLogo.png">
    <title>
        浪愛有家
    </title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-icons.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/templatemo-kind-heart-charity.css">	
</head>
<body>
    <header class="site-header">
        <div class="container">
            <div class="row">
                
                <div class="col-lg-8 col-12 d-flex flex-wrap">
                    <p class="d-flex me-4 mb-0">
                        <i class="bi-geo-alt me-2"></i>
                        桃園市中壢區復興路46號9F
                    </p>

                    <p class="d-flex mb-0">
                        <i class="bi-envelope me-2"></i>

                        <a href="mailto:info@company.com">
                            info@company.com
                        </a>
                    </p>
                </div>

                <div class="col-lg-3 col-12 ms-auto d-lg-block d-none">
                    <ul class="social-icon">
                        <li class="social-icon-item">
                            <a href="https://www.facebook.com/TibaMe" class="social-icon-link bi-facebook"></a>
                        </li>

                        <li class="social-icon-item">
                            <a href="https://www.youtube.com/@TibaMe" class="social-icon-link bi-youtube"></a>
                        </li>
                    </ul>
                </div>

            </div>
        </div>
    </header>
    <nav class="navbar navbar-expand-lg bg-light shadow-lg">
        <div class="container">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp">
                <img src="${pageContext.request.contextPath}/img/logo.png" class="logo img-fluid" alt="Kind Heart Charity">
            </a>

            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item">
                        <a class="nav-link click-scroll" href="${pageContext.request.contextPath}/index.jsp">首頁</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link click-scroll" href="">關於我們</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link click-scroll" href="">寵物領養</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link click-scroll" href="">精選商店</a>
                    </li>

                    <li class="nav-item dropdown">
                        <a class="nav-link click-scroll" href="">公告資訊</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link click-scroll" href="">聯絡我們</a>
                    </li>

                    <li class="nav-item ms-3">
                        <a class="nav-link custom-btn custom-border-btn btn" href="${pageContext.request.contextPath}/login.jsp">會員登入</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    
        <!-- JAVASCRIPT FILES -->
        <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/jquery.sticky.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

</body>
</html>