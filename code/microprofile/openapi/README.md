WildFly OpenAPI example
=====================================

Example taken from [Practical Enterprise Application Development](http://www.itbuzzpress.com/ebooks/java-ee-7-development-on-wildfly.html)

This example demonstrates the basic usage of MicroProfile OpenAPI on WildFly

###### Start WildFly
```shell
./standalone.sh -c standalone-microprofile.xml
```

###### Deploy
```shell
mvn clean install wildfly:deploy
```
###### Test
```shell
http://localhost:8080/openapi 
```
 
 
