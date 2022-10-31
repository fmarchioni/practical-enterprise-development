package com.itbuzzpress.cdi.bean;

import jakarta.enterprise.inject.Alternative;

@Alternative
public class Simple implements Rules {
	private int maxAttempts = 6;

	public int getMaxAttempts() {
		return maxAttempts;
	}
}
