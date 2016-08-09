<%@ page import="com.alex.service.api.ProductService" %>
<%@ page import="com.alex.service.impl.ProductServiceImpl" %>
<%@ page import="com.alex.dto.ProductDto" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Алексей
  Date: 09.08.2016
  Time: 21:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All products</title>
</head>
<body>
    <h3>All products</h3>

    <%
        ProductService productService = ProductServiceImpl.getInstance();
        List<ProductDto> listProducts = productService.getAllProducts();

    %>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Price</th>
            <th>Count</th>
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
                <%=productDto.getPrice()%>
            </td>
            <td>
                <%=productDto.getCount()%>
            </td>

        </tr>
        <%
            }
        %>
    </table>


</body>
</html>
