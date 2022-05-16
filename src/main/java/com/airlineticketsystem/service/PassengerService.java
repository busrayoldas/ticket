package com.airlineticketsystem.service;

import com.airlineticketsystem.dto.PassengerDto;
import com.airlineticketsystem.entity.Passenger;

import java.util.List;


public interface PassengerService {


    PassengerDto savePassenger(PassengerDto passengerDto);

    List<PassengerDto> getAllPassenger();

    PassengerDto getPassengerById(Long passengerId);

    void deletePassengerById(Long passengerId);
}
