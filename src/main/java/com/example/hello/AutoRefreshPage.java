//AutoRefresh Code

package com.example.hello;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;

@WebServlet("/HelloResource")
public class AutoRefreshPage extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Auto refresh every 5 seconds
        response.setIntHeader("Refresh", 1);
        response.setContentType("text/html");

        Calendar calendar = Calendar.getInstance();
        Date currentTime = calendar.getTime();

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>Auto Refresh Demo</title></head>");
        out.println("<body>");
        out.println("<h2 align='center'>Auto Refresh Page Example</h2>");
        out.println("<h3 align='center'>Current Time: " + currentTime + "</h3>");
        out.println("<p align='center'>This page will refresh every 1 seconds.</p>");
        out.println("</body>");
        out.println("</html>");
    }
}
