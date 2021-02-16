package com.aitrich.flightbookingsystem.flightbooking.request;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class FlightRequest {

	@NotBlank
	private String departure;
	@NotBlank
	private String arrival;
	@NotNull
	private LocalDateTime departureDate;
	@NotNull
	private LocalDateTime arrivalDate;

	public FlightRequest() {
	}

	public FlightRequest(String departure, String arrival, LocalDateTime departureDate, LocalDateTime arrivalDate) {
		super();
		this.departure = departure;
		this.arrival = arrival;
		this.departureDate = departureDate;
		this.arrivalDate = arrivalDate;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getArrival() {
		return arrival;
	}

	public void setArrival(String arrival) {
		this.arrival = arrival;
	}

	public LocalDateTime getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(LocalDateTime departureDate) {
		this.departureDate = departureDate;
	}

	public LocalDateTime getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(LocalDateTime arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	@Override
	public String toString() {
		return "FlightModel [departure=" + departure + ", arrival=" + arrival + ", departureDate=" + departureDate
				+ ", arrivalDate=" + arrivalDate + "]";
	}

}
