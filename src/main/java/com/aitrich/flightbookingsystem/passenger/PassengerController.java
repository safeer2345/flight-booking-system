package com.aitrich.flightbookingsystem.passenger;

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

import com.aitrich.flightbookingsystem.domain.entity.PassengerEntity;
import com.aitrich.flightbookingsystem.flightbooking.request.PassengerModel;
import com.aitrich.flightbookingsystem.flightbooking.request.converter.PassengerConverter;

@RestController
@RequestMapping("/passengercontroller")
public class PassengerController {

	@Autowired
	PassengerService passengerService;
	@Autowired
	PassengerConverter passengerConverter;
	
//	public PassengerController(PassengerService passengerService)
//	{
//		this.passengerService=passengerService;
//	}

	private static final Logger logger = LoggerFactory.getLogger(PassengerController.class);

	@PostMapping("/savePassenger")
	public ResponseEntity<PassengerModel> savePassenger(@Valid @RequestBody PassengerModel PassengerModel)
			throws Exception {
		logger.info("save passenger at controller " + PassengerModel);
		PassengerEntity passengerEntity = passengerService
				.savePassenger(passengerConverter.toPassengerEntity(PassengerModel));
		if (passengerEntity == null) {
			throw new PassengerNotFoundException("no passenger found with given data");
		}

		return new ResponseEntity<PassengerModel>(HttpStatus.OK);
	}

	@PostMapping("/updatePassenger")
	public ResponseEntity<PassengerModel> updatePassenger(@Valid @RequestBody PassengerEntity passengerEntity)
			throws Exception {
		logger.info("update passenger at controller " + passengerEntity);
		passengerService.findPassengerById(passengerEntity.getId());
		passengerService.updatePassenger(passengerEntity);
		return new ResponseEntity<PassengerModel>(HttpStatus.OK);
	}

	@GetMapping("/deletePassenger/{p_id}")
	public ResponseEntity<PassengerModel> deletePassenger(@PathVariable("p_id") String passengerId) throws Exception {

		logger.info("delete passenger at controller " + passengerId);
		passengerService.findPassengerById(passengerId);
		passengerService.deletePassenger(passengerId);
		return new ResponseEntity<PassengerModel>(HttpStatus.OK);
	}

	@GetMapping("/findAllPassenger")
	public ResponseEntity<List<PassengerModel>> findAllPassenger() throws Exception {
		logger.info("find all passenger at controller");
		List<PassengerModel> passengerModels = passengerConverter
				.toPassengerModelList(passengerService.findAllPassenger());

		if (passengerModels.isEmpty()) {
			throw new PassengerNotFoundException("no passenger data found");
		}
		return new ResponseEntity<List<PassengerModel>>(passengerModels, HttpStatus.OK);

	}

	@GetMapping("/findByPassengerId/{p_id}")
	public ResponseEntity<PassengerModel> findByPassengerById(@PathVariable("p_id") String passengerId)
			throws Exception {
		logger.info("find Passenger by id at controller " + passengerId);
		PassengerModel passengerModel = passengerConverter
				.toPassengerModel(passengerService.findPassengerById(passengerId));
		return new ResponseEntity<PassengerModel>(passengerModel, HttpStatus.OK);

	}

}
