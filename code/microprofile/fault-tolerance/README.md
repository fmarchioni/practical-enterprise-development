WildFly MicroProfile FaultTolerance example
=====================================

This example demonstrates the basic usage of MicroProfile FaultTolerance API with WildFly

###### Start WildFly
```shell
./standalone.sh -c standalone-microprofile.xml
```

###### Deploy
```shell
mvn clean install wildfly:deploy
```

###### Test

Available REST Endpoints:

```shell
curl http://localhost:8080/ee-microprofile-faulttolerance/rest/text
curl http://localhost:8080/ee-microprofile-faulttolerance/rest/json
curl http://localhost:8080/ee-microprofile-faulttolerance/rest/xml
```
 

