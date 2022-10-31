package com.itbuzzpress.jaxrs.model;



public class SimpleProperty {
	@Override
	public String toString() {
		return "SimpleProperty [key=" + key + ", value=" + value + "]";
	}
	public SimpleProperty() {

	}
 
	 
	private String key;
	private String value;
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public SimpleProperty( String key, String value) {
		super();
	 
		this.key = key;
		this.value = value;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
