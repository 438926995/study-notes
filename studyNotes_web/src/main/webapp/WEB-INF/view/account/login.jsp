<%--
  Created by IntelliJ IDEA.
  User: huwenwen
  Date: 16/8/19
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String basePath = request.getContextPath();
%>
<html>
<head>
    <title>登录</title>
    <link rel="stylesheet" href="<%=basePath%>/stylelib/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="<%=basePath%>/stylelib/bootstrap/css/bootstrap-responsive.css">
    <style type="text/css">
        body {
            padding-top: 40px;
            padding-bottom: 40px;
            background-color: #f5f5f5;
        }

        .form-signin {
            max-width: 300px;
            padding: 19px 29px 29px;
            margin: 60px auto 20px;
            background-color: #fff;
            border: 1px solid #e5e5e5;
            -webkit-border-radius: 5px;
            -moz-border-radius: 5px;
            border-radius: 5px;
            -webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
            -moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
            box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
        }

        .form-signin .form-signin-heading,
        .form-signin .checkbox {
            margin-bottom: 10px;
        }

        .form-signin input[type="text"],
        .form-signin input[type="password"] {
            font-size: 16px;
            height: auto;
            margin-bottom: 15px;
            padding: 7px 9px;
        }

        img{
            vertical-align: text-bottom;
        }
    </style>
</head>
<body>
<div class="container">
    <form class="form-signin" action="<%=basePath%>/login" method="post">
        <c:if test="${not empty loginError}">
            <div class="alert alert-error">
                <button type="button" class="close" data-dismiss="alert">&times;</button>
                ${loginError}
            </div>
        </c:if>
        <h2 class="form-signin-heading">Please sign in</h2>
        <input type="text" name="username" value="${userName}" class="input-block-level" placeholder="Your username" required>
        <input type="password" name="password" class="input-block-level" placeholder="Password" required>

        <div>
            <input type="text" class="form-control" style="display:inline-block;width:60%" name="code" placeholder="验证码" required>&emsp;&emsp;
            <img src="<%=basePath%>/account/captcha" onclick="this.src='<%=basePath%>/account/captcha?t='+new Date()*1" height="30" width="70" />
        </div>

        <label class="checkbox">
            <input type="checkbox" value="remember-me"> Remember me
        </label>
        <button class="btn btn-large btn-primary" type="submit">Sign in</button>
    </form>
</div> <!-- /container -->
<script src="<%=basePath%>/jslib/jquery.js"></script>
<script src="<%=basePath%>/jslib/bootstrap.js"></script>
</body>
</html>
