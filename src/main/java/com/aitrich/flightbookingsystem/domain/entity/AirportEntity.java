package com.aitrich.flightbookingsystem.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "airport")
public class AirportEntity {

	@Id
	private String iataCode;
	@NotBlank
	private String name;
	@NotBlank
	private String countryIsoCode;

	public AirportEntity() {
		super();
	}

	public AirportEntity(String iataCode, String name, String countryIsoCode) {
		super();
		this.iataCode = iataCode;
		this.name = name;
		this.countryIsoCode = countryIsoCode;
	}

	public String getIataCode() {
		return iataCode;
	}

	public void setIataCode(String iataCode) {
		this.iataCode = iataCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountryIsoCode() {
		return countryIsoCode;
	}

	public void setCountryIsoCode(String countryIsoCode) {
		this.countryIsoCode = countryIsoCode;
	}

}
