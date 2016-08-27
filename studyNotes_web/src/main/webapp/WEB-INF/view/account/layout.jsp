<%--
  Created by IntelliJ IDEA.
  User: huwenwen
  Date: 16/8/27
  Time: 19:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getContextPath();
%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="<%=basePath%>/stylelib/metisMenu.css">
    <link rel="stylesheet" href="<%=basePath%>/stylelib/demo.css">
    <link rel="stylesheet" href="<%=basePath%>/stylelib/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=basePath%>/stylelib/bootstrap/css/bootstrap-responsive.min.css">
    <%--<link rel="stylesheet" href="<%=basePath%>/stylelib/adminlte/css/AdminLTE.min.css">--%>
</head>
<body>
<div class="clearfix">
    <aside class="sidebar">
        <nav class="sidebar-nav">
            <ul class="metismenu" id="menu">
                <li class="active">
                    <a href="#" aria-expanded="true">
                        <span class="sidebar-nav-item-icon fa fa-github fa-lg"></span>
                        <span class="sidebar-nav-item">metisMenu</span>
                        <span class="fa arrow fa-fw"></span>
                    </a>
                    <ul aria-expanded="true">
                        <li>
                            <a href="https://github.com/onokumus/metisMenu">
                                <span class="sidebar-nav-item-icon fa fa-code-fork fa-fw"></span>
                                Fork
                            </a>
                        </li>
                        <li>
                            <a href="https://github.com/onokumus/metisMenu">
                                <span class="sidebar-nav-item-icon fa fa-star fa-fw"></span>
                                Star
                            </a>
                        </li>
                        <li>
                            <a href="https://github.com/onokumus/metisMenu/issues">
                                <span class="sidebar-nav-item-icon fa fa-exclamation-triangle fa-fw"></span>
                                Issues
                            </a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#" aria-expanded="false">Menu 0 <span
                            class="fa arrow fa-fw"></span></a>
                    <ul aria-expanded="false">
                        <li><a href="#">item 0.1</a></li>
                        <li><a href="#">item 0.2</a></li>
                        <li><a href="http://onokumus.com">onokumus</a></li>
                        <li><a href="#">item 0.4</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#" aria-expanded="false">Menu 1 <span
                            class="glyphicon arrow"></span></a>
                    <ul aria-expanded="false">
                        <li><a href="#">item 1.1</a></li>
                        <li><a href="#">item 1.2</a></li>
                        <li>
                            <a href="#" aria-expanded="false">Menu 1.3 <span
                                    class="fa plus-times"></span></a>
                            <ul aria-expanded="false">
                                <li><a href="#">item 1.3.1</a></li>
                                <li><a href="#">item 1.3.2</a></li>
                                <li><a href="#">item 1.3.3</a></li>
                                <li><a href="#">item 1.3.4</a></li>
                            </ul>
                        </li>
                        <li><a href="#">item 1.4</a></li>
                        <li>
                            <a href="#" aria-expanded="false">Menu 1.5 <span
                                    class="fa plus-minus"></span></a>
                            <ul aria-expanded="false">
                                <li><a href="#">item 1.5.1</a></li>
                                <li><a href="#">item 1.5.2</a></li>
                                <li><a href="#">item 1.5.3</a></li>
                                <li><a href="#">item 1.5.4</a></li>
                            </ul>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#" aria-expanded="false">Menu 2 <span
                            class="glyphicon arrow"></span></a>
                    <ul aria-expanded="false">
                        <li><a href="#">item 2.1</a></li>
                        <li><a href="#">item 2.2</a></li>
                        <li><a href="#">item 2.3</a></li>
                        <li><a href="#">item 2.4</a></li>
                    </ul>
                </li>
            </ul>
        </nav>
    </aside>
</div>
<script src="<%=basePath%>/jslib/jquery.min.js"></script>
<script src="<%=basePath%>/jslib/bootstrap.min.js"></script>
<script src="<%=basePath%>/jslib/metisMenu.js"></script>
<script>
    $(function () {
        console.log('111');
        $('#menu').metisMenu();
    });
</script>
</body>
</html>
