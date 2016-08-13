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
 * Created by root on 21.07.2016.
 */
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = UserServiceImpl.getInstance();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");

        long userId = userService.checkUserExists(username, password);


        if (userId!=-1) {
            out.println("<h3>" + username + "</h3>");
            out.println("Login successful!");


            session.setAttribute("user", userId);
            session.setAttribute("username", username);

            out.println("<a href=index.jsp>Return to main page</a>");
            out.println("<meta http-equiv=\"refresh\" content=\"3;index.jsp\">");


        } else {
            if (userService.checkUserExists(username)!=-1) {
                out.println("Incorrect password, try again!");
            } else
                out.println("Unknown user!");
            session.removeAttribute("user");
            out.println("<a href=login>Try again</a>");
            out.println("<meta http-equiv=\"refresh\" content=\"3;login\">");
        }
        out.println("</body>");
        out.println("</html>");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/login.html");
    }

}
