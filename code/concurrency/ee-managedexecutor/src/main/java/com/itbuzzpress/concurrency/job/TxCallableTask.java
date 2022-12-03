package com.itbuzzpress.concurrency.job;

import com.itbuzzpress.concurrency.ejb.SimpleEJB;
import jakarta.transaction.UserTransaction;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.concurrent.Callable;

 
public class TxCallableTask implements Callable<Long> {
	long id;
	public TxCallableTask(long i) {
		this.id = i;
	}

	public Long call() {
		long value = 0;
		UserTransaction tx = lookupUserTransaction();
		SimpleEJB ejb = lookupEJB();

		try {

			tx.begin();
			value = ejb.calculate(id); // Do Transactions here
			tx.commit();

			System.out.println("Done!");
		} catch (Exception e) {
			e.printStackTrace();
			try {
				tx.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		return value;
	}

	private UserTransaction lookupUserTransaction() {
		UserTransaction ut = null;
		try {
			ut = (UserTransaction) new InitialContext()
			.lookup("java:comp/UserTransaction");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ut;
	}

	private SimpleEJB lookupEJB() {
		SimpleEJB ejb = null;
		try {
			ejb = (SimpleEJB) new InitialContext()
			.lookup("java:app/ee-managedexecutor/SimpleEJB!com.itbuzzpress.concurrency.ejb.SimpleEJB");

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ejb;
	} 

}
