package com.itbuzzpress.cdi;

import javax.enterprise.event.*;


public class App {
    public void onEvent(@Observes SimpleEvent ignored, SimpleService service) {
        service.greet();
    }
}
