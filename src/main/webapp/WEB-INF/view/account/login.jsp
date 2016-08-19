<%--
  Created by IntelliJ IDEA.
  User: huwenwen
  Date: 16/8/19
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getContextPath();
%>
<html>
<head>
    <title>登录</title>
</head>
<body>
    <form action="${basePath}/login" method="post">
        <label>username:</label>
        <input id="username" name="username">
        <label>password:</label>
        <input id="password" name="password">
        <button type="submit">登录</button>
    </form>
</body>
</html>
