<%@ page import="com.alex.service.api.UserService" %>
<%@ page import="com.alex.service.impl.UserServiceImpl" %>
<%@ page import="com.alex.dto.UserDto" %>
<%@ page import="java.util.List" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: Алексей
  Date: 04.08.2016
  Time: 19:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All users</title>
</head>
<body>
<a href="index.html">Main page</a>
<h3>ALL USERS</h3>
<%
    UserService userService = UserServiceImpl.getInstance();
    List<UserDto> listUsers = userService.getAllUsers();

%>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Login</th>
        <th>Age</th>
    </tr>
    <%
        for (UserDto userDto : listUsers) {
    %>
    <tr>
        <td>
            <%=userDto.getId()%>
        </td>
        <td>
            <%=userDto.getName()%>
        </td>
        <td>
            <%=userDto.getLogin()%>
        </td>
        <td>
            <%=userDto.getAge()%>
        </td>
    </tr>
    <%
        }
    %>
</table>

</body>
</html>
