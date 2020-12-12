Basic JMS example
=====================================
Example taken from [Practical Enterprise Application Development](http://www.itbuzzpress.com/ebooks/java-ee-7-development-on-wildfly.html)

This example demonstrates the basic usage of a JMS 2.0 application

###### Pre-requisites:
Add a JMS Queue named exampleQueue with the following CLI command:

```
jms-queue add --queue-address=exampleQueue --entries=queue/exampleQueue,java:jboss/exported/jms/queue/exampleQueue
```

###### Build and Deploy
```shell
mvn clean install wildfly:deploy  
```

###### Test
```shell
http://localhost:8080/ee-jms-basic
```
 
