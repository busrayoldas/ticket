package com.airlineticketsystem.mapper;

import com.airlineticketsystem.dto.AirPlaneDto;
import com.airlineticketsystem.entity.AirPlane;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface AirPlaneMapper {

    AirPlaneDto entityToDto(AirPlane airPlane);
    AirPlane convertToEntity(AirPlaneDto airPlaneDto);
    List<AirPlaneDto> entityToDtoList(List<AirPlane> airPlaneList);
    List<AirPlane> convertToEntityList(List<AirPlaneDto> airPlaneDtoList);
}
