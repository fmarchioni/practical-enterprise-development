package com.itbuzzpress.jsf.beans;

import jakarta.faces.push.Push;
import jakarta.faces.push.PushContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
@Named
@ViewScoped
public class HelperBean implements Serializable {

    private static final Logger LOG = Logger.getLogger(HelperBean.class.getName());

    @Inject
    @Push(channel ="hello")
    private PushContext push;

    public void random() {
    	Random rnd = new Random();
        int number = rnd.nextInt(100);
        String message = "Random number is " +number;
        LOG.log(Level.INFO, "Number: {0}", number);

        push.send(message);
    }

}
