package com.airlineticketsystem.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "TICKET")
@Getter
@Setter
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String ticketNo;
    private BigDecimal price;
    private String creditCard;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FLIGHT_ID")
    private Flight flight;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PASSENGER_ID")
    private Passenger passenger;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AIR_PORT_ID")
    private AirPort airPort;


}
