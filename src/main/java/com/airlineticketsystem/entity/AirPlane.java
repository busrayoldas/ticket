package com.airlineticketsystem.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "AIR_PLANE")
@Getter
@Setter
public class AirPlane {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String model;

    @OneToOne(mappedBy="airPlane")
    private Flight flight;

}
