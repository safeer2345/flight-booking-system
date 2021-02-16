package com.aitrich.flightbookingsystem.flightbooking;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aitrich.flightbookingsystem.domain.entity.FlightBookingEntity;
import com.aitrich.flightbookingsystem.exception.ResourceNotFoundException;
import com.aitrich.flightbookingsystem.flight.FlightController;
import com.aitrich.flightbookingsystem.flightbooking.request.FlightBookingCreateRequest;
import com.aitrich.flightbookingsystem.flightbooking.request.converter.FlightBookingConverter;

@RestController
@RequestMapping(name = "flightbookingcontroller")
public class FlightBookingController {

	@Autowired
	FlightBookingService flightBookingService;
	@Autowired
	FlightBookingConverter flightBookingConverter;

	private static final Logger logger = LoggerFactory.getLogger(FlightController.class);

	@PostMapping("/bookFlight")
	public ResponseEntity<FlightBookingCreateRequest> BookFlight(@Valid @RequestBody FlightBookingCreateRequest flightBookingCreateRequest) {
		logger.info("book flight at controller");
		FlightBookingEntity flightBookingEntity= flightBookingService.bookFlight(flightBookingConverter.toFlightBookingEntity(flightBookingCreateRequest));
		
		if (flightBookingEntity==null) {
			throw new ResourceNotFoundException("flight booking failed");
		}
		
		return new ResponseEntity<FlightBookingCreateRequest>(HttpStatus.OK);
	}
	

	/*
	 * @PostMapping("/updateBookedFlight") public void
	 * updateBookedFlight(@RequestBody FlightBookingEntity flightBookingEntity) {
	 * logger.info("update booked flight at controller");
	 * flightBookingService.updateBookedFlight(flightBookingEntity); }
	 */

	@GetMapping("/deleteBookedFlight/{fb_id}")
	public ResponseEntity<FlightBookingCreateRequest> deleteBookedFlight(@PathVariable("fb_id") String flighbookingtId) {
		logger.info("delete booked flight at controller");
		flightBookingService.findBookedFlightById(flighbookingtId);
		flightBookingService.deleteBookedFlight(flighbookingtId);
		return new ResponseEntity<FlightBookingCreateRequest>(HttpStatus.OK);
	}

	@GetMapping("/findAllBookedFlight")
	public ResponseEntity<Object> findAllBookedFlight() {
		logger.info("find all booked flight at controller");
		 List<FlightBookingCreateRequest> flightBookingCreateRequests=flightBookingConverter.toFlightBookingModelList(flightBookingService.findAllBookedFlight());
		 if (flightBookingCreateRequests.isEmpty()) {
			throw new ResourceNotFoundException("no flight booked");
		}
		return new ResponseEntity<Object>(flightBookingCreateRequests,HttpStatus.OK);

	}

	@GetMapping("/findByBookedFlightId/{fb_id}")
	public ResponseEntity<FlightBookingCreateRequest> findByBookedFlightId(@PathVariable("fb_id") String flightId) {
		logger.info("find booked flight by id at controller");
		return new ResponseEntity<FlightBookingCreateRequest>(flightBookingConverter.toFlightBookingModel(flightBookingService.findBookedFlightById(flightId)),HttpStatus.OK);

	}

	@GetMapping("/findBookedFlightbyPassengerId/{pr_id}")
	public ResponseEntity<Object> findBookedFlightbyPassengerId(@PathVariable("pr_id") String passengerEntityId) {
		logger.info("find booked flight by id at controller");
		return new ResponseEntity<Object>(flightBookingConverter.toFlightBookingModelList(
				flightBookingService.findBookedFlightByPassengerId(passengerEntityId)), HttpStatus.OK);

	}

//	@GetMapping("/deleteAllByFlightId/{ft_id}")
//	public void deleteAllByFlightId(@PathVariable("ft_id") String flightId) {
//		logger.info("find booked flight by id at controller");
//		flightBookingService.delete_flight_booking_bookedpassengerByFlightId(flightId);
//		
//	}
}
