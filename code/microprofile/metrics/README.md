WildFly MicroProfile metrics example
=====================================

Example taken from [Practical Enterprise Application Development](http://www.itbuzzpress.com/ebooks/java-ee-7-development-on-wildfly.html)

This example demonstrates the basic usage of MicroProfile Metrics with WildFly

###### Build and Deploy
```shell
mvn clean install wildfly:deploy
```

###### Test

Available REST Endpoints:

```shell
curl http://localhost:8080/ee-microprofile-metrics/rest/simple/time
curl http://localhost:8080/ee-microprofile-metrics/rest/simple/hello
curl http://localhost:8080/ee-microprofile-metrics/rest/simple/json
curl http://localhost:8080/ee-microprofile-metrics/rest/simple/xml

curl http://localhost:9990/metrics
```


 
 
