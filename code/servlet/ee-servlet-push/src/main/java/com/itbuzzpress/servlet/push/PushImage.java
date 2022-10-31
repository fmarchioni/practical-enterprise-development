package com.itbuzzpress.servlet.push;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.PushBuilder;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(value = {"/pushimage"})
public class PushImage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
 
        PushBuilder pushBuilder = req.newPushBuilder();
        if (pushBuilder != null) {
            pushBuilder
                    .path("images/duke.png")
                    .addHeader("content-type", "image/png")
                    .push();
        }
 
 
        try (PrintWriter respWriter = resp.getWriter();) {
            respWriter.write("<html>" +
                    "<img src='images/duke.png'>" +
                    "</html>");
        }

    }
}