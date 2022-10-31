package com.itbuzzpress.concurrency.servlet;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.annotation.Resource;
import jakarta.ejb.Singleton;
import jakarta.enterprise.concurrent.ManagedThreadFactory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

 

@Singleton
public class PoolExecutorEJB {

	private ExecutorService threadPoolExecutor = null;
	int  corePoolSize  =    5;
	int  maxPoolSize   =   10;
	long keepAliveTime = 5000;
	@Resource(name = "DefaultManagedThreadFactory")
	ManagedThreadFactory factory;

	public ExecutorService getThreadPoolExecutor() {
		return threadPoolExecutor;
	}

	@PostConstruct
	public void postConstruct() {
		 
		threadPoolExecutor =  new ThreadPoolExecutor(corePoolSize, maxPoolSize,      
					keepAliveTime, TimeUnit.SECONDS,
					new ArrayBlockingQueue<Runnable>(10), factory);
		 
	}
	@PreDestroy
	public void releaseResources() {
		threadPoolExecutor.shutdown();	 
	}
 
}
