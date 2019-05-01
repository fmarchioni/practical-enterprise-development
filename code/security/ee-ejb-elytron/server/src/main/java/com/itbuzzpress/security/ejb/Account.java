package com.itbuzzpress.security.ejb;

import com.itbuzzpress.security.exception.InsufficientFundsException;

 
public interface Account {


	public void deposit(long amount);
	public void withdraw(long amount) throws InsufficientFundsException;
	
	public long getMoney();
	public void createAccount(long amount);
}