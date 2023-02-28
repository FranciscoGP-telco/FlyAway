package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="airlines")
public class Airline {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int airline_id;
	private String name;
	
	public int getAirline_id() {
		return airline_id;
	}
	public void setAirline_id(int airline_id) {
		this.airline_id = airline_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return String.format("Airline [airline_id=%d, name=%s]", airline_id, name);
	}
	
}
