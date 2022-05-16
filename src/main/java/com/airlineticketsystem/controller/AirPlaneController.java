package com.airlineticketsystem.controller;

import com.airlineticketsystem.dto.AirPlaneDto;
import com.airlineticketsystem.service.AirPlaneService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airPlane")
public class AirPlaneController {


    private final AirPlaneService airPlaneService;

    public AirPlaneController(AirPlaneService airPlaneService) {
        this.airPlaneService = airPlaneService;
    }

    @PostMapping("/save")
    public ResponseEntity<AirPlaneDto> saveAirPlane(@RequestBody AirPlaneDto airPlaneDto) {
        return new ResponseEntity<AirPlaneDto>(airPlaneService.saveAirPlane(airPlaneDto), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<AirPlaneDto>> getAllAirPlane() {
        return new ResponseEntity<List<AirPlaneDto>>(airPlaneService.getAllAirPlane(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AirPlaneDto> getAirPlaneById(@PathVariable(name = "id") Long airPlaneId) {
        return new ResponseEntity<AirPlaneDto>(airPlaneService.getAirPlaneById(airPlaneId), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAirPlaneById(@PathVariable(name = "id") Long airPlaneId) {
        airPlaneService.deleteAirPlaneById(airPlaneId);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }
}
