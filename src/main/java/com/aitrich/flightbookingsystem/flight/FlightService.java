package com.aitrich.flightbookingsystem.flight;

import java.util.List;

import com.aitrich.flightbookingsystem.domain.entity.FlightEntity;

public interface FlightService {
	
	public FlightEntity saveFlight(FlightEntity flightEntity);

	public void updateFlight(FlightEntity flightEntity);

	public void deleteFlight(String id);

	public List<FlightEntity> findAllFlight();

	public FlightEntity findFlightById(String id);

}
