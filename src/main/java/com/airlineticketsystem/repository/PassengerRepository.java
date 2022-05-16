package com.airlineticketsystem.repository;

import com.airlineticketsystem.entity.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {
}