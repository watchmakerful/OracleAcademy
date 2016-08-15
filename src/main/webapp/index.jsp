<%@ page import="com.alex.service.api.UserService" %>
<%@ page import="com.alex.service.impl.UserServiceImpl" %>
<%@ page import="com.alex.holders.PropertyHolder" %>
<%@ page import="com.alex.entity.Role" %>
<%@ page import="com.alex.dto.ProductDto" %>
<%@ page import="com.alex.dto.UserDto" %>
<%@ page import="java.util.List" %>
<%@ page import="com.alex.utils.Transformer" %>
<%@ page import="com.alex.entity.Product" %>
<%@ page import="java.util.LinkedList" %>
<%@ page import="com.alex.service.api.ProductService" %>
<%@ page import="com.alex.service.impl.ProductServiceImpl" %><%--
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
    String username = "";
    Role role = Role.USER;
    Long sessionUser = (Long) request.getSession().getAttribute("user");
    List<ProductDto> cart = new LinkedList<>();
    if (!(sessionUser == null)) {
        username = (String) request.getSession().getAttribute("username");
        role = (Role) request.getSession().getAttribute("role");
        UserService userService = UserServiceImpl.getInstance();

        cart = Transformer.transformListProductToListProductDto((List<Product>) session.getAttribute("cart"));


%>
Hello, <a href="userinfo.jsp"><%=username%></a>! <%=role%> <a href="logout">(logout)</a>
<%
} else {
%>
<a href="login.html">Login</a>
<a href="registration.html">Register new user</a> <br/>
<% }
    ; %>
<br/>


<%
if (role == Role.ADMIN) {
%>
<a href="admin.jsp">Admin page</a> <br/>
<%
    }
%>


<%
    if (!(sessionUser == null)) {
%>


<h4>Cart:</h4>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Product</th>
        <th>Count</th>
        <th>Price</th>
        <th>Total</th>
        <th>X</th>
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
        <td>
            <%=productDto.getCount()%>
        </td>
        <td>
            <%=productDto.getPrice()%>
        </td>
        <td>
            <%=productDto.getCount()*productDto.getPrice()%>
        </td>

        <td>

            <a href="removeproduct?productid=<%=productDto.getId()%>">X</a>

        </td>
    </tr>
    <%
        }
    %>
</table>

<%
    }
%>

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
        <th>+</th>

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
            <a href="addproduct?productid=<%=productDto.getId()%>">Add</a>
        </td>


    </tr>
    <%
        }
    %>
</table>




</body>
</html>
