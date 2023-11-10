package com.cabapp.pro.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
 
import javax.persistence.ManyToOne;



@Entity
public class TripBooking {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int tripBookingId;
	private int customerId;
	 
	private String fromLocation;
	private String toLocation;
	private LocalDateTime fromDateTime;
	private LocalDateTime toDateTime;
	private boolean status;
	private float distanceInKm;
	private float bill;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Driver driver;


	public TripBooking() {
		super();
		// TODO Auto-generated constructor stub
	}


	public TripBooking(int customerId, String fromLocation, String toLocation, LocalDateTime fromDateTime,
			LocalDateTime toDateTime, boolean status, float distanceInKm, float bill, Driver driver) {
		super();
		this.customerId = customerId;
		this.fromLocation = fromLocation;
		this.toLocation = toLocation;
		this.fromDateTime = fromDateTime;
		this.toDateTime = toDateTime;
		this.status = status;
		this.distanceInKm = distanceInKm;
		this.bill = bill;
		this.driver = driver;
	}
	


	public int getTripBookingId() {
		return tripBookingId;
	}


	public void setTripBookingId(int tripBookingId) {
		this.tripBookingId = tripBookingId;
	}


	public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}


	public String getFromLocation() {
		return fromLocation;
	}


	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}


	public String getToLocation() {
		return toLocation;
	}


	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}


	public LocalDateTime getFromDateTime() {
		return fromDateTime;
	}


	public void setFromDateTime(LocalDateTime fromDateTime) {
		this.fromDateTime = fromDateTime;
	}


	public LocalDateTime getToDateTime() {
		return toDateTime;
	}


	public void setToDateTime(LocalDateTime toDateTime) {
		this.toDateTime = toDateTime;
	}


	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}


	public float getDistanceInKm() {
		return distanceInKm;
	}


	public void setDistanceInKm(float distanceInKm) {
		this.distanceInKm = distanceInKm;
	}


	public float getBill() {
		return bill;
	}


	public void setBill(float bill) {
		this.bill = bill;
	}


	public Driver getDriver() {
		return driver;
	}


	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	
	
	
	
	
	
	
	

}
