package com.alex.servlets;


import com.alex.service.api.UserService;
import com.alex.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by root on 21.07.2016.
 */
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = UserServiceImpl.getInstance();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<h3>" + username + "</h3>");
        out.println("<h3>" + password + "</h3>");
        if (userService.checkUserExists(username,password)) {
            out.println("Login successful!");
        }
        else
        if (userService.checkUserExists(username)) {
            out.println("Incorrect password, try again!");
        }
        else
            out.println("Unknown user!");

        out.println("</body>");
        out.println("</html>");



    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/login.html");
    }

}
