package com.aitrich.flightbookingsystem.flightbooking;

import java.util.List;

import com.aitrich.flightbookingsystem.domain.entity.FlightBookingEntity;

public interface FlightBookingService {
	
	public FlightBookingEntity bookFlight(FlightBookingEntity flightBookingEntity);

	public void updateBookedFlight(FlightBookingEntity flightBookingEntity);

	public void deleteBookedFlight(String id);

	public List<FlightBookingEntity> findAllBookedFlight();

	public FlightBookingEntity findBookedFlightById(String id);
	
	public List<FlightBookingEntity> findBookedFlightByPassengerId(String passengerEntityId);
	
//	public void delete_flight_booking_bookedpassengerByFlightId(String flightId); 
	
	//public void delete_flight_booking_bookedpassengerByPassengerId(String passengerId); 

}
