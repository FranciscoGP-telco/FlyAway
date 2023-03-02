package com.entity;

import javax.persistence.Column;
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
	@Column(name = "flight_id")
	private int flightId;
	private String source;
	private String destiny;
	@Column(name = "n_passengers")
	private int numPassengers;
	@ManyToOne
	@JoinColumn(name = "airline_id", nullable = false)
	private Airline airline;
	
	
	public int getflightId() {
		return flightId;
	}
	public void setflightId(int flightId) {
		this.flightId = flightId;
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
	public int getnumPassengers() {
		return numPassengers;
	}
	public void setnumPassengers(int numPassengers) {
		this.numPassengers = numPassengers;
	}
	public Airline getAirline() {
		return airline;
	}
	public void setAirline(Airline airline) {
		this.airline = airline;
	}
	@Override
	public String toString() {
		return String.format("Flight [flightId=%d, source=%s, destiny=%s, numPassengers=%d, airline=%s]", 
				flightId, source, destiny, airline.getName());
	}
}
