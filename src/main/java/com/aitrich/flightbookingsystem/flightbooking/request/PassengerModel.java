package com.aitrich.flightbookingsystem.flightbooking.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class PassengerModel {

	@NotBlank
	private String firstName;
	@NotBlank
	private String lastName;
	@NotBlank
	@Email
	private String email;

	public PassengerModel(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public PassengerModel() {
		// TODO Auto-generated constructor stub
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "PassengerModel [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}
}
