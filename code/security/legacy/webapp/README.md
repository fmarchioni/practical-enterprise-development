Jakarta EE Security example
=====================================
Example taken from [Practical Enterprise Application Development](http://www.itbuzzpress.com/ebooks/java-ee-7-development-on-wildfly.html)

This example demonstrates the basic security patterns in a Web application
###### Build and Deploy
```shell
mvn clean install wildfly:deploy  
```

###### Test
```shell
http://localhost:8080/ee-security-jaas/
```
**Note** This application requires configuring a legacy **Security Domain** named "other" 
  
