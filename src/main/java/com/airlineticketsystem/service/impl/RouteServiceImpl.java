package com.airlineticketsystem.service.impl;

import com.airlineticketsystem.dto.RouteDto;
import com.airlineticketsystem.entity.Route;
import com.airlineticketsystem.mapper.RouteMapper;
import com.airlineticketsystem.repository.RouteRepository;
import com.airlineticketsystem.service.RouteService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class RouteServiceImpl implements RouteService {


    private final RouteRepository routeRepository;
    private  RouteMapper routeMapper;

    public RouteServiceImpl(RouteRepository routeRepository, RouteMapper routeMapper) {
        this.routeRepository = routeRepository;
        this.routeMapper = routeMapper;
    }


    @Override
    public RouteDto saveRoute(RouteDto routeDto) {
        return routeMapper.entityToDto(routeRepository.save(routeMapper.convertToEntity(routeDto)));
    }

    @Override
    public List<RouteDto> getAllRoute() {
        return routeMapper.entityToDtoList(routeRepository.findAll());
    }

    @Override
    public RouteDto getRouteById(Long routeId) {
        return routeMapper.entityToDto(routeRepository.findById(routeId).get());
    }

    @Override
    public void deleteRouteById(Long routeId) {
        routeRepository.deleteById(routeId);
    }

    @Override
    public List<RouteDto> findRouteDeparture(String str) {
        List<Route> route = new ArrayList<>();
        route.addAll( routeRepository.findRouteDeparture("%" + str.toLowerCase(Locale.ROOT) + "%"));
        route.addAll( routeRepository.findRouteDeparture("%" + str.toUpperCase(Locale.ROOT) + "%")
                .stream().filter(f-> !route.contains(f)).collect(Collectors.toList()));
        return routeMapper.entityToDtoList(route);
    }

    @Override
    public List<RouteDto> findRouteArrival(String str) {
        List<Route> route = new ArrayList<>();
        route.addAll( routeRepository.findRouteArrival("%" + str.toLowerCase(Locale.ROOT) + "%"));
        route.addAll( routeRepository.findRouteArrival("%" + str.toUpperCase(Locale.ROOT) + "%")
                .stream().filter(f-> !route.contains(f)).collect(Collectors.toList()));
        return routeMapper.entityToDtoList(route);
    }
}
