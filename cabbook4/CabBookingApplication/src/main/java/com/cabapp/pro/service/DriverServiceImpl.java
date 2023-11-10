package com.cabapp.pro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cabapp.pro.entity.Driver;
import com.cabapp.pro.repository.IDriverRepository;

@Service
public class DriverServiceImpl implements IDriverService {
	
	
	
	@Autowired
	IDriverRepository driverRepository;

	@Override
	public Driver InsertDriver(Driver driver) {
		
		Driver savedDriverInfo=driverRepository.save(driver);
		 
		return savedDriverInfo;
	}
	
	
	
	

}
