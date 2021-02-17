package com.aitrich.flightbookingsystem.flightbooking;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aitrich.flightbookingsystem.domain.entity.FlightBookingEntity;
import com.aitrich.flightbookingsystem.domain.entity.FlightEntity;
import com.aitrich.flightbookingsystem.domain.entity.PassengerEntity;
import com.aitrich.flightbookingsystem.exception.ResourceNotFoundException;
import com.aitrich.flightbookingsystem.flight.FlightController;
import com.aitrich.flightbookingsystem.flight.FlightService;
import com.aitrich.flightbookingsystem.flightbooking.request.FlightBookingCreateRequest;
import com.aitrich.flightbookingsystem.flightbooking.request.FlightBookingPassengerRequest;
import com.aitrich.flightbookingsystem.flightbooking.request.converter.FlightBookingConverter;
import com.aitrich.flightbookingsystem.passenger.PassengerService;

@RestController
@RequestMapping("/flightbookingcontroller")
public class FlightBookingController {

	@Autowired
	FlightBookingService flightBookingService;
	@Autowired
	FlightBookingConverter flightBookingConverter;
	@Autowired
	FlightService flightService;
	@Autowired
	PassengerService passengerService;

	private static final Logger logger = LoggerFactory.getLogger(FlightController.class);

	@PostMapping
	public ResponseEntity<FlightBookingEntity> BookFlight(@RequestBody FlightBookingCreateRequest flightBookingCreateRequest) {
		logger.info("book flight at controller");
		FlightEntity flightEntity= flightService.findFlightByAllField(flightBookingCreateRequest);
		Set<FlightEntity> flightEntitySet=new HashSet<FlightEntity>();
		flightEntitySet.add(flightEntity);
		PassengerEntity passengerEntity=passengerService.findPassengerById(flightBookingCreateRequest.getPassengerId());
		FlightBookingEntity flightBookingEntity= flightBookingService.bookFlight(new FlightBookingEntity(null,passengerEntity,flightEntitySet));
		
		if (flightBookingEntity==null) {
			throw new ResourceNotFoundException("flight booking failed");
		}
		
		return new ResponseEntity<FlightBookingEntity>(flightBookingEntity,HttpStatus.OK);
	}
	

	/*
	 * @PostMapping("/updateBookedFlight") public void
	 * updateBookedFlight(@RequestBody FlightBookingEntity flightBookingEntity) {
	 * logger.info("update booked flight at controller");
	 * flightBookingService.updateBookedFlight(flightBookingEntity); }
	 */

	@DeleteMapping("/{fb_id}")
	public ResponseEntity<FlightBookingCreateRequest> deleteBookedFlight(@PathVariable("fb_id") String flighbookingtId) {
		logger.info("delete booked flight at controller");
		flightBookingService.findBookedFlightById(flighbookingtId);
		flightBookingService.deleteBookedFlight(flighbookingtId);
		return new ResponseEntity<FlightBookingCreateRequest>(HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<FlightBookingEntity>> findAllBookedFlight() {
		logger.info("find all booked flight at controller");
		 List<FlightBookingEntity> flightBookingEntities=flightBookingService.findAllBookedFlight();
		 if (flightBookingEntities.isEmpty()) {
			throw new ResourceNotFoundException("no flight booked");
		}
		return new ResponseEntity<List<FlightBookingEntity>>(flightBookingEntities,HttpStatus.OK);

	}

	@GetMapping("/{fb_id}")
	public ResponseEntity<FlightBookingEntity> findByBookedFlightId(@PathVariable("fb_id") String flightId) {
		logger.info("find booked flight by id at controller");
		return new ResponseEntity<FlightBookingEntity>(flightBookingService.findBookedFlightById(flightId),HttpStatus.OK);

	}

	@GetMapping("/findBookedFlightbyPassengerId/{pr_id}")
	public ResponseEntity<List<FlightBookingEntity>> findBookedFlightbyPassengerId(@PathVariable("pr_id") String passengerEntityId) {
		logger.info("find booked flight by id at controller");
		return new ResponseEntity<List<FlightBookingEntity>>(flightBookingService.findBookedFlightByPassengerId(passengerEntityId), HttpStatus.OK);

	}

//	@GetMapping("/deleteAllByFlightId/{ft_id}")
//	public void deleteAllByFlightId(@PathVariable("ft_id") String flightId) {
//		logger.info("find booked flight by id at controller");
//		flightBookingService.delete_flight_booking_bookedpassengerByFlightId(flightId);
//		
//	}
}
