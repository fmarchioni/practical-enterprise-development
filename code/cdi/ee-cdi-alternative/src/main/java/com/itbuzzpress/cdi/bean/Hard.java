package com.itbuzzpress.cdi.bean;

import javax.enterprise.inject.Alternative;

@Alternative
public class Hard implements Rules {
	private int maxAttempts = 3;

	public int getMaxAttempts() {
		return maxAttempts;
	}
}
