package com.hazelcast.spring.cache.application.model;

import java.io.Serializable;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@SuppressWarnings("unused")
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3967232536187247450L;
	private int id;
	private String name;
	private String address;
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", address=" + address + "]";
	}
	
	
}
