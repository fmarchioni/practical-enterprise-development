WildFly MicroProfile REST Client Example
=====================================
Example taken from [Practical Enterprise Application Development](http://www.itbuzzpress.com/ebooks/java-ee-7-development-on-wildfly.html)

This example demonstrates the usage of WildFly MicroProfile REST Client API

###### Deploy the client and server application
```shell
$ mvn clean package wildfly:deploy
```
###### Test the server Endpoint using the Client REST proxy
```shell
curl http://localhost:8080/ee-microprofile-rest-client/proxy/text
```

