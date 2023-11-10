package com.cabapp.pro.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cabapp.pro.entity.Driver;
import com.cabapp.pro.entity.TripBooking;
import com.cabapp.pro.repository.ICustomerRepository;
import com.cabapp.pro.repository.IDriverRepository;
import com.cabapp.pro.repository.ITripBookingRepository;


@Service
public class TripBookingServiceImpl implements ITripBookingService {
	
	
	@Autowired
	ITripBookingRepository tripBookingRepository;
	
	@Autowired
	ICustomerRepository customerRepository;
	
	@Autowired
	IDriverRepository driverRepository;

	@Override
	public List<TripBooking> viewAllTripsCustomer(int customerId) {
		
		List<TripBooking> savedBookings=new ArrayList<>();
		if(customerId!=0) {
			savedBookings=tripBookingRepository.getTripBookingByCustomerId(customerId);
			return savedBookings;
		}///need to test this method ........
		
		
		return null;
	}

	@Override
	public TripBooking insertTripBooking(TripBooking tripBooking) { 
		
		customerRepository.findById(tripBooking.getCustomerId());//throw exception on driver not customer not available exception
		List<Driver> drivers= driverRepository.findByAvailable() ;
		//if(drivers.size()==0)
		//{
		//	("Sorry No driver Available just now...");for exception
		//}
//		drivers.forEach((e)->System.out.println(e.getUserId()));
//		System.out.println(drivers.size());
		drivers.get(0).setAvailable(false);
		driverRepository.save(drivers.get(0));
		 Integer km = (int)tripBooking.getDistanceInKm();
	     Integer price=(int)drivers.get(0).getCab().getPerKmRate();
	     tripBooking.setBill(km*price);
	     tripBooking.setDriver(drivers.get(0));
		return tripBookingRepository.save(tripBooking);
		 
	 
	}

	@Override
	public TripBooking updateTripBooking(TripBooking tripBooking) {//on doubt to use this method
	   
		
		if (tripBooking != null) {

			int id = (int) tripBooking.getCustomerId();

			TripBooking savedBooking = tripBookingRepository.findById(id).get();

			if (savedBooking != null) {
				if (savedBooking.getFromLocation() != null) {

					savedBooking.setFromLocation(tripBooking.getFromLocation());
				}
				if (savedBooking.getToLocation() != null) {
					savedBooking.setToLocation(tripBooking.getToLocation());
				}
				if (savedBooking.getFromDateTime() != null) {
					savedBooking.setFromDateTime(tripBooking.getFromDateTime());
				}
				if (savedBooking.getToDateTime() != null) {
					savedBooking.setDistanceInKm(tripBooking.getDistanceInKm());
				}

				tripBookingRepository.save(savedBooking);
				return savedBooking;
			}
		}

		return null;
	}

	@Override
	public TripBooking deleteTripBooking(int tripBookingId) {
		
		TripBooking tripBooking =tripBookingRepository.findById(tripBookingId).get();
		
		
		if(tripBooking != null) {
		tripBooking.setDriver(null);
		tripBookingRepository.delete(tripBooking);
		}
		
		
 	return null;
	}
	
	
	
	
	
	

}
