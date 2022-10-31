package com.itbuzzpress.servlet.async;

import jakarta.annotation.Resource;
import jakarta.enterprise.concurrent.ManagedExecutorService;
import jakarta.servlet.AsyncContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "async", urlPatterns = { "/async" }, asyncSupported = true)
public class AsyncServlet extends HttpServlet {
	 
	@Resource(name = "DefaultManagedExecutorService")
	ManagedExecutorService executor;

	public AsyncServlet() {
		super();

	}
	
	protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        long startTime = System.currentTimeMillis();
        System.out.println("AsyncServlet Start, Thread Name="
                + Thread.currentThread().getName());
 
 
        AsyncContext ac = request.startAsync();
        ac.addListener(new ExampleAsyncListener());
        ac.setTimeout(5000);
 
        System.out.println("Async Supported? " + ac.getRequest().isAsyncSupported());
        
        executor.execute(new AsyncService(ac));
        long endTime = System.currentTimeMillis();
        System.out.println("AsyncLongRunningServlet End, Thread Name="
                + Thread.currentThread().getName() + ",Time Taken="
                + (endTime - startTime) + " ms.");
    }
 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
