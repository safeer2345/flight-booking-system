package com.aitrich.flightbookingsystem.flightbooking.request;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import com.aitrich.flightbookingsystem.domain.entity.PassengerEntity;

public class FlightBookingCreateRequest {

	@NotNull
	@Valid
	private PassengerEntity passenger;
	
	private List<@NotNull @Valid FlightRequest> flights;

	public FlightBookingCreateRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FlightBookingCreateRequest(PassengerEntity passenger, List<FlightRequest> flights) {
		super();
		this.passenger = passenger;
		this.flights = flights;
	}

	public PassengerEntity getPassenger() {
		return passenger;
	}

	public void setPassenger(PassengerEntity passenger) {
		this.passenger = passenger;
	}

	public List<FlightRequest> getFlights() {
		return flights;
	}

	public void setFlights(List<FlightRequest> flights) {
		this.flights = flights;
	}

	@Override
	public String toString() {
		return "FlightBookingModel [passenger=" + passenger + ", flights=" + flights + "]";
	}

//	public FlightBookingModel(String id, PassengerModel passenger, List<FlightModel> flights) {
//		super();
//		this.id = id;
//		this.passenger = passenger;
//		this.flights = flights;
//	}
//
//	public String getId() {
//		return id;
//	}
//
//	public void setId(String id) {
//		this.id = id;
//	}
//
//	public PassengerModel getPassenger() {
//		return passenger;
//	}
//
//	public void setPassenger(PassengerModel passenger) {
//		this.passenger = passenger;
//	}
//
//	public List<FlightModel> getFlights() {
//		return flights;
//	}
//
//	public void setFlights(List<FlightModel> flights) {
//		this.flights = flights;
//	}

}
