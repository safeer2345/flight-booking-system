package com.aitrich.flightbookingsystem.test.flightbooking;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.aitrich.flightbookingsystem.domain.entity.FlightBookingEntity;
import com.aitrich.flightbookingsystem.domain.entity.FlightEntity;
import com.aitrich.flightbookingsystem.domain.entity.PassengerEntity;
import com.aitrich.flightbookingsystem.domain.repository.FlightBookingRepository;
import com.aitrich.flightbookingsystem.domain.repository.FlightRepository;
import com.aitrich.flightbookingsystem.exception.ResourceNotFoundException;
import com.aitrich.flightbookingsystem.flight.FlightService;
import com.aitrich.flightbookingsystem.flight.FlightServiceImpl;
import com.aitrich.flightbookingsystem.flightbooking.FlightBookingService;
import com.aitrich.flightbookingsystem.flightbooking.FlightBookingServiceImpl;

@ExtendWith(SpringExtension.class)
public class FlightBookingServiceTest {

	@Mock
	FlightBookingRepository flightBookingRepository;

	@InjectMocks
	FlightBookingService flightBookingService;

	public FlightBookingServiceTest() {
		flightBookingRepository = mock(FlightBookingRepository.class);
		flightBookingService = new FlightBookingServiceImpl();
	}

//	@Test
//	public void testFlightBookingSave() throws Exception {
//
//		Set<FlightEntity> flightEntities = new HashSet<FlightEntity>();
//		flightEntities.add(new FlightEntity("FT-1", "uk", "us", LocalDateTime.now(), LocalDateTime.now()));
//		flightEntities.add(new FlightEntity("FT-2", "sa", "us", LocalDateTime.now(), LocalDateTime.now()));
//		flightEntities.add(new FlightEntity("FT-3", "uk", "sa", LocalDateTime.now(), LocalDateTime.now()));
//		PassengerEntity passengerEntity = new PassengerEntity("PR-1", "safeer", "ismail", "safeer2345@gmail.com");
//		FlightBookingEntity flightBookingEntity = new FlightBookingEntity("FB-1", passengerEntity, flightEntities);
//		when(flightBookingRepository.save(flightBookingEntity)).thenReturn(flightBookingEntity);
//		FlightBookingEntity entity = flightBookingService.bookFlight(flightBookingEntity);
//		assertEquals("FB-1", entity.getId());
//		assertEquals(passengerEntity, entity.getPassengerEntity());
//		assertEquals(flightEntities, entity.getFlights());
//	}
//
//	@Test
//	public void testFlightBookingUpdate() {
//		Set<FlightEntity> flightEntities = new HashSet<FlightEntity>();
//		flightEntities.add(new FlightEntity("FT-1", "uk", "us", LocalDateTime.now(), LocalDateTime.now()));
//		flightEntities.add(new FlightEntity("FT-2", "sa", "us", LocalDateTime.now(), LocalDateTime.now()));
//		flightEntities.add(new FlightEntity("FT-3", "uk", "sa", LocalDateTime.now(), LocalDateTime.now()));
//		PassengerEntity passengerEntity = new PassengerEntity("PR-1", "safeer", "ismail", "safeer2345@gmail.com");
//		FlightBookingEntity flightBookingEntity = new FlightBookingEntity("FB-1", passengerEntity, flightEntities);
//		when(flightBookingRepository.save(flightBookingEntity)).thenReturn(flightBookingEntity);
//		FlightBookingEntity entity = flightBookingService.bookFlight(flightBookingEntity);
//		assertEquals("FB-1", entity.getId());
//		assertEquals(passengerEntity, entity.getPassengerEntity());
//		assertEquals(flightEntities, entity.getFlights());
//	}
//
//	@Test
//	public void testFindAllFlightBooking() {
//		Set<FlightEntity> flightEntities = new HashSet<FlightEntity>();
//		flightEntities.add(new FlightEntity("FT-1", "uk", "us", LocalDateTime.now(), LocalDateTime.now()));
//		flightEntities.add(new FlightEntity("FT-2", "sa", "us", LocalDateTime.now(), LocalDateTime.now()));
//		flightEntities.add(new FlightEntity("FT-3", "uk", "sa", LocalDateTime.now(), LocalDateTime.now()));
//
//		List<FlightBookingEntity> flightBookingEntities = new ArrayList<FlightBookingEntity>();
//		flightBookingEntities.add(new FlightBookingEntity("FB-1",
//				new PassengerEntity("PR-1", "safeer", "ismail", "safeer2345@gmail.com"), flightEntities));
//		flightBookingEntities.add(new FlightBookingEntity("FB-2",
//				new PassengerEntity("PR-2", "sruthi", "joes", "sruthijose@gmail.com"), flightEntities));
//		flightBookingEntities.add(new FlightBookingEntity("FB-3",
//				new PassengerEntity("PR-3", "vinaya", "mukundan", "vinayamukundan@gmail.com"), flightEntities));
//		when(flightBookingRepository.findAll()).thenReturn(flightBookingEntities);
//		List<FlightBookingEntity> entities = flightBookingService.findAllBookedFlight();
//		assertEquals(3, entities.size());
//	}
//
//	@Test
//	public void testFlightBookingFIndById() {
//
//		Set<FlightEntity> flightEntities = new HashSet<FlightEntity>();
//		flightEntities.add(new FlightEntity("FT-1", "uk", "us", LocalDateTime.now(), LocalDateTime.now()));
//		flightEntities.add(new FlightEntity("FT-2", "sa", "us", LocalDateTime.now(), LocalDateTime.now()));
//		flightEntities.add(new FlightEntity("FT-3", "uk", "sa", LocalDateTime.now(), LocalDateTime.now()));
//		PassengerEntity passengerEntity = new PassengerEntity("PR-1", "safeer", "ismail", "safeer2345@gmail.com");
//		FlightBookingEntity flightBookingEntity = new FlightBookingEntity("FB-1", passengerEntity, flightEntities);
//
//		Optional<FlightBookingEntity> optional= Optional.of(flightBookingEntity);
//		Mockito.when(flightBookingRepository.findById("FB-1")).thenReturn(optional);
//		assertAll(() -> Optional.ofNullable(flightBookingService.findBookedFlightById("FB-1"))
//				.orElseThrow(() -> new ResourceNotFoundException("test")));
//	}
//
//	@Test
//	public void testAirportFlightBooking() {
//		Set<FlightEntity> flightEntities = new HashSet<FlightEntity>();
//		flightEntities.add(new FlightEntity("FT-1", "uk", "us", LocalDateTime.now(), LocalDateTime.now()));
//		flightEntities.add(new FlightEntity("FT-2", "sa", "us", LocalDateTime.now(), LocalDateTime.now()));
//		flightEntities.add(new FlightEntity("FT-3", "uk", "sa", LocalDateTime.now(), LocalDateTime.now()));
//
//		FlightBookingEntity flightBookingEntity = new FlightBookingEntity("FB-1",
//				new PassengerEntity("PR-1", "safeer", "ismail", "safeer2345@gmail.com"), flightEntities);
//		flightBookingService.deleteBookedFlight(flightBookingEntity.getId());
//		verify(flightBookingRepository, times(1)).deleteById(flightBookingEntity.getId());
//	}

}
