package com.hazelcast.spring.cache.application.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@SuppressWarnings("unused")
@Table(name = "orosoft_association")
public class User implements Serializable {

	/**
		 * 
		 */
	private static final long serialVersionUID = -6912201477750422475L;
	@Id
	private int id;
	private String name;
	private String address;
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", address=" + address + "]";
	}
	
	
}
