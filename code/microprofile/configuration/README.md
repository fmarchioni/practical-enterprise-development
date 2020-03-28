WildFly MicroProfile Configuration Example
=====================================
Example taken from [Practical Enterprise Application Development](http://www.itbuzzpress.com/ebooks/java-ee-7-development-on-wildfly.html)

This example demonstrates the usage of WildFly MicroProfile Configuration which reads configuration from src/main/resources/META-INF/microprofile-config.properties

###### Deploy
```shell
mvn clean install wildfly:deploy
```
###### Test
```shell
http://localhost:8080/ee-microprofile-config/config
```
