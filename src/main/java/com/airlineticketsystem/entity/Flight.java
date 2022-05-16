package com.airlineticketsystem.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "FLIGHT")
@Getter
@Setter
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonIgnore
    @JoinColumn(name = "ROUTE_ID",nullable = false)
    @ManyToOne
    private Route route;

    private Date departureTime;
    private Date departureDate;
    private Date arrivedTime;
    private Date arrivedDate;
    private BigDecimal price;
    private Integer oldCapacity;
    private Integer newCapacity;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="AIR_PLANE_ID")
    private AirPlane airPlane;

    @OneToOne(mappedBy="flight")
    private Ticket ticket;

    @JsonIgnore
    @JoinColumn(name = "AIR_LINE_ID",nullable = true)
    @ManyToOne
    private AirLine airLine;




}
