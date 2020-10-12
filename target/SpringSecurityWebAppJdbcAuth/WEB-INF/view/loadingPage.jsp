<%--
  Created by IntelliJ IDEA.
  User: sorin
  Date: 18.09.2020
  Time: 23:07
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h2>Hello world, all java config just works!!</h2>
<h2>Beer and pizza for me <3</h2>
<p>Also, do some push ups</p>
<p>La cat e meciul ?</p>
<p>Cat e scorul  ?</p>

<br><hr>
<button>
    <a href="${pageContext.request.contextPath}/homePage">Access Secure Site (requires login)</a>
</button>
</body>
</html>
