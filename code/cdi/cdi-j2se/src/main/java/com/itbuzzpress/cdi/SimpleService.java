package com.itbuzzpress.cdi;

import jakarta.inject.Inject;

public class SimpleService {
    @Inject
    private Hello greeter;

    public void greet()
    {
        greeter.greet();
    }
}
