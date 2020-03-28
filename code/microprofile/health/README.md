WildFly MicroProfile Health Example
=====================================
Example taken from [Practical Enterprise Application Development](http://www.itbuzzpress.com/ebooks/java-ee-7-development-on-wildfly.html)

This example demonstrates the usage of WildFly MicroProfile health check

###### Deploy
```shell
mvn clean install wildfly:deploy
```

###### Test Readiness
```shell
http://localhost:9990/health/ready
```

###### Test Liveness
```shell
http://localhost:9990/health/live
```
