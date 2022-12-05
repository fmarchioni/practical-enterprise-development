WildFly MicroProfile Health Example on OpenShift
=====================================
Example taken from [Practical Enterprise Application Development](http://www.itbuzzpress.com/ebooks/java-ee-7-development-on-wildfly.html)

This example demonstrates the usage of WildFly MicroProfile health check on OpenShift.

It is required to have an OpenShift active project before deploying the application.

###### Deploy
```shell
mvn oc:deploy
```

Verify that the application is available in your OpenShift namespace:

```shell
$ oc get pods
NAME                                 READY     STATUS      RESTARTS   AGE
ee-microprofile-health-1-deploy      0/1       Completed   0          71s
ee-microprofile-health-1-fzcpm       1/1       Running     0          68s
```
