package com.aitrich.flightbookingsystem.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aitrich.flightbookingsystem.domain.entity.AirportEntity;

public interface AirportRepository extends JpaRepository<AirportEntity, String> {

}
