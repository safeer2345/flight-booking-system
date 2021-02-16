package com.aitrich.flightbookingsystem.domain.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "flight")
public class FlightEntity {

	@Id
	@GeneratedValue(generator = "fl-gen")
	@GenericGenerator(name = "fl-gen", parameters = @Parameter(name = "prefix", value = "FT"), strategy = "com.aitrich.flightbookingsystem.domain.util.StringSequenceIdentifierGenerator")
	private String id;

	private String departure;
	private String arrival;
	private LocalDateTime departureDate;
	private LocalDateTime arrivalDate;

	@ManyToMany( mappedBy = "flights",cascade = CascadeType.ALL , fetch = FetchType.LAZY)
	@JsonIgnore 
	private Set<FlightBookingEntity> flightBookings;

	public FlightEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FlightEntity(String id, String departure, String arrival, LocalDateTime departureDate,
			LocalDateTime arrivalDate) {
		super();
		this.id = id;
		this.departure = departure;
		this.arrival = arrival;
		this.departureDate = departureDate;
		this.arrivalDate = arrivalDate;
	}

	@NotBlank
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
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

	public Set<FlightBookingEntity> getFlightBookings() {
		return flightBookings;
	}

	public void setFlightBookings(Set<FlightBookingEntity> flightBookings) {
		this.flightBookings = flightBookings;
	}

	/*
	 * public void removeFlight(FlightBookingEntity flightBookingEntity) {
	 * this.getFlightBookings().remove(flightBookingEntity);
	 * flightBookingEntity.getFlights().remove(this);
	 * flightBookingEntity.getPassengerEntity(); }
	 * 
	 * public void removeFlight() { for (FlightBookingEntity flightBookingEntity :
	 * new HashSet<>(flightBookings)) { removeFlight(flightBookingEntity); } }
	 */

	@Override
	public String toString() {
		return "FlightEntity [id=" + id + ", departure=" + departure + ", arrival=" + arrival + ", departureDate="
				+ departureDate + ", arrivalDate=" + arrivalDate + "]";
	}

}
