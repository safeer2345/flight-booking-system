package com.aitrich.flightbookingsystem.test.passenger;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.aitrich.flightbookingsystem.domain.entity.PassengerEntity;
import com.aitrich.flightbookingsystem.domain.repository.PassengerRepository;
import com.aitrich.flightbookingsystem.exception.ResourceNotFoundException;
import com.aitrich.flightbookingsystem.flightbooking.FlightBookingServiceImpl;
import com.aitrich.flightbookingsystem.passenger.PassengerService;
import com.aitrich.flightbookingsystem.passenger.PassengerServiceImpl;

@ExtendWith(SpringExtension.class)
public class PassengerServiceTest {

	@Mock
	PassengerRepository passengerRepository;

	@InjectMocks
	PassengerService passengerService;

	public PassengerServiceTest() {
		passengerRepository = mock(PassengerRepository.class);
		passengerService = new PassengerServiceImpl(new FlightBookingServiceImpl(), passengerRepository);
	}

	@Test
	public void testPersonSave() {
		PassengerEntity passengertEntity = new PassengerEntity("PR-1", "safeer", "ismail", "safeer2345@gmail.com");
		when(passengerRepository.save(passengertEntity)).thenReturn(passengertEntity);
		PassengerEntity entity = passengerService.savePassenger(passengertEntity);
		assertEquals("PR-1", entity.getId());
		assertEquals("safeer", entity.getFirstName());
		assertEquals("ismail", entity.getLastName());
		assertEquals("safeer2345@gmail.com", entity.getEmail());
	}

	@Test
	public void testPersonUpdate() {
		PassengerEntity passengertEntity = new PassengerEntity("PR-1", "safeer", "ismail", "safeer2345@gmail.com");
		when(passengerRepository.save(passengertEntity)).thenReturn(passengertEntity);
		PassengerEntity entity = passengerService.savePassenger(passengertEntity);
		assertEquals("PR-1", entity.getId());
		assertEquals("safeer", entity.getFirstName());
		assertEquals("ismail", entity.getLastName());
		assertEquals("safeer2345@gmail.com", entity.getEmail());
	}

	@Test
	public void testFindAllAirport() {
		List<PassengerEntity> passengerEntities = new ArrayList<PassengerEntity>();
		passengerEntities.add(new PassengerEntity("PR-1", "safeer", "ismail", "safeer2345@gmail.com"));
		passengerEntities.add(new PassengerEntity("PR-2", "sruthi", "joes", "sruthijose@gmail.com"));
		passengerEntities.add(new PassengerEntity("PR-3", "vinaya", "mukundan", "vinayamukundan@gmail.com"));
		when(passengerRepository.findAll()).thenReturn(passengerEntities);
		List<PassengerEntity> entities = passengerService.findAllPassenger();
		assertEquals(3, entities.size());
	}

	@Test
	public void testAirportFIndById() {
		PassengerEntity passengertEntity = new PassengerEntity("PR-1", "safeer", "ismail", "safeer2345@gmail.com");
		Optional<PassengerEntity> optional = Optional.of(passengertEntity);
		Mockito.when(passengerRepository.findById("PR-1")).thenReturn(optional);
		assertAll(() -> Optional.ofNullable(passengerService.findPassengerById("PR-1"))
				.orElseThrow(() -> new ResourceNotFoundException("test")));
	}

	@Test
	public void testAirportDeleteById() {
		PassengerEntity passengertEntity = new PassengerEntity("PR-1", "safeer", "ismail", "safeer2345@gmail.com");
		passengerService.deletePassenger(passengertEntity.getId());
		verify(passengerRepository, times(1)).deleteById(passengertEntity.getId());
	}

}
