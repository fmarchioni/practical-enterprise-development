package com.itbuzzpress.concurrency.servlet;

import com.itbuzzpress.concurrency.job.SimpleTask;
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
@WebServlet("/ScheduledExecutor")
public class ScheduledExecutor extends HttpServlet {
 
    @Resource(name ="DefaultManagedScheduledExecutorService")
    ManagedScheduledExecutorService scheduledExecutor;

    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		
		ScheduledFuture<?> futureResult = scheduledExecutor.schedule(new SimpleTask(),
				10,TimeUnit.SECONDS);

		
		writer.write("Waiting 10 seconds before firing the task");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
