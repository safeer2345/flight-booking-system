package com.aitrich.flightbookingsystem.domain.entity;

import java.time.LocalDateTime;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.ManyToMany;
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
}
