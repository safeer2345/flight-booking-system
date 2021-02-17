package com.aitrich.flightbookingsystem.flight.request;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Data
public class FlightCreateRequest {
	@NotBlank
	private String departure;
	@NotBlank
	private String arrival;
	@NotNull
	private LocalDateTime departureDate;
	@NotNull
	private LocalDateTime arrivalDate;

}
