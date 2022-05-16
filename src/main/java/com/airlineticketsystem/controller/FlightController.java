package com.airlineticketsystem.controller;

import com.airlineticketsystem.dto.FlightDto;
import com.airlineticketsystem.service.FlightService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flight")
public class FlightController {


    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @PostMapping("/save")
    public ResponseEntity<FlightDto> saveFlight(@RequestBody FlightDto flightDto) {
        return new ResponseEntity<FlightDto>(flightService.saveFlight(flightDto), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<FlightDto>> getAllFlight() {
        return new ResponseEntity<List<FlightDto>>(flightService.getAllFlight(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FlightDto> getFlightById(@PathVariable(name = "id") Long flightId) {
        return new ResponseEntity<FlightDto>(flightService.getFlightById(flightId), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteFlightById(@PathVariable(name = "id") Long flightId) {
        flightService.deleteFlightById(flightId);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }
}
