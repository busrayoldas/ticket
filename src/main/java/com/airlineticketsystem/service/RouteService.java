package com.airlineticketsystem.service;

import com.airlineticketsystem.dto.RouteDto;

import java.util.List;


public interface RouteService {


    RouteDto saveRoute(RouteDto routeDto);

    List<RouteDto> getAllRoute();

    RouteDto getRouteById(Long routeId);

    void deleteRouteById(Long routeId);

    List<RouteDto> findRouteDeparture(String str);

    List<RouteDto> findRouteArrival(String str);
}
