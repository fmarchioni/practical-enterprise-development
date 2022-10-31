package com.itbuzzpress.cdi.qualifier;

import jakarta.inject.Qualifier;
import jakarta.interceptor.InterceptorBinding;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@InterceptorBinding
@Retention(RUNTIME)
@Target({TYPE, METHOD, FIELD})
@Qualifier

public @interface Auditing {
	
}
 
