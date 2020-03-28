## Example of a secured Web application


1. You need to Define a Security Domain in your WildFly configuration matching with the information in jboss-web.xml: 
```xml
<jboss-web xmlns="http://www.jboss.com/xml/ns/javaee"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.jboss.org/schema/jbossas
    http://www.jboss.org/schema/jbossas/jboss-web_7_2.xsd">
 
   <security-domain>httpFsSD</security-domain> 
</jboss-web>
```

### Configure Elytron subsystem:

This is needed to configure elytron subsystem:
```shell
/bin/jboss-cli.sh --file=fsrealm.cli
```

###### Compile and deploy

```shell
mvn clean install wildfly:deploy
```

###### Test

Access the application at: http://localhost:8080/ee-security-elytron