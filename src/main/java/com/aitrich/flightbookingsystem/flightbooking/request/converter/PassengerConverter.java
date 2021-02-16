package com.aitrich.flightbookingsystem.flightbooking.request.converter;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.aitrich.flightbookingsystem.domain.entity.PassengerEntity;
import com.aitrich.flightbookingsystem.flightbooking.request.PassengerModel;

@Component
public class PassengerConverter {

	List<PassengerModel> PassengerModelList = new ArrayList<PassengerModel>();
	List<PassengerEntity> passengerEntityList = new ArrayList<PassengerEntity>();

	public PassengerModel toPassengerModel(PassengerEntity passengerEntity) {
		ModelMapper modelMapper = new ModelMapper();
		PassengerModel passengerModel = modelMapper.map(passengerEntity, PassengerModel.class);
		return passengerModel;
	}

	public PassengerEntity toPassengerEntity(PassengerModel passengerModel) {
		ModelMapper modelMapper = new ModelMapper();
		PassengerEntity passengerEntity = modelMapper.map(passengerModel, PassengerEntity.class);
		return passengerEntity;
	}

	public List<PassengerModel> toPassengerModelList(List<PassengerEntity> entityList) {
		entityList.forEach(obj -> {
			this.PassengerModelList.add(toPassengerModel(obj));
		});
		return this.PassengerModelList;
	}

	public List<PassengerEntity> toPassengerEntityList(List<PassengerModel> modelList) {
		modelList.forEach(obj -> {
			this.passengerEntityList.add(toPassengerEntity(obj));
		});
		return this.passengerEntityList;
	}

}
