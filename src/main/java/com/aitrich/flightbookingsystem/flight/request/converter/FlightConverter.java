package com.aitrich.flightbookingsystem.flight.request.converter;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.aitrich.flightbookingsystem.domain.entity.FlightEntity;
import com.aitrich.flightbookingsystem.flight.request.FlightCreateRequest;
import com.aitrich.flightbookingsystem.flight.request.FlightUpdateRequest;

@Component
public class FlightConverter {

	List<FlightCreateRequest> flightCreateRequestList = new ArrayList<FlightCreateRequest>();
	List<FlightEntity> flightEntityList = new ArrayList<FlightEntity>();

	public FlightCreateRequest toFlightrequest(FlightEntity flightEntity) {
		ModelMapper modelMapper = new ModelMapper();
		FlightCreateRequest flightCreateRequest = modelMapper.map(flightEntity, FlightCreateRequest.class);
		return flightCreateRequest;
	}

	public FlightEntity toFlightEntity(FlightCreateRequest flightCreateRequest) {
		ModelMapper modelMapper = new ModelMapper();
		FlightEntity flightEntity = modelMapper.map(flightCreateRequest, FlightEntity.class);
		return flightEntity;
	}

	public List<FlightCreateRequest> toFlightRequestList(List<FlightEntity> flightEntityList) {
		flightEntityList.forEach(obj -> {
			this.flightCreateRequestList.add(toFlightrequest(obj));
		});
		return this.flightCreateRequestList;
	}

	public List<FlightEntity> toFlightEntityList(List<FlightCreateRequest> flightCreateRequestList) {
		flightCreateRequestList.forEach(obj -> {
			this.flightEntityList.add(toFlightEntity(obj));
		});
		return this.flightEntityList;
	}
	
	
	public FlightEntity toFlightEntity(FlightUpdateRequest flightUpdateRequest) {
		ModelMapper modelMapper = new ModelMapper();
		FlightEntity flightEntity = modelMapper.map(flightUpdateRequest, FlightEntity.class);
		return flightEntity;
	}

}
