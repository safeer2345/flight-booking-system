package com.aitrich.flightbookingsystem.airport;

import java.util.List;
import java.util.Optional;

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

import com.aitrich.flightbookingsystem.domain.entity.AirportEntity;
import com.aitrich.flightbookingsystem.exception.DuplicateResourceExcepion;
import com.aitrich.flightbookingsystem.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/airportcontroller")
public class AirportController {

	@Autowired
	AirportService airportService;

	private static final Logger logger = LoggerFactory.getLogger(AirportController.class);

	@PostMapping
	public ResponseEntity<AirportEntity> saveAirport(@Valid@RequestBody AirportEntity airportEntity) throws Exception {
		AirportEntity airportEntityObj = null;
		logger.info("save airport at controller " + airportEntity);
		try
		{
			 airportEntityObj= airportService.findAirportById(airportEntity.getIataCode());
		}
		catch (ResourceNotFoundException e) {
			// TODO: handle exception
		}
		
//		AirportEntity airportEntityObj = Optional.ofNullable(airportService.findAirportById(airportEntity.getIataCode())).orElseThrow(new ResourceNotFoundException(""));
		if(airportEntityObj==null)
		{
			AirportEntity entity = airportService.saveAirport(airportEntity);
			if (entity == null) {
				throw new ResourceNotFoundException("airport saving failed : "+airportEntity);
			}
			
			return new ResponseEntity<AirportEntity>(airportEntityObj,HttpStatus.OK);
		}
		
		throw new DuplicateResourceExcepion("airport already exist : "+airportEntity);
	}

	@PutMapping("/{iataCode}")
	public ResponseEntity<AirportEntity> updateAirport(@PathVariable(value = "iataCode") String iataCode,@Valid@RequestBody AirportEntity airportEntity) throws Exception {
		logger.info("update airport at controller " + airportEntity);
		AirportEntity entity = airportService.findAirportById(iataCode);

		if (entity == null) {
			throw new ResourceNotFoundException("updation failed no airport exist in the given details");
		}
		airportService.updateAirport(airportEntity);
		return new ResponseEntity<AirportEntity>(HttpStatus.OK);
	}

	@DeleteMapping("/{iataCode}")
	public ResponseEntity<AirportEntity> deleteAirport(@PathVariable("iataCode") String iataCode) throws Exception {
		logger.info("delete airport at controller " + iataCode);
		airportService.findAirportById(iataCode);
		airportService.deleteAirport(iataCode);
		return new ResponseEntity<AirportEntity>(HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<AirportEntity>> findAllAirport() throws Exception {
		logger.info("find all airport at controller");
		List<AirportEntity> airportEntities = airportService.findAllAirport();
		if (airportEntities.isEmpty()) {
			throw new ResourceNotFoundException("no airport exist");
		}
		return new ResponseEntity<List<AirportEntity>>(airportEntities, HttpStatus.OK);

	}

	@GetMapping("/{iataCode}")
	public ResponseEntity<AirportEntity> findAirportById(@PathVariable("iataCode") String iataCode) throws Exception {
		logger.info("find airport by id at controller " + iataCode);
		return new ResponseEntity<AirportEntity>(airportService.findAirportById(iataCode), HttpStatus.OK);

	}

}
