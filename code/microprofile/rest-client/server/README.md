Basic REST Web services example
=====================================
Example taken from [Practical Enterprise Application Development](http://www.itbuzzpress.com/ebooks/java-ee-7-development-on-wildfly.html)

This example demonstrates the basic usage of REST Web services

###### Build and Deploy
```shell
$ java -jar target/ee-microprofile-rest-server-bootable.jar
$ java -jar target/ee-microprofile-rest-client-bootable.jar  -Djboss.socket.binding.port-offset=100
```

###### Test
```shell
curl http://localhost:8180/proxy/text
```
 
