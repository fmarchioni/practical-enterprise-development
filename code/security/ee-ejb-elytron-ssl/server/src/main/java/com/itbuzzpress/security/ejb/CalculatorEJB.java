package com.itbuzzpress.security.ejb;

import jakarta.annotation.security.RolesAllowed;
import jakarta.ejb.Remote;
import jakarta.ejb.Stateless;
import org.jboss.ejb3.annotation.SecurityDomain;
@Stateless
@Remote(Calculator.class)
@RolesAllowed("employee")
@SecurityDomain("tlsApp")
public class CalculatorEJB implements Calculator {

	float interest=5;

	@Override
	public float calculateInterest(long money) {

	    return money * (1+ (interest/100));


   }



}
