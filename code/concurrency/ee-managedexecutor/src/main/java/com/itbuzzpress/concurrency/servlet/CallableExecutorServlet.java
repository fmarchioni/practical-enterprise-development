package com.itbuzzpress.concurrency.servlet;

import com.itbuzzpress.concurrency.job.CallableTask;
import jakarta.annotation.Resource;
import jakarta.enterprise.concurrent.ManagedExecutorService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.Future;
 
 
/**
 * Servlet implementation class Test
 */
@WebServlet("/CallableExecutorServlet")
public class CallableExecutorServlet extends HttpServlet {
 
    @Resource(name = "DefaultManagedExecutorService")
    ManagedExecutorService executor;
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		
		Future<Long> futureResult = executor.submit(new CallableTask(5));		 		
		while (!futureResult.isDone()) {
			// Wait
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			writer.write("Callable Task returned " +futureResult.get());
			 
		} catch ( Exception e) {
			// TODO Auto-generated catch block
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
