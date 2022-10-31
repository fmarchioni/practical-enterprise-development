package com.itbuzzpress.jsf.validator;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CustomerValidator implements ConstraintValidator<ValidCustomer, Customer> {
    
    @Override
    public void initialize(ValidCustomer constraintAnnotation) {
        
    }
    
    @Override
    public boolean isValid(Customer value, ConstraintValidatorContext context) {
    	if (value.getEmail().endsWith(".com") && (value.getAge() < 50))
    		return true;
    	else
    		return false;
    			
        
    }
    
}
