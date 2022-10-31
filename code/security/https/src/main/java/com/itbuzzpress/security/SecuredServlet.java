 
package com.itbuzzpress.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

 
@SuppressWarnings("serial")
@WebServlet("/https")
public class SecuredServlet extends HttpServlet {

 

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();


        writer.println("<html><head><title>servlet-security</title></head><body>");
        writer.println("<h1>" + "Called Servlet </h1>");
        writer.println("<p>" + "isSecure  : " + req.isSecure() + "</p>");
        writer.println("</body></html>");
        writer.close();
    }

}
