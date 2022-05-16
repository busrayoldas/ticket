package com.airlineticketsystem.service;

import com.airlineticketsystem.dto.FlightDto;

import java.util.List;


public interface FlightService {


    FlightDto saveFlight(FlightDto flightDto);

    List<FlightDto> getAllFlight();

    FlightDto getFlightById(Long flightId);

    void deleteFlightById(Long flightId);
}
