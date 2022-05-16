package com.airlineticketsystem.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "PASSENGER")
@Getter
@Setter
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String surname;
    private String email;
    private Integer number;

    @JsonIgnore
    @OneToMany(mappedBy="passenger")
    private List<CardInfo> cardInfos;

    @OneToOne(mappedBy="passenger")
    private Ticket ticket;



}
