# WildFly JWT Demo 

Example of OpenID secured Client with JWT authentication. JWTs are issued by Keycloak and contain
claims with general user information as well as current user roles.

## Run Keycloak
```
docker run --rm  \
   --name keycloak \
   -e KEYCLOAK_USER=admin \
   -e KEYCLOAK_PASSWORD=admin \
   -e KEYCLOAK_IMPORT=/tmp/myrealm.json  -v /tmp/myrealm.json:/tmp/myrealm.json \
   -p 8180:8180 \
   -it quay.io/keycloak/keycloak:7.0.1 \
   -b 0.0.0.0 \
   -Djboss.http.port=8180 \
   -Dkeycloak.profile.feature.upload_scripts=enabled  
```
Users available:
- Admin (admin/test) belonging to "admin" group
- User (test/test) belonging to "user" group

NOTE: Copy the file myrealm.json in your /tmp path

## Start WildFly
```
./standalone.sh
```

## Deploy the application
```
mvn clean install wildfly:deploy -DskipTests=true
```

## Test the application
```
mvn test
```

