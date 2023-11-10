package com.cabapp.pro.entity;

 
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
 
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

 

@Entity
@DiscriminatorValue("customer")
public class Customer extends AbstractUser{
	
	
 
	private int customerId;
	
	
	
@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name="custId")
private TripBooking tripBooking;//doubt on implementation part whether it should be here or in tripbooking entity



 



public Customer() {
	super();
	// TODO Auto-generated constructor stub
}



public Customer(int userId, String username, String password, String mobileNumber, String email) {
	super(userId, username, password, mobileNumber, email);
	// TODO Auto-generated constructor stub
}



public Customer(int customerId, TripBooking tripBooking) {
	super();
	this.customerId = customerId;
	this.tripBooking = tripBooking;
}



public int getCustomerId() {
	return customerId;
}



public void setCustomerId(int customerId) {
	this.customerId = customerId;
}



public TripBooking getTripBooking() {
	return tripBooking;
}



public void setTripBooking(TripBooking tripBooking) {
	this.tripBooking = tripBooking;
}


	
	

}
