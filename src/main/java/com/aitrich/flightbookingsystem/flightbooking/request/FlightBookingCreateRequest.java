package com.aitrich.flightbookingsystem.flightbooking.request;








import javax.validation.constraints.NotBlank;




import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class FlightBookingCreateRequest {

	@NotBlank
	private String passengerId;
	@NotBlank
	private String departure;
	@NotBlank
	private String arrival;
	@NotBlank
	private String departureDate;
	@NotBlank
	private String arrivalDate;

}
