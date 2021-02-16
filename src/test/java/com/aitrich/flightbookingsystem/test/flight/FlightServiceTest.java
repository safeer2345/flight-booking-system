package com.aitrich.flightbookingsystem.test.flight;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.aitrich.flightbookingsystem.domain.entity.FlightEntity;
import com.aitrich.flightbookingsystem.domain.repository.FlightRepository;
import com.aitrich.flightbookingsystem.exception.ResourceNotFoundException;
import com.aitrich.flightbookingsystem.flight.FlightService;
import com.aitrich.flightbookingsystem.flight.FlightServiceImpl;


@ExtendWith(SpringExtension.class)
public class FlightServiceTest {
	
	@Mock
	FlightRepository flightRepository;

	@InjectMocks
	FlightService flightService;

	public FlightServiceTest() {
		flightRepository = mock(FlightRepository.class);
		flightService = new FlightServiceImpl();
	}

	//@Test
	public void testPersonSave() {
		FlightEntity flightEntity = new FlightEntity("FT-1","uk","us",LocalDateTime.parse("2021-02-12T23:34:36.410"),LocalDateTime.parse("2021-02-12T23:34:36.410"));
		when(flightRepository.save(flightEntity)).thenReturn(flightEntity);
		FlightEntity entity = flightService.saveFlight(flightEntity);
		assertEquals("FT-1", entity.getId());
		assertEquals("uk", entity.getDeparture());
		assertEquals("us", entity.getArrival());
		assertEquals(LocalDateTime.parse("2021-02-12T23:34:36.410"), entity.getDepartureDate());
		assertEquals(LocalDateTime.parse("2021-02-12T23:34:36.410"), entity.getArrivalDate());
	}
//
//	@Test
//	public void testPersonUpdate() {
//		FlightEntity flightEntity = new FlightEntity("FT-1","uk","us",LocalDateTime.parse("2021-02-12T23:34:36.410"),LocalDateTime.parse("2021-02-12T23:34:36.410"));
//		when(flightRepository.save(flightEntity)).thenReturn(flightEntity);
//		FlightEntity entity = flightService.saveFlight(flightEntity);
//		assertEquals("FT-1", entity.getId());
//		assertEquals("uk", entity.getDeparture());
//		assertEquals("us", entity.getArrival());
//		assertEquals(LocalDateTime.parse("2021-02-12T23:34:36.410"), entity.getDepartureDate());
//		assertEquals(LocalDateTime.parse("2021-02-12T23:34:36.410"), entity.getArrivalDate());
//	}
//
//	@Test
//	public void testFindAllAirport() {
//		List<FlightEntity> flightEntities = new ArrayList<FlightEntity>();
//		flightEntities.add(new FlightEntity("FT-1","uk","us",LocalDateTime.now(),LocalDateTime.now()));
//		flightEntities.add(new FlightEntity("FT-2","sa","us",LocalDateTime.now(),LocalDateTime.now()));
//		flightEntities.add(new FlightEntity("FT-3","uk","sa",LocalDateTime.now(),LocalDateTime.now()));
//		when(flightRepository.findAll()).thenReturn(flightEntities);
//		List<FlightEntity> entities = flightService.findAllFlight();
//		assertEquals(3, entities.size());
//	}
//
//	@Test
//	public void testAirportFIndById() {
//		FlightEntity flightEntity = new FlightEntity("FT-1","uk","us",LocalDateTime.parse("2021-02-12T23:34:36.410"),LocalDateTime.parse("2021-02-12T23:34:36.410"));
//		Optional<FlightEntity> optional=Optional.of(flightEntity);
//		when(flightRepository.findById("FT-1")).thenReturn(optional);
//		
//		assertAll(() -> Optional
//			      .ofNullable(flightService.findFlightById("FT-1"))
//			      .orElseThrow(()->new ResourceNotFoundException("test")));
//	}
//	@Test
//	public void testAirportDeleteById() {
//		FlightEntity flightEntity = new FlightEntity("FT-1","uk","us",LocalDateTime.now(),LocalDateTime.now());
//		flightService.deleteFlight(flightEntity.getId());
//		verify(flightRepository, times(1)).deleteById(flightEntity.getId());
//	}
//

}
