JPA application
=====================================
Example taken from [Practical Enterprise Application Development](http://www.itbuzzpress.com/ebooks/java-ee-7-development-on-wildfly.html)

This example demonstrates a basic JPA application  

###### Build and Deploy
```shell
mvn clean install wildfly-jar:run
```

###### Test
A test JPA application is included in chapter 8

curl -d '{"name":"frank", "phoneNumber":"4334434", "address":"Montgomery Street"}' -H "Content-Type: application/json" -X POST http://localhost:8080/rest/customer

curl http://localhost:8080/rest/customer

curl -d '{"id":"1","name":"john", "address":"Kensington Road", "phoneNumber":"4334434"}' -H "Content-Type: application/json" -X PUT http://localhost:8080/rest/customer

curl -d '{"quantity":"20", "product":"masks"}' -H "Content-Type: application/json" -X POST http://localhost:8080/rest/request/1

curl http://localhost:8080/rest/request

curl http://localhost:8080/rest/request/john
