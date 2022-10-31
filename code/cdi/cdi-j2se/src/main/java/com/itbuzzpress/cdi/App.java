package com.itbuzzpress.cdi;

import jakarta.enterprise.event.Observes;


public class App {
    public void onEvent(@Observes SimpleEvent ignored, SimpleService service) {
        service.greet();
    }
}
