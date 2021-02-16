  package com.aitrich.flightbookingsystem.domain.entity;


import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "flight_booked_passenger")
public class FlightBookingEntity {

	@Id
	@GeneratedValue(generator = "ft-bk-gen")
	@GenericGenerator(name = "ft-bk-gen", parameters = @Parameter(name = "prefix", value = "FB"), strategy = "com.aitrich.flightbookingsystem.domain.util.StringSequenceIdentifierGenerator")
	private String id;

	@ManyToOne(fetch = FetchType.LAZY)
	PassengerEntity passengerEntity;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "booked_flights", joinColumns = @JoinColumn(name = "booking_id"), inverseJoinColumns = @JoinColumn(name = "flight_id"))
	@JsonIgnore 
	private Set<FlightEntity> flights;

	public FlightBookingEntity() {
		super();
		// TODO Auto-generated constructor stub
	}



	public FlightBookingEntity(String id, PassengerEntity passengerEntity, Set<FlightEntity> flights) {
		super();
		this.id = id;
		this.passengerEntity = passengerEntity;
		this.flights = flights;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public PassengerEntity getPassengerEntity() {
		return passengerEntity;
	}

	public void setPassengerEntity(PassengerEntity passengerEntity) {
		this.passengerEntity = passengerEntity;
	}

	public Set<FlightEntity> getFlights() {
		return flights;
	}

	public void setFlights(Set<FlightEntity> flights) {
		this.flights = flights;
	}
	
	/*
	 * public void removeBooking(FlightEntity flightgEntity) {
	 * this.getFlights().remove(flightgEntity);
	 * flightBookingEntity.getFlights().remove(this); }
	 * 
	 * public void removeBooking() { for (FlightEntity flightEntity : new
	 * HashSet<>(flights)) { removeBooking(flights); } }
	 */
	

	@Override
	public String toString() {
		return "FlightBookingEntity [id=" + id + ", passengerEntity=" + passengerEntity + "]";
	}

	
}
