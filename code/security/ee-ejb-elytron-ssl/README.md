## Example how to invoke EJBs over SSL which are using a Security Domain (Updated)

### Configure Keystores

```shell
$ cd ssl
$ ./generatekeys.sh
```

### Compile and deploy the server application
```
cd server
mvn clean install wildfly-jar:run
```

### Move into the client folder
```
cd client
```

### Compile and execute the Client application
```
mvn clean install exec:exec
```

