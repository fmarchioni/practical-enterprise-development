package com.itbuzzpress.batch.servlet;

import com.itbuzzpress.batch.ejb.EJBSingleton;
import jakarta.batch.operations.JobOperator;
import jakarta.batch.operations.JobSecurityException;
import jakarta.batch.operations.JobStartException;
import jakarta.batch.runtime.BatchRuntime;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = { "/TestChunk" })
public class TestChunk extends HttpServlet {
	@Inject EJBSingleton ejb;

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			JobOperator jo = BatchRuntime.getJobOperator();

			long id = jo.start("simplejob", null);
            
			// Setting the checkpoint to 3 for this job
			ejb.setCounter(id, 3);
            
			out.println("Job submitted: " + id);

		} catch (JobStartException | JobSecurityException ex) {
			out.println("Error submitting Job! " + ex.getMessage());
			ex.printStackTrace();
		}
		out.flush();

	}
 

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}


	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
