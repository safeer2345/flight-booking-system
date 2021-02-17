package com.aitrich.flightbookingsystem.flightbooking.request;

import java.time.LocalDateTime;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;



import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
@ToString
public class FlightBookingFlightRequest {

	@NotBlank
	private String departure;
	@NotBlank
	private String arrival;
	@NotNull
	private LocalDateTime departureDate;
	@NotNull
	private LocalDateTime arrivalDate;

}
