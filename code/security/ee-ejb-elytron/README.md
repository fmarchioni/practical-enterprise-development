## Example how to invoke EJBs which are using a Security Domain


### Compile and deploy the server application
```
cd server

mvn clean install wildfly-jar:run
```

### Compile and execute the client application
```
cd client

mvn clean install exec:exec
```

