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

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
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
	private Set<FlightEntity> flights;
	
}
