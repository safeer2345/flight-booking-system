package com.aitrich.flightbookingsystem.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aitrich.flightbookingsystem.domain.entity.FlightBookingEntity;

public interface FlightBookingRepository extends JpaRepository<FlightBookingEntity, String> {

	public List<FlightBookingEntity> findBookedFlightByPassengerEntityId(String id);

	//public void delteBookedFlightByPassengerEntityId(String passengerId);
//	@Query("Delete passenger , flight from passenger inner join flight on passenger FlightBookingEntity where ")
//	public void deleteByFlightId(@Param(value = "flightId") int flightId);

}
