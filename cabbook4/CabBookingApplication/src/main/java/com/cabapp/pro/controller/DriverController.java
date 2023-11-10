package com.cabapp.pro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cabapp.pro.entity.Driver;
import com.cabapp.pro.service.IDriverService;

@RestController
@RequestMapping("/driver")
public class DriverController {
	
	@Autowired
	IDriverService driverService;
	
	
	
	
	@PostMapping
	public Driver saveDriverInfo(@RequestBody Driver driver) {
		if(driver!=null) {
			return driverService.InsertDriver(driver);
		}
		
		
		
		
		return null;
	}
	
	
	
	
	

}
