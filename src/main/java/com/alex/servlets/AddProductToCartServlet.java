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
 * Created by Алексей on 10.08.2016.
 */
public class AddProductToCartServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        Long userId = (Long)(session.getAttribute("user"));
        Long productId = Long.parseLong(request.getParameter("productid"));
        if (userId == null) {
            response.sendRedirect("login.html");
            return;
        }


        UserService userService = UserServiceImpl.getInstance();
        userService.addProductToCart(userId, productId);
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<h3> Product added successfully. </h3>");
        out.println("<meta http-equiv=\"refresh\" content=\"3;userinfo.jsp\">");
        out.println("</body>");
        out.println("</html>");


    }
}
