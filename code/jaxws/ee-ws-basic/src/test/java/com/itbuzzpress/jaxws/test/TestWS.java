package com.itbuzzpress.jaxws.test;

import com.itbuzzpress.jaxws.ws.Account;
import com.itbuzzpress.jaxws.ws.AccountWSItf;
import javax.xml.namespace.QName;
import jakarta.xml.ws.Service;
import org.junit.Test;

import java.net.URL;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class TestWS {

	@Test
	public void test() {
		 
		String name ="John Smith";
		try {
			URL url = new URL("http://localhost:8080/ee-ws-basic/AccountWS?wsdl");
			QName qname = new QName("http://ws.jaxws.itbuzzpress.com/",
					"AccountWSService");

			Service service = Service.create(url, qname);
			AccountWSItf ws = service.getPort(AccountWSItf.class);
			ws.newAccount(name);
			System.out.println("Created account name " +name);
			ws.deposit(name, 1000);
			System.out.println("Deposit $ 1000 ");
			ws.withdraw(name, 500);
			System.out.println("Withdraw $ 500 ");
			Account account = ws.findAccountByName(name);
			assertNotNull(account);

			long money = account.getAmount();
			assertEquals(500l, money);
			System.out.println("Account balance is " +account.getAmount());


		} catch (Exception e) {
			System.out.println("Exception: "+ e);
		}
	}

}
