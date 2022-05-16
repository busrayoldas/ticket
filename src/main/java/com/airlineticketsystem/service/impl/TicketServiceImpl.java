package com.airlineticketsystem.service.impl;

import com.airlineticketsystem.dto.FlightDto;
import com.airlineticketsystem.dto.TicketDto;
import com.airlineticketsystem.entity.Flight;
import com.airlineticketsystem.entity.Ticket;
import com.airlineticketsystem.mapper.TicketMapper;
import com.airlineticketsystem.repository.AirPortRepository;
import com.airlineticketsystem.repository.FlightRepository;
import com.airlineticketsystem.repository.PassengerRepository;
import com.airlineticketsystem.repository.TicketRepository;
import com.airlineticketsystem.service.TicketService;
import org.springframework.stereotype.Service;
import org.springframework.util.NumberUtils;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {


    private final TicketRepository ticketRepository;
    private final FlightRepository flightRepository;
    private final PassengerRepository passengerRepository;
    private final AirPortRepository airPortRepository;
    private  TicketMapper ticketMapper;

    public TicketServiceImpl(TicketRepository ticketRepository, FlightRepository flightRepository, PassengerRepository passengerRepository, AirPortRepository airPortRepository, TicketMapper ticketMapper) {
        this.ticketRepository = ticketRepository;
        this.flightRepository = flightRepository;
        this.passengerRepository = passengerRepository;
        this.airPortRepository = airPortRepository;
        this.ticketMapper = ticketMapper;
    }

    @Override
    public TicketDto findByTicketNo(String str) {
        return ticketMapper.entityToDto(ticketRepository.findByTicketNo(str));
    }

    @Override
    public TicketDto buyTicket(TicketDto ticketDto) {
        Ticket ticket = ticketMapper.convertToEntity(ticketDto);
        ticket.setFlight(flightRepository.getById(ticketDto.getFlight().getId()));
        ticket.setPassenger(passengerRepository.getById(ticketDto.getPassenger().getId()));
        ticket.setAirPort(airPortRepository.getById(ticketDto.getAirPort().getId()));
        ticket.setCreditCard(maskCardNo(ticketDto.getCreditCard()));
        ticket.setPrice(calculatePrice(ticket.getFlight()));
        ticket.setTicketNo(generateTicketNo(ticket));
        return ticketMapper.entityToDto(ticketRepository.save(ticket));
    }

    private String generateTicketNo(Ticket ticket) {
        long time = ZonedDateTime.now().toInstant().toEpochMilli();
        return time +ticket.getPassenger().getName();
    }

    private String maskCardNo(String cardNo) {
        String maskedCardNo = "";
        List<String> list = new ArrayList<>();
        for (int i=0;i<cardNo.length();i++){
            list.add(cardNo.substring(i,i+1));
        }
        List<String> returnList = new ArrayList<>();
        list.stream().forEach(e -> {
            int number;
            try {
                number = NumberUtils.parseNumber(e,Integer.class);
                returnList.add(String.valueOf(number));
            } catch (Exception ex) {

            }
        });
        int count = 1;
        for (String str:returnList) {
            if (count > 6 && count < 13 ) {
                maskedCardNo = maskedCardNo + "*";
            } else {
                maskedCardNo = maskedCardNo + str;
            }
            count++;
        }
        return maskedCardNo;
    }

    private BigDecimal calculatePrice(Flight flight) {
        if (flight.getOldCapacity() * 1.1 <= flight.getNewCapacity()) {
            return flight.getPrice().multiply(BigDecimal.valueOf(1.1));
        }
        return flight.getPrice();
    }
}
