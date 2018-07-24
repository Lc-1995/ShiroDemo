<%--
  Created by IntelliJ IDEA.
  User: BENQ
  Date: 2018/7/23
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%
    String basePath = request.getContextPath();
    if (!"/".equals(basePath)) {
        basePath += "/";
    }
%>
<html>
<head>
    <title>Home</title>
</head>
<body>
    <h1>Login Success!</h1><br>
    <%--property:shiro认证中存放的用户的属性--%>
    <h2>Welcome: <shiro:principal property="name"></shiro:principal></h2>
    <a href="<%=basePath%>user/getList">Look userList</a><br>
    <a href="<%=basePath%>logout">Logout</a>
</body>
</html>
