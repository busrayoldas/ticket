package com.airlineticketsystem.mapper;

import com.airlineticketsystem.dto.AirPortDto;
import com.airlineticketsystem.entity.AirPort;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface AirPortMapper {

    AirPortDto entityToDto(AirPort airPort);
    AirPort convertToEntity(AirPortDto airPortDto);
    List<AirPortDto> entityToDtoList(List<AirPort> airPortList);
    List<AirPort> convertToEntityList(List<AirPortDto> airPortDtoList);
}
