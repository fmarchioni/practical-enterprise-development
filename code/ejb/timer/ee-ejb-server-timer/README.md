Timer EJB example
=====================================
Example taken from [Practical Enterprise Application Development](http://www.itbuzzpress.com/ebooks/java-ee-7-development-on-wildfly.html)

This example demonstrates the usage of Timer EJB.

###### Create User

Add user to WildFly with this command: bin/add-user.sh -a -u ejbuser -p password123

###### Deploy
```shell
mvn clean install wildfly:deploy
```
