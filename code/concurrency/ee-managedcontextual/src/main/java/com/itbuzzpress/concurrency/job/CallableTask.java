package com.itbuzzpress.concurrency.job;

import java.util.Random;
import java.util.concurrent.Callable;

public class CallableTask implements Callable<Integer> {
	private int id;

	public CallableTask(int id) {
		this.id = id;
	}

	public Integer call() {

		Random randObj = new Random();
		Integer randNo = randObj.nextInt(id);

        return randNo;
	}


}
