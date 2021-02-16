package com.aitrich.flightbookingsystem.airport;

public class AirportNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AirportNotFoundException(String message) {
		super(message);
	}

}
