package com.aitrich.flightbookingsystem.passenger.request.converter;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.aitrich.flightbookingsystem.domain.entity.PassengerEntity;
import com.aitrich.flightbookingsystem.passenger.request.PassengerCreateRequest;
import com.aitrich.flightbookingsystem.passenger.request.PassengerUpdateRequest;


@Component
public class PassengerConverter {

	List<PassengerCreateRequest> passengerRequestList = new ArrayList<PassengerCreateRequest>();
	List<PassengerEntity> passengerEntityList = new ArrayList<PassengerEntity>();

	public PassengerCreateRequest toPassengerRequest(PassengerEntity passengerEntity) {
		ModelMapper modelMapper = new ModelMapper();
		PassengerCreateRequest passengerCreateRequest = modelMapper.map(passengerEntity, PassengerCreateRequest.class);
		return passengerCreateRequest;
	}

	public PassengerEntity toPassengerEntity(PassengerCreateRequest passengerCreateRequest) {
		ModelMapper modelMapper = new ModelMapper();
		PassengerEntity passengerEntity = modelMapper.map(passengerCreateRequest, PassengerEntity.class);
		return passengerEntity;
	}

	public List<PassengerCreateRequest> toPassengerRequestList(List<PassengerEntity> entityList) {
		entityList.forEach(obj -> {
			this.passengerRequestList.add(toPassengerRequest(obj));
		});
		return this.passengerRequestList;
	}

	public List<PassengerEntity> toPassengerEntityList(List<PassengerCreateRequest> requestList) {
		requestList.forEach(obj -> {
			this.passengerEntityList.add(toPassengerEntity(obj));
		});
		return this.passengerEntityList;
	}
	
	public PassengerEntity toPassengerEntity(PassengerUpdateRequest passengerUpdateRequest) {
		ModelMapper modelMapper = new ModelMapper();
		PassengerEntity passengerEntity = modelMapper.map(passengerUpdateRequest, PassengerEntity.class);
		return passengerEntity;
	}

}
