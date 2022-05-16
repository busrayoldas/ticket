package com.airlineticketsystem.controller;

import com.airlineticketsystem.dto.RouteDto;
import com.airlineticketsystem.service.RouteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/route")
public class RouteController {


    private final RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @PostMapping("/save")
    public ResponseEntity<RouteDto> saveRoute(@RequestBody RouteDto routeDto) {
        return new ResponseEntity<RouteDto>(routeService.saveRoute(routeDto), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<RouteDto>> getAllRoute() {
        return new ResponseEntity<List<RouteDto>>(routeService.getAllRoute(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RouteDto> getRouteById(@PathVariable(name = "id") Long routeId) {
        return new ResponseEntity<RouteDto>(routeService.getRouteById(routeId), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteRouteById(@PathVariable(name = "id") Long routeId) {
        routeService.deleteRouteById(routeId);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }
    
    @GetMapping("/findDeparture/{str}")
    public ResponseEntity<List<RouteDto>> findRouteDeparture(@PathVariable(name = "str") String str) {
        return new ResponseEntity<List<RouteDto>>(routeService.findRouteDeparture(str), HttpStatus.OK);
    }

    @GetMapping("/findArrival/{str}")
    public ResponseEntity<List<RouteDto>> findRouteArrival(@PathVariable(name = "str") String str) {
        return new ResponseEntity<List<RouteDto>>(routeService.findRouteArrival(str), HttpStatus.OK);
    }
}
