package com.itbuzzpress.jaxws.ws;


import jakarta.inject.Inject;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;



@WebService
@SOAPBinding(style= SOAPBinding.Style.RPC)
public class AccountWS implements AccountWSItf{
	@Inject
	AccountManager ejb;

	public void newAccount(@WebParam(name = "name") String name) {
		System.out.println("Created account "+name);
		ejb.createAccount(name);

	}

 
	public void withdraw(@WebParam(name = "name") String name,
			@WebParam(name = "amount") long amount) throws RuntimeException {
		System.out.println("withdraw account "+name);
		ejb.withdraw(name, amount);
	}

 
	public void deposit(@WebParam(name = "name") String name,
			@WebParam(name = "amount") long amount) {
		ejb.deposit(name, amount);
	}


	public Account findAccountByName(String name) {
		return ejb.findAccount(name);
	}
}
