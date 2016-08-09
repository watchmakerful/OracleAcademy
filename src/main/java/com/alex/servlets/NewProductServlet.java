package com.alex.servlets;

import com.alex.dto.ProductDto;
import com.alex.service.api.ProductService;
import com.alex.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Алексей on 09.08.2016.
 */
public class NewProductServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/newproduct.html");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductService productService = ProductServiceImpl.getInstance();
        String productName = request.getParameter("product");
        String description = request.getParameter("description");
        String made = request.getParameter("made");
        int count = Integer.parseInt(request.getParameter("count"));
        double price = Double.parseDouble(request.getParameter("price"));
        ProductDto productDto = new ProductDto();
        productDto.setName(productName);
        productDto.setDescription(description);
        productDto.setCount(count);
        productDto.setPrice(price);
        productDto.setMade(made);
        productService.createProduct(productDto);

        response.sendRedirect("/index.jsp");





    }
}
