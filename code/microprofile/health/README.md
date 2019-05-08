Thorntail MicroProfile Health Example
=====================================
Example taken from [Practical Enterprise Application Development](http://www.itbuzzpress.com/ebooks/java-ee-7-development-on-wildfly.html)

This example demonstrates the usage of Thorntail MicroProfile health check

###### Deploy
```shell
mvn clean thorntail:run
```
###### Test
```shell
http://localhost:8080/health
```
