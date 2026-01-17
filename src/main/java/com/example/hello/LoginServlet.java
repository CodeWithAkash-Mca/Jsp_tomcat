package com.example.hello;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


public class LoginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");

        Cookie ck = new Cookie("myAppUser", username);
        ck.setMaxAge(3600); // 1 hour
        response.addCookie(ck);

        response.sendRedirect("welcome");
    }
}
