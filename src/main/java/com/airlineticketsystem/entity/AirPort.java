package com.airlineticketsystem.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "AIR_PORT")
@Getter
@Setter
public class AirPort {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String city;
    private String name;

    @OneToOne(mappedBy="airPort")
    private Ticket ticket;

    @JsonIgnore
    @OneToMany(mappedBy="departure")
    private List<Route> departureRoutes;

    @JsonIgnore
    @OneToMany(mappedBy="arrival")
    private List<Route> arrivalRoutes;

}
