package com.itbuzzpress.concurrency.servlet;

import com.itbuzzpress.concurrency.job.SimpleTask;
import jakarta.annotation.Resource;
import jakarta.enterprise.concurrent.ManagedThreadFactory;
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
@WebServlet("/FactoryExecutorServlet")
public class FactoryExecutorServlet extends HttpServlet {
 
	@Resource(name ="DefaultManagedThreadFactory")
	ManagedThreadFactory factory;

 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		
		Thread thread = factory.newThread(new SimpleTask());
		thread.setName("My Managed Thread");
		thread.setPriority(Thread.MAX_PRIORITY);
		thread.start();

		writer.write("Thread started. Check logs");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
