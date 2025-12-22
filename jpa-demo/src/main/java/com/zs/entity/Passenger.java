package com.zs.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "passengers")
public class Passenger {
	@Id @GeneratedValue @Column(name = "pid") 
	private int passId;
	@Column(name = "pname", length = 30)
	private String passName;
	private LocalDate travelDate;
	private double price;
	
	@ManyToOne
	@JoinColumn(name = "fno")
	private Flight flight;
	
	public Passenger() {
	}
	public Passenger(String passName, LocalDate travelDate, double price) {
		this.passName = passName;
		this.travelDate = travelDate;
		this.price = price;
	}

	public int getPassId() {
		return passId;
	}
	public void setPassId(int passId) {
		this.passId = passId;
	}

	public String getPassName() {
		return passName;
	}
	public void setPassName(String passName) {
		this.passName = passName;
	}

	public LocalDate getTravelDate() {
		return travelDate;
	}
	public void setTravelDate(LocalDate travelDate) {
		this.travelDate = travelDate;
	}

	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	@Override
	public String toString() {
		return "Passenger [Id=" + passId + ", Name=" + passName + ", Date=" + travelDate + ", Price="
				+ price + "]";
	}
}
