Basic REST Web services example
=====================================
Example taken from [Practical Enterprise Application Development](http://www.itbuzzpress.com/ebooks/java-ee-7-development-on-wildfly.html)

This example demonstrates the basic usage of REST Web services

###### Build client and server
```shell
$ cd server
$ mvn package
$ cd ../client
$ mvn package
```

###### Build and Deploy
```shell
$ cd server
$ java -jar target/ee-microprofile-rest-server-bootable.jar
$ cd ../client
$ java -jar target/ee-microprofile-rest-client-bootable.jar  -Djboss.socket.binding.port-offset=100
```

###### Test
```shell
curl http://localhost:8180/proxy/text
```

