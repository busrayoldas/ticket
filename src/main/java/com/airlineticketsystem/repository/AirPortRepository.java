package com.airlineticketsystem.repository;

import com.airlineticketsystem.entity.AirPort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AirPortRepository extends JpaRepository<AirPort, Long> {

    @Query(value = "select a from AirPort a where a.name like :name")
    List<AirPort> findAirPort(@Param("name") String name);

}