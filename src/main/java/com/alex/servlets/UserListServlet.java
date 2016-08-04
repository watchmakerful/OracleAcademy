package com.alex.servlets;

import com.alex.dto.UserDto;
import com.alex.service.api.UserService;
import com.alex.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Алексей on 04.08.2016.
 */
public class UserListServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = UserServiceImpl.getInstance();

        List<UserDto> listUsers = userService.getAllUsers();
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<title>Users</title>");
        out.println("<body>");
        out.println("<h3>" + "USERS" + "</h3>");
        out.println("<table border=\"1\">");
        out.println("<tr><th>ID</th><th>Name</th><th>Login</th><th>Age</th></tr>");
        for (UserDto userDto:listUsers) {
            out.print("<tr>");
            out.print("<td>");
            out.print(userDto.getId());
            out.print("</td><td>");
            out.print(userDto.getName());
            out.print("</td><td>");
            out.print(userDto.getLogin());
            out.print("</td><td>");
            out.print(userDto.getAge());
            out.println("</td></tr>");
        }
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");

    }

}
