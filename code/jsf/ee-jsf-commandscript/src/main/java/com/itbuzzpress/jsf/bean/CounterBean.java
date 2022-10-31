package com.itbuzzpress.jsf.bean;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.io.Serializable;

 
@Named
@RequestScoped
public class CounterBean implements Serializable {


    private String input;
    private Integer total;

    public CounterBean() {
        // NOOP
    }

 

    public String getInput() {
		return input;
	}
	public void setInput(String input) {
		this.input = input;
	}
	 
    public void count() {
        total = input.length();    
    }
	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

}
