package com.airlineticketsystem.service.impl;

import com.airlineticketsystem.dto.AirPortDto;
import com.airlineticketsystem.entity.AirPort;
import com.airlineticketsystem.mapper.AirPortMapper;
import com.airlineticketsystem.repository.AirPortRepository;
import com.airlineticketsystem.service.AirPortService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class AirPortServiceImpl implements AirPortService {


    private final AirPortRepository airPortRepository;
    private  AirPortMapper airPortMapper;

    public AirPortServiceImpl(AirPortRepository airPortRepository, AirPortMapper airPortMapper) {
        this.airPortRepository = airPortRepository;
        this.airPortMapper = airPortMapper;
    }


    @Override
    public AirPortDto saveAirPort(AirPortDto airPortDto) {
        return airPortMapper.entityToDto(airPortRepository.save(airPortMapper.convertToEntity(airPortDto)));
    }

    @Override
    public List<AirPortDto> getAllAirPort() {
        return airPortMapper.entityToDtoList(airPortRepository.findAll());
    }

    @Override
    public AirPortDto getAirPortById(Long airPortId) {
        return airPortMapper.entityToDto(airPortRepository.findById(airPortId).get());
    }

    @Override
    public void deleteAirPortById(Long airPortId) {
        airPortRepository.deleteById(airPortId);
    }

    @Override
    public List<AirPortDto> findAirport(String str) {
        List<AirPort> airPort = new ArrayList<>();
        airPort.addAll( airPortRepository.findAirPort("%" + str.toLowerCase(Locale.ROOT) + "%"));
        airPort.addAll( airPortRepository.findAirPort("%" + str.toUpperCase(Locale.ROOT) + "%")
                .stream().filter(f-> !airPort.contains(f)).collect(Collectors.toList()));
        return airPortMapper.entityToDtoList(airPort);
    }

}
