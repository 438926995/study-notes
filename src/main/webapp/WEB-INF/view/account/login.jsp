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
    <form action="<%=basePath%>/login" method="post">
        <div style="color: red;">${loginError}</div>
        <label>username:</label>
        <input type="text" id="username" name="username" value="">
        <label>password:</label>
        <input type="password" id="password" name="password" value="">
        <input type="submit" value="登录">
    </form>
</body>

</html>
