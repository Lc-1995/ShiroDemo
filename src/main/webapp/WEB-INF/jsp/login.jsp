<%--
  Created by IntelliJ IDEA.
  User: BENQ
  Date: 2018/7/23
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getContextPath();
    if (!"/".equals(basePath)) {
        basePath += "/";
    }
%>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <form action="<%=basePath%>login" method="post">
        username: <input type="text" name="username"><br>
        password: <input type="password" name="password"><br>
        <input type="submit" value="Login">
    </form>
</body>
</html>
