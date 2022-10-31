package com.itbuzzpress.concurrency.servlet;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ExecutorService;

@WebServlet("/FactoryExecutorServiceServlet")
public class FactoryExecutorServiceServlet extends HttpServlet {
 
 
    @EJB PoolExecutorEJB ejb;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		final PrintWriter writer = response.getWriter();
		writer.write("Invoking ExecutorService. Check Logs.");
		ExecutorService executorService = ejb.getThreadPoolExecutor();
		executorService.execute(new Runnable() {
			public void run() {
				System.out.println("Message from your Executor!");
			}
		});
		
	}
}
