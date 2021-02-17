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

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
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
}
