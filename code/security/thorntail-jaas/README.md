Jaas security with Thorntail
=====================================
Example taken from [Practical Enterprise Application Development](http://www.itbuzzpress.com/ebooks/java-ee-7-development-on-wildfly.html)

This example demonstrates the usage of JAAS Security in a Microprofile Environment.

###### Deploy
```shell
mvn clean thorntail:run
```
###### Test
```shell
http://localhost:8080 
```

Access the application using any user defined in src/main/resources/META-INF/load.sql
(For example: admin/password)
