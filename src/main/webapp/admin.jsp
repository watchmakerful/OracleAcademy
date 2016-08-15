<%@ page import="com.alex.service.api.ProductService" %>
<%@ page import="com.alex.service.impl.ProductServiceImpl" %>
<%@ page import="com.alex.dto.ProductDto" %>
<%@ page import="java.util.List" %>
<%@ page import="com.alex.service.api.UserService" %>
<%@ page import="com.alex.service.impl.UserServiceImpl" %>
<%@ page import="com.alex.dto.UserDto" %>
<%@ page import="com.alex.entity.Role" %><%--
  Created by IntelliJ IDEA.
  User: Алексей
  Date: 09.08.2016
  Time: 21:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Role role = Role.USER;
    role = (Role) session.getAttribute("role");
    if (role!=Role.ADMIN)
        response.sendRedirect("adminlogin.html");

%>





<html>
<head>
    <title>Admin page</title>
</head>
<body>
    <a href="index.jsp">Main page</a> <a href="userinfo.jsp">User profile</a>

    <h3>Admin page</h3>

    <h4>All products</h4>

    <%
        ProductService productService = ProductServiceImpl.getInstance();
        List<ProductDto> listProducts = productService.getAllProducts();

    %>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Description</th>
            <th>Price</th>
            <th>Count</th>

            <th>X</th>
        </tr>
        <%
            for (ProductDto productDto : listProducts) {
        %>
        <tr>
            <td>
                <a href="productinfo.jsp?id=<%=productDto.getId()%>"><%=productDto.getId()%></a>
            </td>

            <td>
                <%=productDto.getName()%>
            </td>

            <td>
                <%=productDto.getDescription()%>
            </td>
            <td>
                <%=productDto.getPrice()%>
            </td>
            <td>
                <%=productDto.getCount()%>
            </td>

            <td>
                <a href="deleteproduct?productid=<%=productDto.getId()%>">X</a>
            </td>

        </tr>
        <%
            }
        %>
    </table>
    <a href="newproduct.html">New product</a><br/>
<br/>
<h4>All users</h4>
    <%
        UserService userService = UserServiceImpl.getInstance();
        List<UserDto> listUsers = userService.getAllUsers();

    %>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Second name</th>
            <th>Login</th>
            <th>Age</th>
            <th>Email</th>
            <th>Address</th>
            <th>X</th>
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
                <%=userDto.getSecondName()%>
            </td>
            <td>
                <%=userDto.getLogin()%>
            </td>
            <td>
                <%=userDto.getAge()%>
            </td>
            <td>
                <%=userDto.getEmail()%>
            </td>
            <td>
                <%=userDto.getAddress()%>
            </td>


            <td>
                <a href="deleteuser?id=<%=userDto.getId()%>">X</a>
            </td>
        </tr>
        <%
            }
        %>
    </table>
    <a href="registration.html">New user</a> <br/>


</body>
</html>
