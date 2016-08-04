package com.alex.servlets;

import com.alex.dto.UserDto;
import com.alex.entity.Role;
import com.alex.service.api.UserService;
import com.alex.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Алексей on 04.08.2016.
 */
public class RegistrationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = UserServiceImpl.getInstance();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<body>");
        out.println("<h3>" + username + "</h3>");

        if ((username.equals("")) || (password.equals(""))) {
            out.println("Empty username or password, <a href=\"registration.html\"> try again! </a>");
        }
        else

        if (!userService.checkUserExists(username)) {

            UserDto userDto = new UserDto();
            userDto.setName(name);
            userDto.setLogin(username);
            userDto.setPassword(password);
            userDto.setAge(age);
            userDto.setRole(Role.USER);
            userService.createUser(userDto);



            out.println("New user registered.");

        }
        else {
            out.println("This user already exists, register another login!");
        }

        out.println("</body>");
        out.println("</html>");
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/registration.html");

    }
}
