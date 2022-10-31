package com.itbuzzpress.arquillian.entity;


import jakarta.persistence.*;

import java.io.Serializable;

 




@Entity

public class Request implements Serializable {

    
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    int quantity;

    //bi-directional many-to-one association to Customer
    @ManyToOne
    @JoinColumn(name="id_customer")
    private Customer customer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


      @Override
	public String toString() {
		return "Request [id=" + id + ", quantity=" + quantity + "]";
	}

	public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
} 