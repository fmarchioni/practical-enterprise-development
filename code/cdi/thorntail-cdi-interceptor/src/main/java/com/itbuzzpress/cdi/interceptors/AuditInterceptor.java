package com.itbuzzpress.cdi.interceptors;


import java.io.Serializable;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import com.itbuzzpress.cdi.qualifier.Auditing;

 

@Interceptor
@Auditing
public class AuditInterceptor implements Serializable {

    
    @AroundInvoke
     public Object logMethodEntry(InvocationContext ctx) throws Exception {
           System.out.println("Before entering method:" + ctx.getMethod().getName());
           return ctx.proceed();
     }
}