
package com.itbuzzpress.security.client;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.itbuzzpress.security.ejb.Account;
import com.itbuzzpress.security.ejb.Calculator;
import com.itbuzzpress.security.exception.InsufficientFundsException;

import java.util.Hashtable;

public class RemoteEJBClient {

	public static void main(String[] args) throws Exception {
		
		Account account = lookupAccountEJB();
		Calculator calculator = lookupCalculatorEJB();
		System.out.println("Going to deposit 1000$ ");

		account.createAccount(1000l);

		account.deposit(250);

		try {
			System.out.println("Going to withdraw 500$ ");
			account.withdraw(500);
		} catch (InsufficientFundsException e) {
 
			e.printStackTrace();
		}
		long money = account.getMoney();
		System.out.println("Money left " + money);
		float totalMoney = calculator.calculateInterest(money);
		System.out.println("Money plus interests " + totalMoney);

	}

	private static Account lookupAccountEJB() throws NamingException {
		final Hashtable jndiProperties = new Hashtable();
                // specified in wildfly-config.xml             
                //jndiProperties.put(Context.PROVIDER_URL, "remote+http://localhost:8080");

                jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");

		final Context context = new InitialContext(jndiProperties);

		return (Account) context
				.lookup("ejb:/ee-ejb-server-elytron/AccountEJB!com.itbuzzpress.security.ejb.Account?stateful");
	}

	private static Calculator lookupCalculatorEJB() throws NamingException {
		final Hashtable jndiProperties = new Hashtable();
                // specified in wildfly-config.xml             
                //jndiProperties.put(Context.PROVIDER_URL, "remote+http://localhost:8080");
                jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
		final Context context = new InitialContext(jndiProperties);

		return (Calculator) context
				.lookup("ejb:/ee-ejb-server-elytron/CalculatorEJB!com.itbuzzpress.security.ejb.Calculator");
	}
}

