package com.cabapp.pro.entity;

 
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
 

@Entity
@DiscriminatorValue("admin")
public class Admin extends AbstractUser {
	
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int adminId;


	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(int userId, String username, String password, String mobileNumber, String email) {
		super(userId, username, password, mobileNumber, email);
		// TODO Auto-generated constructor stub
	}
	

	public Admin(int adminId) {
		super();
		this.adminId = adminId;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	
	

}
