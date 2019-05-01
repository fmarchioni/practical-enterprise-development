Java EE Concurrency examples  
=====================================
Example taken from [Practical Enterprise Application Development](http://www.itbuzzpress.com/ebooks/java-ee-7-development-on-wildfly.html)

This example demonstrates the basic usage of Java EE Concurrency with Runnable, Callable tasks and in a tx-context
###### Build and Deploy
```shell
mvn clean install wildfly:deploy  
```

###### Test
```shell
http://localhost:8080/eemanagedexecutor/
```
  
