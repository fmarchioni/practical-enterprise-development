package com.itbuzzpress.concurrency.ejb;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import jakarta.ejb.Singleton;
import jakarta.enterprise.concurrent.ContextService;
import jakarta.enterprise.concurrent.ManagedThreadFactory;

import java.util.concurrent.*;

 

@Singleton
public class ContextExecutorEJB {

	private ExecutorService threadPoolExecutor = null;

	@Resource(name = "DefaultManagedThreadFactory")
	ManagedThreadFactory factory;

	@Resource(name = "DefaultContextService")
	ContextService cs;

	public ExecutorService getThreadPoolExecutor() {
		return threadPoolExecutor;
	}

	@PostConstruct
	public void postConstruct() {
		threadPoolExecutor = new ThreadPoolExecutor(5, 10, 5, TimeUnit.SECONDS,
				new ArrayBlockingQueue<Runnable>(10), factory);
	}
	
	public Future<Long> submitJob(Callable<Integer> task) {
		Callable<Long> proxy = cs.createContextualProxy(task, Callable.class);
		return getThreadPoolExecutor().submit(proxy);

	}
}
