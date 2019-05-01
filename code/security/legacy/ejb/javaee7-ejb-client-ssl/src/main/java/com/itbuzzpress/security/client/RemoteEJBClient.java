
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
		jndiProperties.put(Context.URL_PKG_PREFIXES,
				"org.jboss.ejb.client.naming");
		final Context context = new InitialContext(jndiProperties);

		return (Account) context
				.lookup("ejb:/ee-ejb-server-ssl/AccountEJB!com.itbuzzpress.security.ejb.Account?stateful");
	}

	private static Calculator lookupCalculatorEJB() throws NamingException {
		final Hashtable jndiProperties = new Hashtable();
		jndiProperties.put(Context.URL_PKG_PREFIXES,
				"org.jboss.ejb.client.naming");
		final Context context = new InitialContext(jndiProperties);

		return (Calculator) context
				.lookup("ejb:/ee-ejb-server-ssl/CalculatorEJB!com.itbuzzpress.security.ejb.Calculator");
	}
}
