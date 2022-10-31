package com.itbuzzpress.cdi;

import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;

public class CDI2Demo {
	public static void main(String... args) {

		SeContainerInitializer containerInit = SeContainerInitializer.newInstance();
	    SeContainer container = containerInit.initialize();
	    // retrieve a bean and do work with it
	    Hello myBean = container.select(Hello.class).get();
	    myBean.greet();

	    // Fire synchronous event that triggers the code in App class.
		container.getBeanManager().getEvent().fire(new SimpleEvent());
	    // when done
	    container.close();

	}
}
