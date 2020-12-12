Jakarta EE Concurrency example with Contextual instance example
=====================================
Example taken from [Practical Enterprise Application Development](http://www.itbuzzpress.com/ebooks/java-ee-7-development-on-wildfly.html)

This example demonstrates the basic usage of Jakarta EE Concurrency with a Contextual instance
###### Build and Deploy
```shell
mvn clean install wildfly:deploy  
```

###### Test
```shell
http://localhost:8080/ee-managedcontextual/
```
**Note** In order to propagate the Principal identity in the Proxy, it would be necessary to include a Security context in this application
 
