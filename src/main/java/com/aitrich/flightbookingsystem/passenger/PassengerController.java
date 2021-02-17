package com.aitrich.flightbookingsystem.passenger;

import java.util.List;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aitrich.flightbookingsystem.domain.entity.PassengerEntity;
import com.aitrich.flightbookingsystem.flightbooking.request.FlightBookingPassengerRequest;
import com.aitrich.flightbookingsystem.passenger.request.PassengerCreateRequest;
import com.aitrich.flightbookingsystem.passenger.request.PassengerUpdateRequest;
import com.aitrich.flightbookingsystem.passenger.request.converter.PassengerConverter;

@RestController
@RequestMapping("/passengercontroller")
public class PassengerController {

	@Autowired
	PassengerService passengerService;
	@Autowired
	PassengerConverter passengerConverter;

	private static final Logger logger = LoggerFactory.getLogger(PassengerController.class);

	@PostMapping
	public ResponseEntity<PassengerEntity> savePassenger(@Valid @RequestBody PassengerCreateRequest passengerCreateRequest)
			throws Exception {
		logger.info("save passenger at controller " + passengerCreateRequest);
		PassengerEntity passengerEntity = passengerService
				.savePassenger(passengerConverter.toPassengerEntity(passengerCreateRequest));
		if (passengerEntity == null) {
			throw new PassengerNotFoundException("no passenger found with given data");
		}

		return new ResponseEntity<PassengerEntity>(passengerEntity,HttpStatus.OK);
	}

	@PutMapping("/{p_id}")
	public ResponseEntity<PassengerEntity> updatePassenger(@PathVariable("p_id") String p_id,@Valid @RequestBody PassengerUpdateRequest passengerUpdateRequest)
			throws Exception {
		logger.info("update passenger at controller " + passengerUpdateRequest);
		passengerService.findPassengerById(p_id);
		PassengerEntity entity=passengerService.updatePassenger(passengerConverter.toPassengerEntity(passengerUpdateRequest));
		return new ResponseEntity<PassengerEntity>(entity,HttpStatus.OK);
	}

	@DeleteMapping("/{p_id}")
	public ResponseEntity<FlightBookingPassengerRequest> deletePassenger(@PathVariable("p_id") String passengerId) throws Exception {

		logger.info("delete passenger at controller " + passengerId);
		passengerService.findPassengerById(passengerId);
		passengerService.deletePassenger(passengerId);
		return new ResponseEntity<FlightBookingPassengerRequest>(HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<PassengerCreateRequest>> findAllPassenger() throws Exception {
		logger.info("find all passenger at controller");
		List<PassengerCreateRequest> passengerCreateRequests = passengerConverter
				.toPassengerRequestList(passengerService.findAllPassenger());

		if (passengerCreateRequests.isEmpty()) {
			throw new PassengerNotFoundException("no passenger data found");
		}
		return new ResponseEntity<List<PassengerCreateRequest>>(passengerCreateRequests, HttpStatus.OK);

	}

	@GetMapping("/findByPassengerId/{p_id}")
	public ResponseEntity<PassengerEntity> findByPassengerById(@PathVariable("p_id") String passengerId)
			throws Exception {
		logger.info("find Passenger by id at controller " + passengerId);
		PassengerEntity passengerEntity = passengerService.findPassengerById(passengerId);
		return new ResponseEntity<PassengerEntity>(passengerEntity, HttpStatus.OK);

	}

}
