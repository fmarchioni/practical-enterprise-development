package com.itbuzzpress.ejb;

import com.itbuzzpress.exception.InsufficientFundsException;

import java.util.concurrent.Future;
 
public interface Account {


	public void deposit(long amount);
	public void withdraw(long amount) throws InsufficientFundsException;
	
	public long getMoney();
	public Future<String> createAccount(long amount); 
}