<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <title>JSP - Hello World</title>
    <script>
        function ceritfcation() {
            var username = $("#username").val();
            var password = $("#password").val();
            var confirmPassword = $("#confirmPassword").val();
            var name = $("#name").val();
            var age = $("#age").val();
            var email = $("#email").val();
            if (username === "" || password === "" || confirmPassword === "" || name === "" || age === "" || email === "") {
                alert("请填写完整信息");
                return false;
            }
            if (password !== confirmPassword) {
                alert("两次密码不一致");
                return false;
            }
            return true;
        }
    </script>
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
</head>
<body>
<%@include file="header.jsp" %>
<video autoplay loop muted playsinline>
    <source src="mp4/background.mp4" type="video/mp4">
</video>
<%--//距离顶部有一段距离--%>
<div class="container mt-5">
    <div id="myID" style="visibility: hidden">myID</div>
    <%--jQuery--%>
    <%--<script>--%>
    <%--    alert($("#myID"));--%>
    <%--</script>--%>

    <form class="form-group" id="registrationForm" method="post" style="background-color: #f8f9fa; padding: 20px; border-radius: 10px;"
          action="/HandleUserRegister">
        <label for="username"  class="col-md-6 mb-3 font-weight-bold">账号:</label>
        <input type="text" id="username" name="username" class="form-control">
        <label for="password" class="col-md-6 mb-3 font-weight-bold">密码:</label>
        <input type="password" id="password" name="password" class="form-control" >
        <label class="col-md-6 mb-3 font-weight-bold" for="confirmPassword">确认密码:</label>
        <input type="password" id="confirmPassword" name="confirmPassword" class="form-control">
        <label class="col-md-6 mb-3 font-weight-bold" for="name">昵称:</label>
        <input type="text" id="name" name="name" class="form-control">
        <label class="col-md-6 mb-3 font-weight-bold" for="age">年龄:</label>
        <input type="number" id="age" name="age" min="0" max="150" class="form-control">
        <label class="col-md-6 mb-3 font-weight-bold" for="email">电子邮箱:</label>
        <input type="email" id="email" name="email" class="form-control">
        <input type="submit" value="注册"  class="btn btn-success font-weight-bold"  onclick="return ceritfcation()">
    </form>


</div>
<%@include file="footer.jsp" %>
</body>


</html>