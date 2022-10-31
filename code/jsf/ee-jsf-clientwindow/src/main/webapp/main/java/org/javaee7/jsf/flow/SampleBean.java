package org.javaee7.jsf.flow;


import java.io.Serializable;
import jakarta.faces.flow.FlowScoped;
import jakarta.inject.Named;


@Named
@ClientWindowScoped()
public class SampleBean implements Serializable {
    @PostConstruct
    public void init() {
        FacesContext context = FacesContext.getCurrentInstance();
        this.name=UUID.randomUUID().toString();
     }
    public SampleBean() {
    }
    String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.getName();
    }
    
    public String getHomeAction() {
        return "/index";
    }
}
