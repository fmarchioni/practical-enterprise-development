package com.itbuzzpress.jaxrs.ejb;

import com.itbuzzpress.jaxrs.model.SimpleProperty;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
@Named
public class DataList implements Serializable {
	private List<SimpleProperty> list;

	@PostConstruct
	public void init() {
		list = new ArrayList<SimpleProperty>();

	}
	public List<SimpleProperty> getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}
	public int addToList(String key, String value) {

		list.add(new SimpleProperty(key,value));
		return list.size();
	}
	public int addToList(SimpleProperty p) {
		list.add(p);
		return list.size();
	}

}
