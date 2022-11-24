package com.itbuzzpress.security.ejb;

import java.util.List;
import java.util.Timer;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ejb.EJB;
import jakarta.ejb.Remote;
import jakarta.ejb.Stateless;
import jakarta.ejb.Timeout;
import jakarta.ejb.TimerConfig;
import jakarta.ejb.TimerService;

@Stateless
@Remote(Calculator.class)
@RolesAllowed("employee")
@org.jboss.ejb3.annotation.SecurityDomain("EJBDomain")
public class CalculatorEJB implements Calculator {
   
	float interest=5;
 
	@Override
	public float calculateInterest(long money) {
	 
	    return money * (1+ (interest/100));
	    
	   
   }
	
	 
	
}
