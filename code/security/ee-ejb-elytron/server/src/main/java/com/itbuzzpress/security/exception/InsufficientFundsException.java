package com.itbuzzpress.security.exception;

import jakarta.ejb.EJBException;

public class InsufficientFundsException extends Exception {
   public InsufficientFundsException(String mess){
	   super(mess);
   }
}
