package com.itbuzzpress.jaxrs.interceptor;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.ext.Provider;
import jakarta.ws.rs.ext.ReaderInterceptor;
import jakarta.ws.rs.ext.ReaderInterceptorContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;

@Provider
public class ZipReaderInterceptor implements ReaderInterceptor {
 
 

	@Override
	public Object aroundReadFrom(ReaderInterceptorContext context)
			throws IOException, WebApplicationException {
		System.out.println("Called ZipReaderInterceptor");
		final InputStream inputStream = context.getInputStream();
        context.setInputStream(new GZIPInputStream(inputStream));
        return context.proceed();
	}
}
 