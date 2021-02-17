package com.aitrich.flightbookingsystem.flight;

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

import com.aitrich.flightbookingsystem.domain.entity.FlightEntity;
import com.aitrich.flightbookingsystem.exception.ResourceNotFoundException;
import com.aitrich.flightbookingsystem.flight.request.FlightCreateRequest;
import com.aitrich.flightbookingsystem.flight.request.FlightUpdateRequest;
import com.aitrich.flightbookingsystem.flight.request.converter.FlightConverter;


@RestController
@RequestMapping("/flightcontroller")
public class FlightController {

	@Autowired
	FlightService flightService;
	@Autowired
	FlightConverter flightConverter;

	private static final Logger logger = LoggerFactory.getLogger(FlightController.class);

	@PostMapping
	public ResponseEntity<FlightEntity> saveFlight(@Valid @RequestBody FlightCreateRequest flightCreateRequest) {
		logger.info("save flight at controller " + flightCreateRequest);
		FlightEntity entity = flightService.saveFlight(flightConverter.toFlightEntity(flightCreateRequest));
		if (entity == null) {
			throw new ResourceNotFoundException("flight saving failed");
		}
		return new ResponseEntity<FlightEntity>(entity, HttpStatus.OK);
	}

	@PutMapping("/{f_id}")
	public ResponseEntity<FlightEntity> updateFlight(@PathVariable("f_id")String f_id, @Valid @RequestBody FlightUpdateRequest flightUpdateRequest) {
		logger.info("update flight at controller" + flightUpdateRequest);
		System.out.println(f_id);
		flightService.findFlightById(f_id);
		FlightEntity entity=flightService.updateFlight(flightConverter.toFlightEntity(flightUpdateRequest));
		return new ResponseEntity<FlightEntity>(entity,HttpStatus.OK);
	}

	@DeleteMapping("/{f_id}")
	public ResponseEntity<FlightEntity> deleteFlight(@PathVariable("f_id") String f_id) throws Exception{
		logger.info("delete flight at controller");
		flightService.findFlightById(f_id);
		flightService.deleteFlight(f_id);
		return new ResponseEntity<FlightEntity>(HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<FlightCreateRequest>> findAllFlight() {
		logger.info("find all flight at controller");
		List<FlightCreateRequest> flightEntities = flightConverter.toFlightRequestList(flightService.findAllFlight());
		if (flightEntities.isEmpty()) {
			throw new ResourceNotFoundException("no flight found");
		}
		return new ResponseEntity<List<FlightCreateRequest>>(flightEntities, HttpStatus.OK);

	}

	@GetMapping("/{f_id}")
	public ResponseEntity<FlightEntity> findByFlightById(@PathVariable("f_id") String flightId) throws Exception {
		logger.info("find flight by id at controller" + flightId);
		FlightEntity flightEntity = flightService.findFlightById(flightId);
		return new ResponseEntity<FlightEntity>(flightEntity, HttpStatus.OK);

	}

}
