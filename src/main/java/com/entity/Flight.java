package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Flights")
public class Flight {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int flight_id;
	private String source;
	private String destiny;
	private int n_passengers;
	@ManyToOne
	@JoinColumn(name="airline_id", nullable=false)
	private Airline airline;
	
	
	public int getFlight_id() {
		return flight_id;
	}
	public void setFlight_id(int flight_id) {
		this.flight_id = flight_id;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestiny() {
		return destiny;
	}
	public void setDestiny(String destiny) {
		this.destiny = destiny;
	}
	public int getN_passengers() {
		return n_passengers;
	}
	public void setN_passengers(int n_passengers) {
		this.n_passengers = n_passengers;
	}
	public Airline getAirline() {
		return airline;
	}
	public void setAirline(Airline airline) {
		this.airline = airline;
	}
	@Override
	public String toString() {
		return String.format("Flight [flight_id=%d, source=%s, destiny=%s, n_passengers=%d, airline=%s]", 
				flight_id, source, destiny, airline.getName());
	}
}
