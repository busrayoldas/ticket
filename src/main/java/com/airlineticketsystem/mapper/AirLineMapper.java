package com.airlineticketsystem.mapper;

import com.airlineticketsystem.dto.AirLineDto;
import com.airlineticketsystem.entity.AirLine;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface AirLineMapper {

    AirLineDto entityToDto(AirLine airLine);
    AirLine convertToEntity(AirLineDto airLineDto);
    List<AirLineDto> entityToDtoList(List<AirLine> airLineList);
    List<AirLine> convertToEntityList(List<AirLineDto> airLineDtoList);
}
