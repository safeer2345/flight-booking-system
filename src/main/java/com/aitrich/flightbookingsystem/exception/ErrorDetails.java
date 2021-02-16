package com.aitrich.flightbookingsystem.exception;

import java.util.Date;


import org.springframework.http.HttpStatus;

public class ErrorDetails {

	private Date timeStamp;

	private String message;

	private HttpStatus status;

	public ErrorDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ErrorDetails(final Date timeStamp,final String message,final HttpStatus status) {
		super();
		this.timeStamp = timeStamp;
		this.message = message;
		this.status = status;

	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}



	@Override
	public String toString() {
		return "ErrorDetails [timeStamp=" + timeStamp + ", message=" + message + ", status=" + status + "]";
	}

}
