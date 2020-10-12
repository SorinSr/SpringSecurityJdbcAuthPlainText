<%--
  Created by IntelliJ IDEA.
  User: sorin
  Date: 06.10.2020
  Time: 01:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Access denied</title>
</head>
<body>
<h4>Oh, snap!!</h4>
<br>
<h3>Your role don't match with the role required for this page</h3>

<br><hr>
<button><a href="${pageContext.request.contextPath}/homePage">Back to home page</a></button>
</body>
</html>
