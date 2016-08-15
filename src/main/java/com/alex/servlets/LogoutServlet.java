package com.alex.servlets;

import com.alex.entity.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Алексей on 05.08.2016.
 */
public class LogoutServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        session.removeAttribute("username");
        List<Product> cart = new LinkedList<>();
        session.setAttribute("cart",cart);
        session.removeAttribute("role");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<body>");
        out.println("You have been successfully logged out.");
        out.println("<a href=index.jsp>Main page</a>");
        out.println("<meta http-equiv=\"refresh\" content=\"3;index.jsp\">");
        out.println("</body>");
        out.println("</html>");
    }






}
