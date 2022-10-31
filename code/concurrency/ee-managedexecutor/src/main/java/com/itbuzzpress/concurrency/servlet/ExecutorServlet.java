package com.itbuzzpress.concurrency.servlet;

import com.itbuzzpress.concurrency.job.SimpleTask;
import jakarta.annotation.Resource;
import jakarta.enterprise.concurrent.ManagedExecutorService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
 
/**
 * Servlet implementation class Test
 */
@WebServlet("/ExecutorServlet")
public class ExecutorServlet extends HttpServlet {
 
    @Resource(name = "DefaultManagedExecutorService")
    ManagedExecutorService executor;
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		
		executor.execute(new SimpleTask());	 
		
		writer.write("Task SimpleTask executed! check logs");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
