package com.aitrich.flightbookingsystem.test.passenger;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.aitrich.flightbookingsystem.airport.AirportController;
import com.aitrich.flightbookingsystem.airport.AirportService;
import com.aitrich.flightbookingsystem.airport.AirportServiceImpl;
import com.aitrich.flightbookingsystem.domain.entity.AirportEntity;
import com.aitrich.flightbookingsystem.domain.entity.PassengerEntity;
import com.aitrich.flightbookingsystem.domain.repository.FlightBookingRepository;
import com.aitrich.flightbookingsystem.domain.repository.PassengerRepository;
import com.aitrich.flightbookingsystem.flightbooking.FlightBookingService;
import com.aitrich.flightbookingsystem.flightbooking.FlightBookingServiceImpl;
import com.aitrich.flightbookingsystem.passenger.PassengerController;
import com.aitrich.flightbookingsystem.passenger.PassengerService;
import com.aitrich.flightbookingsystem.passenger.PassengerServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
//@ContextConfiguration(classes = {TestContext.class})
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
//@WebAppConfiguration
//@WebMvcTest(controllers = PassengerController.class)
public class PassengerControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
//	@Autowired
//	private WebApplicationContext webApplicationContext;
//	
//	private MockMvc mockMvc;

	@InjectMocks
	private PassengerController passengerController;

@InjectMocks
//	@MockBean
	private PassengerService passengerService;
	@Mock
	private PassengerRepository passengerRepository;

	public PassengerControllerTest() {

		//MockitoAnnotations.initMocks(this);
		//mockMvc = MockMvcBuilders.standaloneSetup(PassengerController.class).build();
		//mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		
//		mockMvc = MockMvcBuilders
//		        .standaloneSetup(new PassengerController())
//		        .build();
		passengerRepository = mock(PassengerRepository.class);
		// passengerService = mock(PassengerServiceImpl.class);
		// passengerController=new PassengerController(passengerService);
		passengerService = new PassengerServiceImpl(new FlightBookingServiceImpl(), passengerRepository);
	}
	

	//@Test
	public void passengerSaveTest() throws JsonProcessingException, Exception {
		String uri = "/passengercontroller/savePassenger";
		PassengerEntity passengertEntity = new PassengerEntity("PR-1", "safeer", "ismail", "safeer2345@gmail.com", null);
		when(passengerService.savePassenger(Mockito.any(PassengerEntity.class))).thenReturn(passengertEntity);
		mockMvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON).content(toJson(passengertEntity)))
				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.id", is("PR-1"))).andExpect(jsonPath("$.firstName", is("safeer")))
				.andExpect(jsonPath("$.lastName", is("ismail")))
				.andExpect(jsonPath("$.email", is("safeer2345@gmail.com")));
	}

	// @Test
	public void passengerUpdateTest() throws JsonProcessingException, Exception {
		String uri = "/passengercontroller/updatePassenger";
		PassengerEntity passengertEntity = new PassengerEntity("PR-1", "safeer", "ismail", "safeer2345@gmail.com", null);
		when(passengerService.updatePassenger(Mockito.any(PassengerEntity.class))).thenReturn(passengertEntity);
		mockMvc.perform(post(uri).contentType(MediaType.APPLICATION_JSON).content(toJson(passengertEntity)))
				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.id", is("PR-1"))).andExpect(jsonPath("$.firstName", is("safeer")))
				.andExpect(jsonPath("$.lastName", is("ismail")))
				.andExpect(jsonPath("$.email", is("safeer2345@gmail.com")));
	}

	// @Test
	public void findAllPassengerTest() throws Exception {
		String uri = "/passengercontroller/findAllPassenger";
		List<PassengerEntity> passengerEntities = new ArrayList<>();
		passengerEntities.add(new PassengerEntity("PR-1", "safeer", "ismail", "safeer2345@gmail.com", null));
		passengerEntities.add(new PassengerEntity("PR-2", "sruthi", "joes", "sruthijose@gmail.com", null));
		passengerEntities.add(new PassengerEntity("PR-3", "vinaya", "mukundan", "vinayamukundan@gmail.com", null));
////		when(passengerService.findAllPassenger()).thenReturn(passengerEntities);
//		passengerService.findAllPassenger();
//		when(passengerRepository.findAll()).thenReturn(passengerEntities);
//		// Mockito.doReturn(passengerEntities).when(passengerService).findAllPassenger();
//		// Mockito.doReturn(passengerEntities).when(passengerRepository).findAll();
//		// given(passengerService.findAllPassenger()).willReturn(Arrays.asList(passengertEntity));
//		mockMvc.perform(get(uri)).andExpect(status().isOk()).andExpect(jsonPath("$[*]", hasSize(3)))
//				.andExpect(jsonPath("$[0].firstName", is("safeer"))).andExpect(jsonPath("$[0].lastName", is("ismail")))
//				.andExpect(jsonPath("$[0].email", is("safeer2345@gmail.com")))
//				.andExpect(jsonPath("$[1].firstName", is("sruthi"))).andExpect(jsonPath("$[1].lastName", is("joes")))
//				.andExpect(jsonPath("$[1].email", is("sruthijose@gmail.com")))
//				.andExpect(jsonPath("$[2].firstName", is("vinaya")))
//				.andExpect(jsonPath("$[2].lastName", is("mukundan")))
//				.andExpect(jsonPath("$[2].email", is("vinayamukundan@gmail.com")));
//
//		verify(passengerService, times(1)).findAllPassenger();
//		verifyNoMoreInteractions(passengerService);
		
		
		
		
		when(passengerService.findAllPassenger()).thenReturn(passengerEntities);

	        this.mockMvc.perform(get(uri))
	                .andExpect(status().isOk())
	                .andExpect(jsonPath("$.size()", is(passengerEntities.size())));

	}

	private String toJson(PassengerEntity Entity) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(Entity);
	}

}
