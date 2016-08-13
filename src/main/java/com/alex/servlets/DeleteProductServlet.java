package com.alex.servlets;

import com.alex.service.api.ProductService;
import com.alex.service.api.UserService;
import com.alex.service.impl.ProductServiceImpl;
import com.alex.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Алексей on 13.08.2016.
 */
public class DeleteProductServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        Long userId = (Long)(session.getAttribute("user"));
        Long productId = Long.parseLong(request.getParameter("productid"));
        if (userId == null) {
            response.sendRedirect("login.html");
            return;
        }


        ProductService productService = ProductServiceImpl.getInstance();
        productService.deleteProduct(productId);
        response.sendRedirect("products.jsp");


    }
}
