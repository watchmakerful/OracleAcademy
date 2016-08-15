<%@ page import="com.alex.service.api.ProductService" %>
<%@ page import="com.alex.service.impl.ProductServiceImpl" %>
<%@ page import="com.alex.dto.ProductDto" %><%--
  Created by IntelliJ IDEA.
  User: Алексей
  Date: 09.08.2016
  Time: 21:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product info</title>
</head>
<body>
<a href="index.jsp">Main page</a> <a href="admin.jsp">All products</a> <br/>
<%
    long id = Long.parseLong(request.getParameter("id"));
    ProductService productService = ProductServiceImpl.getInstance();
    ProductDto productDto = productService.getProductById(id);
%>
Product <%=id%>: <%=productDto.getName()%> <br/>
Description: <%=productDto.getDescription()%> <br/>
Made in <%=productDto.getMade()%> <br/>
Price: <%=productDto.getPrice()%> <br/>
Available: <%=productDto.getCount()%> pcs. <br/>





</body>
</html>
