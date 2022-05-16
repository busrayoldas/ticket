package com.airlineticketsystem.controller;

import com.airlineticketsystem.dto.TicketDto;
import com.airlineticketsystem.service.TicketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")
public class TicketController {


    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/findByTicketNo/{str}")
    public ResponseEntity<TicketDto> findByTicketNo(@PathVariable(name = "str") String str) {
        return new ResponseEntity<TicketDto>(ticketService.findByTicketNo(str), HttpStatus.OK);
    }

    @PostMapping("/buyTicket")
    public ResponseEntity<TicketDto> buyTicket(@RequestBody TicketDto ticketDto) {
        return new ResponseEntity<TicketDto>(ticketService.buyTicket(ticketDto), HttpStatus.CREATED);
    }
}
