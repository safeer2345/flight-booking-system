package com.aitrich.flightbookingsystem.passenger;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aitrich.flightbookingsystem.domain.entity.AirportEntity;
import com.aitrich.flightbookingsystem.domain.entity.PassengerEntity;
import com.aitrich.flightbookingsystem.domain.repository.PassengerRepository;
import com.aitrich.flightbookingsystem.exception.ResourceNotFoundException;
import com.aitrich.flightbookingsystem.flightbooking.FlightBookingService;

@Service
public class PassengerServiceImpl implements PassengerService {
	
	PassengerRepository passengerRepo;
	FlightBookingService flightBookingService;
	
	@Autowired
	public PassengerServiceImpl(FlightBookingService flightBookingService, PassengerRepository passengerRepo) {
		this.flightBookingService = flightBookingService;
		this.passengerRepo = passengerRepo;
	}
	public PassengerServiceImpl()
	{
		
	}

	@Override
	public PassengerEntity savePassenger(PassengerEntity passengerEntity) {

		return passengerRepo.save(passengerEntity);
	}

	@Override
	public PassengerEntity updatePassenger(PassengerEntity passengerEntity) {

		return passengerRepo.save(passengerEntity);
	}

	@Override
	public void deletePassenger(String passengerId) {
		// TODO Auto-generated method stub
		passengerRepo.deleteById(passengerId);
	}

	@Override
	public List<PassengerEntity> findAllPassenger() {
		// TODO Auto-generated method stub
		return passengerRepo.findAll();
	}

	@Override
	public PassengerEntity findPassengerById(String id) {
		// TODO Auto-generated method stub
		return passengerRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("no passenger exist with given id " + id));
	}

	/*
	 * @Override public void deletePassengerBookings(String passengerId) { // TODO
	 * Auto-generated method stub
	 * flightBookingService.delete_flight_booking_bookedpassengerByPassengerId(
	 * passengerId); }
	 */

}
