package com.airlineticketsystem.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AirPlaneDto {

    private Long id;
    private String model;
    private Integer capacity;

}
