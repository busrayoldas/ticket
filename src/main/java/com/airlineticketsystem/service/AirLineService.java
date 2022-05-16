package com.airlineticketsystem.service;

import com.airlineticketsystem.dto.AirLineDto;

import java.util.List;


public interface AirLineService {


    AirLineDto saveAirLine(AirLineDto airLineDto);

    List<AirLineDto> getAllAirLine();

    AirLineDto getAirLineById(Long airLineId);

    void deleteAirLineById(Long airLineId);
    
    List<AirLineDto> findAirLine(String str);
}
