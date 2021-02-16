package com.aitrich.flightbookingsystem.flight;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aitrich.flightbookingsystem.domain.entity.FlightBookingEntity;
import com.aitrich.flightbookingsystem.domain.entity.FlightEntity;
import com.aitrich.flightbookingsystem.domain.repository.FlightBookingRepository;
import com.aitrich.flightbookingsystem.domain.repository.FlightRepository;
import com.aitrich.flightbookingsystem.exception.ResourceNotFoundException;
import com.aitrich.flightbookingsystem.flightbooking.FlightBookingService;

@Service
public class FlightServiceImpl implements FlightService {

	@Autowired
	FlightRepository flightRepository;

	@Autowired
	FlightBookingRepository flightBookingRepository;

	@Autowired
	FlightBookingService flightBookingService;

	@Override
	public FlightEntity saveFlight(FlightEntity flightEntity) {
		return flightRepository.save(flightEntity);
	}

	@Override
	public void updateFlight(FlightEntity flightEntity) {
		flightEntity.setFlightBookings(null);
		System.out.println(flightEntity);
		flightRepository.save(flightEntity);
	}

	@Override
	public void deleteFlight(String id) {
		flightRepository.deleteById(id);
	}

	@Override

	public List<FlightEntity> findAllFlight() {
		return flightRepository.findAll();
	}

	@Override
	public FlightEntity findFlightById(String id) {
		return flightRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("no flight with given id " + id));
	}

}
