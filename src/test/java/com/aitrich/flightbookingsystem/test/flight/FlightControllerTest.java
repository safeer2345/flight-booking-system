package com.aitrich.flightbookingsystem.test.flight;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.aitrich.flightbookingsystem.domain.entity.FlightEntity;
import com.aitrich.flightbookingsystem.domain.entity.PassengerEntity;
import com.aitrich.flightbookingsystem.domain.repository.FlightRepository;
import com.aitrich.flightbookingsystem.flight.FlightService;
import com.aitrich.flightbookingsystem.flight.FlightServiceImpl;
import com.aitrich.flightbookingsystem.passenger.PassengerController;
import com.aitrich.flightbookingsystem.passenger.PassengerService;
import com.aitrich.flightbookingsystem.passenger.PassengerServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
public class FlightControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Mock
	FlightRepository flightRepository;

	@InjectMocks
	FlightService flightService;

	public FlightControllerTest() {
		flightRepository = mock(FlightRepository.class);
		flightService = new FlightServiceImpl();
	}

	//@Test
	public void flightSaveTest() throws JsonProcessingException, Exception {
		String uri = "/flightcontroller/saveFlight";
		FlightEntity flightEntity = new FlightEntity("FT-1", "uk", "us", LocalDateTime.parse("2021-02-12T23:34:36.410"),
				LocalDateTime.parse("2021-02-12T23:34:36.410"));
		when(flightService.saveFlight(Mockito.any(FlightEntity.class))).thenReturn(flightEntity);
		mockMvc.perform(post(uri).contentType(MediaType.APPLICATION_JSON).content(toJson(flightEntity)))
				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.id", is("FT-1")))
				.andExpect(jsonPath("$.departure", is("uk")))
				.andExpect(jsonPath("$.arrival", is("us")))
				.andExpect(jsonPath("$.departureDate", is("2021-02-12T23:34:36.410")))
				.andExpect(jsonPath("$.arrivalDate", is("2021-02-12T23:34:36.410")));
	}

	private String toJson(FlightEntity flightEntity) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(flightEntity);
	}

}
