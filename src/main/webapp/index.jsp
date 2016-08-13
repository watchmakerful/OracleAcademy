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
    Long sessionUser = (Long) request.getSession().getAttribute("user");
    if (!(sessionUser == null )){
%>
    Hello, <%=sessionUser%>! <a href="logout">(logout)</a>
<%}
    else
{
%>
<a href="/login.html">Login</a>
<% }; %>
<br/>
<a href="/registration.html">Register new user</a> <br/>
<a href="/users.jsp">All users</a><br/>
<a href="newproduct.html">New product</a><br/>
<a href="products.jsp">All products</a>
</body>
</html>
