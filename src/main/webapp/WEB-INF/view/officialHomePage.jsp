<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: sorin
  Date: 24.09.2020
  Time: 22:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
<h3>Home Page</h3>
<br><hr>
Username: <security:authentication property="principal.username"/>
<br>
Role(s): <security:authentication property="principal.authorities"/>
<br><br><hr>

<security:authorize access="hasRole('MANAGER')">
<button><a href="${pageContext.request.contextPath}/leaders">LeaderShip Pages</a></button>
    (Leaders info)
</security:authorize>
<br>
<security:authorize access="hasRole('ADMIN')">
<button><a href="${pageContext.request.contextPath}/systems">Administrators Pages</a></button>
    (Admins info)
</security:authorize>
<br> 
<security:authorize access="hasRole('EMPLOYEE')">
    <button><a href="${pageContext.request.contextPath}/employees">Employees Pages</a></button>
    (Employees info)
</security:authorize>

<br><hr>

<form:form action="${pageContext.request.contextPath}/leaders" method="get">
    <input type="submit" value="LeaderShip Pages">
</form:form>
<form:form action="${pageContext.request.contextPath}/systems" method="get">
    <input type="submit" value="Administrators Pages">
</form:form>
<form:form action="${pageContext.request.contextPath}/employees" method="get">
    <input type="submit" value="Employees Pages">
</form:form>

<hr>

<form:form action="${pageContext.request.contextPath}/logout" method="post">
    <input type="submit" value="Log-out">
</form:form>
</body>
</html>
