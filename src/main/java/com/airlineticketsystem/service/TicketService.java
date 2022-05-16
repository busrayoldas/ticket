package com.airlineticketsystem.service;

import com.airlineticketsystem.dto.TicketDto;

import java.util.List;


public interface TicketService {

    TicketDto findByTicketNo(String str);

    TicketDto buyTicket(TicketDto ticketDto);
}
