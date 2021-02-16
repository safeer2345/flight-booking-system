package com.aitrich.flightbookingsystem.test.airport;


import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import com.aitrich.flightbookingsystem.airport.AirportService;
import com.aitrich.flightbookingsystem.airport.AirportServiceImpl;
import com.aitrich.flightbookingsystem.domain.entity.AirportEntity;
import com.aitrich.flightbookingsystem.domain.repository.AirportRepository;
import com.aitrich.flightbookingsystem.exception.ResourceNotFoundException;

@ExtendWith(SpringExtension.class)
public class AirportServiceTest {

	@Mock
	AirportRepository airportRepository;

	@InjectMocks
	AirportService airportService;

    private TestEntityManager entityManager;

	public AirportServiceTest() {
		airportService = new AirportServiceImpl();
		airportRepository = mock(AirportRepository.class);
		entityManager=mock(TestEntityManager.class);
	}
	
//	@BeforeAll
//	public static void setUP()
//	{
//		List<AirportEntity> airportEntities = new ArrayList<AirportEntity>();
//		airportEntities.add(new AirportEntity("koc", "koc-ind", "kochin"));
//		airportEntities.add(new AirportEntity("clt", "clt-ind", "calicut"));
//		airportEntities.add(new AirportEntity("tvm", "tvm-ind", "trivandrum"));
//		
//		airportRepository.saveAll(airportEntities);
//	}
//	
//	 @AfterAll
//	    public static void release() {
//		 airportRepository.deleteAll();
//	    
//	    }
//
//	@Test
//	public void testAirportSave() {
//		AirportEntity airportEntity = new AirportEntity("koc", "koc-ind", "kochin");
//		when(airportRepository.save(airportEntity)).thenReturn(airportEntity);
//		AirportEntity entity = airportService.saveAirport(airportEntity);
//		assertEquals("koc", entity.getIataCode());
//		assertEquals("koc-ind", entity.getName());
//		assertEquals("kochin", entity.getCountryIsoCode());
//	}
//
//	@Test
//	public void testAirportUpdate() {
//		AirportEntity airportEntity = new AirportEntity("koc", "koc-ind", "kochin");
//		when(airportRepository.save(airportEntity)).thenReturn(airportEntity);
//		AirportEntity entity = airportService.updateAirport(airportEntity);
//		assertEquals("koc", entity.getIataCode());
//		assertEquals("koc-ind", entity.getName());
//		assertEquals("kochin", entity.getCountryIsoCode());
//	}
//
//	@Test
//	public void testFindAllAirport() {
//		List<AirportEntity> airportEntities = new ArrayList<AirportEntity>();
//		airportEntities.add(new AirportEntity("koc", "koc-ind", "kochin"));
//		airportEntities.add(new AirportEntity("clt", "clt-ind", "calicut"));
//		airportEntities.add(new AirportEntity("tvm", "tvm-ind", "trivandrum"));
//		when(airportRepository.findAll()).thenReturn(airportEntities);
//		List<AirportEntity> entities = airportService.findAllAirport();
//		assertEquals(3, entities.size());
//	}

//	@Test()
//	public void testAirportFIndById() throws ResourceNotFoundException{
		
//		when(airportRepository.findById("koc").get()).thenReturn(airportEntity);
//		AirportEntity entity = airportService.findAirportById(airportEntity.getIataCode());
//		assertEquals("koc", entity.getIataCode());
		//when(airportRepository.findById("koc").get()).thenReturn(airportEntity);
//		when(airportRepository.findById("koc").get()).thenReturn(airportEntity);
//		doReturn(airportEntity).when(airportRepository).findById(airportEntity.getIataCode()).get();

		
//		AirportEntity airportEntity = new AirportEntity("koc", "koc-ind", "kochin");
		//entityManager.persist(new AirportEntity("koc", "koc-ind", "kochin"));
//		Mockito.when(airportRepository.findById(airportEntity.getIataCode()).get()).thenReturn(airportEntity);
		//AirportEntity entity= airportService.findAirportById("koc");
//		assertAll(() -> Optional
//	    	      .ofNullable(airportService.findAirportById("koc"))
//	    	      .orElseThrow(()->new ResourceNotFoundException("test"))); 
		
//		AirportEntity entity= Optional
//	    	      .ofNullable(airportService.findAirportById("koc"))
//	    	      .orElseThrow(()->new ResourceNotFoundException("test")); 
		//assertThat("result",entity,is(sameInstance(airportEntity)));
		//verify(airportRepository).findById("koc");
		//AirportEntity entity=airportRepository.findById("koc").get();
//		assertEquals(entity.getIataCode(), "koc");
		//airportService.findAirportById("a");
		//verify(airportRepository).findById("a");
//		entityManager.persistAndFlush(airportEntity);
//		AirportEntity entity=airportRepository.findById("koc").orElseThrow(() -> new ResourceNotFoundException("test"));
//		assertThat(entity.getIataCode()).isEqualTo("koc");
		
		//000000000Mockito.when(airportRepository.findById(airportEntity.getIataCode())).thenReturn(airportEntity);
		
//		assertAll(() -> Optional
//	      .ofNullable(airportService.findAirportById("koc"))
//	      .orElseThrow(()->new ResourceNotFoundException("test"))); 
		
//		 Optional<Object> objectList = Optional.of(new AirportEntity());              
//         given(airportRepository.findById(Mockito.anyString())).willReturn(objectList); 
//         Object returnedObject = airportService.findAirportById("koc");
//         Mockito.verify(airportRepository).findById(Mockito.anyString());
//         assertNotNull(returnedObject);
		
//	0000000	assertAll(() -> Optional
//			      .ofNullable(airportService.findAirportById("koc"))
//			      .orElseThrow(()->new ResourceNotFoundException("test")));
		
//		AirportEntity entity= airportRepository.findById("1").get();
//		AirportEntity entityObj=airportService.findAirportById("1");
//		assertEquals(entity.getIataCode(), entityObj.getIataCode());
		
//		final AirportEntity airportEntity = new AirportEntity("koc", "koc-ind", "kochin");
//		 Optional<AirportEntity> optionalEntityType = Optional.of(airportEntity);
//		 Mockito.when(airportRepository.findById("koc")).thenReturn(optionalEntityType);
		 
//		 assertAll(() -> Optional
//			      .ofNullable(airportService.findAirportById("koc"))
//			      .orElseThrow(()->new ResourceNotFoundException("test")));
//		 assertThat(airportService.findAirportById("koc")).isNotNull();  
	
//		 Mockito.verify(airportService).findAirportById("koc");
//	}

//	@Test
//	public void testAirportDeleteById() {
//		AirportEntity airportEntity = new AirportEntity("koc", "koc-ind", "kochin");
//		airportService.deleteAirport(airportEntity.getIataCode());
//		verify(airportRepository, times(1)).deleteById(airportEntity.getIataCode());
//
//	}

}
