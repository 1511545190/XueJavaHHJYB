<%--
  Created by IntelliJ IDEA.
  User: LyonWin
  Date: 4/18/2024
  Time: 9:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户已存在</title>
<%--    //跳转到注册失败页面,GET请求格式发送状态 1为用户已存在, 2为邮箱已存在
            response.sendRedirect("Fail-UserRegister.jsp?status=2");--%>
    <script>
<%--        如果GET请求状态为1,弹出用户已存在--%>
        if (window.location.search === "?status=1") {
            alert("用户已存在");
            //跳转到注册页面
            window.location.href = "index.jsp";
        }
<%--        如果GET请求状态为2,弹出邮箱已存在--%>
        if (window.location.search === "?status=2") {
            alert("邮箱已存在");
            //跳转到注册页面
            window.location.href = "index.jsp";
        }
    </script>
</head>
<body>

</body>
</html>
