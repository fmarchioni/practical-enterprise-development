## Example how to invoke EJBs over SSL which are using a Security Domain (Updated)

### Configure Keystores and Elytron subsystem:

1. Configure keystores
```shell
$ cd ssl
$ ./generatekeys.sh
```
2. Copy server files into WildFly configuration folder (Replace with your JBOSS_HOME)

```shell
$ export JBOSS_HOME=/path/to/wildfly-18.0.1.Final
$ cp server.keystore $JBOSS_HOME/standalone/configuration
$ cp server.truststore $JBOSS_HOME/standalone/configuration
```

3. Copy client files into the client folder

```shell
$ cp client.keystore ../client/
$ cp client.truststore ../client/
```

4. Configure Elytron and SSL (Replace with path to repository)

```shell
$JBOSS_HOME/bin/jboss-cli.sh --file=/path/to/repository/practical-enterprise-development/code/security/ee-ejb-elytron-ssl/ssl/keys.cli
$JBOSS_HOME/bin/jboss-cli.sh --file=/path/to/repository/practical-enterprise-development/code/security/ee-ejb-elytron-ssl/ssl/script.cli
```

### Compile and deploy the server application
```
cd server
mvn clean install wildfly:deploy
```

### Move into the client folder
```
cd client
```

### Compile and execute the Client application
```
mvn clean install exec:exec
```

