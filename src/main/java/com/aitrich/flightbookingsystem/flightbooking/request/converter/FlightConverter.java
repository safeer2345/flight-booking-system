package com.aitrich.flightbookingsystem.flightbooking.request.converter;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.aitrich.flightbookingsystem.domain.entity.FlightEntity;
import com.aitrich.flightbookingsystem.flightbooking.request.FlightRequest;

@Component
public class FlightConverter {

	List<FlightRequest> flightModelList = new ArrayList<FlightRequest>();
	List<FlightEntity> flightEntityList = new ArrayList<FlightEntity>();

	public FlightRequest toFlightModel(FlightEntity flightEntity) {
		ModelMapper modelMapper = new ModelMapper();
		FlightRequest flightRequest = modelMapper.map(flightEntity, FlightRequest.class);
		return flightRequest;
	}

	public FlightEntity toFlightEntity(FlightRequest flightRequest) {
		ModelMapper modelMapper = new ModelMapper();
		FlightEntity flightEntity = modelMapper.map(flightRequest, FlightEntity.class);
		return flightEntity;
	}

	public List<FlightRequest> toFlightModelList(List<FlightEntity> flightEntityList) {
		flightEntityList.forEach(obj -> {
			this.flightModelList.add(toFlightModel(obj));
		});
		return this.flightModelList;
	}

	public List<FlightEntity> toFlightEntityList(List<FlightRequest> flightModelList) {
		flightModelList.forEach(obj -> {
			this.flightEntityList.add(toFlightEntity(obj));
		});
		return this.flightEntityList;
	}

}
