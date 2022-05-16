package com.airlineticketsystem.repository;

import com.airlineticketsystem.entity.AirPlane;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirPlaneRepository extends JpaRepository<AirPlane, Long> {
}