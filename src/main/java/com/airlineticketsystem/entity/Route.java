package com.airlineticketsystem.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ROUTE")
@Getter
@Setter
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonIgnore
    @JoinColumn(name = "DEPARTURE_AIRPORT_ID",nullable = false)
    @ManyToOne
    private AirPort departure;

    @JsonIgnore
    @JoinColumn(name = "ARRIVAL_AIRPORT_ID",nullable = false)
    @ManyToOne
    private AirPort arrival;

    @JsonIgnore
    @OneToMany(mappedBy="route")
    private List<Flight> flights;
}