JPA application
=====================================
Example taken from [Practical Enterprise Application Development](http://www.itbuzzpress.com/ebooks/java-ee-7-development-on-wildfly.html)

This example demonstrates a basic JPA application  

###### Build and Deploy
```shell
mvn clean install wildfly:deploy
```

###### Test
A test JPA application is included in the folder arquillian

###### Test with curl

A sample shell to test the application:

```shell
curl -X POST http://localhost:8080/ee-jpa-basic/rest/customer -H 'Content-Type: application/json' -d '{"name":"JohnSmith","email":"jsmith@gmail.com","address":"3170 Broadway","phoneNumber":"33312345678"}'
```

```shell
curl http://localhost:8080/ee-jpa-basic/rest/customer
[{"id":1,"name":"JohnSmith","email":"jsmith@gmail.com","address":"3170 Broadway","phoneNumber":"33312345678"}]
```

```shell
curl -X POST http://localhost:8080/ee-jpa-basic/rest/request/1 -H 'Content-Type: application/json' -d '{"product":"bycicle","quantity":"1"}'
```

```shell
curl http://localhost:8080/ee-jpa-basic/rest/request 	
[{"id":1,"quantity":1,"customer":{"id":1,"name":"JohnSmith","email":"jsmith@gmail.com","address":"3170 Broadway","phoneNumber":"33312345678"},"product":"bycicle"}]
```


