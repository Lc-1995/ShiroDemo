<%--
  Created by IntelliJ IDEA.
  User: BENQ
  Date: 2018/7/23
  Time: 23:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>UserInfo</title>
</head>
<body>
<table align="center" valign="center" border="1px">
    <thead>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>age</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.age}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
