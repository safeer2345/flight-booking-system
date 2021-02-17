package com.aitrich.flightbookingsystem.flight;

import java.util.List;

import com.aitrich.flightbookingsystem.domain.entity.FlightEntity;
import com.aitrich.flightbookingsystem.flightbooking.request.FlightBookingCreateRequest;


public interface FlightService {
	
	public FlightEntity saveFlight(FlightEntity flightEntity);

	public FlightEntity updateFlight(FlightEntity flightEntity);

	public void deleteFlight(String id);

	public List<FlightEntity> findAllFlight();

	public FlightEntity findFlightById(String id);
	
	public FlightEntity findFlightByAllField(FlightBookingCreateRequest request);

}
