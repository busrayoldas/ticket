package com.airlineticketsystem.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TicketDto {

    private Long id;
    private FlightDto flight;
    private PassengerDto passenger;
    private AirPortDto airPort;
    private String ticketNo;
    private String creditCard;
}
