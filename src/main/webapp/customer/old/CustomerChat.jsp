<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap-v431.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">

    <title>即時客服</title>

    <style>
        body {
            position: relative;
        }
        .fixed-chat-box {
            position: fixed;
            bottom: 220px;
            right: 0;
            height: 50vh;
            width: 500px;
            margin: 0;
        }

        ::-webkit-scrollbar {
            width: 8px;
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
            margin-top: 15px !important;
            margin-bottom: 0 !important;
        }

        .chat-box {
            height: 100%;
            /* height: 568px; */
            overflow-y: scroll;
        }

        .rounded-lg {
            border-radius: 0.5rem;
        }

        input::placeholder {
            font-size: 0.9rem;
            color: #999;
        }
    </style>
</head>

<body>
<div class="fixed-chat-box">
    <div class="container py-5 px-4">
        <div class="row rounded-lg">
            <!-- Chat Box-->
            <div class="col-12 px-3">
                <div class="px-4 py-3" style="background-color: #3498db; color: #fff;">
                    <h5 class="mb-0 text-center">即時客服</h5>
                </div>
                <div class="px-4 py-5 chat-box bg-white mt-0" style="height: 78vh; overflow-y: auto;">
                    <!-- Sender Message-->
                    <div class="media w-50 mb-3">
                        <img src="https://bootstrapious.com/i/snippets/sn-chat/avatar.svg"
                             alt="user" width="50" class="rounded-circle">
                        <div class="media-body ml-3">
                            <div class="bg-light rounded py-2 px-3 mb-2">
                                <p class="text-small mb-0 text-muted">Test which is a new approach all solutions</p>
                            </div>
                            <p class="small text-muted">12:00 PM | Aug 13</p>
                        </div>
                    </div>

                    <!-- Receiver Message-->
                    <div class="media w-50 ml-auto mb-3">
                        <div class="media-body">
                            <div class="bg-primary rounded py-2 px-3 mb-2">
                                <p class="text-small mb-0 text-white">Test which is a new approach to have all solutions
                                </p>
                            </div>
                            <p class="small text-muted">12:00 PM | Aug 13</p>
                        </div>
                    </div>
                    <!-- Sender Message-->
                    <div class="media w-50 mb-3">
                        <img src="https://bootstrapious.com/i/snippets/sn-chat/avatar.svg"
                             alt="user" width="50" class="rounded-circle">
                        <div class="media-body ml-3">
                            <div class="bg-light rounded py-2 px-3 mb-2">
                                <p class="text-small mb-0 text-muted">Test which is a new approach all solutions</p>
                            </div>
                            <p class="small text-muted">12:00 PM | Aug 13</p>
                        </div>
                    </div>

                    <!-- Receiver Message-->
                    <div class="media w-50 ml-auto mb-3">
                        <div class="media-body">
                            <div class="bg-primary rounded py-2 px-3 mb-2">
                                <p class="text-small mb-0 text-white">Test which is a new approach to have all solutions
                                </p>
                            </div>
                            <p class="small text-muted">12:00 PM | Aug 13</p>
                        </div>
                    </div>

                    <!-- Typing area -->
                    <form action="#" class="bg-light typing-area" style="margin-top: -15px;">
                        <div class="input-group">
                            <input type="text" placeholder="Type a message" aria-describedby="button-addon2"
                                   class="form-control rounded-2 border-1 bg-light py-3">
                            <div class="input-group-append">
                                <button id="button-addon2" type="submit" class="btn btn-link"> <i
                                        class="fa fa-paper-plane"></i></button>
                            </div>
                        </div>
                    </form>

                </div>
            </div>
        </div>
    </div>
</div>

    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.slim.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap-v431.bundle.min.js"></script>
</body>

</html>
