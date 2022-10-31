package com.itbuzzpress.servlet.async;

import jakarta.servlet.AsyncContext;

import java.io.IOException;
import java.io.PrintWriter;

public class AsyncService implements Runnable {
	AsyncContext ac;

	public AsyncService(AsyncContext ac) {
		this.ac = ac;
	}

	@Override
	public void run() {

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			PrintWriter out = ac.getResponse().getWriter();
			out.write("AsyncService completed processing!");
		} catch (IOException e) {
			e.printStackTrace();
		}
		//complete the processing
		ac.complete();
	}


}
