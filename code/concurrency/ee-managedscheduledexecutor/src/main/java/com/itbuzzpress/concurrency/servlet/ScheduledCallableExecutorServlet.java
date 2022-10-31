package com.itbuzzpress.concurrency.servlet;

import com.itbuzzpress.concurrency.job.CallableTask;
import jakarta.annotation.Resource;
import jakarta.enterprise.concurrent.ManagedScheduledExecutorService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

 
 
 
 
/**
 * Servlet implementation class Test
 */
@WebServlet("/ScheduledCallableExecutorServlet")
public class ScheduledCallableExecutorServlet extends HttpServlet {
 
	@Resource(name ="DefaultManagedScheduledExecutorService")
	ManagedScheduledExecutorService scheduledExecutor;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
			
		ScheduledFuture<Long> futureResult =
				scheduledExecutor.schedule(new CallableTask(5), 5, TimeUnit.SECONDS);
		 		
		while (!futureResult.isDone()) {
			// Wait
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {			
				e.printStackTrace();
			}
		}
		
		try {
			writer.write("Callable Task returned " +futureResult.get());
			 
		} catch ( Exception e) {
			e.printStackTrace();
		}  
		 
	}

	 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
