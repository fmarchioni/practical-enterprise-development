package com.itbuzzpress.security.ejb;

import com.itbuzzpress.security.exception.InsufficientFundsException;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ejb.Remote;
import jakarta.ejb.Stateful;
import org.jboss.ejb3.annotation.SecurityDomain;

@Stateful
@Remote(Account.class)
@RolesAllowed("employee")
@SecurityDomain("tlsApp")
public class AccountEJB implements Account {

    long money;


	@Override
	public long getMoney() {
		return money;

	}

	public void createAccount(long amount)
	{
		this.money= amount;

	}

	@Override
	public void deposit(long amount)
	{

			this.money+= amount;

		System.out.println("Money deposit. total is "+money);
	}


	@Override
	public void withdraw(long amount) throws InsufficientFundsException {

		long newAmount = money - amount;
		if (newAmount < 0) {
			throw new InsufficientFundsException("Unsufficient funds for account! ");
		}

		money = newAmount;
		System.out.println("Money withdrawal. total is "+money);

	}
}
