package com.airlineticketsystem.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "CARD_INFO")
@Getter
@Setter
public class CardInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String number;

    @JsonIgnore
    @JoinColumn(name = "PASSENGER_ID",nullable = false)
    @ManyToOne
    private Passenger passenger;


}
