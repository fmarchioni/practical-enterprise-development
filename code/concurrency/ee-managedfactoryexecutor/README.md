Java EE Concurrency examples with Thread Factory 
=====================================
Example taken from [Practical Enterprise Application Development](http://www.itbuzzpress.com/ebooks/java-ee-7-development-on-wildfly.html)

This example demonstrates the basic usage of Java EE Concurrency with a Factory to create Threads
###### Build and Deploy
```shell
mvn clean install wildfly:deploy  
```

###### Test
```shell
http://localhost:8080/ee-managedfactoryexecutor/
```
  
