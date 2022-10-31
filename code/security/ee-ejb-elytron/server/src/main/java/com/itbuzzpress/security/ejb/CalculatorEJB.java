package com.itbuzzpress.security.ejb;

import jakarta.annotation.security.RolesAllowed;
import jakarta.ejb.Remote;
import jakarta.ejb.Stateless;

@Stateless
@Remote(Calculator.class)
@RolesAllowed("employee")
@org.jboss.ejb3.annotation.SecurityDomain("secureApp")
public class CalculatorEJB implements Calculator {
   
	float interest=5;
 
	@Override
	public float calculateInterest(long money) {
	 
	    return money * (1+ (interest/100));
	    
	   
   }
	
	 
	
}
