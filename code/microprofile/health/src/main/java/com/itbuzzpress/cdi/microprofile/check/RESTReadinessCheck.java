package com.itbuzzpress.cdi.microprofile.check;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.eclipse.microprofile.health.Readiness;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import com.itbuzzpress.cdi.microprofile.service.SimpleRESTService;

@Readiness
@ApplicationScoped
public class RESTReadinessCheck implements HealthCheck {
    @Inject
    SimpleRESTService service;
    String BASE_URL ="http://localhost:8080/rest";
    public boolean isHealthy() {

        try {
            Client client = ClientBuilder.newClient();
            Response response = client
                    .target(BASE_URL +"/simple/text")
                    .request()
                    .get();

            if (response.getStatus() != 200) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public HealthCheckResponse call() {
        if (!isHealthy()) {
            return HealthCheckResponse
                    .named(RESTReadinessCheck.class.getSimpleName() + "Readiness")
                    .withData("services", "not available").down().build();
        }
        return HealthCheckResponse
                .named(RESTReadinessCheck.class.getSimpleName() + "Readiness")
                .withData("services", "available").up().build();
    }

}
