package com.aitrich.flightbookingsystem.domain.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "passenger")
public class PassengerEntity {

	@Id
	@GeneratedValue(generator = "pass-gen")
	@GenericGenerator(name = "pass-gen", parameters = @Parameter(name = "prefix", value = "PR"), strategy = "com.aitrich.flightbookingsystem.domain.util.StringSequenceIdentifierGenerator")
	private String id;

	@Column

	private String firstName;

	private String lastName;

	private String email;

	@OneToMany(mappedBy = "passengerEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	Set<FlightBookingEntity> flightBookings;

	public PassengerEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PassengerEntity(String id, String firstName, String lastName, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	@NotBlank
	public String getId() {
		return id;
	}
	
	
	public void setId(String id) {
		this.id = id;
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

	public Set<FlightBookingEntity> getFlightBookings() {
		return flightBookings;
	}

	public void setFlightBookings(Set<FlightBookingEntity> flightBookings) {
		this.flightBookings = flightBookings;
	}

	@Override
	public String toString() {
		return "PassengerEntity [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ "]";
	}

}
