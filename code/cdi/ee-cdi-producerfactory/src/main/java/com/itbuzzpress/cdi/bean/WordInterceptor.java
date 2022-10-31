package com.itbuzzpress.cdi.bean;

import com.itbuzzpress.cdi.model.Word;
import com.itbuzzpress.cdi.qualifier.AnagramInterceptor;
import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@AnagramInterceptor
@Interceptor
@Priority(500)
public class WordInterceptor {
    
    @AroundInvoke
    public Object inspect(InvocationContext context) throws Exception {

    	System.out.println("-->"+context.getMethod().getName());
    	System.out.println("data " +context.getContextData());
    	System.out.println("target " +context.getTarget());
    	
    	if (context.getTarget() != null) {
    		Word word = (Word) context.getTarget();
    	    System.out.println("The solution is -->"+word.getSolution());
    	}

        return context.proceed();
    }
}