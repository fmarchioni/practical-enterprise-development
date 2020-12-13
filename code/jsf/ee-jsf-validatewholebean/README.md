JSF ValidateWholeBean example
=====================================
Example taken from [Practical Enterprise Application Development](http://www.itbuzzpress.com/ebooks/java-ee-7-development-on-wildfly.html)

This example demonstrates a JSF feature which enables a centralized validation of all Bean properties using <f:validateWholeBean />

###### Build and Deploy
```shell
mvn clean install wildfly-jar:run
```

###### Test
```shell
http://localhost:8080
```