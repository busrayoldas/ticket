package com.airlineticketsystem.service;

import com.airlineticketsystem.dto.AirPortDto;

import java.util.List;


public interface AirPortService {


    AirPortDto saveAirPort(AirPortDto airPortDto);

    List<AirPortDto> getAllAirPort();

    AirPortDto getAirPortById(Long airPortId);

    void deleteAirPortById(Long airPortId);

    List<AirPortDto> findAirport(String str);
}
