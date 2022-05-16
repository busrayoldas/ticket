package com.airlineticketsystem.dto;


import com.airlineticketsystem.entity.AirPlane;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@ToString
public class FlightDto {

    private Long id;
    private RouteDto route;
    private Date departureTime;
    private Date departureDate;
    private Date arrivedTime;
    private Date arrivedDate;
    private AirPlaneDto airPlane;
    private AirLineDto airLine;
    private BigDecimal price;
    private Integer oldCapacity;
    private Integer newCapacity;

}
