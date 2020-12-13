WildFly MicroProfile metrics example
=====================================

Example taken from [Practical Enterprise Application Development](http://www.itbuzzpress.com/ebooks/java-ee-7-development-on-wildfly.html)

This example demonstrates the basic usage of MicroProfile Metrics with WildFly

###### Build and Deploy
```shell
mvn clean install wildfly-jar:run
```

###### Test

Available REST Endpoints:

```shell
curl http://localhost:8080/rest/time
curl http://localhost:8080/rest/text
curl http://localhost:8080/rest/json
curl http://localhost:8080/rest/xml
```


 
 
