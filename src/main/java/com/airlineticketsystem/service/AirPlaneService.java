package com.airlineticketsystem.service;

import com.airlineticketsystem.dto.AirPlaneDto;

import java.util.List;


public interface AirPlaneService {


    AirPlaneDto saveAirPlane(AirPlaneDto airPlaneDto);

    List<AirPlaneDto> getAllAirPlane();

    AirPlaneDto getAirPlaneById(Long airPlaneId);

    void deleteAirPlaneById(Long airPlaneId);
}
