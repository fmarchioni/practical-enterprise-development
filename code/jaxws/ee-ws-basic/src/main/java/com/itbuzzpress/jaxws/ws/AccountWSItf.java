package com.itbuzzpress.jaxws.ws;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
@WebService
public interface AccountWSItf {

	@WebMethod
	public void newAccount(@WebParam(name = "name") String name);

	@WebMethod
	public void withdraw(@WebParam(name = "name") String name,
						 @WebParam(name = "amount") long amount) throws RuntimeException;

	@WebMethod
	public void deposit(@WebParam(name = "name") String name,
						@WebParam(name = "amount") long amount);

	@WebResult(name = "BankAccount")
	public Account findAccountByName(String name);
}
