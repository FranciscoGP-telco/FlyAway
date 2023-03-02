package com.entity;

import javax.persistence.Column;
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
	@Column(name = "purchase_id")
	private int purchaseId;
	private String name;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "tlfn_number")
	private int tlfnNumber;
	private String email;
	@ManyToOne
	@JoinColumn(name = "flightId", nullable = false)
	private Flight flight;
	public int getpurchaseId() {
		return purchaseId;
	}
	public void setpurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getlastName() {
		return lastName;
	}
	public void setlastName(String lastName) {
		this.lastName = lastName;
	}
	public int gettlfnNumber() {
		return tlfnNumber;
	}
	public void settlfnNumber(int tlfnNumber) {
		this.tlfnNumber = tlfnNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return String.format("Purchase [purchaseId=%d, name=%s, lastName=%s, tlfnNumber=%d, email=%s, flight=%d]", 
				purchaseId, name, lastName, tlfnNumber, flight.getflightId());
	}
}
