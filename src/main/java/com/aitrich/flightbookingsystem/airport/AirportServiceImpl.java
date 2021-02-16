package com.aitrich.flightbookingsystem.airport;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aitrich.flightbookingsystem.domain.entity.AirportEntity;
import com.aitrich.flightbookingsystem.domain.repository.AirportRepository;
import com.aitrich.flightbookingsystem.exception.ResourceNotFoundException;

@Service
public class AirportServiceImpl implements AirportService {

	@Autowired
	AirportRepository airportRepository;

	@Override
	public AirportEntity saveAirport(AirportEntity airportEntity) {

		return airportRepository.save(airportEntity);

	}

	@Override
	public AirportEntity updateAirport(AirportEntity airportEntity) {

		return airportRepository.save(airportEntity);
	}

	@Override
	public void deleteAirport(String iataCode) {

		// findAirportById(iataCode);

		airportRepository.deleteById(iataCode);
	}

	@Override
	public List<AirportEntity> findAllAirport() {

		return airportRepository.findAll();
	}

	@Override
	public AirportEntity findAirportById(String iataCode) {
		
//		AirportEntity entity = Optional.ofNullable(airportRepository.findById(iataCode).get())
//				.orElseThrow(() -> new ResourceNotFoundException("no airport exist with given iata code "+iataCode));

		return airportRepository.findById(iataCode).orElseThrow(() -> new ResourceNotFoundException("no airport exist with given iata code "+iataCode));
	}

}
