package com.airlineticketsystem.controller;

import com.airlineticketsystem.dto.PassengerDto;
import com.airlineticketsystem.entity.Passenger;
import com.airlineticketsystem.service.PassengerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passenger")
public class PassengerController {


    private final PassengerService passengerService;

    public PassengerController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    @PostMapping("/save")
    public ResponseEntity<PassengerDto> savePassenger(@RequestBody PassengerDto passengerDto) {
        return new ResponseEntity<PassengerDto>(passengerService.savePassenger(passengerDto), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<PassengerDto>> getAllPassenger() {
        return new ResponseEntity<List<PassengerDto>>(passengerService.getAllPassenger(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PassengerDto> getPassengerById(@PathVariable(name = "id") Long passengerId) {
        return new ResponseEntity<PassengerDto>(passengerService.getPassengerById(passengerId), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePassengerById(@PathVariable(name = "id") Long passengerId) {
        passengerService.deletePassengerById(passengerId);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }
}
