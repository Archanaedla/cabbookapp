package com.cabapp.pro.entity;

 
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="User_type") 
 public class AbstractUser {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	
	private String username;
	private String password;
	private String address;
	
	public AbstractUser(int userId, String username, String password, String address, String mobileNumber,
			String email) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.address = address;
		this.mobileNumber = mobileNumber;
		this.email = email;
	}
	private String mobileNumber;
	private String email;
	public AbstractUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	
	public AbstractUser(int userId, String username, String password, String mobileNumber, String email) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.mobileNumber = mobileNumber;
		this.email = email;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}