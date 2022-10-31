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
curl http://localhost:8080/rest/simple/time
curl http://localhost:8080/rest/simple/hello
curl http://localhost:8080/rest/simple/json
curl http://localhost:8080/rest/simple/xml
```

###### Check metrics

```shell
http://localhost:9990/metrics
``` 
 
