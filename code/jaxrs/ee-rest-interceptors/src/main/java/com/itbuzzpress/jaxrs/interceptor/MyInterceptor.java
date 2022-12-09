package com.itbuzzpress.jaxrs.interceptor;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.io.ByteArrayInputStream;

import jakarta.ws.rs.Priorities;
import jakarta.ws.rs.ext.Provider;
import jakarta.ws.rs.ext.ReaderInterceptor;
import jakarta.ws.rs.ext.ReaderInterceptorContext;
import jakarta.ws.rs.ext.WriterInterceptor;
import jakarta.ws.rs.ext.WriterInterceptorContext;
import java.util.stream.Collectors;


@Provider
public class MyInterceptor implements ReaderInterceptor, WriterInterceptor {

  @Override
   public Object aroundReadFrom(ReaderInterceptorContext context)
           throws IOException {
       System.out.println("Called ReaderInterceptor");

       InputStream is = context.getInputStream();

       String body = new BufferedReader(new InputStreamReader(is))
  .lines().collect(Collectors.joining("\n"));
       System.out.println("Body:"+body);
       context.setInputStream(new ByteArrayInputStream(
               (body+"\nExtra Body.\n").getBytes()));
       Object result = context.proceed();
       return result;
   }

   @Override
   public void aroundWriteTo(WriterInterceptorContext context)
           throws IOException {
       System.out.println("Called WriterInterceptor");
       OutputStream os = context.getOutputStream();
       os.write("Extra output\n".getBytes());
       context.proceed();
   }

}
