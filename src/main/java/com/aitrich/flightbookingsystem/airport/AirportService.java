package com.aitrich.flightbookingsystem.airport;

import java.util.List;

import com.aitrich.flightbookingsystem.domain.entity.AirportEntity;


public interface AirportService {
	
	public AirportEntity saveAirport(AirportEntity airportEntity);

	public AirportEntity updateAirport(AirportEntity airportEntity);

	public void deleteAirport(String iataCode);

	public List<AirportEntity> findAllAirport();

	public AirportEntity findAirportById(String iataCode);

}
