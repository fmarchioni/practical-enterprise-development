Securing WildFly with SSL
=====================================

This folder contains the script generatekeys.sh to generate client/server keystores and trustores

###### Generate keys

```shell
./generatekeys.sh  
```

###### Compile and deploy

```shell
mvn clean install wildfly-jar:run
```

###### Test

https://localhost:8443/https