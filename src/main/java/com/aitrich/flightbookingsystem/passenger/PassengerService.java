package com.aitrich.flightbookingsystem.passenger;

import java.util.List;

import com.aitrich.flightbookingsystem.domain.entity.PassengerEntity;

public interface PassengerService {

	public PassengerEntity savePassenger(PassengerEntity passengerEntity);

	public PassengerEntity updatePassenger(PassengerEntity passengerEntity);

	public void deletePassenger(String passengerId);

	public List<PassengerEntity> findAllPassenger();

	public PassengerEntity findPassengerById(String id);

	// public void deletePassengerBookings(String passengerId);

}
