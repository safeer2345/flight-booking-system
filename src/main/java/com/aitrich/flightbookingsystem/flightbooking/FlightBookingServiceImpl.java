package com.aitrich.flightbookingsystem.flightbooking;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aitrich.flightbookingsystem.domain.entity.FlightBookingEntity;
import com.aitrich.flightbookingsystem.domain.repository.FlightBookingRepository;
import com.aitrich.flightbookingsystem.exception.ResourceNotFoundException;

@Service
public class FlightBookingServiceImpl implements FlightBookingService {

	@Autowired
	FlightBookingRepository flightBookingRepository;

	@Override
	public FlightBookingEntity bookFlight(FlightBookingEntity flightBookingEntity) {
		return flightBookingRepository.save(flightBookingEntity);
	}

	@Override
	public void updateBookedFlight(FlightBookingEntity flightBookingEntity) {
		flightBookingRepository.save(flightBookingEntity);
	}

	@Override
	public void deleteBookedFlight(String id) {
		flightBookingRepository.deleteById(id);
	}

	@Override
	public List<FlightBookingEntity> findAllBookedFlight() {
		return flightBookingRepository.findAll();
	}

	@Override
	public FlightBookingEntity findBookedFlightById(String id) {
		return flightBookingRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("no flight booked by this booking id " + id));
	}

	@Override
	public List<FlightBookingEntity> findBookedFlightByPassengerId(String passengerEntityId) {
		List<FlightBookingEntity> flightBookingEntities = flightBookingRepository
				.findBookedFlightByPassengerEntityId(passengerEntityId);
		if (flightBookingEntities.isEmpty()) {
			throw new ResourceNotFoundException("no flight booked by this passenger id " + passengerEntityId);
		}
		return flightBookingEntities;
	}

	/*
	 * @Override public void delete_flight_booking_bookedpassengerByFlightId(String
	 * flightId) {
	 * 
	 * 
	 * List<FlightBookingEntity> FlightBookingEntity = findAllBookedFlight();
	 * List<FlightBookingEntity> deleteEntity = new
	 * ArrayList<FlightBookingEntity>(); for (FlightBookingEntity fbe :
	 * FlightBookingEntity) { for (FlightEntity flight : fbe.getFlights()) { if
	 * (flight.getId().equals(flightId)) { // one fbe object have many flight object
	 * bcs of connection flights so if any of // the flight equal to given flight id
	 * need to delete // entire fbe deleteEntity.add(fbe); } } }
	 * 
	 * flightBookingRepository.deleteAll(deleteEntity); //
	 * flightService.deleteFlight(flightId);
	 * 
	 * flightBookingRepository.deleteById(flightId); }
	 */
//	@Override
	// public void delete_flight_booking_bookedpassengerByPassengerId(String
	// passengerId) {

//		List<FlightBookingEntity> listBookingEntity = findBookedFlightByPassengerId(passengerId);
//		List<FlightBookingEntity> deleteBookingEntityList = new ArrayList<FlightBookingEntity>();
//
//		for (FlightBookingEntity lbe : listBookingEntity) {
//			if (lbe.getPassengerEntity().getId().equals(passengerId)) {
//				deleteBookingEntityList.add(new FlightBookingEntity(lbe.getId(), null,null));
//
//			}
//		}
//		deleteBookingEntityList.forEach(obj -> {
//			System.out.println("deleteBookingEntityList" + obj);
//		});
//		flightBookingRepository.deleteAll(deleteBookingEntityList);

//}

}
