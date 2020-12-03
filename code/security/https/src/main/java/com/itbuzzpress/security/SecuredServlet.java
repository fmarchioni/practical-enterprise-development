 
package com.itbuzzpress.security;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;

import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 
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
