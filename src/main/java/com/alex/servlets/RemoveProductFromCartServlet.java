package com.alex.servlets;

import com.alex.service.api.UserService;
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
public class RemoveProductFromCartServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        long userId = (Long)(session.getAttribute("user"));
        long productId = Long.parseLong(request.getParameter("productid"));
        UserService userService = UserServiceImpl.getInstance();
        userService.removeProductFromCart(userId,productId);
        response.sendRedirect("userinfo.jsp");


    }
}
