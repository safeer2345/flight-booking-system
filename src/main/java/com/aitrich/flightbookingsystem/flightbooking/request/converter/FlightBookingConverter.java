package com.aitrich.flightbookingsystem.flightbooking.request.converter;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.aitrich.flightbookingsystem.domain.entity.FlightBookingEntity;
import com.aitrich.flightbookingsystem.flightbooking.request.FlightBookingCreateRequest;

@Component
public class FlightBookingConverter {

	List<FlightBookingCreateRequest> flightBookingModelList = new ArrayList<FlightBookingCreateRequest>();
	List<FlightBookingEntity> flightBookingEntityList = new ArrayList<FlightBookingEntity>();

	public FlightBookingCreateRequest toFlightBookingModel(FlightBookingEntity flightBookingEntity) {
		ModelMapper modelMapper = new ModelMapper();
		FlightBookingCreateRequest flightBookingCreateRequest = modelMapper.map(flightBookingEntity, FlightBookingCreateRequest.class);
		return flightBookingCreateRequest;
	}

	public FlightBookingEntity toFlightBookingEntity(FlightBookingCreateRequest flightBookingCreateRequest) {
		ModelMapper modelMapper = new ModelMapper();
		FlightBookingEntity flightBookingEntity = modelMapper.map(flightBookingCreateRequest, FlightBookingEntity.class);
		return flightBookingEntity;
	}

	public List<FlightBookingCreateRequest> toFlightBookingModelList(List<FlightBookingEntity> flightBookingEntity) {
		flightBookingEntity.forEach(obj -> {
			this.flightBookingModelList.add(toFlightBookingModel(obj));
		});
		return this.flightBookingModelList;
	}

	public List<FlightBookingEntity> toFlightBookingEntityList(List<FlightBookingCreateRequest> flightBookingModelList) {
		flightBookingModelList.forEach(obj -> {
			this.flightBookingEntityList.add(toFlightBookingEntity(obj));
		});
		return this.flightBookingEntityList;
	}

}
