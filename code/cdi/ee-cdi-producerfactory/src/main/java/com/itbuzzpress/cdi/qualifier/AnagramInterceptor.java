package com.itbuzzpress.cdi.qualifier;


import jakarta.enterprise.util.AnnotationLiteral;
import jakarta.interceptor.InterceptorBinding;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Inherited
@InterceptorBinding
@Retention(RUNTIME)
@Target({ METHOD, TYPE })
public @interface AnagramInterceptor {
    
    @SuppressWarnings("all")
    public static final class Literal extends AnnotationLiteral<AnagramInterceptor> implements AnagramInterceptor {
        public static final Literal INSTANCE = new Literal();
        private static final long serialVersionUID = 1L;
    }
}