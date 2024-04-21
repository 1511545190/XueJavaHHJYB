<%--
  Created by IntelliJ IDEA.
  User: LyonWin
  Date: 3/27/2024
  Time: 8:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>登录界面</title>
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .login-container {
            position: absolute;
            right: 0;
            width: 40%; /* 可根据需要调整宽度 */
            padding: 2rem;
            background-color: #f8f9fa;
            border-radius: 0.5rem;
        }

        @media (max-width: 767.98px) {
            .login-container {
                width: 100%;
                position: relative;
                right: auto;
                margin: 0 auto;
            }
        }
    </style>
    <style>
        video {
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            object-fit: cover;
            z-index: -1;
        }
    </style>
    <script>
        <%--        如果GET请求状态为1,弹出用户已存在--%>
        if (window.location.search === "?status=1") {
            alert("用户不存在");
        }
        <%--        如果GET请求状态为2,弹出邮箱已存在--%>
        if (window.location.search === "?status=2") {
            alert("密码错误");
        }
    </script>
</head>
<body>
<%@include file="header.jsp" %>

<video autoplay loop muted playsinline>
    <source src="mp4/background.mp4" type="video/mp4">
</video>
<!-- 其他页面内容 -->

<div class="container  mt-5">


    <div class="container h-100 d-flex align-items-center justify-content-center">
        <div class="login-container">
            <h2 class="text-center mb-4">登录</h2>

            <form class="form-group" id="loginForm" method="post" action="/HandleLogin">
                <label for="loginUsername" class="col-form-label font-weight-bold">账号:</label>
                <input type="text" id="loginUsername" name="username" class="form-control mb-2" required>

                <label for="loginPassword" class="col-form-label font-weight-bold">密码:</label>
                <input type="password" id="loginPassword" name="password" class="form-control mb-2" required>

                <div class="d-grid gap-2">
                    <button type="submit" class="btn btn-primary btn-block font-weight-bold">登录</button>
                </div>
            </form>
        </div>
    </div>


</div>
<%@include file="footer.jsp" %>
</body>
</html>
