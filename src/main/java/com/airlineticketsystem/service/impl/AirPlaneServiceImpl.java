package com.airlineticketsystem.service.impl;

import com.airlineticketsystem.dto.AirPlaneDto;
import com.airlineticketsystem.mapper.AirPlaneMapper;
import com.airlineticketsystem.repository.AirPlaneRepository;
import com.airlineticketsystem.service.AirPlaneService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirPlaneServiceImpl implements AirPlaneService {


    private final AirPlaneRepository airPlaneRepository;
    private  AirPlaneMapper airPlaneMapper;

    public AirPlaneServiceImpl(AirPlaneRepository airPlaneRepository, AirPlaneMapper airPlaneMapper) {
        this.airPlaneRepository = airPlaneRepository;
        this.airPlaneMapper = airPlaneMapper;
    }


    @Override
    public AirPlaneDto saveAirPlane(AirPlaneDto airPlaneDto) {
        return airPlaneMapper.entityToDto(airPlaneRepository.save(airPlaneMapper.convertToEntity(airPlaneDto)));
    }

    @Override
    public List<AirPlaneDto> getAllAirPlane() {
        return airPlaneMapper.entityToDtoList(airPlaneRepository.findAll());
    }

    @Override
    public AirPlaneDto getAirPlaneById(Long airPlaneId) {
        return airPlaneMapper.entityToDto(airPlaneRepository.findById(airPlaneId).get());
    }

    @Override
    public void deleteAirPlaneById(Long airPlaneId) {
        airPlaneRepository.deleteById(airPlaneId);
    }
}
