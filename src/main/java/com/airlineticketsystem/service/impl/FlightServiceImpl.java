package com.airlineticketsystem.service.impl;

import com.airlineticketsystem.dto.FlightDto;
import com.airlineticketsystem.mapper.FlightMapper;
import com.airlineticketsystem.repository.FlightRepository;
import com.airlineticketsystem.service.FlightService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {


    private final FlightRepository flightRepository;
    private  FlightMapper flightMapper;

    public FlightServiceImpl(FlightRepository flightRepository, FlightMapper flightMapper) {
        this.flightRepository = flightRepository;
        this.flightMapper = flightMapper;
    }


    @Override
    public FlightDto saveFlight(FlightDto flightDto) {
        return flightMapper.entityToDto(flightRepository.save(flightMapper.convertToEntity(flightDto)));
    }

    @Override
    public List<FlightDto> getAllFlight() {
        return flightMapper.entityToDtoList(flightRepository.findAll());
    }

    @Override
    public FlightDto getFlightById(Long flightId) {
        return flightMapper.entityToDto(flightRepository.findById(flightId).get());
    }

    @Override
    public void deleteFlightById(Long flightId) {
        flightRepository.deleteById(flightId);
    }
}
