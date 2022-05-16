package com.airlineticketsystem.controller;

import com.airlineticketsystem.dto.AirPortDto;
import com.airlineticketsystem.service.AirPortService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airPort")
public class AirPortController {


    private final AirPortService airPortService;

    public AirPortController(AirPortService airPortService) {
        this.airPortService = airPortService;
    }

    @PostMapping("/save")
    public ResponseEntity<AirPortDto> saveAirPort(@RequestBody AirPortDto airPortDto) {
        return new ResponseEntity<AirPortDto>(airPortService.saveAirPort(airPortDto), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<AirPortDto>> getAllAirPort() {
        return new ResponseEntity<List<AirPortDto>>(airPortService.getAllAirPort(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AirPortDto> getAirPortById(@PathVariable(name = "id") Long airPortId) {
        return new ResponseEntity<AirPortDto>(airPortService.getAirPortById(airPortId), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAirPortById(@PathVariable(name = "id") Long airPortId) {
        airPortService.deleteAirPortById(airPortId);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }

    @GetMapping("/find/{str}")
    public ResponseEntity<List<AirPortDto>> findAirPort(@PathVariable(name = "str") String str) {
        return new ResponseEntity<List<AirPortDto>>(airPortService.findAirport(str), HttpStatus.OK);
    }

}
