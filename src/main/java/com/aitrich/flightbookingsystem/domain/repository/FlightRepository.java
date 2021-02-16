 package com.aitrich.flightbookingsystem.domain.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aitrich.flightbookingsystem.domain.entity.FlightBookingEntity;
import com.aitrich.flightbookingsystem.domain.entity.FlightEntity;

public interface FlightRepository extends JpaRepository<FlightEntity, String> {
	
	//public Set<FlightBookingEntity>findAllFlightBookingEntityById(String flightId); 

}
