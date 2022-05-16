package com.airlineticketsystem.mapper;

import com.airlineticketsystem.dto.PassengerDto;
import com.airlineticketsystem.entity.Passenger;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PassengerMapper {

    PassengerDto entityToDto(Passenger passenger);
    Passenger convertToEntity(PassengerDto passengerDto);
    List<PassengerDto> entityToDtoList(List<Passenger> passengerList);
    List<Passenger> convertToEntityList(List<PassengerDto> passengerDtoList);
}
