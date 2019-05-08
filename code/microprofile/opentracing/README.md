Thorntail OpenTracing Example
=====================================

Example taken from [Practical Enterprise Application Development](http://www.itbuzzpress.com/ebooks/java-ee-7-development-on-wildfly.html)

This example demonstrates the basic usage collecting Traces by means of OpenTracing API

###### Deploy
```shell
mvn clean thorntail:run
```
###### Invoke available REST Services
```shell
http://localhost:8080 
```

###### Start Jaeger Tracing Server
```shell
sudo docker run -it --rm -p 6831:6831/udp -p 16686:16686 jaegertracing/all-in-one
```

###### Check Matrics on Server
http://localhost:16686



 
 
