package com.zs.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "flights")
@NamedQueries(value = {
		@NamedQuery(name = "ByCarrier", query = "SELECT f FROM Flight f WHERE carrier=:car"),
		@NamedQuery(name = "ByRoute", query = 
				"SELECT f FROM Flight f WHERE source=?1 AND destination=?2")
})
public class Flight {
	@Id @Column(name = "fno")
	private int flightNo;
	@Column(length = 20, nullable = false)
	private String carrier;
	@Column(length = 20, nullable = false)
	private String source;
	@Column(length = 20, nullable = false)
	private String destination;
	
	@OneToMany(mappedBy = "flight")
	private List<Passenger> passengers;
	
	public Flight() {
	}
	public Flight(int flightNo, String carrier, String source, String destination) {
		this.flightNo = flightNo;
		this.carrier = carrier;
		this.source = source;
		this.destination = destination;
	}
	public int getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(int flightNo) {
		this.flightNo = flightNo;
	}
	public String getCarrier() {
		return carrier;
	}
	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}

	public List<Passenger> getPassengers() {
		return passengers;
	}
	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}
	
	@Override
	public String toString() {
		return "Flight [No=" + flightNo + ", Carrier=" + carrier + ", Source=" + source + ", Destination="
				+ destination + "]";
	}
}
