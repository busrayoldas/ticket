package com.airlineticketsystem.mapper;

import com.airlineticketsystem.dto.FlightDto;
import com.airlineticketsystem.dto.FlightDto;
import com.airlineticketsystem.entity.Flight;
import com.airlineticketsystem.entity.Flight;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface FlightMapper {

    FlightDto entityToDto(Flight flight);
    Flight convertToEntity(FlightDto flightDto);
    List<FlightDto> entityToDtoList(List<Flight> flightList);
    List<Flight> convertToEntityList(List<FlightDto> flightDtoList);
}
