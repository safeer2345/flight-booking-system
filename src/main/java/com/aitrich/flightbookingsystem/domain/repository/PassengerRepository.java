package com.aitrich.flightbookingsystem.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aitrich.flightbookingsystem.domain.entity.PassengerEntity;

public interface PassengerRepository extends JpaRepository<PassengerEntity, String> {
	
	

}
