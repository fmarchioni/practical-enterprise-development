package com.itbuzzpress.batch.exception;

public class IllegalItemException extends IllegalArgumentException {

	private int item;
	public IllegalItemException(String error, int id) {
		super(error);
		this.item = id;
	}
	public int getItem() {
 
		return item;
	}

}
