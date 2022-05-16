package com.airlineticketsystem.mapper;

import com.airlineticketsystem.dto.RouteDto;
import com.airlineticketsystem.entity.Route;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface RouteMapper {

    RouteDto entityToDto(Route route);
    Route convertToEntity(RouteDto routeDto);
    List<RouteDto> entityToDtoList(List<Route> routeList);
    List<Route> convertToEntityList(List<RouteDto> routeDtoList);
}
