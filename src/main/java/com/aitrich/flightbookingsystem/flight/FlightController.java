package com.aitrich.flightbookingsystem.flight;

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

import com.aitrich.flightbookingsystem.domain.entity.FlightEntity;
import com.aitrich.flightbookingsystem.exception.ResourceNotFoundException;
import com.aitrich.flightbookingsystem.flightbooking.request.FlightRequest;
import com.aitrich.flightbookingsystem.flightbooking.request.converter.FlightConverter;

@RestController
@RequestMapping(name = "flightcontroller")
public class FlightController {

	@Autowired
	FlightService flightService;
	@Autowired
	FlightConverter flightConverter;

	private static final Logger logger = LoggerFactory.getLogger(FlightController.class);

	@PostMapping("/saveFlight")
	public ResponseEntity<FlightEntity> saveFlight(@Valid @RequestBody FlightRequest flightRequest) {
		logger.info("save flight at controller " + flightRequest);
		FlightEntity entity = flightService.saveFlight(flightConverter.toFlightEntity(flightRequest));
		if (entity == null) {
			throw new ResourceNotFoundException("flight saving failed");
		}
		return new ResponseEntity<FlightEntity>(entity, HttpStatus.OK);
	}

	@PostMapping("/updateFlight")
	public ResponseEntity<FlightEntity> updateFlight(@Valid @RequestBody FlightEntity flightEntity) {
		logger.info("update flight at controller" + flightEntity);
		flightService.findFlightById(flightEntity.getId());
		flightService.updateFlight(flightEntity);
		return new ResponseEntity<FlightEntity>(HttpStatus.OK);
	}

	@GetMapping("/deleteFlight/{f_id}")
	public ResponseEntity<FlightEntity> deleteFlight(@PathVariable("f_id") String flightId) {
		logger.info("delete flight at controller");
		flightService.findFlightById(flightId);
		flightService.deleteFlight(flightId);
		return new ResponseEntity<FlightEntity>(HttpStatus.OK);
	}

	@GetMapping("/findAllFlight")
	public ResponseEntity<Object> findAllFlight() {
		logger.info("find all flight at controller");
		List<FlightRequest> flightEntities = flightConverter.toFlightModelList(flightService.findAllFlight());
		if (flightEntities.isEmpty()) {
			throw new ResourceNotFoundException("no flight found");
		}
		return new ResponseEntity<Object>(flightEntities, HttpStatus.OK);

	}

	@GetMapping("/findByFlightId/{f_id}")
	public ResponseEntity<FlightRequest> findByFlightById(@PathVariable("f_id") String flightId) {
		logger.info("find flight by id at controller" + flightId);
		FlightRequest flightRequest = flightConverter.toFlightModel(flightService.findFlightById(flightId));
		return new ResponseEntity<FlightRequest>(flightRequest, HttpStatus.OK);

	}

}
