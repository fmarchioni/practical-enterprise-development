package com.itbuzzpress.batch.ejb;

import java.util.HashMap;

import javax.ejb.Singleton;

@Singleton
public class EJBSingleton {
	private HashMap<Long,Integer> map = new HashMap();
	
	public void setCounter(Long key, Integer i) {
		map.put(key, i);
	}
	
	public Integer getCounter(Long key) {
		return map.get(key);
	}
} 

