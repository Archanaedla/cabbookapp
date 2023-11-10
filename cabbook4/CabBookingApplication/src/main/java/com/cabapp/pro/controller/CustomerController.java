package com.cabapp.pro.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cabapp.pro.dto.CustomerRequestSubmitDTO;
import com.cabapp.pro.dto.CustomerResponseDTO;
import com.cabapp.pro.dto.TripBookingRequestSubmitDTO;
import com.cabapp.pro.dto.TripBookingResponseDTO;
import com.cabapp.pro.entity.Customer;
import com.cabapp.pro.entity.TripBooking;
import com.cabapp.pro.service.ICustomerService;
import com.cabapp.pro.service.ITripBookingService;
import com.cabapp.pro.util.CustomerDTOMapper;
import com.cabapp.pro.util.TripBookingDTOMapper;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	ICustomerService service;
	
	@Autowired
	ITripBookingService tripService;
	
	
	

	public CustomerController() {
		 System.out.println("Inside Customer controller");
	}
	
	
	
	
	@PostMapping("/insert/customer")
	public CustomerResponseDTO saveCustomer(@RequestBody CustomerRequestSubmitDTO dto)  {
		if(dto!=null) {
			CustomerDTOMapper dtoConverter=new CustomerDTOMapper();
			Customer customer=dtoConverter.getCustomerFromCustomerDTO(dto);
			
		
		 
		Customer savedInfo = service.insertCustomer(customer);
		return dtoConverter.getCustomerDTOFromCustomer(savedInfo);
	}
		else {
			
			return null;
		
		}
	}
			 
	
	
	
	
	@GetMapping("/customerby/{cId}")
	public CustomerResponseDTO getCustomerById(@PathVariable int cId)  {
		
		
		CustomerDTOMapper dtoConverter=new CustomerDTOMapper();
		return dtoConverter.getCustomerDTOFromCustomer(service.viewCustomer(cId));
			 
		
	}
	
	
	@GetMapping("/allcustomers") /// www.localhost:5643/customer/allcustomers
	public ResponseEntity<List<CustomerResponseDTO>> getAllCustomers() {
		System.out.println("inside controller getCustomers()");
		CustomerDTOMapper dtoConverter=new CustomerDTOMapper();
		
 
		List<Customer> savedCustomers=service.viewCustomers();
		List<CustomerResponseDTO> finalList = new ArrayList<>();
		 for(Customer cu:savedCustomers) {
			 finalList.add(dtoConverter.getCustomerDTOFromCustomer(cu));
		 }
		return new ResponseEntity<List<CustomerResponseDTO>>(finalList, HttpStatus.OK);
	}
	
	
	
	
	
	@GetMapping("/validate")
	public ResponseEntity<Customer> validateCustomer(@RequestParam String userName, @RequestParam String password) {
		Customer savedCustomer = service.validateCustomer(userName, password);
		Customer e = new Customer();
		if (savedCustomer != null) {
			return new ResponseEntity<Customer>(savedCustomer, HttpStatus.OK);
		} else
			return new ResponseEntity<Customer>(e, HttpStatus.NOT_FOUND);
	}
	
	
		
	@PutMapping("/update/{id}")
	public CustomerResponseDTO updateCustomer(@RequestBody Customer customer, @PathVariable Integer id) {
		
		CustomerDTOMapper dtoConverter=new CustomerDTOMapper();
		return dtoConverter.getCustomerDTOFromCustomer(service.updateCustomer(customer, id));
	}
	
	
	@DeleteMapping("/delete/{id}")
	public CustomerResponseDTO deleteCustomerById(@PathVariable int id) {
		CustomerDTOMapper dtoConverter=new CustomerDTOMapper();
		CustomerResponseDTO deletedCustomer= dtoConverter.getCustomerDTOFromCustomer(service.deleteCustomer(id));
		return deletedCustomer;
	}
	
	//----------------------------tripbooking API's------------------
	
	
	@PostMapping("/trip")
	public TripBookingResponseDTO Add( @RequestBody TripBookingRequestSubmitDTO trip)
	{
		     TripBookingDTOMapper converter=new TripBookingDTOMapper();
		     
		     TripBooking tripBooking=converter.getTripBookingFromTripBookingDTO(trip );
		
		
		    return converter.getTripBookingDTOFromTripBooking(tripService.insertTripBooking(tripBooking));
		     
		    
	}//had to be tested ...................
	
	
	
	
	
	
	
	@GetMapping("/getalltrips")
	public ResponseEntity<List<TripBooking>> getAllTripBooking(@RequestParam int custId) {
		List<TripBooking> savedCustomer = tripService.viewAllTripsCustomer(custId);
		//TripBooking e = new TripBooking();
		if (savedCustomer != null) {
			return new ResponseEntity<List<TripBooking>>(savedCustomer, HttpStatus.OK);
		} 
		return null;//need to test this method....
	}
	
	
	
	@PutMapping("/update/booking")//create one form in the frontend including the customerId//fornow on hold lets see in future
	public TripBooking updateBooking(@RequestBody TripBooking tripBooking) {
		
		 if(tripBooking!=null) {
		return tripService.updateTripBooking( tripBooking);
		 }
		 return null;
	}
	
	@DeleteMapping
    public TripBooking cancelBooking(@PathVariable int tripId) {
    	if(tripId!=0) {
    		return tripService.deleteTripBooking(tripId);
    	}
    	
    	
    	return null;
    }
	
		
		
	}
	
	
	
	

