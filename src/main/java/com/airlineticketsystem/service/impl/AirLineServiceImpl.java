package com.airlineticketsystem.service.impl;

import com.airlineticketsystem.dto.AirLineDto;
import com.airlineticketsystem.entity.AirLine;
import com.airlineticketsystem.mapper.AirLineMapper;
import com.airlineticketsystem.repository.AirLineRepository;
import com.airlineticketsystem.service.AirLineService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class AirLineServiceImpl implements AirLineService {


    private final AirLineRepository airLineRepository;
    private  AirLineMapper airLineMapper;

    public AirLineServiceImpl(AirLineRepository airLineRepository, AirLineMapper airLineMapper) {
        this.airLineRepository = airLineRepository;
        this.airLineMapper = airLineMapper;
    }


    @Override
    public AirLineDto saveAirLine(AirLineDto airLineDto) {
        return airLineMapper.entityToDto(airLineRepository.save(airLineMapper.convertToEntity(airLineDto)));
    }

    @Override
    public List<AirLineDto> getAllAirLine() {
        return airLineMapper.entityToDtoList(airLineRepository.findAll());
    }

    @Override
    public AirLineDto getAirLineById(Long airLineId) {
        return airLineMapper.entityToDto(airLineRepository.findById(airLineId).get());
    }

    @Override
    public void deleteAirLineById(Long airLineId) {
        airLineRepository.deleteById(airLineId);
    }

    @Override
    public List<AirLineDto> findAirLine(String str) {
        List<AirLine> airLine = new ArrayList<>();
        airLine.addAll( airLineRepository.findAirLine("%" + str.toLowerCase(Locale.ROOT) + "%"));
        airLine.addAll( airLineRepository.findAirLine("%" + str.toUpperCase(Locale.ROOT) + "%")
                .stream().filter(f-> !airLine.contains(f)).collect(Collectors.toList()));
        return airLineMapper.entityToDtoList(airLine);
    }
}
