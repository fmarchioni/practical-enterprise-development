package com.itbuzzpress.jsf.validator;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;

import java.io.Serializable;


@Named
@RequestScoped
@ValidCustomer(groups = com.itbuzzpress.jsf.validator.CustomerGroup.class)
public class Customer implements Serializable, Cloneable {

    private static final long serialVersionUID = 1L;

    @Pattern(regexp = "[a-z-A-Z]*", message = "First name has invalid characters", groups = com.itbuzzpress.jsf.validator.CustomerGroup.class)
    private String name;

    @Email(message = "Please enter a valid formated e-mail !", groups = com.itbuzzpress.jsf.validator.CustomerGroup.class)
    private String email;

    @Min(value = 18, message = "Age must be greater than or equal to 18", groups = com.itbuzzpress.jsf.validator.CustomerGroup.class)
    private int age;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Customer other = (Customer) super.clone();
        other.setName(this.getName());
        other.setEmail(this.getEmail());
        other.setAge(this.getAge());
        return other;
    }

}
