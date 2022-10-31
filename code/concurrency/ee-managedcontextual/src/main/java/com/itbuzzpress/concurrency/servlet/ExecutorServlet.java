package com.itbuzzpress.concurrency.servlet;

import com.itbuzzpress.concurrency.ejb.ContextExecutorEJB;
import com.itbuzzpress.concurrency.job.CallableTask;
import jakarta.annotation.security.RunAs;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
 
 
/**
 * Servlet implementation class Test
 */
@WebServlet("/ExecutorServlet")
@RunAs("user")
public class ExecutorServlet extends HttpServlet {
 
  
    @EJB ContextExecutorEJB ejb;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter writer = response.getWriter();
		CallableTask task = new CallableTask(5);
		Future<Long> result = ejb.submitJob(task);

		try {
			writer.write("Callable Task returned random number: "+result.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
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
