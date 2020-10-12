<%--
  Created by IntelliJ IDEA.
  User: sorin
  Date: 22.09.2020
  Time: 23:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Custom Login Page</title>

    <style>
        .failed {
            color: red;
        }
    </style>
</head>
<body>

<h3>My Custom Login Page</h3>
<form:form action="${pageContext.request.contextPath}/authThisUser"
           method="POST">
    <!-- Check for login error -->
    <p>
        User name: <input type="text" name="username"/>
    </p>
    <p>
        Password: <input type="password" name="password"/>
    </p>
    <input type="submit" value="Login"/>
</form:form>

<c:if test="${param.error != null}">
    <h4 class="failed"> Please, try again.

    <script>
            alert("Sorry! You entered bad credentials.");
    </script>

    </h4>
</c:if>


</body>
</html>
