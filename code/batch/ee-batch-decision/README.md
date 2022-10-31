Basic job example with Decision
=====================================
Example taken from [Practical Enterprise Application Development](http://www.itbuzzpress.com/ebooks/java-ee-7-development-on-wildfly.html)

This example demonstrates the basic usage of Batch API with a with Decision class

###### Configure in the decision.xml file the FS Path to be scanned:
```xml
	<properties>
    <property name="filesystem" value="/tmp" />
</properties>
```

###### Build and Deploy

```shell
mvn clean install wildfly-jar:run
```

###### Test

The application is available at http://localhost:8080