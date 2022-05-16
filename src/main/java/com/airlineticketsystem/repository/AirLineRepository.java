package com.airlineticketsystem.repository;

import com.airlineticketsystem.entity.AirLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AirLineRepository extends JpaRepository<AirLine, Long> {

    @Query(value = "select a from AirLine a where a.name like :name")
    List<AirLine> findAirLine(@Param("name") String name);


}