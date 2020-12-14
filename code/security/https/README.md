Securing WildFly with SSL
=====================================

This folder contains the script generatekeys.sh to generate client/server keystores and trustores

###### Generate keys

```shell
./generatekeys.sh  
```

Then copy the keystores and trustores in the $JBOSS_HOME/standalone/configuration folder

```shell
cp *.keystore $JBOSS_HOME/standalone/configuration

cp *.truststore $JBOSS_HOME/standalone/configuration
```


###### Install keys on the application server

```shell
$JBOSS_HOME/bin/jboss-cli.sh --file=script.cli
```


###### Deploy & Test

```shell
$ mvn clean install wildfly:deploy
```
Application available at: https://localhost:8443/ee-security-https/https
