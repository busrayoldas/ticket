package com.airlineticketsystem.controller;

import com.airlineticketsystem.dto.AirLineDto;
import com.airlineticketsystem.service.AirLineService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airLine")
public class AirLineController {


    private final AirLineService airLineService;

    public AirLineController(AirLineService airLineService) {
        this.airLineService = airLineService;
    }

    @PostMapping("/save")
    public ResponseEntity<AirLineDto> saveAirLine(@RequestBody AirLineDto airLineDto) {
        return new ResponseEntity<AirLineDto>(airLineService.saveAirLine(airLineDto), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<AirLineDto>> getAllAirLine() {
        return new ResponseEntity<List<AirLineDto>>(airLineService.getAllAirLine(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AirLineDto> getAirLineById(@PathVariable(name = "id") Long airLineId) {
        return new ResponseEntity<AirLineDto>(airLineService.getAirLineById(airLineId), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAirLineById(@PathVariable(name = "id") Long airLineId) {
        airLineService.deleteAirLineById(airLineId);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }
    
    @GetMapping("/find/{str}")
    public ResponseEntity<List<AirLineDto>> findAirLine(@PathVariable(name = "str") String str) {
        return new ResponseEntity<List<AirLineDto>>(airLineService.findAirLine(str), HttpStatus.OK);
    }
}
