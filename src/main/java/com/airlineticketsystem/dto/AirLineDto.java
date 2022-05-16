package com.airlineticketsystem.dto;


import com.airlineticketsystem.entity.CardInfo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;


@Getter
@Setter
@ToString
public class AirLineDto {

    private Long id;
    private String name;
    private String address;
    private Integer number;
    private List<FlightDto> flightDtoList;



}
