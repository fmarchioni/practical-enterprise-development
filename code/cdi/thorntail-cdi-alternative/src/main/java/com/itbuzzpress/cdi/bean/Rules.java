package com.itbuzzpress.cdi.bean;

import java.io.Serializable;

import javax.inject.Named;

 
@Named
public interface Rules extends Serializable{
	public int getMaxAttempts();
}
