package com.aitrich.flightbookingsystem.domain.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aitrich.flightbookingsystem.domain.entity.FlightEntity;

@Repository
public interface FlightRepository extends JpaRepository<FlightEntity, String> {

	@Query(value = "SELECT * FROM flight f WHERE f.arrival =:arrival and f.arrival_date =:a_date and f.departure =:departure and f.departure_date =:d_date", nativeQuery = true)
	public FlightEntity findFlightEntityByAllField(@Param(value = "arrival") String arrival,
			@Param(value = "a_date") LocalDateTime a_date, @Param(value = "departure") String departure,
			@Param(value = "d_date") LocalDateTime d_date);

}
