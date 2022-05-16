package com.airlineticketsystem.repository;

import com.airlineticketsystem.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RouteRepository extends JpaRepository<Route, Long> {

    @Query(value = "select a from Route a where a.departure.name like :name")
    List<Route> findRouteDeparture(@Param("name") String name);

    @Query(value = "select a from Route a where a.arrival.name like :name")
    List<Route> findRouteArrival(@Param("name") String name);


}