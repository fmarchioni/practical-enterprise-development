Jakarta EE Concurrency examples with Contextual instance
=====================================
Example taken from [Practical Enterprise Application Development](http://www.itbuzzpress.com/ebooks/java-ee-7-development-on-wildfly.html)

This example demonstrates the basic usage of Jakarta EE Concurrency with a Contextual instance
###### Build and Deploy
```shell
mvn clean install wildfly-jar:run
```

The application is available at http://localhost:8080

**Note** In order to propagate the Principal identity in the Proxy, it would be necessary to include a Security context in this application
 
