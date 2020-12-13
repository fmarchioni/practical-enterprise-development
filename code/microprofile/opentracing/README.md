WildFly OpenTracing Example
=====================================

Example taken from [Practical Enterprise Application Development](http://www.itbuzzpress.com/ebooks/java-ee-7-development-on-wildfly.html)

This example demonstrates the basic usage collecting Traces by means of OpenTracing API

###### Start Jaeger Tracing Server
```shell
docker run -e COLLECTOR_ZIPKIN_HTTP_PORT=9411 -p 5775:5775/udp -p 6831:6831/udp -p 6832:6832/udp -p 5778:5778 -p 16686:16686 -p 14268:14268 -p 9411:9411 jaegertracing/all-in-one:latest
```

###### Build and Deploy
```shell
mvn clean install wildfly-jar:run
```

###### Invoke available REST endpoints:
```shell
curl http://localhost:8080/rest/text
curl http://localhost:8080/rest/json
curl http://localhost:8080/rest/xml
```

###### Check Traces on Server
http://localhost:16686



 
 
