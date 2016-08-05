<%--
  Created by IntelliJ IDEA.
  User: Алексей
  Date: 05.08.2016
  Time: 14:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main page</title>
</head>
<body>
<h3>Main page</h3>
<%
    String sessionUser = (String) request.getSession().getAttribute("user");
    if (!(sessionUser == null )){
%>
    Hello, <%=sessionUser%>! <a href="logout">(logout)</a>
<%}
    else
{
%>
<a href="/login.html">Login</a>
<% }; %>
<br>
<a href="/registration.html">Register new user</a> <br>
<a href="/users.jsp">All users</a>
</body>
</html>
