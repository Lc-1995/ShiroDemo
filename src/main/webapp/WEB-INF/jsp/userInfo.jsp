<%--
  Created by IntelliJ IDEA.
  User: BENQ
  Date: 2018/7/23
  Time: 23:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<%
    String basePath = request.getContextPath();
    if (!"/".equals(basePath)) {
        basePath += "/";
    }
%>
<html>
<head>
    <title>UserInfo</title>
    <script type="text/javascript" src="js/jquery-3.3.1.js"></script>
</head>
<body>
<table align="center" valign="center" border="1px">
    <thead>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>age</th>
        <th>operate</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.age}</td>
            <td>
                <a href="<%=basePath%>user/delete?id=${user.id}">解雇</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
