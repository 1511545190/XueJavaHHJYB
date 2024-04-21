<%--
  Created by IntelliJ IDEA.
  User: LyonWin
  Date: 4/3/2024
  Time: 11:41 AM
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>
    <title>Successful Registration</title>
    <style>
        body {
            background-color: #f0f0f0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            font-family: Arial, sans-serif;
        }
        .success-message {
            text-align: center;
            max-width: 80%;
            animation: appear 1s ease-out forwards;
        }
        .success-message h1 {
            font-size: 2.5em;
            color: #4CAF50;
        }
        .success-message p {
            color: #333;
        }
        @keyframes appear {
            0% {transform: translateY(-30px); opacity: 0;}
            100% {transform: translateY(0); opacity: 1;}
        }
    </style>
</head>
<body>
<%@include file="header.jsp"%>
<div>
    <h1>Registration Successful!</h1>
    <p>Thank you for registering. We're glad to have you with us.</p>


</div>

</body>
</html>