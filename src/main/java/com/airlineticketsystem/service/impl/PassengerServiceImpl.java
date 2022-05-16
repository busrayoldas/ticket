package com.airlineticketsystem.service.impl;

import com.airlineticketsystem.dto.PassengerDto;
import com.airlineticketsystem.entity.Passenger;
import com.airlineticketsystem.mapper.PassengerMapper;
import com.airlineticketsystem.repository.PassengerRepository;
import com.airlineticketsystem.service.PassengerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerServiceImpl implements PassengerService {


    private final PassengerRepository passengerRepository;
    private  PassengerMapper passengerMapper;

    public PassengerServiceImpl(PassengerRepository passengerRepository, PassengerMapper passengerMapper) {
        this.passengerRepository = passengerRepository;
        this.passengerMapper = passengerMapper;
    }


    @Override
    public PassengerDto savePassenger(PassengerDto passengerDto) {
        return passengerMapper.entityToDto(passengerRepository.save(passengerMapper.convertToEntity(passengerDto)));
    }

    @Override
    public List<PassengerDto> getAllPassenger() {
        return passengerMapper.entityToDtoList(passengerRepository.findAll());
    }

    @Override
    public PassengerDto getPassengerById(Long passengerId) {
        return passengerMapper.entityToDto(passengerRepository.findById(passengerId).get());
    }

    @Override
    public void deletePassengerById(Long passengerId) {
        passengerRepository.deleteById(passengerId);
    }
}
