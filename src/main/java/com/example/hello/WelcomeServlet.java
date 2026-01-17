package com.example.hello;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;


public class WelcomeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Cookie[] allCookies = request.getCookies();
        String user = null;

        if (allCookies != null) {
            for (Cookie temp : allCookies) {
                if (temp.getName().equals("myAppUser")) {
                    user = temp.getValue();
                    break;
                }
            }
        }

        out.println("<html><body>");

        if (user != null) {
            out.println("<h2>Welcome, " + user + "!</h2>");
        } else {
            out.println("<h2>Welcome, Guest!</h2>");
        }

        out.println("</body></html>");
    }
}