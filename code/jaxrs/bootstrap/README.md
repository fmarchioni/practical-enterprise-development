Jakarta REST Bootstrap example
=====================================
Example taken from [Practical Enterprise Application Development](http://www.itbuzzpress.com/ebooks/java-ee-7-development-on-wildfly.html)

This example demonstrates how to start a Standalone Undertow Server with REST Support.
###### Build  
```shell
mvn clean verify 
```

###### Run
```shell
java -jar target/jaxrs-bootstrap.jar
```

###### Test
```shell
curl http://localhost:8081/rest/frank
```
  
