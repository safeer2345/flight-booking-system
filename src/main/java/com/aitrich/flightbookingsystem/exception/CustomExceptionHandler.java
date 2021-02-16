package com.aitrich.flightbookingsystem.exception;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.aitrich.flightbookingsystem.airport.AirportNotFoundException;
import com.aitrich.flightbookingsystem.passenger.PassengerNotFoundException;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

//	@ExceptionHandler(PassengerNotFoundException.class)
//	public ResponseEntity<Object> passengerNotFoundExceptionHandler(Exception ex, WebRequest request) {
//		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), HttpStatus.NOT_FOUND);
//		return new ResponseEntity<Object>(errorDetails, new HttpHeaders(), errorDetails.getStatus());
//	}
//
//	@ExceptionHandler(AirportNotFoundException.class)
//	public ResponseEntity<Object> airportNotFoundExceptionHandler(Exception ex, WebRequest request) {
//		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), HttpStatus.NOT_FOUND);
//		return new ResponseEntity<Object>(errorDetails, new HttpHeaders(), errorDetails.getStatus());
//	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Object> resourceNotFoundExceptionHandler(Exception ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), HttpStatus.NOT_FOUND);
		return new ResponseEntity<Object>(errorDetails, new HttpHeaders(), errorDetails.getStatus());
	}
	
	@ExceptionHandler(DuplicateResourceExcepion.class)
	public ResponseEntity<Object> duplicateResourceExcepionHandler(Exception ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), HttpStatus.BAD_REQUEST);
		return new ResponseEntity<Object>(errorDetails, new HttpHeaders(), errorDetails.getStatus());
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), "validation error", HttpStatus.BAD_REQUEST);
		return new ResponseEntity<Object>(errorDetails, new HttpHeaders(), errorDetails.getStatus());
	}

}
