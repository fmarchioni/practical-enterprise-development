CDI example with Decorator 
=====================================
Example taken from [Practical Enterprise Application Development](http://www.itbuzzpress.com/ebooks/java-ee-7-development-on-wildfly.html)

This example demonstrates a basic JSF + CDI application with *Decorator*

The decorator will turn the guess into Uppercase making impossible to guess the words which are lowercase.

###### Build and Deploy

```shell
mvn clean install wildfly-jar:run
```

###### Test

The application is available at http://localhost:8080
