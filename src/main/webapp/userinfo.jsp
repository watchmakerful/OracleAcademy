<%@ page import="com.alex.dto.UserDto" %>
<%@ page import="com.alex.service.api.UserService" %>
<%@ page import="com.alex.service.impl.UserServiceImpl" %>
<%@ page import="com.alex.dto.ProductDto" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Алексей
  Date: 04.08.2016
  Time: 20:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User profile</title>
</head>
<body>
<a href="index.jsp">Main page</a>
<h3>User profile</h3>
<%
    long id = Long.parseLong(request.getParameter("id"));
    UserService userService = UserServiceImpl.getInstance();
    UserDto userDto = userService.getUserById(id);
    List<ProductDto> cart = userService.getCartById(id);
%>
User #<%=id%>: <%=userDto.getLogin()%> <br/>
Name: <%=userDto.getName()%> <br/>
Age: <%=userDto.getAge()%> <br/>

Cart: <br/>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Product</th>
    </tr>

    <%
        for (ProductDto productDto : cart) {
    %>
    <tr>
        <td>
            <%=productDto.getId()%>
        </td>
        <td>
            <%=productDto.getName()%>
        </td>
    </tr>
    <%
        }
    %>
</table>


</body>
</html>
