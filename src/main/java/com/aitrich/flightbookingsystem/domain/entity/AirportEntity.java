package com.aitrich.flightbookingsystem.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Entity
@Table(name = "airport")
public class AirportEntity {

	@Id
	private String iataCode;
	@NotBlank
	private String name;
	@NotBlank
	private String countryIsoCode;

}
