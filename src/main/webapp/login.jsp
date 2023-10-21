<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="banner.jsp" flush="true"/>
<html>
<head>
</head> 
<style>
    * {
        margin: 0;
        padding: 0;
        list-style: none;
        text-decoration: none;
        box-sizing: border-box;
    }

    form.login{
        width: 100%;
        height: 100vh;
        /* padding: 5vh 5vh; */
        background-color: rgba(255,255,255,.8);
        display: flex;
        flex-wrap: wrap;
    }

    .one-thirds{
        width: 50%;
        height: auto;
        
    }
    @media (max-width: 575.98px) {
      .one-thirds {
          width: 0%; /* 在小屏幕時設置寬度為100% */
          height: auto; /* 讓高度根據內容自動調整 */
      }
    }
    
    .two-thirds{
        width: 50%;
        background-color: rgba(255,255,255);
       
    }
    @media (max-width: 575.98px){
      .two-thirds{
        width: 100%;
      }
    }  

    fieldset{
        max-width: 400px;
        margin: auto;/*center*/
        font-size: 20px;
        border: 1px solid #fff;
    }

    .lgd{
        font-size: 30px;
        margin: 30px 0 30px 0;
         text-align: center;
    }

    legend,input{
        padding: 5px;
        border: 1px solid #D2D2D2;
    }

    input[type="username"]{
        width: 100%;
        height: 38px;
        margin: 10px 0 10px 0;
        padding: 10px;
        border-radius: 10px; 
    }

    input[type="password"]{
        width: 100%;
        height: 38px;
        margin: 5px 0 10px 0;
        padding: 10px;
        border-radius: 10px; 
    }

    input[type="checkbox"]{
        margin: 10px 0 0 0;
    }

    input[type="button"]{
        width: 100%;
        margin: 10px 0 0 0;
        background: #73A79A;
        color: #fff;
        padding: 10px;
        border-radius: 10px;
        font-size: 15px;
        
    }

    .btn{
        margin: 0 0 10px 0;
    }

    .btn:hover {
        opacity: 0.8;
    }

    #sign a{
        color: #73A79A;
        margin: 0 25px 0 25px;
    } 

    #rmbr{
        padding: 3px 10px 5px 0;
        margin: 0;
    }

    .member_btn{
        border-top: 1px solid #D2D2D2;
        margin: 10px 0 10px 0;
        padding-top: 10px;
    }

    .img_btn{
        width: 100%;
        display: inline-flex;/*合併在一起*/
        flex-wrap: wrap;/*合併在一起*/
    }

    .c_btn a img{
        width: 198px;
        margin: 0;
        padding: 0;
        flex: 0 1 auto;/*合併在一起*/
    }
    .small-image{
      width:8%;
    }  

    #left img {
      width:100%;
      height: 100vh; 
    }
  </style>
</head>
<body>
  <!--login會員登入-->
  <form class="login" action="javascript:;" method="post">
    <div id="left" class="one-thirds">
      <img src="${pageContext.request.contextPath}/img/login.png">
    </div><!--one-thirds-->
    <div id="right" class="two-thirds">
        <fieldset>
            <!--<div class="fie">-->
                <h1 class="lgd">會員登入</h1>
<!--1-->        帳號:<input type="username" id="username" class="username_email" name="username" placeholder="您的電子郵件地址" required>
<!--2-->        密碼:<input type="password" id="password" class="password1" name="password" placeholder="您的密碼" required>
<!--3-->        <input type="button" value="登入" class="btn" id="submit" onclick="myFormCheck()"/>
<!--4-->        <div id="rmbr">
<!--4.1-->          <input type="checkbox" id="remberme" name="remberme" required>
<!--4.2-->          <label for="remberme" id="remberme0">記住我</label>
                </div>
                <div id="sign">
                  <lable>
                    <a href="javascript:;" id="register">
                      <img src="${pageContext.request.contextPath}/img/register.png" class="small-image">
                      會員註冊
                    </a>
                  </lable>

                  <label name="member_btn">
                    <a href="javascript:;" id="member_btn">
                      <img src="${pageContext.request.contextPath}/img/forgot.png" class="small-image">
                      忘記密碼
                    </a>
                  </label> 
                </div>
                <p class="member_btn"></p>
                <div class="img_btn">
                    <div class="c_btn facebook-btn fb">
                        <a href="javascript:;" ><img src="${pageContext.request.contextPath}/img/facebook.png" alt=""></a>
                    </div>
                </div>
            <!--</div>-->
        </fieldset>
     </div><!--two-thirds-->
    </form>
    <script>
      'use strict';

      //會員登入------------------
      var attempt = 3; // 可變數來計算嘗試次數。
      function myFormCheck(){// 以下功能單擊登錄按鈕執行。
          var username = document.getElementById("username").value;
          var password = document.getElementById("password").value;
          if ( username === "Formget" && password === "formget#123"){
              alert ("Login successfully");
              window.location = "javascript:;"; // 重定向到其他頁面。
              return false;
          }
          else{
              attempt --;// 減少一個。
              alert("You have left "+attempt+" attempt;");
      // 3次嘗試後禁用字段。
              if( attempt === 0){
                  document.getElementById("username").disabled = true;
                  document.getElementById("password").disabled = true;
                  document.getElementById("submit").disabled = true;
                  return false;
              }
          }
      }
      //第種寫法// 記住我 passport remember-me  (NodeJS Express Passport Remember me)
      // app.use( function (req, res, next) {
      //     if ( req.method === 'POST' && req.url === '/login' ) {
      //         if ( req.body.rememberme ) {
      //             req.session.cookie.maxAge = 2592000000; // 30*24*60*60*1000 Rememeber 'me' for 30 days
      //         } else {
      //             req.session.cookie.expires = false;
      //         }
      //     }
      //     next();
      // });
      //第二種寫法 // 記住我 passport remember-me:php
      if (JSON && JSON.stringify && JSON.parse) var Session = Session || (function() {

              // window object
              var win = window.top || window;

              // session store
              var store = (win.name ? JSON.parse(win.name) : {});

              // save store on page unload
              function Save() {
                  win.name = JSON.stringify(store);
              }

              // page unload event
              if (window.addEventListener) window.addEventListener("unload", Save, false);
              else if (window.attachEvent) window.attachEvent("onunload", Save);
              else window.onunload = Save;

              // public methods
              return {

                  // set a session variable
                  set: function(name, value) {
                      store[name] = value;
                  },

                  // get a session value
                  get: function(name) {
                      return (store[name] ? store[name] : undefined);
                  },

                  // clear session
                  clear: function() { store = {}; },

                  // dump session data
                  dump: function() { return JSON.stringify(store); }

              };

          })();

      // store a session value/object
      Session.set(name, object);

      // retreive a session value/object
      Session.get(name);

      // clear all session data
      Session.clear();

      // dump session data
      Session.dump();
    </script>
</body>
</html>