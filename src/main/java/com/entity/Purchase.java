package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Purchase {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int purchase_id;
	private String name;
	private String last_name;
	private int tlfn_number;
	private String email;
	@ManyToOne
	@JoinColumn(name="flight_id", nullable=false)
	private Flight flight;
	public int getPurchase_id() {
		return purchase_id;
	}
	public void setPurchase_id(int purchase_id) {
		this.purchase_id = purchase_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public int getTlfn_number() {
		return tlfn_number;
	}
	public void setTlfn_number(int tlfn_number) {
		this.tlfn_number = tlfn_number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return String.format("Purchase [purchase_id=%d, name=%s, last_name=%s, tlfn_number=%d, email=%s, flight=%d]", 
				purchase_id, name, last_name, tlfn_number, flight.getFlight_id());
	}
}
