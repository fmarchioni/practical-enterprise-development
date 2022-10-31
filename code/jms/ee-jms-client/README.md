JMS Client example
=====================================
Example taken from [Practical Enterprise Application Development](http://www.itbuzzpress.com/ebooks/java-ee-7-development-on-wildfly.html)

This example demonstrates the basic usage of a remote JMS 2.0 client

###### Pre-requisites:
Add a JMS Queue named exampleQueue with the following CLI command:

``` 
jms-queue add --queue-address=ExampleClientQueue --entries=queue/exampleClientQueue,java:jboss/exported/jms/queue/exampleClientQueue
```
Add an Application user with the following command:

./add-user.sh -a -u jmsuser -p Password1! -g guest

###### Build Deploy and Test
```shell
mvn clean install exec:java  
```



