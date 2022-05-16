package com.airlineticketsystem.dto;


import com.airlineticketsystem.entity.CardInfo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;


@Getter
@Setter
@ToString
public class PassengerDto {

    private Long id;
    private String name;
    private String surname;
    private String email;
    private Integer number;
    private List<CardInfoDto> cardInfos;


}
