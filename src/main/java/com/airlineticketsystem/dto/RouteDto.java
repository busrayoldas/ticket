package com.airlineticketsystem.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;


@Getter
@Setter
@ToString
public class RouteDto {

    private Long id;
    private AirPortDto departure;
    private AirPortDto arrival;

}
