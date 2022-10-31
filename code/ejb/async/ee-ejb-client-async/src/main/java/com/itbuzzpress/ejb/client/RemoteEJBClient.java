
package com.itbuzzpress.ejb.client;

import com.itbuzzpress.ejb.Account;
import com.itbuzzpress.ejb.Calculator;
import com.itbuzzpress.exception.InsufficientFundsException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Hashtable;
import java.util.concurrent.Future;


public class RemoteEJBClient {

	public static void main(String[] args) throws Exception {
		 Account account = lookupAccountEJB();
		 Calculator calculator = lookupCalculatorEJB();
			System.out.println("Create Account with 1000$ ");


         Future<String> futureResult = account.createAccount(1000l);

             // Do other tasks
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (futureResult.isDone()) {
			System.out.println("Got result "+futureResult.get());
		}

		System.out.println("Deposit 250$ ");
		account.deposit(250);

		try {
			System.out.println("Going to withdraw 500$ ");
			account.withdraw(500);
		} catch (InsufficientFundsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long money = account.getMoney();
		System.out.println("Money left " + money);
		float totalMoney = calculator.calculateInterest(money);
		System.out.println("Money plus interests " + totalMoney);



	}

	private static Account lookupAccountEJB() throws NamingException {
		final Hashtable jndiProperties = new Hashtable();
		jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY,
                 "org.wildfly.naming.client.WildFlyInitialContextFactory");
		final Context context = new InitialContext(jndiProperties);

		return (Account) context
				.lookup("ejb:/ee-ejb-server-async/AccountEJB!com.itbuzzpress.ejb.Account?stateful");
	}

	private static Calculator lookupCalculatorEJB() throws NamingException {
		final Hashtable jndiProperties = new Hashtable();
		jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY,
                 "org.wildfly.naming.client.WildFlyInitialContextFactory");
		final Context context = new InitialContext(jndiProperties);

		return (Calculator) context
				.lookup("ejb:/ee-ejb-server-async/CalculatorEJB!com.itbuzzpress.ejb.Calculator");
	}
}
