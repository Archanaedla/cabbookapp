package com.cabapp.pro.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cab {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cabId;
	private String carType;
	private float perKmRate;
	public Cab() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cab(String carType, float perKmRate) {
		super();
		this.carType = carType;
		this.perKmRate = perKmRate;
	}
	public int getCabId() {
		return cabId;
	}
	public void setCabId(int cabId) {
		this.cabId = cabId;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public float getPerKmRate() {
		return perKmRate;
	}
	public void setPerKmRate(float perKmRate) {
		this.perKmRate = perKmRate;
	}
	
	
	

}
