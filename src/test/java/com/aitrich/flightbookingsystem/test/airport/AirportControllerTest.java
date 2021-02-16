package com.aitrich.flightbookingsystem.test.airport;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.aitrich.flightbookingsystem.airport.AirportController;
import com.aitrich.flightbookingsystem.airport.AirportService;
import com.aitrich.flightbookingsystem.airport.AirportServiceImpl;
import com.aitrich.flightbookingsystem.domain.entity.AirportEntity;
import com.aitrich.flightbookingsystem.exception.ResourceNotFoundException;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class AirportControllerTest {

	final String BASE_URL = "http://localhost:8080/";

	@Autowired
	private MockMvc mockMvc;

	@InjectMocks
	private AirportController airportController;

	@Mock
	private AirportService airportService;

	public AirportControllerTest() {
		airportController = new AirportController();
		airportService = new AirportServiceImpl();
		// this.mockMvc = standaloneSetup(new AirportController()).build();
	}

//	@Test
	public void testAirportSave_Return200() throws Exception {

//    	AirportEntity airportEntity=new AirportEntity("koc","kochi","koc-ind");
//    	MockHttpServletRequest request = new MockHttpServletRequest();
//        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
//        when(airportService.saveAirport(airportEntity)).thenReturn(airportEntity);
//        ResponseEntity<AirportEntity> responseEntity=airportController.saveAirport(airportEntity);
//        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);

///////////////////////////////////////////////////////////////////////////////////////////////////////////   
//		AirportEntity airportEntity = new AirportEntity("koc", "kochi", "koc-ind");
//		String uri = "/airportcontroller/saveAirport";
		//String data = toJson(airportEntity);

//		when(airportService.saveAirport(Mockito.any(AirportEntity.class))).thenReturn(airportEntity);
//		 assertAll(() -> Optional
//	      .ofNullable(Mockito.when(airportService.findAirportById("koc")).thenReturn(airportEntity))
//	      .orElseThrow(()->new ResourceNotFoundException("test")));

//		 MockMvcRequestBuilders.post(uri).accept(MediaType.APPLICATION_JSON)
//				.content(data).contentType(MediaType.APPLICATION_JSON);
//		MvcResult mvcResult= mockMvc.perform(requestBuilder).andReturn();
//		MockHttpServletResponse httpServletResponse=mvcResult.getResponse();
//		String response=httpServletResponse.getContentAsString();
//		assertThat(data).isEqualTo(response);
//		assertEquals(HttpStatus.OK, httpServletResponse.getStatus());

//        this.mockMvc.perform(post("/").accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
//        .andExpect(status().isOk())
//        .andExpect(content().contentType("application/json"));

//        mockMvc.perform(post(uri)
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(toJson(airportEntity))
//        )
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.iataCode", is("koc")))
//                .andExpect(jsonPath("$.name", is("kochi")))
//                .andExpect(jsonPath("$.countryIsoCode", is("koc-ind")));

//    	 mockMvc.perform(post("/airportcontroller/saveAirport")
//    		        .contentType("application/json")
//    		        .content(objectMapper.writeValueAsString(airportEntity)))
//    		        .andExpect(status().isOk());
//    	
//    	Mockito.when(this.airportService.saveAirport(airportEntity)).thenReturn(airportEntity);
//    	 this.mockMvc.perform(post("/airportcontroller/saveAirport")
//    	            .contentType("application/json")
//    	            .accept(mediaTypes.sa)

	}

//	@Test
//	public void testAirportUpdate_Return200() throws Exception {
//
//		AirportEntity airportEntity = new AirportEntity("koc", "kochi", "koc-ind");
//
//		MockHttpServletRequest request = new MockHttpServletRequest();
//		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
//		when(airportService.updateAirport(airportEntity)).thenReturn(airportEntity);
//		when(airportService.findAirportById("koc")).thenReturn(airportEntity);
//		ResponseEntity<AirportEntity> responseEntity = airportController.updateAirport(airportEntity);
//		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
//	}

	private String toJson(AirportEntity airportEntity) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(airportEntity);
	}

}
