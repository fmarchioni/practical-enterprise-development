package com.itbuzzpress.cdi.interceptors;


import com.itbuzzpress.cdi.qualifier.Auditing;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

import java.io.Serializable;

 

@Interceptor
@Auditing
public class AuditInterceptor implements Serializable {

    
    @AroundInvoke
     public Object logMethodEntry(InvocationContext ctx) throws Exception {
           System.out.println("Before entering method:" + ctx.getMethod().getName());
           return ctx.proceed();
     }
}