package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="purchases")
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
	@Column(name = "card_number")
	private String cardNumber;
	@Column(name = "num_passengers")
	private int numPassengers;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "flight_id", nullable = false)
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
	
	public int getNumPassengers() {
		return numPassengers;
	}
	public void setNumPassengers(int numPassengers) {
		this.numPassengers = numPassengers;
	}

	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	
	@Override
	public String toString() {
		return String.format("Purchase [purchaseId=%d, name=%s, lastName=%s, tlfnNumber=%d, email=%s, cardNumber=%s, numPassengers=%d, flight=%s]", 
				purchaseId, name, lastName, tlfnNumber, email, cardNumber, numPassengers, flight.toString());
	}
}
