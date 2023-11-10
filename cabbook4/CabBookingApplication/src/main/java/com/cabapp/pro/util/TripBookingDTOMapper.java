package com.cabapp.pro.util;

 
import com.cabapp.pro.dto.TripBookingRequestSubmitDTO;
import com.cabapp.pro.dto.TripBookingResponseDTO;
import com.cabapp.pro.entity.TripBooking;

public class TripBookingDTOMapper {
	
	public TripBooking getTripBookingFromTripBookingDTO(TripBookingRequestSubmitDTO dto)
	{
		TripBooking e = new TripBooking();
		
		e.setCustomerId(dto.getCustomerId());
		e.setFromLocation(dto.getFromLocation());
		e.setToLocation(dto.getToLocation());
		e.setFromDateTime(dto.getFromDateTime());
		e.setDistanceInKm(dto.getDistanceInKm());
		e.setStatus(dto.isStatus());
		e.setBill(dto.getBill());
		
		
		
		
		 
		
	
		return e;
	 
		
	}
	public TripBookingResponseDTO getTripBookingDTOFromTripBooking(TripBooking tripBooking)
	{
		TripBookingResponseDTO e = new TripBookingResponseDTO();
		
		e.setCustomerId(tripBooking.getCustomerId());
		e.setFromLocation(tripBooking.getFromLocation());
		e.setToLocation(tripBooking.getToLocation());
		e.setFromDateTime(tripBooking.getFromDateTime());
		e.setDistanceInKm(tripBooking.getDistanceInKm());
		e.setStatus(tripBooking.isStatus());
		e.setBill(tripBooking.getBill());
		
		
		
		
		 
		
	
		return e;
	 
		
	}
	
	
	

}
