package org.javaee7.jsf.flow;


import java.io.Serializable;
import jakarta.faces.flow.FlowScoped;
import jakarta.inject.Named;


@Named
@FlowScoped("flow1")
public class Flow1Bean implements Serializable {

    public Flow1Bean() {
    }

    public String getName() {
        return this.getClass().getSimpleName();
    }
    
    public String getHomeAction() {
        return "/index";
    }
}
