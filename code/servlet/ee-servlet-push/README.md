Servlet Push Example
=====================================
Example taken from [Practical Enterprise Application Development](http://www.itbuzzpress.com/ebooks/java-ee-7-development-on-wildfly.html)

This example demonstrates the usage of a ServletPush feature in a Jakarta EE  Environment.

###### Deploy
```shell
mvn clean install wildfly:deploy
```
###### Test
```shell
http://localhost:8080/ee-servlet-push//pushresource
```
